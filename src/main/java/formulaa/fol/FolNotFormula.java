package formulaa.fol;

import formulaa.FormulaType;
import formulaa.NotFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolNotFormula extends FolUnaryFormula implements NotFormula, FolBooleanOpFormula {

	public FolNotFormula(FolFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_NOT;
	}

}