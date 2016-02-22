package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface ExistsQuantifiedFormula extends QuantifiedFormula {

	@Override
	default String stringOperator() {
		return "Exists";
	}

	@Override
	default OperatorType getQuantifierType(){
		return OperatorType.EXISTS;
	}

	@Override
	default Formula nnf(){
		Formula nested = this.getNestedFormula().nnf();
		Variable qvar = this.getQuantifiedVariable();
		return this.quantifiedFormulaFactory(this.getQuantifierType(), nested, qvar);
	}

	@Override
	default Formula negate(){
		Formula nested = this.getNestedFormula().negate();
		Variable qvar = this.getQuantifiedVariable();
		return this.quantifiedFormulaFactory(OperatorType.FORALL, nested, qvar);
	}

}
