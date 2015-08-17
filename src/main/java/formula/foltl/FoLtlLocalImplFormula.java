package formula.foltl;

import formula.ImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalImplFormula extends FoLtlBinaryFormula implements ImplFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_IMPLICATION;
	}

}
