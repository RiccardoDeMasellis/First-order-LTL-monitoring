package runtimeVerification;

import automata.FoLtlEmptyTrace;
import automata.FoLtlLabel;
import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlFormula;
import formulaa.foltl.FoLtlLocalFormula;
import formulaa.foltl.FoLtlVariable;
import formulaa.foltl.semantics.FoLtlAssignment;
import rationals.Automaton;
import rationals.State;
import rationals.Transition;
import util.AutomataUtils;
import util.Pair;
import utils.AutomatonUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

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
	private SatisfiabilityMap satisfiabilityMap;

	private State currentState;

	public ExecutableAutomaton(FoLtlFormula formula, LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
		this.formula = formula;

		//Build the automaton from the given formula
		this.automaton = AutomataUtils.buildFoLtlAutomaton(formula, domain);

		if (automaton.initials().size() > 1){
			throw new RuntimeException("Built Automaton has more than one initial state");
		}

		//Compute all possible assignments
		this.assignments = this.computeAllAssignments();

		//Compute satisfiability of labels x assignments
		this.satisfiabilityMap = new SatisfiabilityMap();
		this.computeSatisfiabilityMap();

		//Init current state
		this.currentState = (State) automaton.initials().iterator().next();
	}

	private LinkedHashSet<FoLtlAssignment> computeAllAssignments(){
		ArrayList<FoLtlVariable> variables = new ArrayList<>();
		variables.addAll(this.formula.getAcrossVariables());
		return this.allAssignments(0, variables);
	}

	private LinkedHashSet<FoLtlAssignment> allAssignments(int i, ArrayList<FoLtlVariable> variables){
		LinkedHashSet<FoLtlAssignment> res = new LinkedHashSet<>();

		if (i == variables.size() - 1){
			//Base case
			for (FoLtlConstant c : this.domain){
				FoLtlAssignment assignment = new FoLtlAssignment();
				assignment.put(variables.get(i), c);
				res.add(assignment);
			}

		} else {
			LinkedHashSet<FoLtlAssignment> old = allAssignments(i+1, variables);

			for (FoLtlAssignment assignment : old) {
				for (FoLtlConstant c : this.domain) {
					FoLtlAssignment ass = (FoLtlAssignment) assignment.clone();
					ass.put(variables.get(i), c);
					res.add(ass);
				}
			}
		}

		return res;
	}

	private void computeSatisfiabilityMap(){

		//Get all transitions ?
		Set<Transition<FoLtlLabel>> transitions = this.automaton.delta();

		for (Transition<FoLtlLabel> t : transitions){
			FoLtlLabel label = t.label();

			if (label instanceof FoLtlLocalFormula){
				for (FoLtlAssignment ass : this.assignments){
					Pair<FoLtlLabel, FoLtlAssignment> p = new Pair<>(label, ass);

					FoLtlLocalFormula f = (FoLtlLocalFormula) label;

					this.satisfiabilityMap.put(p, f.isSatisfiable(this.domain, ass));

				}
			} else if (label instanceof FoLtlEmptyTrace){
				//TODO che famo?
			} else {
				throw new RuntimeException("Unknown label type");
			}
		}
	}

	public SatisfiabilityMap getSatisfiabilityMap() {
		return satisfiabilityMap;
	}

	public LinkedHashSet<FoLtlAssignment> getAssignments() {
		return assignments;
	}
}
