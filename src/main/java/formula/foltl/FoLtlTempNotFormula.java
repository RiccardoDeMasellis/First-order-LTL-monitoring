package formula.foltl;

import formula.NotFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

}
