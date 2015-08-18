package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlNextFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlNextFormula(FoLtlFormula nestedFormula){
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.NEXT;
	}

	@Override
	public String stringOperator(){
		return "X";
	}

}
