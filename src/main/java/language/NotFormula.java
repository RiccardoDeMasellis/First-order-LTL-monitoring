package language;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface NotFormula extends UnaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "NOT";
	}

	@Override
	default OperatorType getOpType(){
		return OperatorType.NOT;
	}

	@Override
	default language.Formula nnf(){
		language.Formula res;
		language.Formula nested = this.getNestedFormula();

		if (nested instanceof AtomicFormula){
			res = this.clone();
		} else {
			res = nested.negate().nnf();
		}

		return res;
	}

	@Override
	default language.Formula negate(){
		return this.getNestedFormula().clone();
	}

}
