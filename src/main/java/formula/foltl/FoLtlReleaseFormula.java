package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlReleaseFormula extends FoLtlBinaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlReleaseFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public String stringOperator() {
		return "R";
	}

}
