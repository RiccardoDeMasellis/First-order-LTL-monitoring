package formula.fol;

import formula.FormulaType;
import formula.TrueAtom;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolTrueAtom extends FolAtomicFormula implements TrueAtom {

	@Override
	public String toString(){
		return "TRUE";
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_TRUE_ATOM;
	}

}
