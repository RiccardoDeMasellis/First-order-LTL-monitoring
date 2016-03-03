package language;

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
	default language.Formula nnf(){
		language.Formula left = this.getLeftFormula().nnf();
		language.Formula right = this.getRightFormula().nnf();
		return this.boolFormulaFactory(this.getOpType(), left, right);
	}

	@Override
	default language.Formula negate(){
		language.Formula left = this.getLeftFormula().negate();
		language.Formula right = this.getRightFormula().negate();
		return this.boolFormulaFactory(OperatorType.OR, left, right);
	}

}
