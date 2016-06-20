// Generated from Linguaxe.g4 by ANTLR 4.5
package linguaxe;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LinguaxeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LinguaxeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code classDef}
	 * labeled alternative in {@link LinguaxeParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(LinguaxeParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sCode}
	 * labeled alternative in {@link LinguaxeParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSCode(LinguaxeParser.SCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(LinguaxeParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(LinguaxeParser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#attrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrib(LinguaxeParser.AttribContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethods(LinguaxeParser.MethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(LinguaxeParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(LinguaxeParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(LinguaxeParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#aline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAline(LinguaxeParser.AlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(LinguaxeParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rootVariable}
	 * labeled alternative in {@link LinguaxeParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootVariable(LinguaxeParser.RootVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intermediateVariable}
	 * labeled alternative in {@link LinguaxeParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntermediateVariable(LinguaxeParser.IntermediateVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LinguaxeParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensOp(LinguaxeParser.ParensOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(LinguaxeParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code move}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove(LinguaxeParser.MoveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(LinguaxeParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(LinguaxeParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code roomOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoomOp(LinguaxeParser.RoomOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(LinguaxeParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(LinguaxeParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableOp(LinguaxeParser.VariableOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDice(LinguaxeParser.DiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code index}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(LinguaxeParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObj(LinguaxeParser.NewObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(LinguaxeParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code list}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LinguaxeParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexAssign}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAssign(LinguaxeParser.IndexAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(LinguaxeParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sharp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharp(LinguaxeParser.SharpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDice(LinguaxeParser.MultDiceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative(LinguaxeParser.NegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOp(LinguaxeParser.FunctionOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logic}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(LinguaxeParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LinguaxeParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponent}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponent(LinguaxeParser.ExponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(LinguaxeParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#new_obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_obj(LinguaxeParser.New_objContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#sharp_identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharp_identifier(LinguaxeParser.Sharp_identifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#room}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom(LinguaxeParser.RoomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#room_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoom_path(LinguaxeParser.Room_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#exp_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_if(LinguaxeParser.Exp_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#exp_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_for(LinguaxeParser.Exp_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#exp_user}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_user(LinguaxeParser.Exp_userContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#username}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsername(LinguaxeParser.UsernameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LinguaxeParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(LinguaxeParser.Data_typeContext ctx);
}