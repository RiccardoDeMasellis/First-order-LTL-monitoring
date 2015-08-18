package formula.foltl;

import formula.FalseAtom;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalFalseAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_FALSE_ATOM;
	}

}
