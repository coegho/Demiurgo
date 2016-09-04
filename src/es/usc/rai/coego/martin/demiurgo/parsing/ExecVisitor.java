package es.usc.rai.coego.martin.demiurgo.parsing;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.RuleNode;

import es.usc.rai.coego.martin.demiurgo.coe.COEBaseVisitor;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.AddSubContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ArgsContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.AssignContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.BoolContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CompareContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.DiceContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.EchoContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_elseContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_forContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_ifContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_userContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.FloatContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.FloatTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Function_callContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IndexAssignContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IndexContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntermediateVariableContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ListContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ListTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.LogicContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MethodContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MoveContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MulDivContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MultDiceContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.NegativeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.New_objContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.OperationContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ParensContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RoomContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RoomTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RootObjectContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RootVariableContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Sharp_identifierContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.StringContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.StringTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.SymbolTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Var_declContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.VariableOpContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ArgumentMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.BadConstructorException;
import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.IrregularListException;
import es.usc.rai.coego.martin.demiurgo.exceptions.NotAListException;
import es.usc.rai.coego.martin.demiurgo.exceptions.NotAnObjectException;
import es.usc.rai.coego.martin.demiurgo.exceptions.RoomNotFoundException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UndeclaredVariableException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UndefinedClassException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UnexistentUserException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.exceptions.WrongMovementException;
import es.usc.rai.coego.martin.demiurgo.scopes.ClassScope;
import es.usc.rai.coego.martin.demiurgo.scopes.ForScope;
import es.usc.rai.coego.martin.demiurgo.scopes.FunctionScope;
import es.usc.rai.coego.martin.demiurgo.scopes.LoopScope;
import es.usc.rai.coego.martin.demiurgo.scopes.ObjectScope;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.universe.ClassMethod;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.values.FloatValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.LocationValue;
import es.usc.rai.coego.martin.demiurgo.values.NullValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ReferenceValue;
import es.usc.rai.coego.martin.demiurgo.values.StringValue;
import gal.republica.coego.demiurgo.lib.ReturnValueTypes;

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
public abstract class ExecVisitor extends COEBaseVisitor<ValueInterface> {

	protected ScopeManager sm;
	protected ErrorHandler errors;

	public ExecVisitor(ErrorHandler errors) {
		this.errors = errors;
	}

	public ScopeManager getSM() {
		return sm;
	}

	public void setSM(ScopeManager sm) {
		this.sm = sm;
	}

