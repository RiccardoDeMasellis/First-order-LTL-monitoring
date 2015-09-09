package util;

import formula.ltlf.*;
import formulaa.foltl.*;
import net.sf.tweety.logics.pl.syntax.*;

import java.util.HashMap;
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
	 * Translates a given tweety Proposition into a LTLfLocalVar.
	 * @param prop the tweety Proposition.
	 * @return a LTLfLocalVar with the same name.
	 */
	public static LTLfLocalVar tweetyPropToLTLfVar(Proposition prop){
		return new LTLfLocalVar(prop.getName());
	}

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
				res = new LTLfLocalAndFormula(tweetyPropToLTLf(pf), res);
			}

		} else if (propformula instanceof Disjunction){

			int size = ((Disjunction) propformula).size();
			res = tweetyPropToLTLf(((Disjunction) propformula).get(size - 1));

			for (int i = size-2; i>=0; i--){
				PropositionalFormula pf = ((Disjunction) propformula).get(i);
				res = new LTLfLocalOrFormula(tweetyPropToLTLf(pf), res);
			}

		} else if (propformula instanceof Negation){
			PropositionalFormula pNested = ((Negation) propformula).getFormula();
			LTLfFormula nested = tweetyPropToLTLf(pNested);
			res = new LTLfLocalNotFormula(nested);

		} else if (propformula instanceof Proposition){
			res = tweetyPropToLTLfVar((Proposition) propformula);

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

		} else if (ltlff instanceof LTLfTempDoubleImplFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempDoubleImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempDoubleImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempDoubleImplFormula(left, right);

		} else if (ltlff instanceof LTLfTempImplFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempImplFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempImplFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempImplFormula(left, right);

		} else if (ltlff instanceof LTLfTempOrFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempOrFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempOrFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempOrFormula(left, right);

		} else if (ltlff instanceof LTLfTempAndFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfTempAndFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfTempAndFormula) ltlff).getRightFormula(), map);
			res = new FoLtlTempAndFormula(left, right);

		} else if (ltlff instanceof LTLfWeakUntilFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfWeakUntilFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfWeakUntilFormula) ltlff).getRightFormula(), map);
			res = new FoLtlWeakUntilFormula(left, right);

		} else if (ltlff instanceof LTLfReleaseFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfReleaseFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfReleaseFormula) ltlff).getRightFormula(), map);
			res = new FoLtlReleaseFormula(left, right);

		} else if (ltlff instanceof LTLfUntilFormula) {
			FoLtlFormula left = ltlfToFoLtl(((LTLfUntilFormula) ltlff).getLeftFormula(), map);
			FoLtlFormula right = ltlfToFoLtl(((LTLfUntilFormula) ltlff).getRightFormula(), map);
			res = new FoLtlUntilFormula(left, right);

		} else if (ltlff instanceof LTLfGloballyFormula) {
			FoLtlFormula nested = ltlfToFoLtl(((LTLfGloballyFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlGloballyFormula(nested);

		} else if (ltlff instanceof LTLfEventuallyFormula) {
			FoLtlFormula nested = ltlfToFoLtl(((LTLfEventuallyFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlEventuallyFormula(nested);

		} else if (ltlff instanceof LTLfWeakNextFormula) {
			FoLtlFormula nested = ltlfToFoLtl(((LTLfWeakNextFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlWeakNextFormula(nested);

		} else if (ltlff instanceof LTLfNextFormula) {
			FoLtlFormula nested = ltlfToFoLtl(((LTLfNextFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlNextFormula(nested);

		} else if (ltlff instanceof LTLfTempNotFormula) {
			FoLtlFormula nested = ltlfToFoLtl(((LTLfTempNotFormula) ltlff).getNestedFormula(), map);
			res = new FoLtlTempNotFormula(nested);

		} else if (ltlff instanceof LTLfLocalVar) {
			res = map.get(ltlff);

		} else {
			throw new RuntimeException("Unknown LTLfFormula type");
		}

		return res;
	}

}
