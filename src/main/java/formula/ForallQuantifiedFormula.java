package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface ForallQuantifiedFormula extends QuantifiedFormula {

	default String stringOperator() {
		return "Exists";
	}

}
