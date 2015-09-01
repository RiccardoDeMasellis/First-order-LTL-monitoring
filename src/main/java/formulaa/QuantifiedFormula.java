package formulaa;


/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface QuantifiedFormula extends Formula {

	Formula getNestedFormula();

	Variable getQuantifiedVariable();

	String stringOperator();

	OperatorType getQuantifierType();

	Formula quantifiedFormulaFactory(OperatorType quantifier, Formula nestedFormula, Variable qvar);

}
