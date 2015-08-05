package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface UnaryFormula extends Formula {

	Formula getNestedFormula();

	String stringOperator();

}
