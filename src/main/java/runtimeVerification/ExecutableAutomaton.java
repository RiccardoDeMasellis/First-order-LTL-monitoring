package runtimeVerification;

import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlFormula;
import formulaa.foltl.FoLtlVariable;
import formulaa.foltl.semantics.FoLtlAssignment;
import rationals.Automaton;
import util.AutomataUtils;
import utils.AutomatonUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * ExecutableAutomaton
 * <br>
 * Created by Simone Calciolari on 16/02/16.
 * @author Simone Calciolari.
 */
public class ExecutableAutomaton {

	private Automaton automaton;
	private LinkedHashSet<FoLtlConstant> domain;
	private FoLtlFormula formula;
	private LinkedHashSet<FoLtlAssignment> assignments;

	public ExecutableAutomaton(FoLtlFormula formula, LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
		this.formula = formula;

		//Build the automaton from the given formula
		this.automaton = AutomataUtils.buildFoLtlAutomaton(formula);

		if (automaton.initials().size() > 1){
			throw new RuntimeException("Built Automaton has more than one initial state");
		}

		//Compute all possible assignments
		this.assignments = this.computeAllAssignments(formula, domain);

	}

	private LinkedHashSet<FoLtlAssignment> computeAllAssignments(FoLtlFormula formula, LinkedHashSet<FoLtlConstant> domain){
		ArrayList<FoLtlVariable> variables = new ArrayList<>();
		variables.addAll(formula.getAcrossVariables());
		return this.allAssignments(0, variables, domain);
	}

	private LinkedHashSet<FoLtlAssignment> allAssignments(int i, ArrayList<FoLtlVariable> variables,
																												LinkedHashSet<FoLtlConstant> domain){
		LinkedHashSet<FoLtlAssignment> res = new LinkedHashSet<>();

		if (i == variables.size() - 1){
			//Base case
			for (FoLtlConstant c : domain){
				FoLtlAssignment assignment = new FoLtlAssignment();
				assignment.put(variables.get(i), c);
				res.add(assignment);
			}

		} else {
			LinkedHashSet<FoLtlAssignment> old = allAssignments(i+1, variables, domain);

			for (FoLtlAssignment assignment : old) {
				for (FoLtlConstant c : domain) {
					FoLtlAssignment ass = (FoLtlAssignment) assignment.clone();
					ass.put(variables.get(i), c);
					res.add(ass);
				}
			}
		}

		return res;
	}

	public LinkedHashSet<FoLtlAssignment> getAssignments() {
		return assignments;
	}
}
