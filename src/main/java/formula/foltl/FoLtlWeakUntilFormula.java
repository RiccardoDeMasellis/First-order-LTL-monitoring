package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlWeakUntilFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlWeakUntilFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.WEAK_UNTIL;
	}

	@Override
	public String stringOperator() {
		return "WU";
	}

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

	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
	}

}
