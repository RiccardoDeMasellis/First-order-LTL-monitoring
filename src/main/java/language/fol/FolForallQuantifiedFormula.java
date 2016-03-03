package language.fol;

import language.ForallQuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolForallQuantifiedFormula extends FolQuantifiedFormula implements ForallQuantifiedFormula {

	public FolForallQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.FOL_EXISTS;
	}

}
