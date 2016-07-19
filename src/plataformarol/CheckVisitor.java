package plataformarol;

import linguaxe.LinguaxeBaseVisitor;
import linguaxe.LinguaxeParser.AddSubContext;
import linguaxe.LinguaxeParser.ArgsContext;
import linguaxe.LinguaxeParser.AssignContext;
import linguaxe.LinguaxeParser.BoolContext;
import linguaxe.LinguaxeParser.Class_defContext;
import linguaxe.LinguaxeParser.CodeContext;
import linguaxe.LinguaxeParser.CompareContext;
import linguaxe.LinguaxeParser.Data_typeContext;
import linguaxe.LinguaxeParser.DiceContext;
import linguaxe.LinguaxeParser.Exp_forContext;
import linguaxe.LinguaxeParser.Exp_ifContext;
import linguaxe.LinguaxeParser.Exp_userContext;
import linguaxe.LinguaxeParser.ExponentContext;
import linguaxe.LinguaxeParser.FieldsContext;
import linguaxe.LinguaxeParser.FloatContext;
import linguaxe.LinguaxeParser.FunctionContext;
import linguaxe.LinguaxeParser.FunctionOpContext;
import linguaxe.LinguaxeParser.IndexAssignContext;
import linguaxe.LinguaxeParser.IndexContext;
import linguaxe.LinguaxeParser.IntContext;
import linguaxe.LinguaxeParser.IntermediateVariableContext;
import linguaxe.LinguaxeParser.LeafRoomContext;
import linguaxe.LinguaxeParser.LineContext;
import linguaxe.LinguaxeParser.ListContext;
import linguaxe.LinguaxeParser.LogicContext;
import linguaxe.LinguaxeParser.MethodContext;
import linguaxe.LinguaxeParser.MethodsContext;
import linguaxe.LinguaxeParser.MoveContext;
import linguaxe.LinguaxeParser.MulDivContext;
import linguaxe.LinguaxeParser.MultDiceContext;
import linguaxe.LinguaxeParser.NegativeContext;
import linguaxe.LinguaxeParser.NewObjContext;
import linguaxe.LinguaxeParser.New_objContext;
import linguaxe.LinguaxeParser.NlContext;
import linguaxe.LinguaxeParser.OperationContext;
import linguaxe.LinguaxeParser.ParensContext;
import linguaxe.LinguaxeParser.ParensOpContext;
import linguaxe.LinguaxeParser.RelativeRoomContext;
import linguaxe.LinguaxeParser.RoomContext;
import linguaxe.LinguaxeParser.RoomOpContext;
import linguaxe.LinguaxeParser.RootRoomContext;
import linguaxe.LinguaxeParser.RootVariableContext;
import linguaxe.LinguaxeParser.SharpContext;
import linguaxe.LinguaxeParser.Sharp_identifierContext;
import linguaxe.LinguaxeParser.StringContext;
import linguaxe.LinguaxeParser.Var_declContext;
import linguaxe.LinguaxeParser.VariableOpContext;
import universe.UserDefinedClass;
import universe.World;
import universe.WorldRoom;
import values.FloatValue;
import values.IReturnValue;
import values.IntegerValue;
import values.ListValue;
import values.ReturnValueTypes;
import values.StringValue;

/**
 * <p>
 * This class provides a Visitor that check all the code introduced to detect
 * type compatibility errors. It store all errors found; these errors will be
 * notified to the user, so he/she could fix them. This visitor doesn't make any
 * change into the world.
 * </p>
 * 
 * @author Martín Coego Pérez
 * @version %I%, %G%
 * @since 1.0
 */
public class CheckVisitor extends LinguaxeBaseVisitor<IReturnValue> {

	protected ScopeManager sm;

	public CheckVisitor(World world, WorldRoom room) {
		sm = new ScopeManager(world, room);
	}

	public ScopeManager getSM() {
		return sm;
	}

	public void setSM(ScopeManager st) {
		this.sm = st;
	}

	@Override
	public IReturnValue visitBool(BoolContext ctx) {
		return IntegerValue.defaultValue();
	}

	@Override
	public IReturnValue visitString(StringContext ctx) {
		return StringValue.defaultValue();
	}

	@Override
	public IReturnValue visitFloat(FloatContext ctx) {
		return FloatValue.defaultValue();
	}

	@Override
	public IReturnValue visitList(ListContext ctx) {
		ReturnValueTypes type = null;
		int depth = 0;
		for (OperationContext op : ctx.operation()) {
			IReturnValue v = visit(op);
			if (type == null || type == v.getType()) {
				type = v.getType();
			} else {
				// TODO: error: all elements must be of the same type
				return null;
			}
		}

		if (type == ReturnValueTypes.LIST) { // list of lists
			for (OperationContext op : ctx.operation()) {
				IReturnValue v = visit(op);
				if (depth == 0 || depth == (v.getDepth() + 1)) {
					type = v.getType(); //get the inner type
					depth = v.getDepth() + 1;
				} else {
					// TODO: error: all elements must be of the same type
					return null;
				}
			}
		} else
			depth = 1;

		return ListValue.defaultValue(type, depth);
	}

