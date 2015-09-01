package formulaa.fol;

import formulaa.FormulaType;
import formulaa.OrFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolOrFormula extends FolBinaryFormula implements OrFormula, FolBooleanOpFormula {

	public FolOrFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_OR;
	}

}
