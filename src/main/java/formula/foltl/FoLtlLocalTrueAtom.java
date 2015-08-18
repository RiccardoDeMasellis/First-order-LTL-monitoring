package formula.foltl;

import formula.TrueAtom;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalTrueAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, TrueAtom {

	@Override
	public String toString(){
		return "TRUE";
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_TRUE_ATOM;
	}

}
