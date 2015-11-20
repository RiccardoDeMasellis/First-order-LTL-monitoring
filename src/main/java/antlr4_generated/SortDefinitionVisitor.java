// Generated from SortDefinition.g4 by ANTLR 4.3

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SortDefinitionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SortDefinitionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SortDefinitionParser#sortAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortAssignment(@NotNull SortDefinitionParser.SortAssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link SortDefinitionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull SortDefinitionParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link SortDefinitionParser#sortDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDefinition(@NotNull SortDefinitionParser.SortDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link SortDefinitionParser#sortDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortDeclaration(@NotNull SortDefinitionParser.SortDeclarationContext ctx);
}