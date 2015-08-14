package formula.foltl;

import formula.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalExistsFormula extends FoLtlQuantifiedFormula implements FoLtlLocalQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlLocalExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

}
