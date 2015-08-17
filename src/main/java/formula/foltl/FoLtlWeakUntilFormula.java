package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlWeakUntilFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlWeakUntilFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.WEAK_UNTIL;
	}

	@Override
	public String stringOperator() {
		return "WU";
	}

}
