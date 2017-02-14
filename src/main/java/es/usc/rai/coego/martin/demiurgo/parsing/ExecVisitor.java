package es.usc.rai.coego.martin.demiurgo.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.usc.rai.coego.martin.demiurgo.coe.COEBaseVisitor;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.AddSubContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.AssignContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.BoolContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.CompareContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ConcatContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.DiceContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.EchoContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_elseContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_forContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_ifContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Exp_userContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.FloatContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.FloatTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Function_callContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.GetIdContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.GetLocContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.GetUserContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IndexContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.InstanceofOpContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.IntermediateVariableContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ListContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ListTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.LocationContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.LogicContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MethodOpContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MoveContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MulDivContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.MultDiceContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.NegativeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.New_objContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.NotOpContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.NullObjContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.OperationContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ParensContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RoomContentsContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.RoomTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.Sharp_identifierContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.SomeContentsContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.SomeRoomContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.StringContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.StringTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.SymbolTypeContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.ThisRoomContext;
import es.usc.rai.coego.martin.demiurgo.coe.COEParser.VariableContext;
import es.usc.rai.coego.martin.demiurgo.exceptions.ArgumentMismatchException;
import es.usc.rai.coego.martin.demiurgo.exceptions.CannotLoopException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ConstructorCalledLikeAMethodException;
import es.usc.rai.coego.martin.demiurgo.exceptions.IllegalOperationException;
import es.usc.rai.coego.martin.demiurgo.exceptions.IrregularListException;
import es.usc.rai.coego.martin.demiurgo.exceptions.NotAnObjectException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ObjectInsideItselfException;
import es.usc.rai.coego.martin.demiurgo.exceptions.RoomNotFoundException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UndeclaredVariableException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UndefinedClassException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UndefinedMethodException;
import es.usc.rai.coego.martin.demiurgo.exceptions.UnexistentUserException;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.exceptions.WrongMovementException;
import es.usc.rai.coego.martin.demiurgo.parsing.functions.BuiltinFunction;
import es.usc.rai.coego.martin.demiurgo.scopes.ForScope;
import es.usc.rai.coego.martin.demiurgo.scopes.FunctionScope;
import es.usc.rai.coego.martin.demiurgo.scopes.LoopScope;
import es.usc.rai.coego.martin.demiurgo.scopes.ObjectScope;
import es.usc.rai.coego.martin.demiurgo.scopes.Scope;
import es.usc.rai.coego.martin.demiurgo.universe.ClassMethod;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass.DefaultField;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoMethod;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.Inventory;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.values.FloatValue;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.InventoryValue;
import es.usc.rai.coego.martin.demiurgo.values.ListValue;
import es.usc.rai.coego.martin.demiurgo.values.LocationValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;
import es.usc.rai.coego.martin.demiurgo.values.RoomValue;
import es.usc.rai.coego.martin.demiurgo.values.StringValue;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

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

	public ExecVisitor() {
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
	 * <p>
	 * ECHO operation
	 */
	@Override
	public ValueInterface visitEcho(EchoContext ctx) {
		ValueInterface v = visit(ctx.operation());

		// TODO: temporal code for debugging
		try {
			System.out.println(v.castToString());
		} catch (ValueCastException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.operation().start.getLine());
			e.setColumn(ctx.operation().start.getCharPositionInLine());
			throw new RuntimeException(e);
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
		switch (ctx.v.getType()) {
		case COEParser.TRUE:
			return new IntegerValue(1);
		case COEParser.FALSE:
		default:
			return new IntegerValue(0);
		}
	}

	/**
	 * Returns a list value found on the input.
	 * <p>
	 * '{' (operation (',' operation)*)? '}'
	 */
	@Override
	public ValueInterface visitList(ListContext ctx) {
		try {
			ReturnValueTypes type = null;
			int depth = -1;
			List<ValueInterface> l = new ArrayList<>();
			for (OperationContext op : ctx.operation()) {
				ValueInterface v = visit(op);

				if ((depth == -1 || depth == v.getDepth()) && (type == null || type == v.getType())) {
					depth = v.getDepth();
					type = v.getType();
					l.add(v);
				} else {
					throw new IrregularListException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
							ctx.start.getStartIndex());
				}
			}

			ListValue lv = new ListValue(l, depth + 1, type);

			return lv;
		} catch (IrregularListException ex) {
			throw new RuntimeException(ex);
		}
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

		if(innerType instanceof ListValue && ((ListValue)innerType).getClassType() != null) {
			return ListValue.defaultValue(((ListValue)innerType).getClassType(), innerType.getDepth() + 1);
		}
		else if(innerType instanceof ObjectValue) {
			return ListValue.defaultValue(((ObjectValue)innerType).getClassType(), innerType.getDepth() + 1);
		}
		else {
			return ListValue.defaultValue(innerType.getInnerType(), innerType.getDepth() + 1);
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
			DemiurgoClass itsClass = getSM().getClassFromName(className);
			if (itsClass == null) {
				throw new UndefinedClassException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), className);
			}
			return ObjectValue.defaultValue(itsClass);
		} catch (UndefinedClassException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns a default ROOM value (it counts as a type).
	 */
	@Override
	public ValueInterface visitRoomType(RoomTypeContext ctx) {
		return RoomValue.defaultValue(getSM().getCurrentWorld());
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
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.op.getLine());
			e.setColumn(ctx.op.getCharPositionInLine());
			throw new RuntimeException(e);
		}
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

			switch (ctx.op.getType()) {
			case COEParser.ADD:
				return left.add(right);
			case COEParser.SUB:
			default:
				return left.sub(right);
			}
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.op.getLine());
			e.setColumn(ctx.op.getCharPositionInLine());
			throw new RuntimeException(e);

		}
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

			switch (ctx.op.getType()) {
			case COEParser.MUL:
				return left.mul(right);
			case COEParser.DIV:
			default:
				return left.div(right);
			}
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.op.getLine());
			e.setColumn(ctx.op.getCharPositionInLine());
			throw new RuntimeException(e);

		}
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
	 * Performs a dice roll operation.
	 * <p>
	 * D operation
	 */
	@Override
	public ValueInterface visitDice(DiceContext ctx) {
		try {
			ValueInterface v = visit(ctx.operation());

			return v.dice();
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.operation().start.getLine());
			e.setColumn(ctx.operation().start.getCharPositionInLine());
			throw new RuntimeException(e);

		}
	}

	/**
	 * Performs a multiple dice roll operation.
	 * <p>
	 * operation D operation
	 */
	@Override
	public ValueInterface visitMultDice(MultDiceContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));

			return left.multDice(right);
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.D().getSymbol().getLine());
			e.setColumn(ctx.D().getSymbol().getCharPositionInLine());
			throw new RuntimeException(e);

		}
	}

	/**
	 * Extracts one item of a list.
	 * <p>
	 * operation '[' operation ']'
	 */
	@Override
	public ValueInterface visitIndex(IndexContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));
			int index = right.castToInteger();

			return left.getFromIndex(index);
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.start.getLine());
			e.setColumn(ctx.start.getCharPositionInLine());
			throw new RuntimeException(e);
		} catch (ValueCastException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.operation(1).start.getLine());
			e.setColumn(ctx.operation(1).start.getCharPositionInLine());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Performs a "NOT" logic operation.
	 */
	@Override
	public ValueInterface visitNotOp(NotOpContext ctx) {
		try {
			ValueInterface v = visit(ctx.operation());
			return v.not();
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.start.getLine());
			e.setColumn(ctx.start.getCharPositionInLine());
			throw new RuntimeException(e);
		}
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

			return v.negative();
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.start.getLine());
			e.setColumn(ctx.start.getCharPositionInLine());
			throw new RuntimeException(e);
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
	public ValueInterface visitLogic(LogicContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));

			switch (ctx.op.getType()) {
			case COEParser.AND:
				return left.and(right);
			case COEParser.OR:
			default:
				return left.or(right);
			}
		} catch (IllegalOperationException e) {
			e.setStartIndex(ctx.start.getStartIndex());
			e.setLine(ctx.op.getLine());
			e.setColumn(ctx.op.getCharPositionInLine());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Assigns the value on the right to the variable on the left.
	 * <p>
	 * operation ASSIGN operation
	 */
	@Override
	public ValueInterface visitAssign(AssignContext ctx) {
		try {
			ValueInterface left = visit(ctx.operation(0));
			ValueInterface right = visit(ctx.operation(1));

			left.assign(right);
			return left.cloneValue();
		} catch (ValueCastException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Concatenates two lists or a list and an element.
	 * <p>
	 * operation CONCAT operation
	 */
	@Override
	public ValueInterface visitConcat(ConcatContext ctx) {
		ValueInterface left = visit(ctx.operation(0));
		ValueInterface right = visit(ctx.operation(1));
		
		if (Math.abs(left.getDepth() - right.getDepth()) > 1 || (left.getInnerType() != right.getInnerType())) {
			// too different
			throw new RuntimeException(new IllegalOperationException(ctx.CONCAT().getSymbol().getLine(),
					ctx.CONCAT().getSymbol().getCharPositionInLine(), ctx.CONCAT().getSymbol().getStartIndex(),
					left.getTypeName(), right.getTypeName(), "++"));
		}
		if (left.getDepth() < right.getDepth()) {
			// append left to right (at first)
			List<ValueInterface> rightList = ((ListValue) right.cloneValue()).getValue();
			rightList.add(0, left.cloneValue());
			return new ListValue(rightList, right.getDepth(), right.getInnerType());
		}
		if (left.getDepth() > right.getDepth()) {
			// append right to left (at end)
			List<ValueInterface> leftList = ((ListValue) left.cloneValue()).getValue();
			leftList.add(right.cloneValue());
			return new ListValue(leftList, left.getDepth(), left.getInnerType());
		}
		// concats at same depth
		if (left.getDepth() == 0) {
			// none of them are lists
			ListValue list = ListValue.defaultValue(left.getType(), 1);
			list.getValue().add(left.cloneValue());
			list.getValue().add(right.cloneValue());
			return list;
		}
		// two lists
		List<ValueInterface> leftList = ((ListValue) left.cloneValue()).getValue();
		leftList.addAll(((ListValue) right.cloneValue()).getValue());
		return new ListValue(leftList, left.getDepth(), left.getInnerType());
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

		try {

			if (mobile instanceof ObjectValue && room instanceof LocationValue) {
				((ObjectValue) mobile).getObj().moveTo(((LocationValue) room).getLocation());
			} else if (mobile instanceof ListValue && (((ListValue) mobile).getInnerType() == ReturnValueTypes.OBJECT)
					&& (((ListValue) mobile).getDepth() == 1) && room instanceof LocationValue) {
				for (ValueInterface o : ((ListValue) mobile).getValue()) {
					DemiurgoObject obj = ((ObjectValue) o).getObj();
					obj.moveTo(((LocationValue) room).getLocation());
				}
			} else {
				throw new WrongMovementException(ctx.MOVE().getSymbol().getLine(),
						ctx.MOVE().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), mobile.getTypeName(),
						room.getTypeName());
			}
		} catch (WrongMovementException e) {
			throw new RuntimeException(e);
		} catch (ObjectInsideItselfException e) {
			e.setLine(ctx.MOVE().getSymbol().getLine());
			e.setColumn(ctx.MOVE().getSymbol().getCharPositionInLine());
			e.setStartIndex(ctx.MOVE().getSymbol().getStartIndex());
			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * Returns a variable found on the input.
	 * <p>
	 * SYMBOL
	 */
	@Override
	public ValueInterface visitVariable(VariableContext ctx) {
		try {
			String varname = ctx.SYMBOL().getText().toLowerCase();
			ValueInterface v = getSM().getVariable(varname);
			if (v == null)
				throw new UndeclaredVariableException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
						ctx.start.getStartIndex(), varname);
			return v;
		} catch (UndeclaredVariableException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Returns a variable within another variable (a field within an object).
	 * <p>
	 * operation '.' SYMBOL
	 */
	@Override
	public ValueInterface visitIntermediateVariable(IntermediateVariableContext ctx) {
		ValueInterface value = visit(ctx.operation());

		try {
			String fieldName = ctx.SYMBOL().getText().toLowerCase();
			if (value instanceof ObjectValue) {
				DemiurgoObject obj = ((ObjectValue) value).getObj();
				if (obj.getField(fieldName) == null) {
					throw new UndeclaredVariableException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
							ctx.start.getStartIndex(), fieldName);
				}
				return obj.getField(fieldName);
			} else {
				throw new NotAnObjectException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
						ctx.start.getStartIndex(), value.getTypeName());
			}
		} catch (NotAnObjectException | UndeclaredVariableException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Executes a function and returns the return value.
	 * <p>
	 * function_call : SYMBOL '(' (operation (',' operation)*)?
	 * ')' ;
	 */
	@Override
	public ValueInterface visitFunction_call(Function_callContext ctx) {
		// Getting method
		String methodName = ctx.SYMBOL().getText().toLowerCase();
		DemiurgoMethod method;
		Scope parentScope;
		try {
			
			// function without object reference
			// could be a local function or a world function (non-class)
			
			method = getSM().getMethod(methodName);
			if (method instanceof ClassMethod) {
				parentScope = new ObjectScope(getSM().getThisObject());
			} else {
				parentScope = getSM().getGlobalScope();
			}
			
			if (method == null) {
				throw new UndefinedMethodException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), methodName);
			}

			// the method is selected

			// arguments
			List<ValueInterface> args = new ArrayList<>();
			for (OperationContext x : ctx.operation()) {
				ValueInterface a = visit(x);

				args.add(a.cloneValue());
			}

			if (!method.checkArgs(args)) {
				throw new ArgumentMismatchException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), args,
						method.getArgsValues());
			}

			// SETTING SCOPE
			FunctionScope fs = new FunctionScope(method, args, parentScope);
			getSM().pushScope(fs);

			if (method instanceof ClassMethod) {
				((ClassMethod) method).execute(this);
			} else if (method instanceof BuiltinFunction) {
				((BuiltinFunction) method).execute(getSM().getScope());
			}

			getSM().popScope();

			if (method.hasReturnArgument())
				return fs.getReturnVariable().cloneValue();
			else
				return null;

		} catch (UndefinedMethodException | ArgumentMismatchException e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * Executes a method and returns the return value.
	 * <p>
	 * operation '.' SYMBOL '(' (operation (',' operation)*)?
	 * ')' ;
	 */
	@Override
	public ValueInterface visitMethodOp(MethodOpContext ctx) {
		// Getting method
		String methodName = ctx.SYMBOL().getText().toLowerCase();
		ValueInterface left = visit(ctx.operation(0));
		DemiurgoMethod method;
		Scope parentScope;
		try {
			if (left instanceof ObjectValue && ((ObjectValue)left).getObj()!=null) {
				ObjectValue obj = (ObjectValue) left;
				if (!obj.getObj().getDemiurgoClass().getClassName().equalsIgnoreCase(methodName)) {
					method = obj.getObj().getDemiurgoClass().getMethod(methodName);
					parentScope = new ObjectScope(obj.getObj());
				} else {
					// Cannot call a constructor method like an ordinary
					// method
					throw new ConstructorCalledLikeAMethodException(ctx.SYMBOL().getSymbol().getLine(),
							ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(),
							methodName);
				}
			} else {
				throw new NotAnObjectException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(),
						left.getTypeName());
			}
			
			if(method == null) {
				throw new UndefinedMethodException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(),
						methodName);
			}
			// the method is selected

			// arguments
			List<ValueInterface> args = new ArrayList<>();
			for (OperationContext x : ctx.operation().subList(1, ctx.operation().size())) {
				ValueInterface a = visit(x);

				args.add(a.cloneValue());
			}

			if (!method.checkArgs(args)) {
				throw new ArgumentMismatchException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), args,
						method.getArgsValues());
			}

			// SETTING SCOPE
			FunctionScope fs = new FunctionScope(method, args, parentScope);
			getSM().pushScope(fs);

			((ClassMethod) method).execute(this);
			

			getSM().popScope();
			if (method.hasReturnArgument())
				return fs.getReturnVariable().cloneValue();
			else
				return null;

		} catch (ConstructorCalledLikeAMethodException | UndefinedMethodException | ArgumentMismatchException
				| NotAnObjectException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a new object with the specified class, and returns it.
	 * <p>
	 * new_obj : 'new' SYMBOL '(' (operation (',' operation)*)? ')' ;
	 */
	@Override
	public ValueInterface visitNew_obj(New_objContext ctx) {
		try {
			DemiurgoClass objClass = getSM().getClassFromName(ctx.SYMBOL().getText().toLowerCase());

			List<ValueInterface> args = new ArrayList<>();
			for (OperationContext x : ctx.operation()) {
				ValueInterface a = visit(x);
				args.add(a);
			}

			if (objClass.getConstructor() == null && args.size() > 1) {
				// Unnecessary arguments, there is no constructor
				throw new ArgumentMismatchException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), args,
						new ArrayList<>());
			}
			if (objClass.getConstructor() != null && !objClass.getConstructor().checkArgs(args)) {
				// Wrong constructor arguments
				throw new ArgumentMismatchException(ctx.SYMBOL().getSymbol().getLine(),
						ctx.SYMBOL().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), args,
						objClass.getConstructor().getArgsValues());
			}

			DemiurgoObject obj = new DemiurgoObject(objClass, getSM().getCurrentRoom(), null);

			Map<String, ValueInterface> fields = new HashMap<>();
			for (Entry<String, DefaultField> e : objClass.getFields().entrySet()) {
				if (e.getValue().getField() instanceof InventoryValue) {
					Inventory inv = getSM().getCurrentWorld().createInventory(obj, e.getKey());
					fields.put(e.getKey(), new InventoryValue(inv));
				} else {
					ValueInterface f = e.getValue().getField().cloneValue();

					if (e.getValue().getInitialAssign() != null) {
						ValueInterface v = visit(e.getValue().getInitialAssign());
						f.assign(v);
					}
					fields.put(e.getKey(), f);
				}
			}

			obj.setFields(fields);

			if (objClass.getConstructor() != null) {
				ClassMethod constructor = objClass.getConstructor();
				ObjectScope os = new ObjectScope(obj);
				getSM().pushScope(new FunctionScope(constructor, args, os));
				visit(constructor.getNode());
				getSM().popScope();
			}

			return new ObjectValue(obj);
		} catch (ArgumentMismatchException | ValueCastException e) {
			throw new RuntimeException(e);
		}
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
			e.setLine(ctx.operation().start.getLine());
			e.setColumn(ctx.operation().start.getCharPositionInLine());
			throw new RuntimeException(e);
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
	public ValueInterface visitExp_for(Exp_forContext ctx) {
		try {
			String auxVar = ctx.SYMBOL().getText().toLowerCase();
			ValueInterface origin = visit(ctx.operation());

			// SCOPE
			Scope prevScope = getSM().getScope();
			ForScope loopScope;
			loopScope = new ForScope(auxVar, new ListValue(origin.castToList()), prevScope);

			getSM().pushScope(loopScope);

			for (ValueInterface v : loopScope.getOriginValues()) {
				v.setWritable(false);
				getSM().setVariable(auxVar, v);
				if (ctx.code() != null) {
					visit(ctx.code());
				} else if (ctx.line() != null) {
					visit(ctx.line());
				}
			}

			getSM().popScope();

		} catch (ValueCastException e) {
			throw new RuntimeException(new CannotLoopException(ctx.FOR().getSymbol().getLine(),
					ctx.FOR().getSymbol().getCharPositionInLine(), ctx.start.getStartIndex(), e.getType()));
		}
		return null;
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
	 * ROOM room_path
	 */
	@Override
	public ValueInterface visitSomeRoom(SomeRoomContext ctx) {
		try {
			String path = ctx.room_path().getText();
			DemiurgoRoom room;
			if (path.startsWith("/")) { // absolute path
				room = getSM().getRoom(path);
			} else { // relative path
				String curRoom = getSM().getCurrentRoom().getLongPath();
				room = getSM().getRoom(curRoom + '/' + path);
			}
			if (room != null) {
				return new RoomValue(room);
			} else
				throw new RoomNotFoundException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
						ctx.start.getStartIndex(), path);
		} catch (RoomNotFoundException e) {
			throw new RuntimeException(e);
		}
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

			if (objref instanceof ObjectValue) {
				DemiurgoObject obj = ((ObjectValue) objref).getObj();
				User user = getSM().getCurrentWorld().getUser(username);
				if (user == null) {
					throw new UnexistentUserException(ctx.start.getLine(), ctx.start.getCharPositionInLine(),
							ctx.start.getStartIndex(), username);
				}
				getSM().setUserObject(user, obj);
			}
			return null;
		} catch (UnexistentUserException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the contents of a inventory.
	 * <p>
	 * operation '.' INVENTORY
	 */
	@Override
	public ValueInterface visitSomeContents(SomeContentsContext ctx) {
		ValueInterface v = visit(ctx.operation());
		if (v instanceof LocationValue) {
			return new ListValue(((LocationValue) v).getContents());
		} else {
			throw new RuntimeException(new IllegalOperationException(ctx.INVENTORY().getSymbol().getLine(),
					ctx.INVENTORY().getSymbol().getCharPositionInLine(), ctx.INVENTORY().getSymbol().getStartIndex(),
					v.getTypeName(), ReturnValueTypes.INVENTORY.name(), "%"));
		}
	}

	/**
	 * <p>
	 * room '.' INVENTORY
	 */
	@Override
	public ValueInterface visitRoomContents(RoomContentsContext ctx) {
		ValueInterface v = visit(ctx.room());
		if (v instanceof RoomValue) {
			return new ListValue(((RoomValue) v).getContents());
		} else {
			throw new RuntimeException(new IllegalOperationException(ctx.INVENTORY().getSymbol().getLine(),
					ctx.INVENTORY().getSymbol().getCharPositionInLine(), ctx.INVENTORY().getSymbol().getStartIndex(),
					v.getTypeName(), ReturnValueTypes.ROOM.name(), "%"));
		}
	}

	/**
	 * Creates a NULL object.
	 */
	@Override
	public ValueInterface visitNullObj(NullObjContext ctx) {
		return ObjectValue.defaultValue(getSM().getRootClass());
	}

	/**
	 * Checks if the object inherits from given class.
	 * <p>
	 * operation INSTANCEOFSYMBOL SYMBOL
	 */
	@Override
	public ValueInterface visitInstanceofOp(InstanceofOpContext ctx) {
		ValueInterface left = visit(ctx.operation());
		String classname = ctx.SYMBOL().getText().toLowerCase();

		if (left instanceof ObjectValue) {
			ObjectValue ov = (ObjectValue) left;
			if (ov.getObj() == null) {
				return new IntegerValue(0); // null obj
			}
			return new IntegerValue(
					ov.getObj().getDemiurgoClass().inheritFrom(getSM().getCurrentWorld().getClassFromName(classname)));
		} else { // it's not an object; returns false
			return new IntegerValue(0);
		}
	}

	/**
	 * operation '.' ROOM
	 */
	@Override
	public ValueInterface visitGetLoc(GetLocContext ctx) {
		ValueInterface left = visit(ctx.operation());

		if (left instanceof ObjectValue) {
			ObjectValue ov = (ObjectValue) left;
			if(ov.getObj() != null)
				return new RoomValue(ov.getObj().getRealLocation());
		}
		throw new RuntimeException(new NotAnObjectException(ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(), 0, left.getTypeName()));
	}

	/**
	 * operation '.' '$'
	 */
	@Override
	public ValueInterface visitGetUser(GetUserContext ctx) {
		ValueInterface left = visit(ctx.operation());

		if (left instanceof ObjectValue) {
			ObjectValue ov = (ObjectValue) left;
			if(ov.getObj() != null && ov.getObj().getUser() != null)
				return new StringValue(ov.getObj().getUser().getUsername());
			else
				return new StringValue("");
		} else
			throw new RuntimeException(new NotAnObjectException(ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(), 0, left.getTypeName()));
	}

	/**
	 * operation '.' '#'
	 */
	@Override
	public ValueInterface visitGetId(GetIdContext ctx) {
		ValueInterface left = visit(ctx.operation());

		if (left instanceof ObjectValue) {
			ObjectValue ov = (ObjectValue) left;
			if(ov.getObj() != null)
				return new IntegerValue((int)ov.getObj().getId());
			else
				return new IntegerValue(0);
		} else
			throw new RuntimeException(new NotAnObjectException(ctx.getStart().getLine(),
					ctx.getStart().getCharPositionInLine(), 0, left.getTypeName()));
	}

	@Override
	public ValueInterface visitThisRoom(ThisRoomContext ctx) {
		return new RoomValue(getSM().getCurrentRoom());
	}

	/**
	 * Returns the object's location.
	 * <p>
	 * operation '.' ROOM
	 */
	@Override
	public ValueInterface visitLocation(LocationContext ctx) {
		ValueInterface left = visit(ctx.operation());
		if(left instanceof ObjectValue && ((ObjectValue)left).getObj() != null) {
			return new RoomValue(((ObjectValue)left).getObj().getRealLocation());
		}
		else {
			throw new RuntimeException(new NotAnObjectException(ctx.start.getLine(), ctx.start.getCharPositionInLine(), 0, left.getTypeName()));
		}
	}

	
}