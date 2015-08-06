package formula.foltl;

import formula.AndFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalAndFormula extends FoLtlBinaryFormula implements AndFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

}
