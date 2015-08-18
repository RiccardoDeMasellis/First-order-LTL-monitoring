package formula.fol;


import formula.ExistsQuantifiedFormula;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolExistsQuantifiedFormula extends FolQuantifiedFormula implements ExistsQuantifiedFormula {

	public FolExistsQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_FORALL;
	}

}
