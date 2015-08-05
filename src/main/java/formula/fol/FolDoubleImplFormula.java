package formula.fol;

import formula.DoubleImplFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolDoubleImplFormula extends FolBinaryFormula implements DoubleImplFormula, FolBooleanOpFormula {

	public FolDoubleImplFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

}
