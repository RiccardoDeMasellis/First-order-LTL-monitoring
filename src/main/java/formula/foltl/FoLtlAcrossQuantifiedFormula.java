package formula.foltl;

import formula.AcrossQuantifiedFormula;
import formula.Formula;
import formula.OperatorType;
import formula.Variable;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public interface FoLtlAcrossQuantifiedFormula extends FoLtlTemporalFormula, AcrossQuantifiedFormula {

	@Override
	default FoLtlFormula quantifiedFormulaFactory(OperatorType quantifier, Formula nestedFormula, Variable qvar){
		FoLtlFormula res;

		switch (quantifier){

			case FORALL:
				res = new FoLtlAcrossForallFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			case EXISTS:
				res = new FoLtlAcrossExistsFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			default:
				throw new RuntimeException("Unknown quantifier");

		}

		return res;
	}

}
