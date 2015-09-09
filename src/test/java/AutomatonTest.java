import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalVar;
import formulaa.foltl.*;
import net.sf.tweety.logics.fol.syntax.Conjunction;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
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

/**
 * AutomatonTest
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 *
 * @author Simone Calciolari.
 */
public class AutomatonTest {

	@Test
	public void testAutomaton(){
		parseFoLtlFormula("P(a)");
		System.out.println();
		System.out.println();

		FoLtlFormula formula = parseFoLtlFormula("P(a) U P(b)");
		//System.out.println(formula);

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltLfFormula = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		//System.out.println(ltLfFormula);
		//System.out.println(foltlTOltlf);
		//System.out.println(ltlfTOfoltl);

		LDLfFormula ldLfFormula = ltLfFormula.toLDLf();

		Automaton automaton = AutomatonUtils.ldlf2Automaton(ldLfFormula, ldLfFormula.getSignature());

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("ltlfAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(automaton));
		ps.flush();
		ps.close();


		///////////////////////////////////////////////////////
		//                  TEST TRANSLATION                 //
		///////////////////////////////////////////////////////

		Automaton translated = new Automaton();
		Iterator<State> states = automaton.states().iterator();
		HashMap<State, State> oldTOnew = new HashMap<>();

		//Add all states to new automaton. Keep a map from old to new States.
		while (states.hasNext()){
			State s = states.next();
			State news = translated.addState(s.isInitial(), s.isTerminal());
			oldTOnew.put(s, news);
		}

		//Signature for our test case (Must be generated automatically)
		PropositionalSignature sig = new PropositionalSignature();
		sig.add(new Proposition("P_a"));
		sig.add(new Proposition("P_b"));

		//To be done better and somewhere else
		ltlfTOfoltl.put(new LTLfLocalVar("last"), new FoLtlTempNotFormula(new FoLtlNextFormula(new FoLtlLocalTrueAtom())));

		states = automaton.states().iterator();

		while (states.hasNext()){
			State s = states.next();
			Iterator<Transition<PossibleWorld>> oldtransitions = automaton.delta(s).iterator();

			while (oldtransitions.hasNext()){
				Transition<PossibleWorld> oldt = oldtransitions.next();
				System.out.println("Old transition: " + oldt);
				State oldEnd = oldt.end();

				PossibleWorld pw = oldt.label();
				System.out.println("\n\t\tPssible world: " + pw);

				PropositionalFormula cj = pw.getCompleteConjunction(sig);

				LTLfFormula ltlff = tweetyPropToLTLf(cj);
				System.out.println("\t\tComplete conjunction (LTLf): " + ltlff);

				FoLtlFormula label = ltlfToFoLtl(tweetyPropToLTLf(cj), ltlfTOfoltl);
				System.out.println("\t\tLabel (FO-LTL): " + label + "\n");

				Transition<FoLtlFormula> t = new Transition<>(oldTOnew.get(s), label, oldTOnew.get(oldEnd));
				System.out.println("New transition: " + t);

				try {
					translated.addTransition(t);
				} catch (NoSuchStateException e) {
					throw new RuntimeException(e);
				}

				System.out.println("\n");

			}

		}

		fos = null;
		try {
			fos = new FileOutputStream("foltlAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(translated));
		ps.flush();
		ps.close();

	}

	@Test
	public void testPossibleWorlds(){

		Proposition a = new Proposition("a");
		Proposition b = new Proposition("b");

		HashSet<Proposition> props = new HashSet<>();
		props.add(a);
		PossibleWorld pw = new PossibleWorld(props);
		System.out.println(pw);

		PropositionalSignature sig = new PropositionalSignature();
		sig.add(a);
		sig.add(b);
		System.out.println(sig);

		System.out.println(pw.getCompleteConjunction(sig));

	}

}
