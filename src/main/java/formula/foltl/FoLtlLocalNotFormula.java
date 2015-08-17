package formula.foltl;

import formula.NotFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpLocalFormula{

	public FoLtlLocalNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_NOT;
	}

}
