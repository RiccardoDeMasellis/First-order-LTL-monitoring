package formula.foltl;

import formula.NotFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.TEMP_NOT;
	}

	@Override
	public String stringOperator(){
		return "TeNOT";
	}

}
