package main;

import language.foltl.FoLtlAtomicFormula;
import language.foltl.FoLtlConstant;
import language.foltl.FoLtlFormula;
import language.foltl.FoLtlLocalAtom;
import language.foltl.semantics.FoLtlInterpretation;
import runtimeVerification.ExecutableAutomaton;
import runtimeVerification.FoLtlEmptyTraceInput;
import runtimeVerification.FoLtlTraceInput;
import util.FoLtlSortManager;

import java.util.LinkedHashSet;

import static util.ParsingUtils.*;

/**
 * ExampleMain
 * <br>
 * Created by Simone Calciolari on 08/03/16.
 * @author Simone Calciolari.
 */
public class ExampleMain {

	public static void main(String[] args){

		//Parse the desired formula using static method parseFoLtlFormula defined in util.ParsingUtils
		FoLtlFormula formula = parseFoLtlFormula("Forall ?x (Forall ?y (G ((P(?x)) -> F (Exists ?z (Q(?y, ?z))))))");

		//Define the domain; parseConstantSet defined in util.ParsingUtils
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b", "c", "d", "e", "f", "g");

		//Define and assign sorts
		FoLtlSortManager sm = new FoLtlSortManager(domain);
		//Definition
		sm.parseSortDefinition("SortABC := {a, b, c}; SortDE := {d, e}; SortFG := {f, g};");
		//Assignment
		sm.assignSort(formula, "?x <- SortABC; ?y <- SortDE; ?z <- SortFG;");

		//Initialize ExecutableAutomaton
		//Performs intensive and time consuming operations; may require some time.
		ExecutableAutomaton ea = new ExecutableAutomaton(formula, domain);

		//Proceed with execution
		//Time consuming operations have already been performed, so it should proceed quickly

		//Example output; initial state
		//Print State -> Set<Assigment> map
		System.out.println(ea.getMovementMap());
		//Print Assignment -> Set<State> map
		System.out.println(ea.getReverseMovementMap());
		//Print current RV Truth Value
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

		//Define next input
		FoLtlInterpretation interpretation = new FoLtlInterpretation(domain);
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("P(a)"));
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("Q(d, g)"));

		//Perform step
		ea.step(interpretation);

		//Example output; print current state (see above)
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();


		//Define next input
		interpretation = new FoLtlInterpretation(domain);
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("P(a)"));
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("P(b)"));
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("Q(e, f)"));

		//Perform step
		ea.step(interpretation);

		//Example output; print current state (see above)
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();


		//End of trace input
		ea.step(new FoLtlEmptyTraceInput());

		//Example output; print current state (see above)
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

	}
}
