package formulaa.foltl;

import formulaa.EqualityFormula;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalEqualityFormula extends FoLtlAtomicFormula implements FoLtlLocalFormula, EqualityFormula {

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
	public void assignSort(FoLtlVariable variable, FoLtlSort sort){
		FoLtlTerm left = this.getLeftTerm();
		FoLtlTerm right = this.getRightTerm();

		if (left.equals(variable)){
			((FoLtlVariable) left).setSort(sort);
		}

		if (right.equals(variable)){
			((FoLtlVariable) right).setSort(sort);
		}
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
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_EQUALITY;
	}

	@Override
	public FoLtlFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getLeftTerm().clone(), this.getRightTerm().clone(), null, null);
	}

	@Override
	public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlTerm left = this.getLeftTerm();
		FoLtlTerm right = this.getRightTerm();

		if (left instanceof FoLtlVariable){
			FoLtlConstant c = assignment.get(left);
			if (c != null){
				left = c;
			}
		}

		if (right instanceof FoLtlVariable){
			FoLtlConstant c = assignment.get(right);
			if (c != null){
				right = c;
			}
		}

		return new FoLtlLocalEqualityFormula(left, right);
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalEqualityFormula sub = (FoLtlLocalEqualityFormula) this.substitute(domain, assignment);
		FoLtlTerm left = sub.getLeftTerm();
		FoLtlTerm right = sub.getRightTerm();

		LTLfLocalFormula res;

		if (left instanceof FoLtlVariable || right instanceof FoLtlVariable){
			throw new RuntimeException("Found open variable");
		} else {
			if (left.equals(right)){
				res = new LTLfLocalTrueFormula();
			} else {
				res = new LTLfLocalFalseFormula();
			}
		}

		return res;
	}

}