	@Override
	public IReturnValue visitInt(IntContext ctx) {
		return new IntegerValue(0);
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
			newClass = new UserDefinedClass(className, getSM().getClassFromName(parentName));
		} else { // inherit from "Object" class
			newClass = new UserDefinedClass(className, getSM().getRootClass());
		}
		getSM().setDefiningClass(newClass);
		getSM().addClass(className, newClass);
		visit(ctx.fields());
		visit(ctx.methods());
		getSM().setDefiningClass(null);
		return null;
		//TODO: do this in class scope
	}

	/**
	 * Adds a new field to the class that is currently being defined.
	 * <p>
	 * var_decl : data_type SYMBOL (ASSIGN operation)? ;
	 */
	@Override
	public IReturnValue visitVar_decl(Var_declContext ctx) {
		IReturnValue type = visit(ctx.data_type());
		String varName = ctx.SYMBOL().getText().toLowerCase();
		IReturnValue value;
		if (ctx.operation() != null) {
			value = visit(ctx.operation());
		} else {
			value = type;
		}

		// TODO: Class Scope
		if (getSM().getDefiningClass() != null) {
			// defining class fields
			getSM().getDefiningClass().addField(varName, value);
		} else {
			// declaring a normal variable
			getSM().setVariable(varName, value);
		}
		return null;
	}

	@Override
	public IReturnValue visitMethods(MethodsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethods(ctx);
	}

	@Override
	public IReturnValue visitMethod(MethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethod(ctx);
	}

	@Override
	public IReturnValue visitArgs(ArgsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArgs(ctx);
	}

	@Override
	public IReturnValue visitCode(CodeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCode(ctx);
	}

	@Override
	public IReturnValue visitLine(LineContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLine(ctx);
	}

	@Override
	public IReturnValue visitRootVariable(RootVariableContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRootVariable(ctx);
	}

	@Override
	public IReturnValue visitIntermediateVariable(IntermediateVariableContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIntermediateVariable(ctx);
	}

	@Override
	public IReturnValue visitFunction(FunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunction(ctx);
	}

	@Override
	public IReturnValue visitParensOp(ParensOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParensOp(ctx);
	}

	@Override
	public IReturnValue visitCompare(CompareContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCompare(ctx);
	}

	@Override
	public IReturnValue visitMove(MoveContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMove(ctx);
	}

	@Override
	public IReturnValue visitRoomOp(RoomOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRoomOp(ctx);
	}

	@Override
	public IReturnValue visitMulDiv(MulDivContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMulDiv(ctx);
	}

	@Override
	public IReturnValue visitAddSub(AddSubContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddSub(ctx);
	}

	@Override
	public IReturnValue visitVariableOp(VariableOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableOp(ctx);
	}

	@Override
	public IReturnValue visitDice(DiceContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDice(ctx);
	}

	@Override
	public IReturnValue visitIndex(IndexContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIndex(ctx);
	}

	@Override
	public IReturnValue visitNewObj(NewObjContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNewObj(ctx);
	}

	@Override
	public IReturnValue visitIndexAssign(IndexAssignContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIndexAssign(ctx);
	}

	@Override
	public IReturnValue visitSharp(SharpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSharp(ctx);
	}

	@Override
	public IReturnValue visitMultDice(MultDiceContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultDice(ctx);
	}

	@Override
	public IReturnValue visitNegative(NegativeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegative(ctx);
	}

	@Override
	public IReturnValue visitFunctionOp(FunctionOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunctionOp(ctx);
	}

	@Override
	public IReturnValue visitLogic(LogicContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLogic(ctx);
	}

	@Override
	public IReturnValue visitAssign(AssignContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign(ctx);
	}

	@Override
	public IReturnValue visitExponent(ExponentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExponent(ctx);
	}

	@Override
	public IReturnValue visitParens(ParensContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParens(ctx);
	}

	@Override
	public IReturnValue visitNew_obj(New_objContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNew_obj(ctx);
	}

	@Override
	public IReturnValue visitSharp_identifier(Sharp_identifierContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSharp_identifier(ctx);
	}

	@Override
	public IReturnValue visitRoom(RoomContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRoom(ctx);
	}

	@Override
	public IReturnValue visitRootRoom(RootRoomContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRootRoom(ctx);
	}

	@Override
	public IReturnValue visitLeafRoom(LeafRoomContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLeafRoom(ctx);
	}

	@Override
	public IReturnValue visitRelativeRoom(RelativeRoomContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelativeRoom(ctx);
	}

	@Override
	public IReturnValue visitExp_if(Exp_ifContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExp_if(ctx);
	}

	@Override
	public IReturnValue visitExp_for(Exp_forContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExp_for(ctx);
	}

	@Override
	public IReturnValue visitExp_user(Exp_userContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExp_user(ctx);
	}

	@Override
	public IReturnValue visitData_type(Data_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitData_type(ctx);
	}

	@Override
	public IReturnValue visitNl(NlContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNl(ctx);
	}

}
