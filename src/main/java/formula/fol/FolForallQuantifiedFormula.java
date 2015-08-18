package formula.fol;

import formula.ForallQuantifiedFormula;
import formula.FormulaType;
import formula.Variable;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolForallQuantifiedFormula extends FolQuantifiedFormula implements ForallQuantifiedFormula {

	public FolForallQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_EXISTS;
	}

}
