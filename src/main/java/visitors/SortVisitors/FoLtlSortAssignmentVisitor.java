package visitors.SortVisitors;

import antlr4_generated.FoLtlSortAssignmentBaseVisitor;
import antlr4_generated.FoLtlSortAssignmentParser;
import formulaa.foltl.FoLtlSort;
import formulaa.foltl.FoLtlVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * FoLtlSortAssignment
 * <br>
 * Created by Simone Calciolari on 11/12/15.
 * @author Simone Calciolari.
 */
public class FoLtlSortAssignmentVisitor extends FoLtlSortAssignmentBaseVisitor<HashMap<FoLtlVariable, FoLtlSort>>{

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = false;

	private HashSet<FoLtlVariable> variables;
	private LinkedHashSet<FoLtlSort> sorts;
	private HashSet<FoLtlVariable> sortedVariables;

	public FoLtlSortAssignmentVisitor(HashSet<FoLtlVariable> variables, LinkedHashSet<FoLtlSort> sorts){
		this.variables = variables;
		this.sorts = sorts;
		this.sortedVariables = new HashSet<>();
	}

	@Override
	public HashMap<FoLtlVariable, FoLtlSort> visitStart(FoLtlSortAssignmentParser.StartContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public HashMap<FoLtlVariable, FoLtlSort> visitSortAssignments(FoLtlSortAssignmentParser.SortAssignmentsContext ctx) {
		HashMap<FoLtlVariable, FoLtlSort> res = new HashMap<>();

		for (int i = 0; i < ctx.getChildCount(); i++){
			res.putAll(visit(ctx.getChild(i)));
		}

		if (!this.sortedVariables.equals(variables)){
			throw new RuntimeException("Not all variables were sorted");
		}

		return res;
	}

	@Override
	public HashMap<FoLtlVariable, FoLtlSort> visitSortAssignment(FoLtlSortAssignmentParser.SortAssignmentContext ctx) {
		HashMap<FoLtlVariable, FoLtlSort> res = new HashMap<>();

		FoLtlVariable v = this.getVariable(ctx.getChild(0).getText().substring(1));
		FoLtlSort sort = this.getSort(ctx.getChild(2).getText());

		res.put(v, sort);
		return res;
	}

	private FoLtlVariable getVariable(String name){
		FoLtlVariable res = null;

		for (FoLtlVariable v : this.variables){
			if (v.getName().equals(name)){
				res = v;
			}
		}

		if (res == null){
			throw new RuntimeException("Variable ?" + name + " was not specified");
		} else if (this.sortedVariables.contains(res)){
			throw new RuntimeException("Variable " + res + " has already been sorted");
		} else {
			this.sortedVariables.add(res);
		}

		return res;
	}

	private FoLtlSort getSort(String name){
		FoLtlSort res = null;

		for (FoLtlSort s : this.sorts){
			if (s.getName().equals(name)){
				res = s;
			}
		}

		if (res == null){
			throw new RuntimeException("Sort " + name + " was not specified");
		}

		return res;
	}

}
