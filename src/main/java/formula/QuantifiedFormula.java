package formula;


/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface QuantifiedFormula extends Formula {

	Formula getNestedFormula();

	Variable getQuantifiedVariable();

	String stringOperator();

}
