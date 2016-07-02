package plataformarol;

import java.util.ArrayList;
import java.util.List;

import linguaxe.LinguaxeBaseVisitor;
import linguaxe.LinguaxeParser;
import linguaxe.LinguaxeParser.AddSubContext;
import linguaxe.LinguaxeParser.ArgsContext;
import linguaxe.LinguaxeParser.AssignContext;
import linguaxe.LinguaxeParser.BoolContext;
import linguaxe.LinguaxeParser.Class_defContext;
import linguaxe.LinguaxeParser.CompareContext;
import linguaxe.LinguaxeParser.DiceContext;
import linguaxe.LinguaxeParser.Exp_forContext;
import linguaxe.LinguaxeParser.Exp_ifContext;
import linguaxe.LinguaxeParser.ExponentContext;
import linguaxe.LinguaxeParser.FloatContext;
import linguaxe.LinguaxeParser.FunctionContext;
import linguaxe.LinguaxeParser.IndexContext;
import linguaxe.LinguaxeParser.IntContext;
import linguaxe.LinguaxeParser.IntermediateVariableContext;
import linguaxe.LinguaxeParser.LineContext;
import linguaxe.LinguaxeParser.ListContext;
import linguaxe.LinguaxeParser.LogicContext;
import linguaxe.LinguaxeParser.MethodContext;
import linguaxe.LinguaxeParser.MoveContext;
import linguaxe.LinguaxeParser.MulDivContext;
import linguaxe.LinguaxeParser.MultDiceContext;
import linguaxe.LinguaxeParser.NegativeContext;
import linguaxe.LinguaxeParser.New_objContext;
import linguaxe.LinguaxeParser.OperationContext;
import linguaxe.LinguaxeParser.ParensContext;
import linguaxe.LinguaxeParser.RoomContext;
import linguaxe.LinguaxeParser.RoomOpContext;
import linguaxe.LinguaxeParser.RootVariableContext;
import linguaxe.LinguaxeParser.Sharp_identifierContext;
import linguaxe.LinguaxeParser.StringContext;
import linguaxe.LinguaxeParser.Var_declContext;
import linguaxe.LinguaxeParser.VariableOpContext;
import universe.ClassMethod;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldObject;
import universe.WorldRoom;
import values.FloatValue;
import values.IReturnValue;
import values.IntegerValue;
import values.ListValue;
import values.LocationValue;
import values.ObjectValue;
import values.ReferenceValue;
import values.StringValue;

/**
 * <p>
 * This class provides a Visitor that performs all the operations defined by the
 * language. All the operations return an object that implements the
 * IReturnValue interface; this object contains the value generated.
 * </p>
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 */
public class ExecVisitor extends LinguaxeBaseVisitor<IReturnValue> {

	protected SymbolTable st;

	public SymbolTable getSymbolTable() {
		return st;
	}

	public void setSymbolTable(SymbolTable st) {
		this.st = st;
	}
	
	public ExecVisitor(World world, WorldRoom room) {
		st = new SymbolTable(world, room);
	}

	@Override
	public IReturnValue visitLine(LineContext ctx) {
		IReturnValue x = super.visitLine(ctx);
		//TODO: println
		if(x != null) System.out.println(x);
		return x;
	}

	/**
	 * <p>
	 * Returns an integer value found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitInt(IntContext ctx) {
		return new IntegerValue(Integer.valueOf(ctx.INT_NUMBER().getText()));
	}

	/**
	 * <p>
	 * Returns a float value found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitFloat(FloatContext ctx) {
		return new FloatValue(Float.valueOf(ctx.FLOAT_NUMBER().getText()));
	}

	/**
	 * <p>
	 * Returns a string value found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitString(StringContext ctx) {
		return new StringValue(ctx.TEXT_STRING().getText());
	}

	/**
	 * <p>
	 * Returns an integer equivalent to a boolean value found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitBool(BoolContext ctx) {
		switch (ctx.BOOLEAN().getText()) {
		case "true":
			return new IntegerValue(1);
		case "false":
		default:
			return new IntegerValue(0);
		}
	}

	/**
	 * <p>
	 * Returns a list value found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitList(ListContext ctx) {
		ListValue lv = new ListValue();
		for (OperationContext op : ctx.operation()) {
			lv.getValue().add(visit(op));
		}
		return lv;
	}

	/**
	 * <p>
	 * Compares between two values and return the results.
	 * </p>
	 * <p>
	 * This operation may be one of the following:
	 * </p>
	 * <ul>
	 * <li>Equal</li>
	 * <li>Not Equal</li>
	 * <li>Greater or Equal</li>
	 * <li>Lesser or Equal</li>
	 * <li>Greater</li>
	 * <li>Lesser</li>
	 * </ul>
	 */
	@Override
	public IReturnValue visitCompare(CompareContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		switch (ctx.op.getType()) {
		case LinguaxeParser.EQ:
			return left.eq(right);
		case LinguaxeParser.NEQ:
			return left.neq(right);
		case LinguaxeParser.GREQ:
			return left.greq(right);
		case LinguaxeParser.LESEQ:
			return left.leseq(right);
		case LinguaxeParser.GREAT:
			return left.great(right);
		case LinguaxeParser.LESS:
		default:
			return left.less(right);
		}
	}

