package formula.fol;

import formula.QuantifiedFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolQuantifiedFormula implements FolFormula, QuantifiedFormula{

	private FolFormula nestedFormula;
	private FolVariable quantifiedVariable;

	public FolQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable){
		this.nestedFormula = nestedFormula;
		this.quantifiedVariable = quantifiedVariable;
	}

	public FolFormula getNestedFormula(){
		return this.nestedFormula;
	}

	public FolVariable getQuantifiedVariable(){
		return this.quantifiedVariable;
	}

	public String toString() {
		return this.stringOperator() + " " + this.getQuantifiedVariable() + ": (" + this.getNestedFormula() + ")";
	}

}
