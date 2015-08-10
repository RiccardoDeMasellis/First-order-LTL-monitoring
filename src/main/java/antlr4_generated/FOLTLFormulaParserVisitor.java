// Generated from FOLTLFormulaParser.g4 by ANTLR 4.3

    package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOLTLFormulaParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOLTLFormulaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext(@NotNull FOLTLFormulaParserParser.NextContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalNegation(@NotNull FOLTLFormulaParserParser.LocalNegationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#folAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolAtom(@NotNull FOLTLFormulaParserParser.FolAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalImplication(@NotNull FOLTLFormulaParserParser.TemporalImplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#release}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease(@NotNull FOLTLFormulaParserParser.ReleaseContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#globally}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobally(@NotNull FOLTLFormulaParserParser.GloballyContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalConjunction(@NotNull FOLTLFormulaParserParser.TemporalConjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#eventually}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventually(@NotNull FOLTLFormulaParserParser.EventuallyContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDisjunction(@NotNull FOLTLFormulaParserParser.LocalDisjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalImplication(@NotNull FOLTLFormulaParserParser.LocalImplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDoubleImplication(@NotNull FOLTLFormulaParserParser.LocalDoubleImplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(@NotNull FOLTLFormulaParserParser.PredicateContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalNegation(@NotNull FOLTLFormulaParserParser.TemporalNegationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#weakNext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakNext(@NotNull FOLTLFormulaParserParser.WeakNextContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#weakUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakUntil(@NotNull FOLTLFormulaParserParser.WeakUntilContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalConjunction(@NotNull FOLTLFormulaParserParser.LocalConjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(@NotNull FOLTLFormulaParserParser.EqualityContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#acrossQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcrossQuantifiedFormula(@NotNull FOLTLFormulaParserParser.AcrossQuantifiedFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull FOLTLFormulaParserParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#ltlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlfAtom(@NotNull FOLTLFormulaParserParser.LtlfAtomContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#foltlFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoltlFormula(@NotNull FOLTLFormulaParserParser.FoltlFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalFormula(@NotNull FOLTLFormulaParserParser.TemporalFormulaContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalDisjunction(@NotNull FOLTLFormulaParserParser.TemporalDisjunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalDoubleImplication(@NotNull FOLTLFormulaParserParser.TemporalDoubleImplicationContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#until}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntil(@NotNull FOLTLFormulaParserParser.UntilContext ctx);

	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalQuantifiedFormula(@NotNull FOLTLFormulaParserParser.LocalQuantifiedFormulaContext ctx);
}