package language.fol;

import language.FalseAtom;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolFalseAtom extends FolAtomicFormula implements FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.FOL_FALSE_ATOM;
	}

	@Override
	public FolFormula negate(){
		return new FolTrueAtom();
	}

}
