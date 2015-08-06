package formula.foltl;

import formula.AcrossQuantifiedFormula;
import formula.ExistsQuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlAcrossExistsFormula extends FoLtlQuantifiedFormula implements ExistsQuantifiedFormula, AcrossQuantifiedFormula {

	public FoLtlAcrossExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

}
