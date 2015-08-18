package formula.fol;

import formula.EqualityFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolEqualityFormula extends FolAtomicFormula implements EqualityFormula {

	private FolTerm left;
	private FolTerm right;

	public FolEqualityFormula(FolTerm left, FolTerm right){
		this.left = left;
		this.right = right;
	}

	public FolTerm getLeftTerm(){
		return left;
	}

	public FolTerm getRightTerm(){
		return right;
	}

	@Override
	public String toString(){
		return this.getLeftTerm().toString() + " = " + this.getRightTerm().toString();
	}

}
