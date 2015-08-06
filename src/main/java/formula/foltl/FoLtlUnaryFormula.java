package formula.foltl;

import formula.UnaryFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlUnaryFormula implements FoLtlFormula, UnaryFormula {

	private FoLtlFormula nestedFormula;

	public FoLtlUnaryFormula(FoLtlFormula nestedFormula){
		this.nestedFormula = nestedFormula;
	}

	@Override
	public FoLtlFormula getNestedFormula(){
		return this.nestedFormula;
	}

	@Override
	public String toString() {
		return this.stringOperator() + "(" + getNestedFormula() + ")";
	}

}
