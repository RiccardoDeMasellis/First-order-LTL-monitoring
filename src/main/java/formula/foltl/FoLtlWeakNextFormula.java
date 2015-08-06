package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlWeakNextFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlWeakNextFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public String stringOperator() {
		return "WX";
	}

}
