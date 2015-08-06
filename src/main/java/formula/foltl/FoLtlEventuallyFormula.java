package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlEventuallyFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlEventuallyFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public String stringOperator() {
		return "F";
	}

}
