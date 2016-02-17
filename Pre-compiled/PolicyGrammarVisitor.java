// Generated from PolicyGrammar.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PolicyGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PolicyGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PolicyGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(PolicyGrammarParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printDecision_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintDecision_method(PolicyGrammarParser.PrintDecision_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank_method}
	 * labeled alternative in {@link PolicyGrammarParser#policy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank_method(PolicyGrammarParser.Blank_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_method}
	 * labeled alternative in {@link PolicyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_method(PolicyGrammarParser.Assign_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens_method(PolicyGrammarParser.Parens_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_method(PolicyGrammarParser.Not_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code s_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS_method(PolicyGrammarParser.S_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atom_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_method(PolicyGrammarParser.Atom_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code y_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY_method(PolicyGrammarParser.Y_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_method(PolicyGrammarParser.And_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exist_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExist_method(PolicyGrammarParser.Exist_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code h_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitH_method(PolicyGrammarParser.H_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_method(PolicyGrammarParser.Or_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code p_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitP_method(PolicyGrammarParser.P_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code all_method}
	 * labeled alternative in {@link PolicyGrammarParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll_method(PolicyGrammarParser.All_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_method(PolicyGrammarParser.Flow_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iflow_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIflow_method(PolicyGrammarParser.Iflow_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elem_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElem_method(PolicyGrammarParser.Elem_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equ_ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqu_ctx_method(PolicyGrammarParser.Equ_ctx_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equ_dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqu_dom_method(PolicyGrammarParser.Equ_dom_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctx_method}
	 * labeled alternative in {@link PolicyGrammarParser#termctx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtx_method(PolicyGrammarParser.Ctx_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dom_method}
	 * labeled alternative in {@link PolicyGrammarParser#termdom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDom_method(PolicyGrammarParser.Dom_methodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_method}
	 * labeled alternative in {@link PolicyGrammarParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_method(PolicyGrammarParser.Var_methodContext ctx);
}