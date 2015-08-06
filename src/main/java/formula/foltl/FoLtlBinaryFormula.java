package formula.foltl;

import formula.BinaryFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlBinaryFormula implements FoLtlFormula, BinaryFormula {

	private FoLtlFormula left;
	private FoLtlFormula right;

	public FoLtlBinaryFormula(FoLtlFormula left, FoLtlFormula right){
		this.left = left;
		this.right = right;
	}

	public FoLtlFormula getLeftFormula() {
		return left;
	}

	public FoLtlFormula getRightFormula() {
		return right;
	}

	public String toString() {
		return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
	}

}
