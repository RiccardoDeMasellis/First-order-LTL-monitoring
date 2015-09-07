package formulaa.foltl;

import formulaa.LocalQuantifiedFormula;
import formulaa.OperatorType;
import formulaa.Variable;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public interface FoLtlLocalQuantifiedFormula extends FoLtlLocalFormula, LocalQuantifiedFormula {

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	@Override
	default String getAtomicName(){
		FoLtlVariable v = (FoLtlVariable) this.getQuantifiedVariable();
		FoLtlLocalFormula nf = (FoLtlLocalFormula) this.getNestedFormula();
		return this.stringOperator().toUpperCase() + "_var_" + v.getName() + nf.getAtomicName();
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
