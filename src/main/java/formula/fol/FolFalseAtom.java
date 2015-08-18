package formula.fol;

import formula.FalseAtom;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolFalseAtom extends FolAtomicFormula implements FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_FALSE_ATOM;
	}

	@Override
	public FolFormula negate(){
		return new FolTrueAtom();
	}

}
