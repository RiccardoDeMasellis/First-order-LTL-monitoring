package formulaa.fol;

import formulaa.DoubleImplFormula;
import formulaa.FormulaType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolDoubleImplFormula extends FolBinaryFormula implements DoubleImplFormula, FolBooleanOpFormula {

	public FolDoubleImplFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_DOUBLE_IMPL;
	}

}
