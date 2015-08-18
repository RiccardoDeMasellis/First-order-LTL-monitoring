package formula.foltl;

import formula.FormulaType;
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
	public FormulaType getFormulaType(){
		return FormulaType.ACROSS_FORALL;
	}

	@Override
	public String stringOperator(){
		return "xsForall";
	}

}
