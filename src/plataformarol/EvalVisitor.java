package plataformarol;

import linguaxe.LinguaxeBaseVisitor;
import linguaxe.LinguaxeParser;
import linguaxe.LinguaxeParser.AddSubContext;
import linguaxe.LinguaxeParser.AssignContext;
import linguaxe.LinguaxeParser.AttribContext;
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
import linguaxe.LinguaxeParser.RootVariableContext;
import linguaxe.LinguaxeParser.StringContext;
import linguaxe.LinguaxeParser.VariableOpContext;
import universe.UserDefinedClass;
import universe.WorldObject;

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
public class EvalVisitor extends LinguaxeBaseVisitor<IReturnValue> {

	protected SymbolTable st;

	public SymbolTable getSymbolTable() {
		return st;
	}

	public void setSymbolTable(SymbolTable st) {
		this.st = st;
	}
	
	public EvalVisitor() {
		st = new SymbolTable();
	}

	@Override
	public IReturnValue visitLine(LineContext ctx) {
		IReturnValue x = super.visitLine(ctx);
		//TODO: println
		System.out.println(x);
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
	 * </p>
	 */
	@Override
	public IReturnValue visitMove(MoveContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMove(ctx);
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
				//TODO: scope
				ClassMethod m = obj.getObj().getUserClass().getMethod(methodName);
				visit(m.getNode());
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
		if(condition.isTrue()) {
			visit(ctx.code(0));
		}
		else if(ctx.ELSE() != null) {
			visit(ctx.code(1));
		}
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
		if(origin instanceof ListValue) {
			ListValue list = (ListValue) origin;
			for(IReturnValue v : list.getValue()) {
				//TODO: scope
				getSymbolTable().setVariable(auxVar, v);
				visit(ctx.code());
			}
		}
		else if(origin instanceof StringValue) {
			StringValue str = (StringValue) origin;
			for(char c : str.getValue().toCharArray()) {
				//TODO: scope
				String cc = Character.toString(c);
				getSymbolTable().setVariable(auxVar, new StringValue(cc));
				visit(ctx.code());
			}
		}
		//TODO: cannot modify origin variable
		return null;
	}
	
	/**
	 * Defines a new class.
	 * class_def : SYMBOL ( '(' SYMBOL ')' )? ('/n')* '{' ('/n')* attributes methods '}' ;
	 */
	@Override
	public IReturnValue visitClass_def(Class_defContext ctx) {
		String className = ctx.SYMBOL(0).getText().toLowerCase();
		//TODO: methods and inheritance
		UserDefinedClass newClass = new UserDefinedClass(className);
		getSymbolTable().setDefiningClass(newClass);
		getSymbolTable().getCurrentWorld().addClass(className, newClass);
		visit(ctx.attributes());
		visit(ctx.methods());
		getSymbolTable().setDefiningClass(null);
		return null;
	}

	/**
	 * Adds a new field to the class that is currently being defined.
	 * attrib : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public IReturnValue visitAttrib(AttribContext ctx) {
		//TODO: data type
		String fieldName = ctx.SYMBOL().getText().toLowerCase();
		IReturnValue defaultValue;
		if(ctx.operation() != null) {
			defaultValue = visit(ctx.operation());
		}
		else {
			defaultValue = new IntegerValue(0); //TODO: default values for default values...
		}
		getSymbolTable().getDefiningClass().addField(fieldName, defaultValue);
		return defaultValue;
	}

	/**
	 * Defines a new method in the current class.
	 * method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' params? ')' nl? '{' code? '}' ;
	 */
	@Override
	public IReturnValue visitMethod(MethodContext ctx) {
		String methodName = ctx.metname.getText().toLowerCase();
		if(ctx.ASSIGN() != null) {
			//TODO: return value
		}
		//TODO: params
		UserDefinedClass curClass = getSymbolTable().getDefiningClass();
		curClass.addMethod(methodName, new ClassMethod(ctx.code()));
		return null;
	}
	
	
}