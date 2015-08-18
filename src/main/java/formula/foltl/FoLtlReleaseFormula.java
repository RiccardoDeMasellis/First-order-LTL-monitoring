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

}
