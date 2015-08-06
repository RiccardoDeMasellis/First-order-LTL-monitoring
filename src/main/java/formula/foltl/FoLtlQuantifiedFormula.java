package formula.foltl;

import formula.QuantifiedFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlQuantifiedFormula implements FoLtlFormula, QuantifiedFormula {

	private FoLtlFormula nestedFormula;
	private FolVariable quantifiedVariable;

	public FoLtlQuantifiedFormula(FoLtlFormula nestedFormula, FolVariable quantifiedVariable){
		this.nestedFormula = nestedFormula;
		this.quantifiedVariable = quantifiedVariable;
	}

	public FoLtlFormula getNestedFormula(){
		return this.nestedFormula;
	}

	public FolVariable getQuantifiedVariable(){
		return this.quantifiedVariable;
	}

	public String toString() {
		return this.stringOperator() + " " + this.getQuantifiedVariable() + ": (" + this.getNestedFormula() + ")";
	}

}
