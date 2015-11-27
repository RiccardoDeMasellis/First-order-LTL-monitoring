import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formulaa.foltl.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import rationals.Automaton;
import utils.AutomatonUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

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

		FoLtlFormula inputFormula = parseFoLtlFormula("Forall ?x (P(a) U (P(b) && P(?x)))");

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltlfFormula = inputFormula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LDLfFormula ldlfFormula = ltlfFormula.toLDLf();

		Automaton original = AutomatonUtils.ldlf2Automaton(ldlfFormula, ldlfFormula.getSignature());
		Automaton computed = ldlfAutomataToFoLtl(original, ltlfTOfoltl);

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
