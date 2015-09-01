package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface BinaryFormula extends Formula {

	Formula getLeftFormula();

	Formula getRightFormula();

	String stringOperator();

}
