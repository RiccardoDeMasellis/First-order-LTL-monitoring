package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface ImplFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "->";
	}

	@Override
	default BoolOpType getOpType(){
		return BoolOpType.IMPL;
	}

	@Override
	default Formula nnf(){
		Formula left = this.getLeftFormula().negate().nnf();
		Formula right = this.getRightFormula().nnf();
		return boolFormulaFactory(BoolOpType.OR, left, right);
	}

	@Override
	default Formula negate(){
		return this.nnf().negate();
	}

}
