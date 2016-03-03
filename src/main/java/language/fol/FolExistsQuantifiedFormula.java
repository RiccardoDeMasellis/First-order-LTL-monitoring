package language.fol;


import language.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolExistsQuantifiedFormula extends FolQuantifiedFormula implements ExistsQuantifiedFormula {

	public FolExistsQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.FOL_FORALL;
	}

}
