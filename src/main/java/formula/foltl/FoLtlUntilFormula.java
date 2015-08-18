package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlUntilFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlUntilFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.UNTIL;
	}

	@Override
	public String stringOperator() {
		return "U";
	}

	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula left = (FoLtlFormula) getLeftFormula().nnf();
		FoLtlFormula right = (FoLtlFormula) getRightFormula().nnf();
		return new FoLtlUntilFormula(left, right);
	}

	@Override
	public FoLtlFormula negate(){
		FoLtlFormula left = (FoLtlFormula) getLeftFormula().negate();
		FoLtlFormula right = (FoLtlFormula) getRightFormula().negate();
		return new FoLtlReleaseFormula(left, right);
	}

}
