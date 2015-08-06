package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface OrFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "OR";
	}

}
