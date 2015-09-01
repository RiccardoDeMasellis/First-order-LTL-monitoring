package formulaa;

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
	default formulaa.Formula nnf(){
		formulaa.Formula left = this.getLeftFormula().nnf();
		formulaa.Formula right = this.getRightFormula().nnf();
		return this.boolFormulaFactory(this.getOpType(), left, right);
	}

	@Override
	default formulaa.Formula negate(){
		formulaa.Formula left = this.getLeftFormula().negate();
		formulaa.Formula right = this.getRightFormula().negate();
		return this.boolFormulaFactory(OperatorType.OR, left, right);
	}

}
