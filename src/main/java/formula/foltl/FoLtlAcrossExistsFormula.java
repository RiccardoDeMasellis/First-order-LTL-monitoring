package formula.foltl;

import formula.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlAcrossExistsFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlAcrossExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.ACROSS_EXISTS;
	}

	@Override
	public String stringOperator(){
		return "xsExists";
	}

}
