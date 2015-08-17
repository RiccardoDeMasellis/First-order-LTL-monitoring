package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempLastAtom extends FoLtlAtomicFormula {

	public String toString(){
		return "LAST";
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.TEMP_LAST_ATOM;
	}

}
