package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempAndFormula;
import formula.ltlf.LTLfWeakUntilFormula;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlWeakUntilFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlWeakUntilFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.WEAK_UNTIL;
	}

	@Override
	public String stringOperator() {
		return "WU";
	}

	/**
	 * Returns a representation of this formula's negation normal form
	 * @return
	 */
	//phi WU psi == psi R (phi OR psi)
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula left = this.getLeftFormula().clone();
		FoLtlFormula right = this.getRightFormula().clone();
		FoLtlFormula or;

		if (left instanceof FoLtlLocalFormula && right instanceof FoLtlLocalFormula){
			or = new FoLtlLocalOrFormula(left, right);
		} else {
			or = new FoLtlTempOrFormula(left, right);
		}

		return new FoLtlReleaseFormula(right, or).nnf();
	}

	/**
	 * returns the negation of this formula
	 * @return
	 */
	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
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
		return new LTLfWeakUntilFormula(left.toLTLf(foltlTOltlf, ltlfTOfoltl), right.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
