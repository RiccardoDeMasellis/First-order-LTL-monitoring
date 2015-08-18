package formula.fol;

import formula.FalseAtom;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolFalseAtom extends FolAtomicFormula implements FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

}
