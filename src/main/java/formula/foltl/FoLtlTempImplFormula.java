package formula.foltl;

import formula.ImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempImplFormula extends FoLtlBinaryFormula implements ImplFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

}
