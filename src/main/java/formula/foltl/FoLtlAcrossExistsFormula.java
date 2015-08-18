package formula.foltl;

import formula.ExistsQuantifiedFormula;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlAcrossExistsFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlAcrossExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.ACROSS_EXISTS;
	}

	@Override
	public String stringOperator(){
		return "xsExists";
	}

}
