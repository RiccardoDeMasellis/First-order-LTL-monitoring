package formula.fol;


import formula.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolExistsQuantifiedFormula extends FolQuantifiedFormula implements ExistsQuantifiedFormula {

	public FolExistsQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable) {
		super(nestedFormula, quantifiedVariable);
	}

}
