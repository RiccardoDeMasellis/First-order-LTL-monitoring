package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface ImplFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "IMPL";
	}

	@Override
	default OperatorType getOpType(){
		return OperatorType.IMPL;
	}

	@Override
	default Formula nnf(){
		Formula left = this.getLeftFormula().negate().nnf();
		Formula right = this.getRightFormula().nnf();
		return this.boolFormulaFactory(OperatorType.OR, left, right);
	}

	@Override
	default Formula negate(){
		return this.nnf().negate();
	}

}
