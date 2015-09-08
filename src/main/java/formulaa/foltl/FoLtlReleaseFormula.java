package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfReleaseFormula;

import java.util.HashMap;

/**
 * Class that represents a FO-LTL release formula.
 * <p></p>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlReleaseFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlReleaseFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.RELEASE;
	}

	@Override
	public String stringOperator() {
		return "R";
	}

	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula left = (FoLtlFormula) getLeftFormula().nnf();
		FoLtlFormula right = (FoLtlFormula) getRightFormula().nnf();
		return new FoLtlReleaseFormula(left, right);
	}

	@Override
	public FoLtlFormula negate(){
		FoLtlFormula left = (FoLtlFormula) getLeftFormula().negate();
		FoLtlFormula right = (FoLtlFormula) getRightFormula().negate();
		return new FoLtlUntilFormula(left, right);
	}

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula left = this.getLeftFormula();
		FoLtlFormula right = this.getRightFormula();
		return new LTLfReleaseFormula(left.toLTLf(foltlTOltlf, ltlfTOfoltl), right.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
