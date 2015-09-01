package formulaa.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempNotFormula extends FoLtlUnaryFormula implements formulaa.NotFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_NOT;
	}

	@Override
	public String stringOperator(){
		return "TeNOT";
	}

}
