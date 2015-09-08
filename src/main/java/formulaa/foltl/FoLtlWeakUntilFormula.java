package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempAndFormula;
import formula.ltlf.LTLfWeakUntilFormula;

import java.util.HashMap;

/**
 * Class that represents a FO-LTL weak until formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
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

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula left = this.getLeftFormula();
		FoLtlFormula right = this.getRightFormula();
		return new LTLfWeakUntilFormula(left.toLTLf(foltlTOltlf, ltlfTOfoltl), right.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
