package formula;

/**
 * Created by Simone Calciolari on 18/08/15.
 */
public interface EqualityFormula extends AtomicFormula {

	Term getLeftTerm();

	Term getRightTerm();

}
