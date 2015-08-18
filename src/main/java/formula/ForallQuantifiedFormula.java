package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface ForallQuantifiedFormula extends QuantifiedFormula {

	default String stringOperator() {
		return "Forall";
	}

	@Override
	default OperatorType getQuantifierType(){
		return OperatorType.FORALL;
	}

	@Override
	default Formula nnf(){
		Formula nested = this.getNestedFormula().nnf();
		Variable qvar = (Variable) this.getQuantifiedVariable().clone();
		return this.quantifiedFormulaFactory(this.getQuantifierType(), nested, qvar);
	}

	@Override
	default Formula negate(){
		Formula nested = this.getNestedFormula().negate();
		Variable qvar = (Variable) this.getQuantifiedVariable().clone();
		return this.quantifiedFormulaFactory(OperatorType.EXISTS, nested, qvar);
	}

}
