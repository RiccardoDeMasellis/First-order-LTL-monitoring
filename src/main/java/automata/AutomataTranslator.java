package automata;

import static util.TweetyTranslator.*;

import automaton.EmptyTrace;
import automaton.PossibleWorldWrap;
import automaton.TransitionLabel;
import formula.ltlf.LTLfFormula;
import formulaa.foltl.FoLtlFormula;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Class that packs static methods to translate automata.
 * <br>
 * Created by Simone Calciolari on 10/09/15.
 * @author Simone Calciolari
 */
public class AutomataTranslator {

	/**
	 * Empty constructor; does nothing. Protected since this class is not intended to be instantiated.
	 */
	protected AutomataTranslator(){}

	/**
	 * Translates a ldlf Automaton (with Tweety PossibleWorld labels) into a new Automaton with
	 * (open) FoLtlFormula labels.
	 * @param original the original Automaton.
	 * @param ltlfTOfoltl a map to translate LTLfLocalVar into open FoLtlLocalFormula.
	 * @return the translated Automaton.
	 */
	public static Automaton ldlfAutomataToFoLtl(Automaton original, HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		Automaton res = new Automaton();

		/*We now ignore last atom
		//Update the map to handle last atoms (still to be improved)
		//TODO put in a better place
		ltlfTOfoltl.put(new LTLfLocalVar(new PropositionLast()),
				new FoLtlTempNotFormula(new FoLtlNextFormula(new FoLtlLocalTrueAtom())));
		*/

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
			oldToNewStates.put(old, news);
		}

		//ADDING TRANSITION TO NEW AUTOMATON
		//For each original state, get all transitions starting from it, translate the label,
		//and insert the new translated transition in the translated automaton

		//Get the iterator on the original states (again)
		originalStates = original.states().iterator();

		while (originalStates.hasNext()){

			State oldStart = originalStates.next();
			Iterator<Transition<TransitionLabel>> oldTransitions = original.delta(oldStart).iterator();

			//Iterate over all transition starting from the current (old) state.
			while (oldTransitions.hasNext()){
				//Get next transition
				Transition<TransitionLabel> oldt = oldTransitions.next();

				//Get its end state
				State oldEnd = oldt.end();

				//Get original label
				TransitionLabel oldLabel = oldt.label();

				//Translate original label
				FoLtlLabel newLabel;

				if (oldLabel instanceof EmptyTrace){
					newLabel = new FoLtlEmptyTrace();
				} else if (oldLabel instanceof PossibleWorldWrap) {
					//Get the new label
					newLabel = tweetyPwToFoLtl((PossibleWorldWrap) oldLabel, sig, ltlfTOfoltl);
				} else {
					throw new RuntimeException("Unknown transition label type");
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

}
