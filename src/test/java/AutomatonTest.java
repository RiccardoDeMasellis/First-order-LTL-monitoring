import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import language.foltl.*;
import language.foltl.semantics.FoLtlInterpretation;
import language.rv.*;
import org.junit.Assert;
import org.junit.Test;
import rationals.Automaton;
import runtimeVerification.ExecutableAutomaton;
import runtimeVerification.FoLtlEmptyTraceInput;
import util.FoLtlSortManager;
import utils.AutomatonUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashSet;

import static util.ParsingUtils.*;
import static automata.AutomataTranslator.*;

/**
 * AutomatonTest
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 * @author Simone Calciolari.
 */
public class AutomatonTest {

	//Used to display verbose debug messages during execution
	private static final boolean DEBUG = true;

	@Test
	public void testAutomaton(){
		System.out.println("TEST AUTOMATA TRANSLATION\n");

		FoLtlFormula inputFormula = parseFoLtlFormula("Forall ?x (P(?x) U P(b))");
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltlfFormula = inputFormula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LDLfFormula ldlfFormula = ltlfFormula.toLDLf();

		Automaton original = AutomatonUtils.ldlf2Automaton(ldlfFormula, ldlfFormula.getSignature());
		Automaton computed = ldlfAutomataToFoLtl(original, ltlfTOfoltl, domain);

		//<editor-fold desc="Writes graphs to disk" defaultstate="collapsed">

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("ltlfAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintStream ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(original));
		ps.flush();
		ps.close();

		fos = null;

		try {
			fos = new FileOutputStream("foltlAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(computed));
		ps.flush();
		ps.close();
		//</editor-fold>
	}

	@Test
	public void testExecutableAutomaton(){
		FoLtlFormula formula = parseFoLtlFormula("Exists ?z (Forall ?x ((P(?x) && !P(?z)) U (Exists ?y (Q(?y)))))");
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");
		ExecutableAutomaton ea = new ExecutableAutomaton(formula, domain);

		System.out.println(ea.getAssignments());
		//System.out.println(ea.getSatisfiabilityMap());
		//System.out.println(ea.getReachabilityMap());
		//System.out.println(ea.getTruthValueMap());

	}

	@Test
	public void testRVExpansion(){
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b", "c");
		FoLtlFormula formula = parseFoLtlFormula("Exists ?x (Forall ?y (Q(x) U P(y)))");
		FoLtlSortManager sm = new FoLtlSortManager(domain);

		sm.parseSortDefinition("SortAB := {a, b}; SortC := {c};");
		sm.assignSort(formula, "?x <- SortAB; ?y <- SortC;");

		System.out.println(formula.expandToRVFormula(domain));

	}

	@Test
	public void testRVEvaluation(){

		RVFormula t = new RVTrue();
		RVFormula tt = new RVTempTrue();
		RVFormula tf = new RVTempFalse();
		RVFormula f = new RVFalse();

		RVFormula formula = new RVAndFormula(t, t);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVAndFormula(t, tt);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVAndFormula(t, tf);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVAndFormula(t, f);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(tt, t);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVAndFormula(tt, tt);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVAndFormula(tt, tf);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVAndFormula(tt, f);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(tf, t);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVAndFormula(tf, tt);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVAndFormula(tf, tf);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVAndFormula(tf, f);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(f, t);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(f, tt);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(f, tf);
		assertEquals("", new RVFalse(), formula.evaluate());

		formula = new RVAndFormula(f, f);
		assertEquals("", new RVFalse(), formula.evaluate());


		formula = new RVOrFormula(t, t);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(t, tt);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(t, tf);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(t, f);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(tt, t);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(tt, tt);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVOrFormula(tt, tf);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVOrFormula(tt, f);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVOrFormula(tf, t);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(tf, tt);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVOrFormula(tf, tf);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVOrFormula(tf, f);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVOrFormula(f, t);
		assertEquals("", new RVTrue(), formula.evaluate());

		formula = new RVOrFormula(f, tt);
		assertEquals("", new RVTempTrue(), formula.evaluate());

		formula = new RVOrFormula(f, tf);
		assertEquals("", new RVTempFalse(), formula.evaluate());

		formula = new RVOrFormula(f, f);
		assertEquals("", new RVFalse(), formula.evaluate());

	}

	@Test
	public void testExecution(){
		FoLtlFormula formula =
				parseFoLtlFormula("Forall ?z (Forall ?x ( (G(P(?x) -> F (Exists ?y (Q(?x, ?y))))) " +
				"& (G(S(?z) -> F (Exists ?w (T(?z, ?w))))) ))");

		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b", "c", "d");

		FoLtlSortManager sm = new FoLtlSortManager(domain);
		sm.parseSortDefinition("SortAB := {a, b}; SortC := {c}; SortD := {d};");
		sm.assignSort(formula, "?z <- SortAB; ?x <- SortD; ?y <- SortAB; ?w <- SortC;");

		ExecutableAutomaton ea = new ExecutableAutomaton(formula, domain);

		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

		FoLtlInterpretation interpretation = new FoLtlInterpretation(domain);
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("P(a)"));

		ea.step(interpretation);
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

		interpretation = new FoLtlInterpretation(domain);
		interpretation.add((FoLtlLocalAtom) parseFoLtlFormula("P(d)"));

		ea.step(interpretation);
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

		ea.step(new FoLtlEmptyTraceInput());
		System.out.println(ea.getMovementMap());
		System.out.println(ea.getReverseMovementMap());
		System.out.println(ea.computeFormulaRVTruthValue());
		System.out.println();

	}

	//<editor-fold desc="assertEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertEquals";
		}

		try {
			Assert.assertEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertNotEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertNotEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertNotEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertNotEquals";
		}

		try {
			Assert.assertNotEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}
