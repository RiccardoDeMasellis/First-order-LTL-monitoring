package formulaa.foltl;

import formulaa.LocalQuantifiedFormula;
import formulaa.OperatorType;
import formulaa.Variable;

/**
 * Interface that represents the generic FO-LTL local quantified formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public interface FoLtlLocalQuantifiedFormula extends FoLtlLocalFormula, LocalQuantifiedFormula {

	@Override
	default String getAtomicName(){
		FoLtlVariable v = (FoLtlVariable) this.getQuantifiedVariable();
		FoLtlLocalFormula nf = (FoLtlLocalFormula) this.getNestedFormula();
		return this.stringOperator() + "_" + v.toString() + '_' + nf.getAtomicName();
	}

	/**
	 * Used to get new Instances of Local Quantified Formulas given their parameters
	 * @param quantifier the type of quantifier
	 * @param nestedFormula the quantified formula
	 * @param qvar the quantified variable
	 * @return the desired Instance
	 */
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
