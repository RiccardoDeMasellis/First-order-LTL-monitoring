package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface EqualityFormula extends BinaryFormula {

	default String stringOperator() {
		return "=";
	}

}
