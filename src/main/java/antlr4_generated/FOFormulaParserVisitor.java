// Generated from FOFormulaParser.g4 by ANTLR 4.5

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
	 * Visit a parse tree produced by {@link FOFormulaParserParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FOFormulaParserParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localQuantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalQuantifiedFormula(FOFormulaParserParser.LocalQuantifiedFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localDoubleImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDoubleImplication(FOFormulaParserParser.LocalDoubleImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localImplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalImplication(FOFormulaParserParser.LocalImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localDisjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDisjunction(FOFormulaParserParser.LocalDisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localConjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalConjunction(FOFormulaParserParser.LocalConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#localNegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalNegation(FOFormulaParserParser.LocalNegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#folAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolAtom(FOFormulaParserParser.FolAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(FOFormulaParserParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOFormulaParserParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(FOFormulaParserParser.PredicateContext ctx);
}