package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalEqualityFormula extends FoLtlAtomicFormula implements FoLtlLocalFormula {

	private FoLtlTerm left;
	private FoLtlTerm right;

	public FoLtlLocalEqualityFormula(FoLtlTerm left, FoLtlTerm right){
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString(){
		return this.left.toString() + " = " + this.right.toString();
	}

}
