package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface AndFormula extends BinaryFormula, BooleanOpFormula {

	default String stringOperator() {
		return "AND";
	}

	@Override
	default OperatorType getOpType(){
		return OperatorType.AND;
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
		return this.boolFormulaFactory(OperatorType.OR, left, right);
	}

}
