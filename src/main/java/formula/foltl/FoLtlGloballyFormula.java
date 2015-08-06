package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlGloballyFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlGloballyFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public String stringOperator() {
		return "G";
	}

}