	/**
	 * <p>
	 * Performs an arithmetic operation between two values.
	 * </p>
	 * <p>
	 * This operation may be one of the following:
	 * </p>
	 * <ul>
	 * <li>Addition</li>
	 * <li>Subtraction</li>
	 * </ul>
	 */
	@Override
	public IReturnValue visitAddSub(AddSubContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		switch (ctx.op.getType()) {
		case LinguaxeParser.ADD:
			return left.add(right);
		case LinguaxeParser.SUB:
		default:
			return left.sub(right);
		}
	}

	/**
	 * <p>
	 * Performs an arithmetic operation between two values.
	 * </p>
	 * <p>
	 * This operation may be one of the following:
	 * </p>
	 * <ul>
	 * <li>Multiplication</li>
	 * <li>Division</li>
	 * </ul>
	 */
	@Override
	public IReturnValue visitMulDiv(MulDivContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		switch (ctx.op.getType()) {
		case LinguaxeParser.MUL:
			return left.mul(right);
		case LinguaxeParser.DIV:
		default:
			return left.div(right);
		}
	}

	/**
	 * <p>
	 * Returns the value of the operation between parentheses.
	 * </p>
	 */
	@Override
	public IReturnValue visitParens(ParensContext ctx) {
		return visit(ctx.operation());
	}

	/**
	 * <p>
	 * Performs a dice roll operation.
	 * </p>
	 */
	@Override
	public IReturnValue visitDice(DiceContext ctx) {
		return visit(ctx.operation()).dice();
	}

	/**
	 * <p>
	 * Performs a multiple dice roll operation.
	 * </p>
	 */
	@Override
	public IReturnValue visitMultDice(MultDiceContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		return left.multDice(right);
	}

	/**
	 * <p>
	 * Extracts one item of a list.
	 * </p>
	 */
	@Override
	public IReturnValue visitIndex(IndexContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		return left.getFromIndex(right);
	}

	/**
	 * <p>
	 * Performs a negative operation.
	 * </p>
	 */
	@Override
	public IReturnValue visitNegative(NegativeContext ctx) {
		return visit(ctx.operation()).negative();
	}

	/**
	 * <p>
	 * Performs a exponentiation operation between two values.
	 * </p>
	 */
	@Override
	public IReturnValue visitExponent(ExponentContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		return left.exponent(right);
	}

	/**
	 * <p>
	 * Performs a logic operation between two values.
	 * </p>
	 * <p>
	 * This operation may be one of the following:
	 * </p>
	 * <ul>
	 * <li>And</li>
	 * <li>Or</li>
	 * </ul>
	 */
	@Override
	public IReturnValue visitLogic(LogicContext ctx) {
		IReturnValue left = visit(ctx.operation(0));
		IReturnValue right = visit(ctx.operation(1));
		switch (ctx.op.getType()) {
		case LinguaxeParser.AND:
			return left.and(right);
		case LinguaxeParser.OR:
		default:
			return left.or(right);
		}
	}

	/**
	 * <p>
	 * Assigns the right value to the left variable.
	 * </p>
	 */
	@Override
	public IReturnValue visitAssign(AssignContext ctx) {
		ReferenceValue left = (ReferenceValue)visit(ctx.variable());
		IReturnValue right = visit(ctx.operation());
		left.getReference().setValue(right);
		return right;
	}

	/**
	 * <p>
	 * Moves a game object between rooms.
	 *operation MOVE operation
	 * </p>
	 */
	@Override
	public IReturnValue visitMove(MoveContext ctx) {
		IReturnValue mobile = visit(ctx.operation(0));
		IReturnValue room = visit(ctx.operation(1));
		if(mobile instanceof ObjectValue && room instanceof LocationValue) {
			((ObjectValue)mobile).getObj().moveTo(((LocationValue)room).getLocation());
		}
		return null;
	}

