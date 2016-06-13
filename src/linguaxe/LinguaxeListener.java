// Generated from Linguaxe.g4 by ANTLR 4.5

package linguaxe;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LinguaxeParser}.
 */
public interface LinguaxeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(LinguaxeParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(LinguaxeParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(LinguaxeParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(LinguaxeParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(LinguaxeParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(LinguaxeParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#attrib}.
	 * @param ctx the parse tree
	 */
	void enterAttrib(LinguaxeParser.AttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#attrib}.
	 * @param ctx the parse tree
	 */
	void exitAttrib(LinguaxeParser.AttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#methods}.
	 * @param ctx the parse tree
	 */
	void enterMethods(LinguaxeParser.MethodsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#methods}.
	 * @param ctx the parse tree
	 */
	void exitMethods(LinguaxeParser.MethodsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(LinguaxeParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(LinguaxeParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LinguaxeParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LinguaxeParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(LinguaxeParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(LinguaxeParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#aline}.
	 * @param ctx the parse tree
	 */
	void enterAline(LinguaxeParser.AlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#aline}.
	 * @param ctx the parse tree
	 */
	void exitAline(LinguaxeParser.AlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(LinguaxeParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(LinguaxeParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(LinguaxeParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(LinguaxeParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compare}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterCompare(LinguaxeParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitCompare(LinguaxeParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code move}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterMove(LinguaxeParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code move}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitMove(LinguaxeParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterBool(LinguaxeParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitBool(LinguaxeParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterString(LinguaxeParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitString(LinguaxeParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code roomOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterRoomOp(LinguaxeParser.RoomOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code roomOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitRoomOp(LinguaxeParser.RoomOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(LinguaxeParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(LinguaxeParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LinguaxeParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LinguaxeParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterDice(LinguaxeParser.DiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitDice(LinguaxeParser.DiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenth}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterParenth(LinguaxeParser.ParenthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenth}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitParenth(LinguaxeParser.ParenthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code index}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterIndex(LinguaxeParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code index}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitIndex(LinguaxeParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(LinguaxeParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObj}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(LinguaxeParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LinguaxeParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LinguaxeParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code list}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterList(LinguaxeParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code list}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitList(LinguaxeParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterInt(LinguaxeParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitInt(LinguaxeParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sharp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterSharp(LinguaxeParser.SharpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sharp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitSharp(LinguaxeParser.SharpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterMultDice(LinguaxeParser.MultDiceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDice}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitMultDice(LinguaxeParser.MultDiceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterMemberOp(LinguaxeParser.MemberOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberOp}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitMemberOp(LinguaxeParser.MemberOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negative}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterNegative(LinguaxeParser.NegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negative}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitNegative(LinguaxeParser.NegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code potence}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterPotence(LinguaxeParser.PotenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code potence}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitPotence(LinguaxeParser.PotenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logic}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterLogic(LinguaxeParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logic}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitLogic(LinguaxeParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LinguaxeParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LinguaxeParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LinguaxeParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#new_obj}.
	 * @param ctx the parse tree
	 */
	void enterNew_obj(LinguaxeParser.New_objContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#new_obj}.
	 * @param ctx the parse tree
	 */
	void exitNew_obj(LinguaxeParser.New_objContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#sharp_identifier}.
	 * @param ctx the parse tree
	 */
	void enterSharp_identifier(LinguaxeParser.Sharp_identifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#sharp_identifier}.
	 * @param ctx the parse tree
	 */
	void exitSharp_identifier(LinguaxeParser.Sharp_identifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#room}.
	 * @param ctx the parse tree
	 */
	void enterRoom(LinguaxeParser.RoomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#room}.
	 * @param ctx the parse tree
	 */
	void exitRoom(LinguaxeParser.RoomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#room_path}.
	 * @param ctx the parse tree
	 */
	void enterRoom_path(LinguaxeParser.Room_pathContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#room_path}.
	 * @param ctx the parse tree
	 */
	void exitRoom_path(LinguaxeParser.Room_pathContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#exp_if}.
	 * @param ctx the parse tree
	 */
	void enterExp_if(LinguaxeParser.Exp_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#exp_if}.
	 * @param ctx the parse tree
	 */
	void exitExp_if(LinguaxeParser.Exp_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#exp_for}.
	 * @param ctx the parse tree
	 */
	void enterExp_for(LinguaxeParser.Exp_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#exp_for}.
	 * @param ctx the parse tree
	 */
	void exitExp_for(LinguaxeParser.Exp_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#exp_user}.
	 * @param ctx the parse tree
	 */
	void enterExp_user(LinguaxeParser.Exp_userContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#exp_user}.
	 * @param ctx the parse tree
	 */
	void exitExp_user(LinguaxeParser.Exp_userContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#username}.
	 * @param ctx the parse tree
	 */
	void enterUsername(LinguaxeParser.UsernameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#username}.
	 * @param ctx the parse tree
	 */
	void exitUsername(LinguaxeParser.UsernameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LinguaxeParser#data_type}.
	 * @param ctx the parse tree
	 */
	void enterData_type(LinguaxeParser.Data_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LinguaxeParser#data_type}.
	 * @param ctx the parse tree
	 */
	void exitData_type(LinguaxeParser.Data_typeContext ctx);
}