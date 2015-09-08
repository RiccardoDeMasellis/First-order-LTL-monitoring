package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempAndFormula;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempAndFormula extends FoLtlBinaryFormula implements formulaa.AndFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_AND;
	}

	@Override
	public String stringOperator(){
		return "TeAND";
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
		FoLtlFormula left = this.getLeftFormula();
		FoLtlFormula right = this.getRightFormula();
		return new LTLfTempAndFormula(left.toLTLf(foltlTOltlf, ltlfTOfoltl), right.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTempAndFormula other = (FoLtlTempAndFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