	/**
	 * <p>
	 * Returns a variable found on the input.
	 * </p>
	 */
	@Override
	public IReturnValue visitRootVariable(RootVariableContext ctx) {
		return new ReferenceValue(getSymbolTable().getVariable(ctx.SYMBOL().getText().toLowerCase()));
	}

	/**
	 * Returns a variable within another variable (a field within an object).
	 */
	@Override
	public IReturnValue visitIntermediateVariable(IntermediateVariableContext ctx) {
		ReferenceValue prev = (ReferenceValue)visit(ctx.variable());
		IReturnValue value = prev.getReference().getValue();
		String fieldName =  ctx.SYMBOL().getText().toLowerCase();
		if(value instanceof ObjectValue) {
			WorldObject obj = ((ObjectValue)value).getObj();
			return new ReferenceValue(obj.getField(fieldName));
		}
		else {
			return null; //the variable is not an object
		}
	}

	/**
	 * Returns the value of a variable.
	 */
	@Override
	public IReturnValue visitVariableOp(VariableOpContext ctx) {
		ReferenceValue var = (ReferenceValue)visit(ctx.variable());
		return var.getReference().getValue();
	}
	
	
	/**
	 * Executes a function or method and returns the return value.
	 * function : (variable '.')? SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public IReturnValue visitFunction(FunctionContext ctx) {
		String methodName = ctx.SYMBOL().getText().toLowerCase();
		if(ctx.variable() != null) {
			ReferenceValue ref = (ReferenceValue)visit(ctx.variable());
			if(ref.getReference().getValue() instanceof ObjectValue) {
				ObjectValue obj = (ObjectValue)ref.getReference().getValue();

				//arguments
				//TODO: check arguments
				List<IReturnValue> args = new ArrayList<>();
				for(OperationContext x : ctx.operation()) {
					args.add(visit(x));
				}
				
				//SETTING SCOPE
				ClassMethod m = obj.getObj().getUserClass().getMethod(methodName);
				ObjectScope os = new ObjectScope(obj.getObj());
				FunctionScope fs = new FunctionScope(m, args, os);
				getSymbolTable().pushScope(fs);
				
				visit(m.getNode());
				
				getSymbolTable().popScope();
				//TODO: return value
			}
		}
		else {
			//TODO: non-class functions
		}
		return null;
	}

	/**
	 * Creates a new object with the specified class, and returns it.
	 * new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public IReturnValue visitNew_obj(New_objContext ctx) {
		UserDefinedClass objClass = st.getCurrentWorld().getClassFromName(ctx.SYMBOL().getText().toLowerCase());
		//TODO: constructor parameters
		return new ObjectValue(new WorldObject(objClass, st.currentRoom));
	}	
	

	/**
	 * IF expression. It executes the code between brackets if the condition is met.
	 * exp_if : IF '(' operation ')' nl? '{' code '}' ( nl? ELSE nl? '{' code '}' )? ;
	 */
	@Override
	public IReturnValue visitExp_if(Exp_ifContext ctx) {
		IReturnValue condition = visit(ctx.operation());
		
		//SCOPE
		Scope prevScope = getSymbolTable().getScope();
		LoopScope newScope = new LoopScope(prevScope);
		getSymbolTable().pushScope(newScope);
		
		if(condition.isTrue()) {
			
			visit(ctx.code(0));
		}
		else if(ctx.ELSE() != null) {
			visit(ctx.code(1));
		}
		
		getSymbolTable().popScope();
		return null;
	}

	/**
	 * FOR expression. It executes the code between brackets one time for element on the list.
	 * exp_for : FOR '(' SYMBOL ':' operation ')' nl? '{' code '}' ;
	 */
	@Override
	public IReturnValue visitExp_for(Exp_forContext ctx) {
		String auxVar = ctx.SYMBOL().getText().toLowerCase();
		IReturnValue origin = visit(ctx.operation());
		
		//SCOPE
		Scope prevScope = getSymbolTable().getScope();
		ForScope newScope;
		if(origin instanceof ListValue)
			newScope = new ForScope(auxVar, (ListValue)origin, prevScope);
		else if(origin instanceof StringValue)
			newScope = new ForScope(auxVar, (StringValue)origin, prevScope);
		else
			return null; //cannot walk other values
		
		getSymbolTable().pushScope(newScope);
		
		for(IReturnValue v : newScope.getOriginValues()) {
			getSymbolTable().setVariable(auxVar, v);
			visit(ctx.code());
		}
		
		getSymbolTable().popScope();
		//TODO: cannot modify origin variable
		return null;
	}
	
