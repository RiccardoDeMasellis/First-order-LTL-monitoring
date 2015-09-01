package formulaa.fol;


import formulaa.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolExistsQuantifiedFormula extends FolQuantifiedFormula implements ExistsQuantifiedFormula {

	public FolExistsQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.FOL_FORALL;
	}

}
