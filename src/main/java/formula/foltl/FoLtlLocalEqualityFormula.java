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

	public FoLtlTerm getLeftTerm(){
		return left;
	}

	public FoLtlTerm getRightTerm(){
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
			FoLtlLocalEqualityFormula other = (FoLtlLocalEqualityFormula) o;
			res = this.getLeftTerm().equals(other.getLeftTerm())
					&& this.getRightTerm().equals(other.getRightTerm());
		}

		return res;
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_EQUALITY;
	}

	@Override
	public FoLtlFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getLeftTerm().clone(), this.getRightTerm().clone(), null, null);
	}
}
