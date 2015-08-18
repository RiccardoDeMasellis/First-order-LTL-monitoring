package formula.foltl;

import formula.FormulaType;
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
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_FORALL;
	}

}
