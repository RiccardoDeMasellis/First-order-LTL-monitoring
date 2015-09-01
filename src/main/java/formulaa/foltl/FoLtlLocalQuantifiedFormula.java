package formulaa.foltl;

import formulaa.LocalQuantifiedFormula;
import formulaa.OperatorType;
import formulaa.Variable;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public interface FoLtlLocalQuantifiedFormula extends FoLtlLocalFormula, LocalQuantifiedFormula {

	@Override
	default FoLtlFormula quantifiedFormulaFactory(OperatorType quantifier, formulaa.Formula nestedFormula, Variable qvar){
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
