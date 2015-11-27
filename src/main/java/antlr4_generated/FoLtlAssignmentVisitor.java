// Generated from FoLtlAssignment.g4 by ANTLR 4.5

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoLtlAssignmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoLtlAssignmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FoLtlAssignmentParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FoLtlAssignmentParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlAssignmentParser#assignmentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentDefinition(FoLtlAssignmentParser.AssignmentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlAssignmentParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(FoLtlAssignmentParser.VariableAssignmentContext ctx);
}