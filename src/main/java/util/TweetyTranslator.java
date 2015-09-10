package util;

import evaluations.PropositionLast;
import formula.ltlf.*;
import formulaa.foltl.*;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Class that packs static methods to translate tweety formulas back.
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 * @author Simone Calciolari.
 */
public class TweetyTranslator {

	/**
	 * Empty constructor; does nothing.
	 * Protected since this class is not intended to be instantiated.
	 */
	protected TweetyTranslator(){}

	/**
	 * Translates a given Tweety propositional formula into a LTLf(Local)Formula
	 * @param propformula the formula to be translated
	 * @return a LTLfFormula equivalent to the original
	 */
	public static LTLfFormula tweetyPropToLTLf(PropositionalFormula propformula){
		LTLfFormula res;

		if (propformula instanceof Conjunction){

			int size = ((Conjunction) propformula).size();
			res = tweetyPropToLTLf(((Conjunction) propformula).get(size - 1));

			for (int i = size-2; i>=0; i--){
				PropositionalFormula pf = ((Conjunction) propformula).get(i);
				LTLfFormula ltlff = tweetyPropToLTLf(pf);

				if (ltlff instanceof LTLfTempFormula || res instanceof LTLfTempFormula){
					res = new LTLfTempAndFormula(ltlff, res);
				} else {
					res = new LTLfLocalAndFormula(ltlff, res);
				}
			}

		} else if (propformula instanceof Disjunction){

			int size = ((Disjunction) propformula).size();
			res = tweetyPropToLTLf(((Disjunction) propformula).get(size - 1));

			for (int i = size-2; i>=0; i--){
				PropositionalFormula pf = ((Disjunction) propformula).get(i);
				LTLfFormula ltlff = tweetyPropToLTLf(pf);

				if (ltlff instanceof LTLfTempFormula || res instanceof LTLfTempFormula){
					res = new LTLfTempOrFormula(ltlff, res);
				} else {
					res = new LTLfLocalOrFormula(ltlff, res);
				}
			}

		} else if (propformula instanceof Negation){
			PropositionalFormula pNested = ((Negation) propformula).getFormula();
			LTLfFormula nested = tweetyPropToLTLf(pNested);

			if (nested instanceof LTLfTempFormula) {
				res = new LTLfTempNotFormula(nested);
			} else {
				res = new LTLfLocalNotFormula(nested);
			}

		} else if (propformula instanceof Proposition){

			if (propformula instanceof PropositionLast){
				//Substitute last with its interpretation
				res = new LTLfTempNotFormula(new LTLfNextFormula(new LTLfLocalTrueFormula()));
			} else {
				res = new LTLfLocalVar((Proposition) propformula);
			}

		} else if (propformula instanceof Tautology){
			res = new LTLfLocalTrueFormula();

		} else if (propformula instanceof Contradiction){
			res = new LTLfLocalFalseFormula();

		} else {
			throw new RuntimeException("Unknown propositional formula type");
		}

		return res;
	}

