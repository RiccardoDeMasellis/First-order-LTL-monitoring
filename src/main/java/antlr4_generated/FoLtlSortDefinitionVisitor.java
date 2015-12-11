// Generated from FoLtlSortDefinition.g4 by ANTLR 4.5

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoLtlSortDefinitionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoLtlSortDefinitionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FoLtlSortDefinitionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FoLtlSortDefinitionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlSortDefinitionParser#sortDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDefinition(FoLtlSortDefinitionParser.SortDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlSortDefinitionParser#sortDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDeclaration(FoLtlSortDefinitionParser.SortDeclarationContext ctx);
}