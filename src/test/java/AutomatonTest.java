import automata.FoLtlEmptyTrace;
import automata.FoLtlLabel;
import evaluations.EmptyTrace;
import evaluations.PropositionLast;
import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalVar;
import formulaa.foltl.*;
import net.sf.tweety.logics.fol.syntax.Conjunction;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.junit.Assert;
import org.junit.Test;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;
import utils.AutomatonUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import static util.ParsingUtils.*;
import static util.TweetyTranslator.*;
import static automata.AutomataTranslator.*;

/**
 * AutomatonTest
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 * @author Simone Calciolari.
 */
public class AutomatonTest {

	//Used to display verbose debug mesages during execution
	private static final boolean DEBUG = true;

	@Test
	public void testAutomaton(){
		parseFoLtlFormula("P(a)");
		System.out.println("\n\nTEST AUTOMATA TRANSLATION\n");

		FoLtlFormula inputFormula = parseFoLtlFormula("P(a) U P(b)");

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltlfFormula = inputFormula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LDLfFormula ldlfFormula = ltlfFormula.toLDLf();

		Automaton original = AutomatonUtils.ldlf2Automaton(ldlfFormula, ldlfFormula.getSignature());
		Automaton expected = ldlfAutomataToFoLtl(original, ltlfTOfoltl);
		Automaton computed = ldlfAutomataToFoLtlTest(original, ltlfTOfoltl);

		//assertEquals("Sanity check: test method and actual method produce the same result", expected, computed);

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
		ps.println(AutomatonUtils.toDot(expected));
		ps.flush();
		ps.close();
		//</editor-fold>

	}

	/**
	 * Translates a ldlf Automaton (with Tweety PossibleWorld labels) into a new Automaton with
	 * (open) FoLtlFormula labels.
	 * @param original the original Automaton.
	 * @param ltlfTOfoltl a map to translate LTLfLocalVar into open FoLtlLocalFormula.
	 * @return the translated Automaton.
	 */
	private static Automaton ldlfAutomataToFoLtlTest(Automaton original, HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		Automaton res = new Automaton();

		//Update the map to handle last atoms (still to be improved)
		ltlfTOfoltl.put(new LTLfLocalVar(new PropositionLast()),
				new FoLtlTempNotFormula(new FoLtlNextFormula(new FoLtlLocalTrueAtom())));

		//Get the signature
		PropositionalSignature sig = getPropSignature(ltlfTOfoltl);

		//ADD STATES TO THE NEW AUTOMATON
		//Original states iterator
		Iterator<State> originalStates = original.states().iterator();

		//Map of the state translation
		HashMap<State, State> oldToNewStates = new HashMap<>();

		//For each original state, insert a new "identical" one and update the translation map
		while (originalStates.hasNext()){
			State old = originalStates.next();
			State news = res.addState(old.isInitial(), old.isTerminal());

			Assert.assertTrue(old.isInitial() == news.isInitial());
			Assert.assertTrue(old.isTerminal() == news.isTerminal());

			oldToNewStates.put(old, news);
		}

		//ADDING TRANSITION TO NEW AUTOMATON
		//For each original state, get all transitions starting from it, translate the label,
		//and insert the new translated transition in the translated automaton

		//Get the iterator on the original states (again)
		originalStates = original.states().iterator();

		while (originalStates.hasNext()){

			State oldStart = originalStates.next();
			Iterator<Transition<PossibleWorld>> oldTransitions = original.delta(oldStart).iterator();

			//Iterate over all transition starting from the current (old) state.
			while (oldTransitions.hasNext()){
				//Get next transition
				Transition<PossibleWorld> oldt = oldTransitions.next();

				//Get its end state
				State oldEnd = oldt.end();

				//Get original label
				PossibleWorld pw = oldt.label();

				//Translate original label
				FoLtlLabel newLabel;

				if (pw instanceof EmptyTrace){
					newLabel = new FoLtlEmptyTrace();
				} else {
					//Get the new label
					newLabel = tweetyPwToFoLtl(pw, sig, ltlfTOfoltl);
				}

				//Create new transition
				//Get start and end states
				State newStart = oldToNewStates.get(oldStart);
				State newEnd = oldToNewStates.get(oldEnd);

				Transition<FoLtlLabel> newt = new Transition<>(newStart, newLabel, newEnd);

				//Add it to translated automaton
				try {
					res.addTransition(newt);
				} catch (NoSuchStateException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return res;
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
