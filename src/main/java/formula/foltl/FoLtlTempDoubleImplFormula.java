package formula.foltl;

import formula.DoubleImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempDoubleImplFormula extends FoLtlBinaryFormula implements DoubleImplFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempDoubleImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

}
