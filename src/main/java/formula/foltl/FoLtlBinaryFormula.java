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

	@Override
	public String toString() {
		return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlBinaryFormula other = (FoLtlBinaryFormula) o;
			res = this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula());
		}

		return res;
	}

}
