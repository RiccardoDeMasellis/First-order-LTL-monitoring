package formula.foltl;

import formula.ForallQuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalForallFormula extends FoLtlQuantifiedFormula implements FoLtlLocalQuantifiedFormula,
		ForallQuantifiedFormula {

	public FoLtlLocalForallFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_FORALL;
	}

}
