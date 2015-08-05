package formula.fol;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolEqualityFormula extends FolAtomicFormula {

	private FolTerm left;
	private FolTerm right;

	public FolEqualityFormula(FolTerm left, FolTerm right){
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString(){
		return this.left.toString() + " = " + this.right.toString();
	}

}
