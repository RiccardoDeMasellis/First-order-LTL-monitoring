package formula.fol;

import formula.UnaryFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolUnaryFormula implements FolFormula, UnaryFormula {

	private FolFormula nestedFormula;

	public FolUnaryFormula(FolFormula nestedFormula){
		this.nestedFormula = nestedFormula;
	}

	@Override
	public FolFormula getNestedFormula(){
		return this.nestedFormula;
	}

	@Override
	public String toString() {
		return this.stringOperator() + "(" + getNestedFormula() + ")";
	}

}
