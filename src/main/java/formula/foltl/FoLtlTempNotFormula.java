package formula.foltl;

import formula.FormulaType;
import formula.NotFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.TEMP_NOT;
	}

	@Override
	public String stringOperator(){
		return "TeNOT";
	}

}
