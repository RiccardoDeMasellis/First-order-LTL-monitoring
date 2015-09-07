package formulaa.foltl;

import formula.ltlf.LTLfFormula;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempLastAtom extends FoLtlAtomicFormula implements FoLtlTemporalFormula {

	//TODO: fix interpretation into Visitor

	public String toString(){
		return "LAST";
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_LAST_ATOM;
	}

	/**
	 * Returns a negation of this formula
	 * @return
	 */
	@Override
	public FoLtlFormula negate(){
		return new FoLtlTempNotFormula(this.clone());
	}

	/**
	 * Translates this formula into a FLLOAT LTLf formula, where to every original local (FOL) formula
	 * corresponds an atomic proposition.
	 * @param foltlTOltlf a map that allows to transform foltl local formulas to ltlf atomic proposition
	 * @param ltlfTOfoltl a map that allows to do the inverse
	 * @return the newly built LTLf formula
	 */
	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		//TODO return correct thing (?)
		return null;
	}

}
