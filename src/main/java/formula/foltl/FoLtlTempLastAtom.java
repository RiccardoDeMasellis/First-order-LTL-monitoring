package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempLastAtom extends FoLtlAtomicFormula implements FoLtlTemporalFormula {

	public String toString(){
		return "LAST";
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.TEMP_LAST_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlTempNotFormula(this.clone());
	}

}
