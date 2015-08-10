package formula.foltl;

import formula.AndFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempAndFormula extends FoLtlBinaryFormula implements AndFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public String stringOperator(){
		return "tAND";
	}

}
