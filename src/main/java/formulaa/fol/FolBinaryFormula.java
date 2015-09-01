package formulaa.fol;

import formulaa.BinaryFormula;
import formulaa.FormulaType;

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

	@Override
	public String toString() {
		return "(" + this.getLeftFormula() + ") " + this.stringOperator() + " (" + this.getRightFormula() + ")";
	}

	@Override
	public int hashCode(){
		int res;
		res = this.getLeftFormula() != null ? this.getLeftFormula().hashCode() : 0;
		res = res * 31;
		res = res + (this.getRightFormula() != null ? this.getRightFormula().hashCode() : 0);
		return res;
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolBinaryFormula other = (FolBinaryFormula) o;
			res = this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula());
		}

		return res;
	}

	@Override
	public FolFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getLeftFormula().clone(), this.getRightFormula().clone());
	}

	public FolFormula formulaFactory(FormulaType type, FolFormula left, FolFormula right){
		FolFormula res;

		switch(type){

			case FOL_DOUBLE_IMPL:
				res = new FolDoubleImplFormula(left, right);
				break;

			case FOL_IMPLICATION:
				res = new FolImplFormula(left, right);
				break;

			case FOL_OR:
				res = new FolOrFormula(left, right);
				break;

			case FOL_AND:
				res = new FolAndFormula(left, right);
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;
	}

}
