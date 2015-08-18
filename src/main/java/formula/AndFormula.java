package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface AndFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "AND";
	}

	@Override
	default BoolOpType getOpType(){
		return BoolOpType.AND;
	}

	@Override
	default Formula nnf(){
		Formula left = this.getLeftFormula().nnf();
		Formula right = this.getRightFormula().nnf();
		return boolFormulaFactory(this.getOpType(), left, right);
	}

	@Override
	default Formula negate(){
		Formula left = this.getLeftFormula().negate();
		Formula right = this.getRightFormula().negate();
		return boolFormulaFactory(BoolOpType.OR, left, right);
	}

}
