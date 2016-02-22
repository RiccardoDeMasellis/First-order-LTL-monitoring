package runtimeVerification;

import automata.FoLtlEmptyTrace;
import automata.FoLtlLabel;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

import java.util.*;

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
	private ReachabilityMap reachabilityMap;
	private StateRVTruthValueMap truthValueMap;

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

		//Compute RVTruthValues
		this.computeReachability();

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
				//TODO are we sure about this?
				for (FoLtlAssignment ass : this.assignments){
					Pair<FoLtlLabel, FoLtlAssignment> p = new Pair<>(label, ass);
					this.satisfiabilityMap.put(p, true);
				}
			} else {
				throw new RuntimeException("Unknown label type");
			}
		}
	}

	private void computeReachability(){
		for (FoLtlAssignment assignment : this.assignments){
			this.reachabilityFloydWarshall(assignment);
		}
	}


	private void reachabilityFloydWarshall(FoLtlAssignment assignment){
		HashMap<State, HashMap<State, Boolean>> adjMatrix = new HashMap<>();
		ArrayList<State> states = new ArrayList<>();
		states.addAll(this.automaton.states());

		//Init
		for (int i = 0; i < states.size(); i++){
			State si = states.get(i);
			adjMatrix.put(si, new HashMap<>());

			for (int j = 0; j < states.size(); j++){
				State sj = states.get(j);
				Set<Transition<FoLtlLabel>> transitions = this.automaton.deltaFrom(si, sj);

				adjMatrix.get(si).put(sj, false);

				for (Transition<FoLtlLabel> t : transitions){
					adjMatrix.get(si).put(sj, this.satisfiabilityMap.get(new Pair<>(t.label(), assignment)));
				}
			}

			adjMatrix.get(si).put(si, true);
		}

		//Floyd-Warshall algorithm
		for (int k = 0; k < states.size(); k++){
			for (int i = 0; i < states.size(); i++){
				for (int j = 0; j < states.size(); j++){
					State si = states.get(i);
					State sj = states.get(j);
					State sk = states.get(k);

					if (adjMatrix.get(si).get(sk) && adjMatrix.get(sk).get(sj)){
						adjMatrix.get(si).put(sj, true);
					}
				}
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
