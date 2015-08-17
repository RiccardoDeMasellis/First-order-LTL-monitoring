package formula.foltl;

import formula.ForallQuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlAcrossForallFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ForallQuantifiedFormula {

	public FoLtlAcrossForallFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.ACROSS_FORALL;
	}

	@Override
	public String stringOperator(){
		return "xsForall";
	}

}