	/**
	 * Translates a LTLfFormula into an open FoLtlFormula, given a map that translates LTLfLocalVars into FoLtlLocalFormulas.
	 * @param ltlff the LTLfFormula to be translated.
	 * @param map the map.
	 * @return an open FoLtlFormula.
	 */
	public static FoLtlFormula ltlfToFoLtl(LTLfFormula ltlff, HashMap<LTLfFormula, FoLtlFormula> map){
		FoLtlFormula res;

		if (ltlff instanceof LTLfLocalVar){
			res = map.get(ltlff);

		} else if (ltlff instanceof LTLfTempDoubleImplFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempDoubleImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempDoubleImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempDoubleImplFormula(left, right);

		} else if (ltlff instanceof LTLfTempImplFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempImplFormula(left, right);

		} else if (ltlff instanceof LTLfTempOrFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempOrFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempOrFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempOrFormula(left, right);

		} else if (ltlff instanceof LTLfTempAndFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempAndFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempAndFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempAndFormula(left, right);

		} else if (ltlff instanceof LTLfWeakUntilFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfWeakUntilFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfWeakUntilFormula) ltlff).getRightFormula(), map);
			res = new FoLtlWeakUntilFormula(left, right);

		} else if (ltlff instanceof LTLfReleaseFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfReleaseFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfReleaseFormula) ltlff).getRightFormula(), map);
			res = new FoLtlReleaseFormula(left, right);

		} else if (ltlff instanceof LTLfUntilFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfUntilFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfUntilFormula) ltlff).getRightFormula(), map);
			res = new FoLtlUntilFormula(left, right);

		} else if (ltlff instanceof LTLfGloballyFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfGloballyFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlGloballyFormula(nested);

		} else if (ltlff instanceof LTLfEventuallyFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfEventuallyFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlEventuallyFormula(nested);

		} else if (ltlff instanceof LTLfWeakNextFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfWeakNextFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlWeakNextFormula(nested);

		} else if (ltlff instanceof LTLfNextFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfNextFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlNextFormula(nested);

		} else if (ltlff instanceof LTLfTempNotFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfTempNotFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlTempNotFormula(nested);

		} else if (ltlff instanceof LTLfLocalDoubleImplFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfLocalDoubleImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfLocalDoubleImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlLocalDoubleImplFormula(left, right);

		} else if (ltlff instanceof LTLfLocalImplFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfLocalImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfLocalImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlLocalImplFormula(left, right);

		} else if (ltlff instanceof LTLfLocalOrFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfLocalOrFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfLocalOrFormula) ltlff).getRightFormula(), map);
			res = new FoLtlLocalOrFormula(left, right);

		} else if (ltlff instanceof LTLfLocalAndFormula){
			FoLtlFormula left = ltlfToFoLtl(((LTLfLocalAndFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfLocalAndFormula) ltlff).getRightFormula(), map);
			res = new FoLtlLocalAndFormula(left, right);

		} else if (ltlff instanceof LTLfLocalNotFormula){
			FoLtlFormula nested = ltlfToFoLtl(((LTLfLocalNotFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlLocalNotFormula(nested);

		} else if (ltlff instanceof LTLfLocalTrueFormula){
			res = new FoLtlLocalTrueAtom();

		} else if (ltlff instanceof LTLfLocalFalseFormula){
			res = new FoLtlLocalFalseAtom();

		} else {
			throw new RuntimeException("Unknown LTLfFormula type: " + ltlff);
		}

		return res;
	}

	/**
	 * Transform a Tweety PossibleWorld into an open FoLtlFormula.
	 * @param pw the PossibleWorld object.
 	 * @param sig the relative PropositionalSignature.
	 * @param ltlfTOfoltl a map used to translate LTLfLocalVars into FoLtlLocalFormulas.
	 * @return an open FoLtlFormula.
	 */
	public static FoLtlFormula tweetyPwToFoLtl(PossibleWorld pw, PropositionalSignature sig,
																						 HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){

		FoLtlFormula res;

		PropositionalFormula cj = pw.getCompleteConjunction(sig);
		LTLfFormula ltlff = tweetyPropToLTLf(cj);
		res = ltlfToFoLtl(ltlff, ltlfTOfoltl);

		return res;
	}

	/**
	 * Given a map from LTLfFormula to FoLtlFormula (used during automata translation),
	 * computes the corresponding Propositional Signature in Tweety data structures.
	 * @param ltlfTOfoltl the map.
	 * @return the computed PRopositionalSignature.
	 */
	public static PropositionalSignature getPropSignature(HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		Iterator<LTLfFormula> ltlffs = ltlfTOfoltl.keySet().iterator();
		PropositionalSignature res = new PropositionalSignature();

		while (ltlffs.hasNext()){
			LTLfFormula next = ltlffs.next();

			if (next instanceof LTLfLocalFormula){
				PropositionalFormula pf = ((LTLfLocalFormula) next).toTweetyProp();

				if (pf instanceof Proposition){
					if (pf instanceof PropositionLast){
						res.add((PropositionLast) pf);
					} else {
						res.add((Proposition) pf);
					}
				} else {
					throw new RuntimeException("Tweety Proposition expected");
				}
			} else {
				throw new RuntimeException("Wrong LTLf formula type");
			}
		}

		return res;
	}

}