	/**
	 * Emits output. Useful for debugging and helping the DX to describe the
	 * situation.
	 */
	@Override
	public ValueInterface visitEcho(EchoContext ctx) {
		ValueInterface v = visit(ctx.operation());
		if (errors.hasErrors())
			return null;

		// TODO: temporal code for debugging
		try {
			System.out.println(v.castToString());
		} catch (ValueCastException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * <p>
	 * Returns an integer value found on the input.
	 * </p>
	 */
	@Override
	public ValueInterface visitInt(IntContext ctx) {
		return new IntegerValue(Integer.valueOf(ctx.INT_NUMBER().getText()));
	}

	/**
	 * <p>
	 * Returns a float value found on the input.
	 * </p>
	 */
	@Override
	public ValueInterface visitFloat(FloatContext ctx) {
		return new FloatValue(Float.valueOf(ctx.FLOAT_NUMBER().getText()));
	}

	/**
	 * <p>
	 * Returns a string value found on the input.
	 * </p>
	 */
	@Override
	public ValueInterface visitString(StringContext ctx) {
		String str = ctx.TEXT_STRING().getText();
		return new StringValue(str.substring(1, str.length() - 1));
	}

	/**
	 * <p>
	 * Returns an integer equivalent to a boolean value found on the input.
	 * </p>
	 */
	@Override
	public ValueInterface visitBool(BoolContext ctx) {
		switch (ctx.BOOLEAN().getSymbol().getType()) {
		case COEParser.TRUE:
			return new IntegerValue(1);
		case COEParser.FALSE:
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
	public ValueInterface visitList(ListContext ctx) {
		try {
			ReturnValueTypes type = null;
			int depth = -1;
			List<ValueInterface> l = new ArrayList<>();
			for (OperationContext op : ctx.operation()) {
				ValueInterface v = visit(op);
				if (errors.hasErrors())
					return null;
				if ((depth == -1 || depth == v.getDepth()) && (type == null || type == v.getType())) {
					depth = v.getDepth();
					type = v.getType();
					l.add(v);
				} else {
					throw new IrregularListException();
				}
			}

			ListValue lv = new ListValue(l);
			lv.setDepth(depth);
			lv.setInnerType(type);

			return lv;
		} catch (IrregularListException ex) {
			errors.notifyError(ex);
		}
		return null;
	}

	/**
	 * Returns a default FLOAT value (it counts as a type).
	 */
	@Override
	public ValueInterface visitFloatType(FloatTypeContext ctx) {
		return FloatValue.defaultValue();
	}

	/**
	 * Returns a default INT value (it counts as a type).
	 */
	@Override
	public ValueInterface visitIntType(IntTypeContext ctx) {
		return IntegerValue.defaultValue();
	}

	/**
	 * Returns a default STRING value (it counts as a type).
	 */
	@Override
	public ValueInterface visitStringType(StringTypeContext ctx) {
		return StringValue.defaultValue();
	}

	/**
	 * Returns a default LIST value (it counts as a type).
	 * <p>
	 * data_type: data_type '[]'
	 */
	@Override
	public ValueInterface visitListType(ListTypeContext ctx) {
		ValueInterface innerType = visit(ctx.data_type());
		if (errors.hasErrors())
			return null;
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
	public ValueInterface visitSymbolType(SymbolTypeContext ctx) {
		try {
			// First we get the type, in this case, a class
			String className = ctx.SYMBOL().getText().toLowerCase();
			UserDefinedClass itsClass = getSM().getClassFromName(className);
			if (itsClass == null) {
				throw new UndefinedClassException(className);
			}
			return ObjectValue.defaultValue(itsClass);
		} catch (UndefinedClassException e) {
			errors.notifyError(e);
			return null;
		}
	}

	/**
	 * Returns a default LOCATION value (it counts as a type).
	 */
	@Override
	public ValueInterface visitRoomType(RoomTypeContext ctx) {
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
	public ValueInterface visitCompare(CompareContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			if (errors.hasErrors())
				return null;
			switch (ctx.op.getType()) {
			case COEParser.EQ:
				return left.eq(right);
			case COEParser.NEQ:
				return left.neq(right);
			case COEParser.GREQ:
				return left.greq(right);
			case COEParser.LESEQ:
				return left.leseq(right);
			case COEParser.GREAT:
				return left.great(right);
			case COEParser.LESS:
			default:
				return left.less(right);
			}
		} catch (IllegalOperationException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * Performs an arithmetic operation between two values.
	 * <p>
	 * This operation may be one of the following:
	 * <ul>
	 * <li>Addition</li>
	 * <li>Subtraction</li>
	 * </ul>
	 */
	@Override
	public ValueInterface visitAddSub(AddSubContext ctx) {

		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			if (errors.hasErrors())
				return null;
			switch (ctx.op.getType()) {
			case COEParser.ADD:
				return left.add(right);
			case COEParser.SUB:
			default:
				return left.sub(right);
			}
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
	}

	/**
	 * Performs an arithmetic operation between two values.
	 * <p>
	 * This operation may be one of the following:
	 * <ul>
	 * <li>Multiplication</li>
	 * <li>Division</li>
	 * </ul>
	 */
	@Override
	public ValueInterface visitMulDiv(MulDivContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			if (errors.hasErrors())
				return null;
			switch (ctx.op.getType()) {
			case COEParser.MUL:
				return left.mul(right);
			case COEParser.DIV:
			default:
				return left.div(right);
			}
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
	}

	/**
	 * <p>
	 * Returns the value of the operation between parentheses.
	 * </p>
	 */
	@Override
	public ValueInterface visitParens(ParensContext ctx) {
		return visit(ctx.operation());
	}

	/**
	 * <p>
	 * Performs a dice roll operation.
	 * </p>
	 */
	@Override
	public ValueInterface visitDice(DiceContext ctx) {
		try {
			ValueInterface v = visit(ctx.operation());
			if (errors.hasErrors())
				return null;
			return v.dice();
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
	}

	/**
	 * <p>
	 * Performs a multiple dice roll operation.
	 * </p>
	 */
	@Override
	public ValueInterface visitMultDice(MultDiceContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			if (errors.hasErrors())
				return null;
			return left.multDice(right);
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
	}

	/**
	 * <p>
	 * Extracts one item of a list.
	 * </p>
	 */
	@Override
	public ValueInterface visitIndex(IndexContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			int index = right.castToInteger();
			if (errors.hasErrors())
				return null;
			return left.getFromIndex(index);
		} catch (IllegalOperationException e) {
			errors.notifyError(e);
		} catch (ValueCastException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * <p>
	 * Performs a negative operation.
	 * </p>
	 */
	@Override
	public ValueInterface visitNegative(NegativeContext ctx) {
		try {
			ValueInterface v = visit(ctx.operation());
			if (errors.hasErrors())
				return null;
			return v.negative();
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
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
	public ValueInterface visitLogic(LogicContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			if (errors.hasErrors())
				return null;
			switch (ctx.op.getType()) {
			case COEParser.AND:
				return left.and(right);
			case COEParser.OR:
			default:
				return left.or(right);
			}
		} catch (IllegalOperationException e) {
			errors.notifyError(e);

		}
		return null;
	}

	/**
	 * Assigns the value on the right to the variable on the left.
	 * <p>
	 * operation: variable ASSIGN operation
	 */
	@Override
	public ValueInterface visitAssign(AssignContext ctx) {
		try {
			ValueInterface l = visit(ctx.variable());
			ValueInterface right = visit(ctx.operation());
			if (errors.hasErrors())
				return null;
			ReferenceValue left = (ReferenceValue) l;
			if (left.getReference().canAssign(right)) {
				left.getReference().assign(right);
				return left.getReference();
			} else {
				throw new ValueCastException();
			}
		} catch (ValueCastException ex) {
			errors.notifyError(ex);
		}
		return null;
	}

	/**
	 * Assigns the value on the right into the given position of the variable on
	 * the left.
	 * </p>
	 * operation: variable '[' operation ']' ASSIGN operation
	 */
	@Override
	public ValueInterface visitIndexAssign(IndexAssignContext ctx) {
		ValueInterface r = visit(ctx.variable());
		ValueInterface i = visit(ctx.operation(0));
		ValueInterface value = visit(ctx.operation(1));
		if (errors.hasErrors())
			return null;
		ReferenceValue ref = (ReferenceValue) r;
		int index;
		ValueInterface element;
		try {
			index = i.castToInteger();

			if (!(ref.getReference() instanceof ListValue))
				throw new NotAListException();
			element = ref.getReference().getFromIndex(index);
			if (element.canAssign(value)) {
				element.assign(value);
				return value;
			} else {
				throw new ValueCastException();
			}
		} catch (ValueCastException e) {
			errors.notifyError(e);
		} catch (NotAListException e) {
			errors.notifyError(e);
		} catch (IllegalOperationException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * Moves a game object between rooms.
	 * <p>
	 * operation: operation MOVE operation
	 */
	@Override
	public ValueInterface visitMove(MoveContext ctx) {
		ValueInterface mobile = visit(ctx.operation(0));
		ValueInterface room = visit(ctx.operation(1));
		if (errors.hasErrors())
			return null;
		try {

			if (mobile instanceof ObjectValue && room instanceof LocationValue) {
				((ObjectValue) mobile).getObj().moveTo(((LocationValue) room).getLocation());
			} else {
				throw new WrongMovementException();
			}
		} catch (WrongMovementException e) {
			errors.notifyError(e);
			return null;
		}
		return new NullValue();
	}

	/**
	 * <p>
	 * Returns a variable found on the input.
	 * </p>
	 */
	@Override
	public ValueInterface visitRootVariable(RootVariableContext ctx) {
		try {
			ValueInterface v = getSM().getVariable(ctx.SYMBOL().getText().toLowerCase());
			if (v == null)
				throw new UndeclaredVariableException();
			return new ReferenceValue(v);
		} catch (UndeclaredVariableException e) {
			errors.notifyError(e);
		}
		return null;
	}
	
	
	/**
	 * Returns a ReferenceObject with an object identified by its ID.
	 */
	@Override
	public ValueInterface visitRootObject(RootObjectContext ctx) {
		return new ReferenceValue(visit(ctx.sharp_identifier()));
	}

	/**
	 * Returns a variable within another variable (a field within an object).
	 */
	@Override
	public ValueInterface visitIntermediateVariable(IntermediateVariableContext ctx) {
		ValueInterface v = visit(ctx.variable());
		if (errors.hasErrors())
			return null;
		try {
			ReferenceValue prev = (ReferenceValue) v;
			ValueInterface value = prev.getReference();
			String fieldName = ctx.SYMBOL().getText().toLowerCase();
			if (value instanceof ObjectValue) {
				WorldObject obj = ((ObjectValue) value).getObj();
				if (obj.getField(fieldName) == null) {
					throw new UndeclaredVariableException();
				}
				return new ReferenceValue(obj.getField(fieldName));
			} else {
				throw new NotAnObjectException();
			}
		} catch (NotAnObjectException | UndeclaredVariableException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * Returns the value of a variable.
	 * 
	 * @return The value contained into the variable.
	 */
	@Override
	public ValueInterface visitVariableOp(VariableOpContext ctx) {
		ValueInterface v = visit(ctx.variable());
		if (errors.hasErrors())
			return null;
		ReferenceValue var = (ReferenceValue) v;
		return var.getReference().cloneValue();
	}

	/**
	 * Executes a function or method and returns the return value.
	 * <p>
	 * function_call : (variable '.')? SYMBOL '(' (operation (',' operation)*)?
	 * ')' ;
	 */
	@Override
	public ValueInterface visitFunction_call(Function_callContext ctx) {
		ValueInterface v = visit(ctx.variable());
		try {
			String methodName = ctx.SYMBOL().getText().toLowerCase();
			if (ctx.variable() != null) {
				ReferenceValue ref = (ReferenceValue) v;
				if (ref.getReference() instanceof ObjectValue) {
					ObjectValue obj = (ObjectValue) ref.getReference();

					if (obj.getObj().getUserClass().getClassName().equalsIgnoreCase(methodName)) {
						throw new IllegalOperationException();
					}
					// arguments
					List<ValueInterface> args = new ArrayList<>();
					for (OperationContext x : ctx.operation()) {
						ValueInterface a = visit(x);
						if (errors.hasErrors())
							return null;
						args.add(a);
					}

					ClassMethod m = obj.getObj().getUserClass().getMethod(methodName);

					if (!m.checkArgs(args)) {
						System.out.println(m.getArgumentType("outro"));
						throw new ArgumentMismatchException();
					}

					// SETTING SCOPE
					ObjectScope os = new ObjectScope(obj.getObj());
					FunctionScope fs = new FunctionScope(m, args, m.getReturnArgumentName(), os);
					getSM().pushScope(fs);

					visit(m.getNode());

					getSM().popScope();

					if (m.hasReturnArgument())
						return fs.getReturnVariable();
				}
			} else {
				// TODO: non-class functions
			}
		} catch (ArgumentMismatchException e) {
			errors.notifyError(e);
		} catch (IllegalOperationException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * Creates a new object with the specified class, and returns it.
	 * <p>
	 * new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public ValueInterface visitNew_obj(New_objContext ctx) {
		try {
			UserDefinedClass objClass = getSM().getClassFromName(ctx.SYMBOL().getText().toLowerCase());

			List<ValueInterface> args = new ArrayList<>();
			for (OperationContext x : ctx.operation()) {
				ValueInterface a = visit(x);
				if (errors.hasErrors())
					return null;
				args.add(a);
			}

			if (objClass.getConstructor() == null && args.size() > 1) {
				// Unnecessary arguments, there is no constructor
				throw new ArgumentMismatchException();
			}
			if (objClass.getConstructor() != null && !objClass.getConstructor().checkArgs(args)) {
				// Wrong constructor arguments
				throw new ArgumentMismatchException();
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
		} catch (ArgumentMismatchException e) {
			errors.notifyError(e);
		}
		return null;
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
	public ValueInterface visitExp_if(Exp_ifContext ctx) {
		ValueInterface condition = visit(ctx.operation());
		if (errors.hasErrors())
			return null;

		// SCOPE
		Scope prevScope = getSM().getScope();
		LoopScope newScope = new LoopScope(prevScope);
		getSM().pushScope(newScope);

		try {
			if (condition.isTrue()) {
				if (ctx.code() != null)
					visit(ctx.code());
				else if (ctx.line() != null)
					visit(ctx.line());
			} else if (ctx.exp_else() != null) {
				visit(ctx.exp_else());
			}
		} catch (ValueCastException e) {
			errors.notifyError(e);
		}

		getSM().popScope();
		return new NullValue();
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
	public ValueInterface visitExp_else(Exp_elseContext ctx) {

		// SCOPE
		Scope prevScope = getSM().getScope();
		LoopScope newScope = new LoopScope(prevScope);
		getSM().pushScope(newScope);

		if (ctx.code() != null)
			visit(ctx.code());
		else if (ctx.line() != null)
			visit(ctx.line());
		getSM().popScope();
		return new NullValue();
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
	public ValueInterface visitExp_for(Exp_forContext ctx) {
		try {
			String auxVar = ctx.SYMBOL().getText().toLowerCase();
			ValueInterface origin = visit(ctx.operation());
			if (errors.hasErrors())
				return null;

			// SCOPE
			Scope prevScope = getSM().getScope();
			ForScope newScope;
			if (origin instanceof ListValue)
				newScope = new ForScope(auxVar, (ListValue) origin, prevScope);
			else if (origin instanceof StringValue)
				newScope = new ForScope(auxVar, (StringValue) origin, prevScope);
			else
				throw new IllegalOperationException(); // cannot walk other
														// values

			getSM().pushScope(newScope);

			for (ValueInterface v : newScope.getOriginValues()) {
				ValueInterface vv = v.cloneValue();
				v.setWritable(false);
				getSM().setVariable(auxVar, vv);
				if (ctx.code() != null) {
					visit(ctx.code());
					if (errors.hasErrors())
						return null;
				}
			}

			getSM().popScope();

		} catch (IllegalOperationException e) {
			errors.notifyError(e);
			return null;
		}
		return new NullValue();
	}

	/**
	 * Declares a new variable into the current room.
	 * <p>
	 * If a class is currently being defined, adds a new field to it.
	 * <p>
	 * var_decl : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public ValueInterface visitVar_decl(Var_declContext ctx) {
		ValueInterface type = visit(ctx.data_type());

		String varName = ctx.SYMBOL().getText().toLowerCase();
		if (ctx.operation() != null) {
			ValueInterface v = visit(ctx.operation());
			if (errors.hasErrors())
				return null;
			type.assign(v);

		}

		// If the Scope is a ClassScope, it will add a field to the current
		// class
		// if is not, it will add a normal variable
		getSM().setVariable(varName, type);

		return new NullValue();
	}

	/**
	 * Defines a new method in the current class.
	 * <p>
	 * method : ( data_type SYMBOL ASSIGN )? metname=SYMBOL '(' args? ')' nl?
	 * '{' code? '}' ;
	 */
	@Override
	public ValueInterface visitMethod(MethodContext ctx) {
		try {
			// TODO: non-class methods?
			UserDefinedClass curClass = ((ClassScope) getSM().getScope()).getCurrentClass();
			String methodName = ctx.metname.getText().toLowerCase();
			ClassMethod cm = new ClassMethod(ctx.code());

			if (methodName.equals(curClass.getClassName())) { // CONSTRUCTOR
				if (ctx.ASSIGN() != null) {
					throw new BadConstructorException();
				}
				curClass.setConstructor(cm); // TODO: at this moment only one
												// constructor is allowed
			} else {
				// Return value
				if (ctx.ASSIGN() != null) {
					String returnName = ctx.SYMBOL(0).getText().toLowerCase();
					ValueInterface t = visit(ctx.data_type());
					if (errors.hasErrors())
						return null;
					cm.setReturnArgument(returnName, t);

				}
				curClass.addMethod(methodName, cm);
			}

			if (ctx.args() != null) {
				// little fix to add args
				((ClassScope) getSM().getScope()).setDefiningMethod(cm);
				visit(ctx.args());
				((ClassScope) getSM().getScope()).setDefiningMethod(null);
			}
		} catch (BadConstructorException e) {
			errors.notifyError(e);
			return null;
		}
		return new NullValue();
	}

	/**
	 * Defines the arguments of the method or function.
	 * <p>
	 * args : data_type SYMBOL ( ',' data_type SYMBOL )* ;
	 */
	@Override
	public ValueInterface visitArgs(ArgsContext ctx) {
		for (int i = 0; i < ctx.SYMBOL().size(); i++) {
			String argName = ctx.SYMBOL(i).getText().toLowerCase();
			ValueInterface typeV = visit(ctx.data_type(i));
			if (errors.hasErrors())
				return null;

			((ClassScope) getSM().getScope()).getDefiningMethod().addArgument(argName, typeV);
		}
		return new NullValue();
	}

	/**
	 * Identifies an object by its ID.
	 * <p>
	 * sharp_identifier : '#' INT_NUMBER ;
	 */
	@Override
	public ValueInterface visitSharp_identifier(Sharp_identifierContext ctx) {
		long id = Long.valueOf(ctx.INT_NUMBER().getText());
		return new ObjectValue(getSM().getObject(id));
	}

	/**
	 * Returns a room by its path.
	 * <p>
	 * room : '@' room_path ;
	 */
	@Override
	public ValueInterface visitRoom(RoomContext ctx) {
		try {
			String path = ctx.room_path().getText();
			WorldRoom room;
			if (path.startsWith("/")) { // absolute path
				room = getSM().getRoom(path);
			} else { // relative path
				String curRoom = getSM().getCurrentRoom().getLongPath();
				String curPath = curRoom.substring(0, curRoom.lastIndexOf('/') + 1);
				room = getSM().getRoom(path, curPath);
			}
			if (room != null) {
				return new LocationValue(room);
			} else
				throw new RoomNotFoundException();
		} catch (RoomNotFoundException e) {
			errors.notifyError(e);
		}
		return null;
	}

	/**
	 * Assigns an object to an user.
	 * <p>
	 * exp_user : USERNAME '->' operation ;
	 */
	@Override
	public ValueInterface visitExp_user(Exp_userContext ctx) {
		try {
			// We get the user name without the '$' symbol
			String username = ctx.USERNAME().getText().toLowerCase().substring(1);
			ValueInterface objref = visit(ctx.operation());
			if (errors.hasErrors())
				return null;
			if (objref instanceof ObjectValue) {
				WorldObject obj = ((ObjectValue) objref).getObj();
				User user = getSM().getCurrentWorld().getUser(username);
				if (user == null) {
					throw new UnexistentUserException(username);
				}
				getSM().setUserObject(user, obj);
			}
			return new NullValue();
		} catch (UnexistentUserException e) {
			errors.notifyError(e);
		}
		return null;
	}

	@Override
	protected boolean shouldVisitNextChild(RuleNode node, ValueInterface currentResult) {
		return !errors.hasErrors();
	}

}