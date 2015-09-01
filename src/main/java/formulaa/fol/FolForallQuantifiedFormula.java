package formulaa.fol;

import formulaa.ForallQuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolForallQuantifiedFormula extends FolQuantifiedFormula implements ForallQuantifiedFormula {

	public FolForallQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.FOL_EXISTS;
	}

}
