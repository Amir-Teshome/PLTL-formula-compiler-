// Generated from PolicyGrammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PolicyGrammarParser}.
 */
public interface PolicyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PolicyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(PolicyGrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolicyGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(PolicyGrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printDecision_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 */
	void enterPrintDecision_method(PolicyGrammarParser.PrintDecision_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printDecision_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 */
	void exitPrintDecision_method(PolicyGrammarParser.PrintDecision_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 */
	void enterBlank_method(PolicyGrammarParser.Blank_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 */
	void exitBlank_method(PolicyGrammarParser.Blank_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_method}
	 * labeled alternative in {@link PolicyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssign_method(PolicyGrammarParser.Assign_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_method}
	 * labeled alternative in {@link PolicyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssign_method(PolicyGrammarParser.Assign_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParens_method(PolicyGrammarParser.Parens_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParens_method(PolicyGrammarParser.Parens_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot_method(PolicyGrammarParser.Not_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot_method(PolicyGrammarParser.Not_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code s_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterS_method(PolicyGrammarParser.S_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code s_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitS_method(PolicyGrammarParser.S_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atom_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtom_method(PolicyGrammarParser.Atom_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtom_method(PolicyGrammarParser.Atom_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code y_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterY_method(PolicyGrammarParser.Y_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code y_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitY_method(PolicyGrammarParser.Y_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd_method(PolicyGrammarParser.And_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd_method(PolicyGrammarParser.And_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exist_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExist_method(PolicyGrammarParser.Exist_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exist_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExist_method(PolicyGrammarParser.Exist_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code h_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterH_method(PolicyGrammarParser.H_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code h_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitH_method(PolicyGrammarParser.H_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOr_method(PolicyGrammarParser.Or_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOr_method(PolicyGrammarParser.Or_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code p_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterP_method(PolicyGrammarParser.P_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code p_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitP_method(PolicyGrammarParser.P_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code all_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAll_method(PolicyGrammarParser.All_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code all_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAll_method(PolicyGrammarParser.All_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFlow_method(PolicyGrammarParser.Flow_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFlow_method(PolicyGrammarParser.Flow_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iflow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIflow_method(PolicyGrammarParser.Iflow_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iflow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIflow_method(PolicyGrammarParser.Iflow_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elem_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterElem_method(PolicyGrammarParser.Elem_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elem_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitElem_method(PolicyGrammarParser.Elem_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equ_ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterEqu_ctx_method(PolicyGrammarParser.Equ_ctx_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equ_ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitEqu_ctx_method(PolicyGrammarParser.Equ_ctx_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equ_dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterEqu_dom_method(PolicyGrammarParser.Equ_dom_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equ_dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitEqu_dom_method(PolicyGrammarParser.Equ_dom_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#termctx}.
	 * @param ctx the parse tree
	 */
	void enterCtx_method(PolicyGrammarParser.Ctx_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#termctx}.
	 * @param ctx the parse tree
	 */
	void exitCtx_method(PolicyGrammarParser.Ctx_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#termdom}.
	 * @param ctx the parse tree
	 */
	void enterDom_method(PolicyGrammarParser.Dom_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#termdom}.
	 * @param ctx the parse tree
	 */
	void exitDom_method(PolicyGrammarParser.Dom_methodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_method}
	 * labeled alternative in {@link PolicyGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar_method(PolicyGrammarParser.Var_methodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_method}
	 * labeled alternative in {@link PolicyGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar_method(PolicyGrammarParser.Var_methodContext ctx);
}