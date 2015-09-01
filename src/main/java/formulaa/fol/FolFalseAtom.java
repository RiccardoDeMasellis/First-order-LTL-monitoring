package formulaa.fol;

import formulaa.FalseAtom;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolFalseAtom extends FolAtomicFormula implements FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.FOL_FALSE_ATOM;
	}

	@Override
	public FolFormula negate(){
		return new FolTrueAtom();
	}

}
