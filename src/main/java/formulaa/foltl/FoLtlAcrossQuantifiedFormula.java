package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formulaa.AcrossQuantifiedFormula;
import formulaa.Formula;
import formulaa.OperatorType;
import formulaa.Variable;

import java.util.HashMap;

/**
 * Interface that represents a generic FOLTL across-state quantified formula.
 * <p>
 * Created by Simone Calciolari on 10/08/15.
 * @author Simone Calciolari
 */
public interface FoLtlAcrossQuantifiedFormula extends FoLtlTemporalFormula, AcrossQuantifiedFormula {

	/**
	 * Translates this formula into a FLLOAT LTLf formula, where to every original local (FOL) formula
	 * corresponds an atomic proposition.
	 * @param foltlTOltlf a map that allows to transform foltl local formulas to ltlf atomic proposition
	 * @param ltlfTOfoltl a map that allows to do the inverse
	 * @return the newly built LTLf formula
	 */
	@Override
	default LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														 HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		return ((FoLtlFormula) this.getNestedFormula()).toLTLf(foltlTOltlf, ltlfTOfoltl);
	}

	/**
	 * Returns an instance with the desired properties.
	 * @param quantifier the quantifier type
	 * @param nestedFormula the quantified formula
	 * @param qvar the quantified variable
	 * @return the desired instance
	 */
	@Override
	default FoLtlFormula quantifiedFormulaFactory(OperatorType quantifier, Formula nestedFormula, Variable qvar){
		FoLtlFormula res;

		switch (quantifier){

			case FORALL:
				res = new FoLtlAcrossForallFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			case EXISTS:
				res = new FoLtlAcrossExistsFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			default:
				throw new RuntimeException("Unknown quantifier");

		}

		return res;
	}

}
