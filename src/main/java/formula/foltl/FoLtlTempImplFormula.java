package formula.foltl;

import formula.ImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempImplFormula extends FoLtlBinaryFormula implements ImplFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.TEMP_IMPLICATION;
	}

	@Override
	public String stringOperator(){
		return "Te->";
	}

}
