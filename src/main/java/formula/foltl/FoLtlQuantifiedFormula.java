package formula.foltl;

import formula.QuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlQuantifiedFormula implements FoLtlFormula, QuantifiedFormula {

	private FoLtlFormula nestedFormula;
	private FoLtlVariable quantifiedVariable;

	public FoLtlQuantifiedFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		this.nestedFormula = nestedFormula;
		this.quantifiedVariable = quantifiedVariable;
	}

	public FoLtlFormula getNestedFormula(){
		return this.nestedFormula;
	}

	public FoLtlVariable getQuantifiedVariable(){
		return this.quantifiedVariable;
	}

	public String toString() {
		return this.stringOperator() + " " + this.getQuantifiedVariable() + ": (" + this.getNestedFormula() + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlQuantifiedFormula other = (FoLtlQuantifiedFormula) o;
			res = this.stringOperator().equals(other.stringOperator())
					&& this.getNestedFormula().equals(other.getNestedFormula())
					&& this.getQuantifiedVariable().equals(other.getQuantifiedVariable());
		}

		return res;
	}
}
