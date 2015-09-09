package util;

import formula.ltlf.*;
import formulaa.foltl.FoLtlFormula;
import net.sf.tweety.logics.pl.syntax.*;

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


	public static LTLfFormula tweetyPropToLTLf(PropositionalFormula propformula){
		LTLfFormula res = null;

		if (propformula instanceof Conjunction){
			Set<PropositionalFormula> formulas = ((Conjunction) propformula).getFormulas();

			for (PropositionalFormula pf : formulas){
				if (res == null){
					res = tweetyPropToLTLf(pf);
				} else {
					res = new LTLfLocalAndFormula(tweetyPropToLTLf(pf), res);
				}
			}

		} else if (propformula instanceof Disjunction){
			Set<PropositionalFormula> formulas = ((Disjunction) propformula).getFormulas();

			for (PropositionalFormula pf : formulas){
				if (res == null){
					res = tweetyPropToLTLf(pf);
				} else {
					res = new LTLfLocalOrFormula(tweetyPropToLTLf(pf), res);
				}
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

}
