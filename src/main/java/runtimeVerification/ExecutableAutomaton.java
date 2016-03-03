package runtimeVerification;

import automata.FoLtlEmptyTrace;
import automata.FoLtlLabel;
import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlFormula;
import formulaa.foltl.FoLtlLocalFormula;
import formulaa.foltl.FoLtlVariable;
import formulaa.foltl.semantics.FoLtlAssignment;
import formulaa.foltl.semantics.FoLtlInterpretation;
import formulaa.rv.RVFalse;
import formulaa.rv.RVTempFalse;
import formulaa.rv.RVTempTrue;
import formulaa.rv.RVTrue;
import rationals.Automaton;
import rationals.State;
import rationals.Transition;
import util.AutomataUtils;
import util.Pair;
import utils.AutomatonUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
	private HashMap<State, HashSet<FoLtlAssignment>> movementMap;
	private HashMap<FoLtlAssignment, HashSet<State>> reverseMovementMap;

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

		//Init movement map
		this.movementMap = new HashMap<>();

		for (Object o : this.automaton.states()){
			this.movementMap.put((State) o, new HashSet<>());
		}

		State i = (State) this.automaton.initials().iterator().next();
		this.movementMap.get(i).addAll(this.assignments);

		//Init reverse movement map
		this.reverseMovementMap = new HashMap<>();
		for (FoLtlAssignment assignment: this.assignments){
			this.reverseMovementMap.put(assignment, new HashSet<>());
			this.reverseMovementMap.get(assignment).add(i);
		}

		//<editor-fold desc="Write graph to disk" defaultstate="collapsed">
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("foltlAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintStream ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(this.automaton));
		ps.flush();
		ps.close();
		//</editor-fold>
	}

	private LinkedHashSet<FoLtlAssignment> computeAllAssignments(){
		ArrayList<FoLtlVariable> variables = new ArrayList<>();
		variables.addAll(this.formula.getAcrossVariables());
		return this.allAssignments(0, variables);
	}

	private LinkedHashSet<FoLtlAssignment> allAssignments(int i, ArrayList<FoLtlVariable> variables){
		LinkedHashSet<FoLtlAssignment> res = new LinkedHashSet<>();

		if (i == variables.size()){
			//Base case
			res.add(new FoLtlAssignment());

		} else {
			LinkedHashSet<FoLtlAssignment> old = allAssignments(i + 1, variables);
			FoLtlVariable v = variables.get(i);

			for (FoLtlAssignment assignment : old) {
				for (FoLtlConstant c : v.getSort()) {
					FoLtlAssignment ass = (FoLtlAssignment) assignment.clone();
					ass.put(v, c);
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

	public void step(FoLtlTraceInput traceInput){
		HashMap<State, HashSet<FoLtlAssignment>> newMovementMap =
				(HashMap<State, HashSet<FoLtlAssignment>>) this.movementMap.clone();

		for (Object o : this.automaton.states()){
			State from = (State) o;
			Set<Transition<FoLtlLabel>> transitions = this.automaton.delta(from);

			for (Transition<FoLtlLabel> t : transitions){
				State to = t.end();
				FoLtlLabel label = t.label();
				HashSet<FoLtlAssignment> stateAssignments = (HashSet<FoLtlAssignment>) this.movementMap.get(from).clone();

				if (label instanceof FoLtlFormula && traceInput instanceof FoLtlInterpretation){
					FoLtlFormula formula = (FoLtlFormula) label;
					FoLtlInterpretation interpretation = (FoLtlInterpretation) traceInput;

					for (FoLtlAssignment assignment : stateAssignments){
						if (interpretation.satisfies((FoLtlLocalFormula) formula.substitute(assignment))){
							this.moveAssignment(newMovementMap, this.reverseMovementMap, assignment, from, to);
						}
					}
				} else if (label instanceof FoLtlEmptyTrace && traceInput instanceof FoLtlEmptyTraceInput){
					//TODO ?
					for (FoLtlAssignment assignment: stateAssignments){
						this.moveAssignment(newMovementMap, this.reverseMovementMap, assignment, from, to);
					}
				} else {
					//Do nothing
				}
			}
		}

		this.movementMap = newMovementMap;
	}

	private void moveAssignment(HashMap<State, HashSet<FoLtlAssignment>> movementMap,
															HashMap<FoLtlAssignment, HashSet<State>> reverseMovementMap,
															FoLtlAssignment assignment, State from, State to){

		movementMap.get(from).remove(assignment);
		movementMap.get(to).add(assignment);
		reverseMovementMap.get(assignment).remove(from);
		reverseMovementMap.get(assignment).add(to);
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
	public HashMap<State, HashSet<FoLtlAssignment>> getMovementMap() {
		return movementMap;
	}
	public HashMap<FoLtlAssignment, HashSet<State>> getReverseMovementMap() {
		return reverseMovementMap;
	}
}
