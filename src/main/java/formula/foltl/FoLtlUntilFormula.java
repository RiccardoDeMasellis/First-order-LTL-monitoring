package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlUntilFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlUntilFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.UNTIL;
	}

	@Override
	public String stringOperator() {
		return "U";
	}

}
