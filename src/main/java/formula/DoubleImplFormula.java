package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface DoubleImplFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "<->";
	}

	@Override
	default BoolOpType getOpType(){
		return BoolOpType.DIMPL;
	}

	@Override
	default Formula nnf(){
		Formula left = this.getLeftFormula().clone();
		Formula right = this.getRightFormula().clone();
		Formula impl1 = boolFormulaFactory(BoolOpType.IMPL, left, right);
		Formula impl2 = boolFormulaFactory(BoolOpType.IMPL, right, left);
		return boolFormulaFactory(BoolOpType.AND, impl1.nnf(), impl2.nnf());
	}

	@Override
	default Formula negate(){
		return this.nnf().negate();
	}

}
