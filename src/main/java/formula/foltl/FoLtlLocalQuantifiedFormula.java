package formula.foltl;

import formula.Formula;
import formula.LocalQuantifiedFormula;
import formula.OperatorType;
import formula.Variable;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public interface FoLtlLocalQuantifiedFormula extends FoLtlLocalFormula, LocalQuantifiedFormula {

	@Override
	default FoLtlFormula quantifiedFormulaFactory(OperatorType quantifier, Formula nestedFormula, Variable qvar){
		FoLtlFormula res;

		switch (quantifier){

			case FORALL:
				res = new FoLtlLocalForallFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			case EXISTS:
				res = new FoLtlLocalExistsFormula((FoLtlFormula) nestedFormula, (FoLtlVariable) qvar);
				break;

			default:
				throw new RuntimeException("Unknown quantifier");

		}

		return res;
	}

}
