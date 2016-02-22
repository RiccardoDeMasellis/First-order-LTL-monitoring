// Generated from FoLtlSortAssignment.g4 by ANTLR 4.5

	package antlr4_generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoLtlSortAssignmentParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoLtlSortAssignmentVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FoLtlSortAssignmentParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FoLtlSortAssignmentParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlSortAssignmentParser#sortAssignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortAssignments(FoLtlSortAssignmentParser.SortAssignmentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoLtlSortAssignmentParser#sortAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortAssignment(FoLtlSortAssignmentParser.SortAssignmentContext ctx);
}