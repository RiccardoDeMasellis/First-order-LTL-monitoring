package formulaa;

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
	default formulaa.Formula nnf(){
		formulaa.Formula res;
		formulaa.Formula nested = this.getNestedFormula();

		if (nested instanceof AtomicFormula){
			res = this.clone();
		} else {
			res = nested.negate().nnf();
		}

		return res;
	}

	@Override
	default formulaa.Formula negate(){
		return this.getNestedFormula().clone();
	}

}
