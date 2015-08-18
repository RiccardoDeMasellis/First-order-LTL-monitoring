package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempLastAtom extends FoLtlAtomicFormula {

	public String toString(){
		return "LAST";
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.TEMP_LAST_ATOM;
	}

}
