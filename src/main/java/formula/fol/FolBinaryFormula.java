package formula.fol;

import formula.BinaryFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolBinaryFormula implements FolFormula, BinaryFormula {

	private FolFormula left;
	private FolFormula right;

	public FolBinaryFormula(FolFormula left, FolFormula right){
		this.left = left;
		this.right = right;
	}

	public FolFormula getLeftFormula() {
		return left;
	}

	public FolFormula getRightFormula() {
		return right;
	}

	public String toString() {
		return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
	}

}
