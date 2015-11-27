// Generated from FOLTLFormulaParser.g4 by ANTLR 4.5

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
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FOLTLFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#foltlFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoltlFormula(FOLTLFormulaParserParser.FoltlFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#acrossQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcrossQuantifiedFormula(FOLTLFormulaParserParser.AcrossQuantifiedFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalDoubleImplication(FOLTLFormulaParserParser.TemporalDoubleImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalImplication(FOLTLFormulaParserParser.TemporalImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalDisjunction(FOLTLFormulaParserParser.TemporalDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalConjunction(FOLTLFormulaParserParser.TemporalConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#weakUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakUntil(FOLTLFormulaParserParser.WeakUntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#release}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelease(FOLTLFormulaParserParser.ReleaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#until}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntil(FOLTLFormulaParserParser.UntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#globally}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobally(FOLTLFormulaParserParser.GloballyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#eventually}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventually(FOLTLFormulaParserParser.EventuallyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#weakNext}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeakNext(FOLTLFormulaParserParser.WeakNextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#next}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext(FOLTLFormulaParserParser.NextContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#temporalNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporalNegation(FOLTLFormulaParserParser.TemporalNegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#ltlfAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtlfAtom(FOLTLFormulaParserParser.LtlfAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalQuantifiedFormula(FOLTLFormulaParserParser.LocalQuantifiedFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDoubleImplication(FOLTLFormulaParserParser.LocalDoubleImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalImplication(FOLTLFormulaParserParser.LocalImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDisjunction(FOLTLFormulaParserParser.LocalDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalConjunction(FOLTLFormulaParserParser.LocalConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#localNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalNegation(FOLTLFormulaParserParser.LocalNegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#folAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolAtom(FOLTLFormulaParserParser.FolAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(FOLTLFormulaParserParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLTLFormulaParserParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(FOLTLFormulaParserParser.PredicateContext ctx);
}