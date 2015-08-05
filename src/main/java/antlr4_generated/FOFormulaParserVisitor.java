// Generated from FOFormulaParser.g4 by ANTLR 4.3

    package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOFormulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOFormulaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDoubleImplication(@NotNull FOFormulaParserParser.LocalDoubleImplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(@NotNull FOFormulaParserParser.PredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalNegation(@NotNull FOFormulaParserParser.LocalNegationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#folAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolAtom(@NotNull FOFormulaParserParser.FolAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull FOFormulaParserParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalConjunction(@NotNull FOFormulaParserParser.LocalConjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalQuantifiedFormula(@NotNull FOFormulaParserParser.LocalQuantifiedFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(@NotNull FOFormulaParserParser.EqualityContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDisjunction(@NotNull FOFormulaParserParser.LocalDisjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalImplication(@NotNull FOFormulaParserParser.LocalImplicationContext ctx);
}