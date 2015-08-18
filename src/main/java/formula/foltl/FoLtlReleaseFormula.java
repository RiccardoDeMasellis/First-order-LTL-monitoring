package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlReleaseFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlReleaseFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.RELEASE;
	}

	@Override
	public String stringOperator() {
		return "R";
	}

}
