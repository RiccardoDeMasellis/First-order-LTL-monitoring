package formula.fol;

import formula.OrFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolOrFormula extends FolBinaryFormula implements OrFormula, FolBooleanOpFormula {

	public FolOrFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

}
