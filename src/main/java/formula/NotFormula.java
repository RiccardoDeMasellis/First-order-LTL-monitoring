package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface NotFormula extends UnaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "NOT";
	}

	@Override
	default BoolOpType getOpType(){
		return BoolOpType.OR;
	}

	@Override
	default Formula nnf(){
		Formula res;
		Formula nested = this.getNestedFormula();

		if (nested instanceof AtomicFormula){
			res = this.clone();
		} else {
			res = nested.negate().nnf();
		}

		return res;
	}

	@Override
	default Formula negate(){
		return this.getNestedFormula().clone();
	}

}
