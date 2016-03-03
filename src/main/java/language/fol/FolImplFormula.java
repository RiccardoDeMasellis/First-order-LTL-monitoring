package language.fol;

import language.FormulaType;
import language.ImplFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolImplFormula extends FolBinaryFormula implements ImplFormula, FolBooleanOpFormula {

	public FolImplFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_IMPLICATION;
	}

}
