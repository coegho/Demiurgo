package plataformarol;

import java.util.ArrayList;
import java.util.List;

import exceptions.IllegalOperationException;
import exceptions.NotAListException;
import exceptions.ValueCastException;
import linguaxe.LinguaxeBaseVisitor;
import linguaxe.LinguaxeParser;
import linguaxe.LinguaxeParser.AddSubContext;
import linguaxe.LinguaxeParser.ArgsContext;
import linguaxe.LinguaxeParser.AssignContext;
import linguaxe.LinguaxeParser.BoolContext;
import linguaxe.LinguaxeParser.Class_defContext;
import linguaxe.LinguaxeParser.CompareContext;
import linguaxe.LinguaxeParser.DiceContext;
import linguaxe.LinguaxeParser.EchoContext;
import linguaxe.LinguaxeParser.Exp_elseContext;
import linguaxe.LinguaxeParser.Exp_forContext;
import linguaxe.LinguaxeParser.Exp_ifContext;
import linguaxe.LinguaxeParser.Exp_userContext;
import linguaxe.LinguaxeParser.FloatContext;
import linguaxe.LinguaxeParser.FloatTypeContext;
import linguaxe.LinguaxeParser.Function_callContext;
import linguaxe.LinguaxeParser.IndexAssignContext;
import linguaxe.LinguaxeParser.IndexContext;
import linguaxe.LinguaxeParser.IntContext;
import linguaxe.LinguaxeParser.IntTypeContext;
import linguaxe.LinguaxeParser.IntermediateVariableContext;
import linguaxe.LinguaxeParser.ListContext;
import linguaxe.LinguaxeParser.ListTypeContext;
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
import linguaxe.LinguaxeParser.RoomTypeContext;
import linguaxe.LinguaxeParser.RootVariableContext;
import linguaxe.LinguaxeParser.Sharp_identifierContext;
import linguaxe.LinguaxeParser.StringContext;
import linguaxe.LinguaxeParser.StringTypeContext;
import linguaxe.LinguaxeParser.SymbolTypeContext;
import linguaxe.LinguaxeParser.Var_declContext;
import linguaxe.LinguaxeParser.VariableOpContext;
import scope.ClassScope;
import scope.ForScope;
import scope.FunctionScope;
import scope.LoopScope;
import scope.ObjectScope;
import scope.Scope;
import universe.ClassMethod;
import universe.StoredSymbol;
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
import values.ReturnValueTypes;
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

	protected ScopeManager sm;

	public ExecVisitor(World world, WorldRoom room) {
		sm = new ScopeManager(world, room);
	}

	public ScopeManager getSM() {
		return sm;
	}

	public void setSM(ScopeManager sm) {
		this.sm = sm;
	}

	@Override
	/**
	 * Emits output. Useful for debugging and helping the DX to describe the
	 * situation.
	 */
	public IReturnValue visitEcho(EchoContext ctx) {
		IReturnValue v = visit(ctx.operation());
		// TODO: temporal code for debugging
		try {
			System.out.println(v.castToString());
		} catch (ValueCastException e) {
			System.out.println("Cannot cast to string: " + v.toString());
		}
		return null;
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
		String str = ctx.TEXT_STRING().getText();
		return new StringValue(str.substring(1, str.length() - 1));
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
		ReturnValueTypes type = null;
		int depth = -1;
		List<IReturnValue> l = new ArrayList<>();
		for (OperationContext op : ctx.operation()) {
			IReturnValue v = visit(op);
			if ((depth == -1 || depth == v.getDepth()) && (type == null || type == v.getType())) {
				depth = v.getDepth();
				type = v.getType();
				l.add(v);
			} else {
				return null; // cannot create irregular lists
				// TODO: error
			}
		}

		ListValue lv = new ListValue(l);
		lv.setDepth(depth);
		lv.setInnerType(type);

		return lv;
	}

	/**
	 * Returns a default FLOAT value (it counts as a type).
	 */
	@Override
	public IReturnValue visitFloatType(FloatTypeContext ctx) {
		return FloatValue.defaultValue();
	}

	/**
	 * Returns a default INT value (it counts as a type).
	 */
	@Override
	public IReturnValue visitIntType(IntTypeContext ctx) {
		return IntegerValue.defaultValue();
	}

	/**
	 * Returns a default STRING value (it counts as a type).
	 */
	@Override
	public IReturnValue visitStringType(StringTypeContext ctx) {
		return StringValue.defaultValue();
	}

	/**
	 * Returns a default LIST value (it counts as a type).
	 * <p>
	 * data_type: data_type '[]'
	 */
	@Override
	public IReturnValue visitListType(ListTypeContext ctx) {
		IReturnValue innerType = visit(ctx.data_type());
		if (innerType instanceof ListValue) {
			// It has more depth than 1, ex. "int[][]"
			ListValue lv = (ListValue) innerType;
			return ListValue.defaultValue(lv.getInnerType(), lv.getDepth() + 1);
		} else {
			// Common list of depth=1
			return ListValue.defaultValue(innerType.getType(), 1);
		}
	}

	/**
	 * Returns a default OBJECT value (it counts as a type).
	 * <p>
	 * data_type: SYMBOL
	 */
	@Override
	public IReturnValue visitSymbolType(SymbolTypeContext ctx) {
		// First we get the type, in this case, a class
		String className = ctx.SYMBOL().getText().toLowerCase();
		UserDefinedClass itsClass = getSM().getClassFromName(className);
		return ObjectValue.defaultValue(itsClass);
	}

	/**
	 * Returns a default LOCATION value (it counts as a type).
	 */
	@Override
	public IReturnValue visitRoomType(RoomTypeContext ctx) {
		return LocationValue.defaultValue(getSM().getCurrentWorld());
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
		try {
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
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
		try {
			IReturnValue left = visit(ctx.operation(0));
			IReturnValue right = visit(ctx.operation(1));
			switch (ctx.op.getType()) {
			case LinguaxeParser.ADD:
				return left.add(right);
			case LinguaxeParser.SUB:
			default:
				return left.sub(right);
			}
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
		try {
			IReturnValue left = visit(ctx.operation(0));
			IReturnValue right = visit(ctx.operation(1));
			switch (ctx.op.getType()) {
			case LinguaxeParser.MUL:
				return left.mul(right);
			case LinguaxeParser.DIV:
			default:
				return left.div(right);
			}
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
		try {
			return visit(ctx.operation()).dice();
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * <p>
	 * Performs a multiple dice roll operation.
	 * </p>
	 */
	@Override
	public IReturnValue visitMultDice(MultDiceContext ctx) {
		try {
			IReturnValue left = visit(ctx.operation(0));
			IReturnValue right = visit(ctx.operation(1));
			return left.multDice(right);
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * <p>
	 * Extracts one item of a list.
	 * </p>
	 */
	@Override
	public IReturnValue visitIndex(IndexContext ctx) {
		try {
			IReturnValue left = visit(ctx.operation(0));
			int index = visit(ctx.operation(1)).castToInteger();
			return left.getFromIndex(index);
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValueCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <p>
	 * Performs a negative operation.
	 * </p>
	 */
	@Override
	public IReturnValue visitNegative(NegativeContext ctx) {
		try {
			return visit(ctx.operation()).negative();
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
		try {
			IReturnValue left = visit(ctx.operation(0));
			IReturnValue right = visit(ctx.operation(1));
			switch (ctx.op.getType()) {
			case LinguaxeParser.AND:
				return left.and(right);
			case LinguaxeParser.OR:
			default:
				return left.or(right);
			}
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Assigns the value on the right to the variable on the left.
	 * <p>
	 * operation: variable ASSIGN operation
	 */
	@Override
	public IReturnValue visitAssign(AssignContext ctx) {
		ReferenceValue left = (ReferenceValue) visit(ctx.variable());
		IReturnValue right = visit(ctx.operation());
		if(left.getReference().getValue().canAssign(right)) {
			left.getReference().assign(right);
			return left.getReference().getValue();
		}
		else {
			//TODO: error
			return null;
		}
	}

	/**
	 * Assigns the value on the right into the given position of the variable on
	 * the left.
	 * </p>
	 * operation: variable '[' operation ']' ASSIGN operation
	 */
	@Override
	public IReturnValue visitIndexAssign(IndexAssignContext ctx) {
		ReferenceValue ref = (ReferenceValue) visit(ctx.variable());
		int index;
		IReturnValue value;
		IReturnValue element;
		try {
			index = visit(ctx.operation(0)).castToInteger();
			value = visit(ctx.operation(1));
			if(!(ref.getReference().getValue() instanceof ListValue))
				throw new NotAListException();
			element = ref.getReference().getValue().getFromIndex(index);
			if(element.canAssign(value)) {
				element.assign(value);
				return value;
			}
			else {
				throw new ValueCastException();
			}
		} catch (ValueCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotAListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Moves a game object between rooms.
	 * <p>
	 * operation: operation MOVE operation
	 */
	@Override
	public IReturnValue visitMove(MoveContext ctx) {
		IReturnValue mobile = visit(ctx.operation(0));
		IReturnValue room = visit(ctx.operation(1));
		if (mobile instanceof ObjectValue && room instanceof LocationValue) {
			((ObjectValue) mobile).getObj().moveTo(((LocationValue) room).getLocation());
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
		return new ReferenceValue(getSM().getVariable(ctx.SYMBOL().getText().toLowerCase()));
	}

	/**
	 * Returns a variable within another variable (a field within an object).
	 */
	@Override
	public IReturnValue visitIntermediateVariable(IntermediateVariableContext ctx) {
		ReferenceValue prev = (ReferenceValue) visit(ctx.variable());
		IReturnValue value = prev.getReference().getValue();
		String fieldName = ctx.SYMBOL().getText().toLowerCase();
		if (value instanceof ObjectValue) {
			WorldObject obj = ((ObjectValue) value).getObj();
			return new ReferenceValue(obj.getField(fieldName));
		} else {
			return null; // the variable is not an object
		}
	}

	/**
	 * Returns the value of a variable.
	 * 
	 * @return The value contained into the variable.
	 */
	@Override
	public IReturnValue visitVariableOp(VariableOpContext ctx) {
		ReferenceValue var = (ReferenceValue) visit(ctx.variable());
		return var.getReference().getValue();
	}

	/**
	 * Executes a function or method and returns the return value.
	 * <p>
	 * function_call : (variable '.')? SYMBOL '(' (operation (',' operation)*)?
	 * ')' ;
	 */
	@Override
	public IReturnValue visitFunction_call(Function_callContext ctx) {
		String methodName = ctx.SYMBOL().getText().toLowerCase();
		if (ctx.variable() != null) {
			ReferenceValue ref = (ReferenceValue) visit(ctx.variable());
			if (ref.getReference().getValue() instanceof ObjectValue) {
				ObjectValue obj = (ObjectValue) ref.getReference().getValue();

				// arguments
				List<IReturnValue> args = new ArrayList<>();
				for (OperationContext x : ctx.operation()) {
					args.add(visit(x));
				}

				ClassMethod m = obj.getObj().getUserClass().getMethod(methodName);

				if (!m.checkArgs(args)) {
					return null;
					// TODO: error
				}

				// SETTING SCOPE
				ObjectScope os = new ObjectScope(obj.getObj());
				FunctionScope fs = new FunctionScope(m, args, m.getReturnArgumentName(), os);
				getSM().pushScope(fs);

				visit(m.getNode());

				getSM().popScope();

				if (m.hasReturnArgument())
					return fs.getReturnVariable().getValue();
			}
		} else {
			// TODO: non-class functions
		}
		return null;
	}

	/**
	 * Creates a new object with the specified class, and returns it.
	 * <p>
	 * new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public IReturnValue visitNew_obj(New_objContext ctx) {
		UserDefinedClass objClass = getSM().getClassFromName(ctx.SYMBOL().getText().toLowerCase());

		List<IReturnValue> args = new ArrayList<>();
		for (OperationContext a : ctx.operation()) {
			args.add(visit(a));
		}

		if (objClass.getConstructor() == null && args.size() > 1) {
			// Unnecessary arguments, there is no constructor
			return null;
			// TODO: error
		}
		if (objClass.getConstructor() != null && !objClass.getConstructor().checkArgs(args)) {
			// Wrong constructor arguments
			return null;
			// TODO: error
		}

		WorldObject obj = new WorldObject(objClass, getSM().getCurrentRoom());

		if (objClass.getConstructor() != null) {
			ClassMethod constructor = objClass.getConstructor();
			ObjectScope os = new ObjectScope(obj);
			getSM().pushScope(new FunctionScope(constructor, args, constructor.getReturnArgumentName(), os));
			visit(constructor.getNode());
			getSM().popScope();
		}

		return new ObjectValue(obj);
	}

	/**
	 * IF expression. It executes the code between brackets if the condition is
	 * met.
	 * <p>
	 * exp_if : IF '(' operation ')' nl? '{' nl? code? nl? '}' exp_else?
	 * <p>
	 * | IF '(' operation ')' nl? nl? line? nl? exp_else? ;
	 */
	@Override
	public IReturnValue visitExp_if(Exp_ifContext ctx) {
		IReturnValue condition = visit(ctx.operation());

		// SCOPE
		Scope prevScope = getSM().getScope();
		LoopScope newScope = new LoopScope(prevScope);
		getSM().pushScope(newScope);

		try {
			if (condition.isTrue()) {
				if(ctx.code() != null)
					visit(ctx.code());
				else if(ctx.line() != null)
					visit(ctx.line());
			} else if (ctx.exp_else() != null) {
				visit(ctx.exp_else());
			}
		} catch (ValueCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getSM().popScope();
		return null;
	}

	/**
	 * ELSE expression. It executes the code between brackets if the previous IF
	 * expression is not executed.
	 * <p>
	 * exp_else : nl? ELSE nl? '{' nl? code? nl? '}'
	 * <p>
	 * | nl? ELSE nl? nl? line? nl? ;
	 */
	@Override
	public IReturnValue visitExp_else(Exp_elseContext ctx) {

		// SCOPE
		Scope prevScope = getSM().getScope();
		LoopScope newScope = new LoopScope(prevScope);
		getSM().pushScope(newScope);

		if(ctx.code() != null)
			visit(ctx.code());
		else if(ctx.line() != null)
			visit(ctx.line());
		getSM().popScope();
		return null;
	}

	/**
	 * FOR expression. It executes the code between brackets one time for
	 * element on the list.
	 * <p>
	 * exp_for : FOR '(' SYMBOL ':' operation ')' nl? '{' nl? code? nl? '}'
	 * <p>
	 * | FOR '(' SYMBOL ':' operation ')' nl? nl? line nl? ;
	 */
	@Override
	public IReturnValue visitExp_for(Exp_forContext ctx) {
		String auxVar = ctx.SYMBOL().getText().toLowerCase();
		IReturnValue origin = visit(ctx.operation());

		// SCOPE
		Scope prevScope = getSM().getScope();
		ForScope newScope;
		if (origin instanceof ListValue)
			newScope = new ForScope(auxVar, (ListValue) origin, prevScope);
		else if (origin instanceof StringValue)
			newScope = new ForScope(auxVar, (StringValue) origin, prevScope);
		else
			return null; // cannot walk other values

		getSM().pushScope(newScope);

		for (IReturnValue v : newScope.getOriginValues()) {
			getSM().setVariable(auxVar, new StoredSymbol(v, false));
			if (ctx.code() != null)
				visit(ctx.code());
		}

		getSM().popScope();
		return null;
	}

	/**
	 * Defines a new class.
	 * <p>
	 * class_def : SYMBOL ( '(' SYMBOL ')' )? ('/n')* '{' ('/n')* fields?
	 * methods? '}' ;
	 */
	@Override
	public IReturnValue visitClass_def(Class_defContext ctx) {
		String className = ctx.SYMBOL(0).getText().toLowerCase();
		UserDefinedClass newClass;
		if (ctx.SYMBOL(1) != null) { // inherit from another class
			String parentName = ctx.SYMBOL(1).getText().toLowerCase();
			newClass = new UserDefinedClass(className, getSM().getClassFromName(parentName), getSM().getCurrentWorld());
		} else { // inherit from "Object" class
			newClass = new UserDefinedClass(className, getSM().getRootClass(), getSM().getCurrentWorld());
		}
		getSM().pushScope(new ClassScope(newClass));
		getSM().addClass(className, newClass);
		if (ctx.fields() != null)
			visit(ctx.fields());
		if (ctx.methods() != null)
			visit(ctx.methods());
		getSM().popScope();
		return null;
	}

	/**
	 * Declares a new variable into the current room.
	 * <p>
	 * If a class is currently being defined, adds a new field to it.
	 * <p>
	 * var_decl : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public IReturnValue visitVar_decl(Var_declContext ctx) {
		IReturnValue type = visit(ctx.data_type());
		String varName = ctx.SYMBOL().getText().toLowerCase();
		if (ctx.operation() != null) {
			type.assign(visit(ctx.operation()));

		}

		// If the Scope is a ClassScope, it will add a field to the current
		// class
		// if is not, it will add a normal variable
		getSM().setVariable(varName, new StoredSymbol(type));

		return null;
	}

	/**
	 * Defines a new method in the current class.
	 * <p>
	 * method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl?
	 * '{' code? '}' ;
	 */
	@Override
	public IReturnValue visitMethod(MethodContext ctx) {
		// TODO: non-class methods?
		UserDefinedClass curClass = ((ClassScope) getSM().getScope()).getCurrentClass();
		String methodName = ctx.metname.getText().toLowerCase();
		ClassMethod cm = new ClassMethod(ctx.code());

		if (methodName.equals(curClass.getClassName())) { // CONSTRUCTOR
			if (ctx.ASSIGN() != null) {
				// TODO: error
				return null;
			}
			curClass.setConstructor(cm); // TODO: at this moment only one
											// constructor is allowed
		} else {
			// Return value
			if (ctx.ASSIGN() != null) {
				String returnName = ctx.SYMBOL(0).getText().toLowerCase();
				cm.setReturnArgument(returnName, visit(ctx.data_type()));

			}
			curClass.addMethod(methodName, cm);
		}

		if (ctx.args() != null) {
			// TODO: little fix to add args
			((ClassScope) getSM().getScope()).setDefiningMethod(cm);
			visit(ctx.args());
			((ClassScope) getSM().getScope()).setDefiningMethod(null);
		}

		return null;
	}

	/**
	 * Defines the arguments of the method or function.
	 * <p>
	 * args : data_type SYMBOL ( ',' data_type SYMBOL )* ;
	 */
	@Override
	public IReturnValue visitArgs(ArgsContext ctx) {
		for (int i = 0; i < ctx.SYMBOL().size(); i++) {
			String argName = ctx.SYMBOL(i).getText().toLowerCase();
			IReturnValue typeV = visit(ctx.data_type(i));

			((ClassScope) getSM().getScope()).getDefiningMethod().addArgument(argName, typeV);
		}
		return null;
	}

	/**
	 * Identifies an object by its ID.
	 * <p>
	 * sharp_identifier : '#' INT_NUMBER ;
	 */
	@Override
	public IReturnValue visitSharp_identifier(Sharp_identifierContext ctx) {
		long id = Long.valueOf(ctx.INT_NUMBER().getText());
		return new ObjectValue(getSM().getObject(id));
	}

	/**
	 * Returns a room by its path.
	 * <p>
	 * room : '@' room_path ;
	 */
	@Override
	public IReturnValue visitRoom(RoomContext ctx) {
		String path = ctx.room_path().getText();
		WorldRoom room;
		if (path.startsWith("/")) { // absolute path
			room = getSM().getRoom(path);
		} else { // relative path
			String curRoom = getSM().getCurrentRoom().getLongName();
			String curPath = curRoom.substring(0, curRoom.lastIndexOf('/') + 1);
			room = getSM().getRoom(path, curPath);
		}
		if (room != null) {
			return new LocationValue(room);
		}
		return null;
	}

	/**
	 * Assigns an object to an user.
	 * <p>
	 * exp_user : USERNAME '->' operation ;
	 */
	@Override
	public IReturnValue visitExp_user(Exp_userContext ctx) {
		// We get the user name without the '$' symbol
		String username = ctx.USERNAME().getText().toLowerCase().substring(1);
		IReturnValue objref = visit(ctx.operation());
		if (objref instanceof ObjectValue) {
			WorldObject obj = ((ObjectValue) objref).getObj();
			// TODO: check user
			getSM().setUserObject(username, obj);
		}
		return null;
	}

}