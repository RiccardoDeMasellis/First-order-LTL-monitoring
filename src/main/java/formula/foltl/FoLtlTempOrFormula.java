package formula.foltl;

import formula.OrFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempOrFormula extends FoLtlBinaryFormula implements OrFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempOrFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public String stringOperator(){
		return "tOR";
	}

}
