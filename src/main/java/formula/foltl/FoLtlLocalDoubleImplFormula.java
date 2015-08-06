package formula.foltl;

import formula.DoubleImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalDoubleImplFormula extends FoLtlBinaryFormula implements DoubleImplFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalDoubleImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

}
