package formula.fol;

import formula.AndFormula;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolAndFormula extends FolBinaryFormula implements AndFormula, FolBooleanOpFormula {

	public FolAndFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_AND;
	}

}
