package formula.fol;

import formula.EqualityFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolEqualityFormula extends FolBinaryFormula implements EqualityFormula {

	public FolEqualityFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

}
