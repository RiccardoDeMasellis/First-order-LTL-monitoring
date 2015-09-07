package formulaa.foltl;

import formulaa.EqualityFormula;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;
import net.sf.tweety.logics.commons.syntax.Constant;
import net.sf.tweety.logics.commons.syntax.Predicate;
import net.sf.tweety.logics.commons.syntax.Variable;
import net.sf.tweety.logics.fol.syntax.FOLAtom;
import net.sf.tweety.logics.fol.syntax.FolFormula;

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

	/**
	 * Given a variable and a sort, assigns the sort to every occurrence of such variable
	 * @param variable the variable
	 * @param sort the sort
	 */
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

	/**
	 * Translates this formula into an equivalent FolFormula using Tweety data structures
	 * @return
	 */
	@Override
	public FolFormula toTweetyFol(){
		FoLtlTerm left = this.getLeftTerm();
		FoLtlTerm right = this.getRightTerm();

		Predicate eq = new Predicate("Eq", 2);
		FOLAtom res = new FOLAtom(eq);

		if (left instanceof FoLtlVariable){
			res.addArgument(new Variable(left.getName().toUpperCase()));
		} else {
			res.addArgument(new Constant(left.getName().toLowerCase()));
		}

		if (right instanceof FoLtlVariable){
			res.addArgument(new Variable(right.getName().toUpperCase()));
		} else {
			res.addArgument(new Constant(right.getName().toLowerCase()));
		}

		return res;
	}

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	@Override
	public String getAtomicName(){
		FoLtlTerm left = this.getLeftTerm();
		FoLtlTerm right = this.getRightTerm();
		String res = "";

		if (left instanceof FoLtlVariable){
			res = res + "var_" + left.getName();
		} else {
			res = res + "con_" + left.getName();
		}

		res = res + "EQ";

		if (right instanceof FoLtlVariable){
			res = res + "var_" + right.getName();
		} else {
			res = res + "con_" + right.getName();
		}

		return res;
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

	/**
	 * Given the domain and an assignment substitutes all the variables in this Formula
	 * according to the assignment
	 * @param domain the domain
	 * @param assignment the assignment
	 * @return a new FoltlFormula where variables are substituted by constants according to the given assignment
	 */
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

	/**
	 * Given the domain and an assignment, tranforms this formula into an equivalent propositional formula
	 * (Built with FLLOAT LTLf structures)
	 * @param domain the domain
	 * @param assignment a given assignment
	 * @return
	 */
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
