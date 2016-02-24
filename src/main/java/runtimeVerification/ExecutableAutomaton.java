package runtimeVerification;

import RuntimeVerification.RVFalse;
import RuntimeVerification.RVTempFalse;
import RuntimeVerification.RVTempTrue;
import RuntimeVerification.RVTrue;
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

		//Compute reachability
		this.computeReachability();

		//Compute RVTruthValues
		this.computeRVTruthValues();

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
		this.reachabilityMap = new ReachabilityMap();

		for (FoLtlAssignment assignment : this.assignments){
			this.reachabilityFloydWarshall(assignment);
		}
	}

	private void reachabilityFloydWarshall(FoLtlAssignment assignment){
		ArrayList<State> states = new ArrayList<>();
		states.addAll(this.automaton.states());
		boolean [][] adjMatrix = new boolean[states.size()][states.size()];

		//Init
		for (int i = 0; i < states.size(); i++){
			for (int j = 0; j < states.size(); j++){
				adjMatrix[i][j] = false;
				Set<Transition<FoLtlLabel>> transitions = this.automaton.deltaFrom(states.get(i), states.get(j));

				for (Transition<FoLtlLabel> t : transitions){
					adjMatrix[i][j] = this.satisfiabilityMap.get(new Pair<>(t.label(), assignment));
				}
			}

			adjMatrix[i][i] = true;
		}

		//Floyd-Warshall algorithm
		for (int k = 0; k < states.size(); k++){
			for (int i = 0; i < states.size(); i++){
				for (int j = 0; j < states.size(); j++){
					if (adjMatrix[i][k] && adjMatrix[k][j]){
						adjMatrix[i][j] = true ;
					}
				}
			}
		}

		//Fill reachability map
		for (int i = 0; i < states.size(); i++){
			State si = states.get(i);
			Pair<State, FoLtlAssignment> key = new Pair<>(si, assignment);
			HashSet<State> reachableStates = new HashSet<>();

			for (int j = 0; j < states.size(); j++){
				if (adjMatrix[i][j]){
					State sj = states.get(j);
					reachableStates.add(sj);
				}
			}

			this.reachabilityMap.put(key, reachableStates);
		}

	}

	private void computeRVTruthValues(){
		this.truthValueMap = new StateRVTruthValueMap();

		for (Pair<State, FoLtlAssignment> key : this.reachabilityMap.keySet()){
			boolean allTerminals = true;
			boolean allNonTerminals = true;
			HashSet<State> accessibleStates = this.reachabilityMap.get(key);

			for (State s : accessibleStates){
				if (!s.isTerminal()){
					allTerminals = false;
				} else {
					allNonTerminals = false;
				}
			}

			if (key.getFirst().isTerminal()){
				if (allTerminals){
					this.truthValueMap.put(key, new RVTrue());
				} else {
					this.truthValueMap.put(key, new RVTempTrue());
				}
			} else {
				if (allNonTerminals){
					this.truthValueMap.put(key, new RVFalse());
				} else {
					this.truthValueMap.put(key, new RVTempFalse());
				}
			}
		}
	}




	//SETTER-GETTER methods

	public SatisfiabilityMap getSatisfiabilityMap() {
		return satisfiabilityMap;
	}
	public LinkedHashSet<FoLtlAssignment> getAssignments() {
		return assignments;
	}
	public ReachabilityMap getReachabilityMap() {
		return reachabilityMap;
	}
	public StateRVTruthValueMap getTruthValueMap() {
		return truthValueMap;
	}
}
