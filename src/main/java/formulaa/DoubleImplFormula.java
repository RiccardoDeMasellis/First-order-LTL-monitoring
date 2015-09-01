package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface DoubleImplFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "<->";
	}

	@Override
	default OperatorType getOpType(){
		return OperatorType.DIMPL;
	}

	@Override
	default Formula nnf(){
		Formula left = this.getLeftFormula().clone();
		Formula right = this.getRightFormula().clone();
		Formula impl1 = this.boolFormulaFactory(OperatorType.IMPL, left, right);
		Formula impl2 = this.boolFormulaFactory(OperatorType.IMPL, right, left);
		return this.boolFormulaFactory(OperatorType.AND, impl1.nnf(), impl2.nnf());
	}

	@Override
	default Formula negate(){
		return this.nnf().negate();
	}

}
