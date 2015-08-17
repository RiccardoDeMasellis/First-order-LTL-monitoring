package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalFalseAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula {

	public String toString(){
		return "FALSE";
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_FALSE_ATOM;
	}

}
