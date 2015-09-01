package formulaa.fol;

import formulaa.EqualityFormula;
import formulaa.FormulaType;

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

	@Override
	public int hashCode(){
		int res;
		res = this.getLeftTerm() != null ? this.getLeftTerm().hashCode() : 0;
		res = res * 31;
		res = res + (this.getRightTerm() != null ? this.getRightTerm().hashCode() : 0);
		return res;
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolEqualityFormula other = (FolEqualityFormula) o;
			res = this.getLeftTerm().equals(other.getLeftTerm())
					&& this.getRightTerm().equals(other.getRightTerm());
		}

		return res;
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.FOL_EQUALITY;
	}

	@Override
	public FolFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getLeftTerm().clone(), this.getRightTerm().clone(), null, null);
	}


}
