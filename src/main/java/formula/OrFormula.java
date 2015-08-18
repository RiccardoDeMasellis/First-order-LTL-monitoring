package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface OrFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "OR";
	}

	@Override
	default BoolOpType getOpType(){
		return BoolOpType.OR;
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
		return boolFormulaFactory(BoolOpType.AND, left, right);
	}

}