	/**
	 * Defines a new class.
	 * class_def : SYMBOL ( '(' SYMBOL ')' )? ('/n')* '{' ('/n')* fields? methods? '}' ;
	 */
	@Override
	public IReturnValue visitClass_def(Class_defContext ctx) {
		String className = ctx.SYMBOL(0).getText().toLowerCase();
		UserDefinedClass newClass;
		if(ctx.SYMBOL(1)!=null) { //inherit from another class
			String parentName = ctx.SYMBOL(1).getText().toLowerCase();
			newClass = new UserDefinedClass(className,
					getSymbolTable().getCurrentWorld().getClassFromName(parentName));
		}
		else { //inherit from "Object" class
			newClass = new UserDefinedClass(className,
					getSymbolTable().getCurrentWorld().getRootClass());
		}
		getSymbolTable().setDefiningClass(newClass);
		getSymbolTable().getCurrentWorld().addClass(className, newClass);
		visit(ctx.fields());
		visit(ctx.methods());
		getSymbolTable().setDefiningClass(null);
		return null;
	}

	/**
	 * Adds a new field to the class that is currently being defined.
	 * var_decl : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public IReturnValue visitVar_decl(Var_declContext ctx) {
		//TODO: data type
		String varName = ctx.SYMBOL().getText().toLowerCase();
		IReturnValue value;
		if(ctx.operation() != null) {
			value = visit(ctx.operation());
		}
		else {
			value = new IntegerValue(0); //TODO: default values...
		}
		
		//TODO: Class Scope
		if(getSymbolTable().getDefiningClass() != null) {
			//defining class fields
			getSymbolTable().getDefiningClass().addField(varName, value);
		}
		else {
			//declaring a normal variable
			getSymbolTable().setVariable(varName, value);
		}
		return null;
	}

	/**
	 * Defines a new method in the current class.
	 * method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl? '{' code? '}' ;
	 */
	@Override
	public IReturnValue visitMethod(MethodContext ctx) {
		String methodName = ctx.metname.getText().toLowerCase();
		
		UserDefinedClass curClass = getSymbolTable().getDefiningClass();
		ClassMethod cm = new ClassMethod(ctx.code());
		
		//Return value
		if(ctx.ASSIGN() != null) {
			String returnName = ctx.SYMBOL(0).getText().toLowerCase();
			cm.setReturnVariable(returnName);
			
		}
		
		getSymbolTable().setDefiningMethod(cm);
		
		if(ctx.args() != null)
			visit(ctx.args());
		
		curClass.addMethod(methodName, cm);
		getSymbolTable().setDefiningMethod(null);
		return null;
	}

	/**
	 * Defines the arguments of the method or function.
	 * args : data_type SYMBOL ( ',' data_type SYMBOL )* ;
	 */
	@Override
	public IReturnValue visitArgs(ArgsContext ctx) {
		//TODO: typed args
		for(int i=0; i<ctx.SYMBOL().size(); i++) {
			getSymbolTable().getDefiningMethod().addArgument(ctx.SYMBOL(i).getText().toLowerCase());
		}
		return null;
	}

	/**
	 * Identifies an object by its ID.
	 * sharp_identifier : '#' INT_NUMBER ;
	 */
	@Override
	public IReturnValue visitSharp_identifier(Sharp_identifierContext ctx) {
		long id = Long.valueOf(ctx.INT_NUMBER().getText());
		return new ObjectValue(getSymbolTable().getCurrentWorld().getObject(id));
	}


	/**
	 * Returns a room by its path.
	 * room : '@' room_path ;
	 */
	@Override
	public IReturnValue visitRoom(RoomContext ctx) {
		String path = ctx.room_path().getText();
		WorldRoom room;
		if(path.startsWith("/")) { //absolute path
			room = getSymbolTable().getCurrentWorld().getRoom(path);
		}
		else { //relative path
			String curRoom = getSymbolTable().getCurrentRoom().getLongName();
			String curPath = curRoom.substring(0, curRoom.lastIndexOf('/')+1);
			room = getSymbolTable().getCurrentWorld().getRoom(path, curPath);
		}
		if(room != null) {
			return new LocationValue(room);
		}
		return null;
	}	
}