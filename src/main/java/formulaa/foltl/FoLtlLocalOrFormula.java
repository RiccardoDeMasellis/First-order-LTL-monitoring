package formulaa.foltl;

import formulaa.OrFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalOrFormula;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalOrFormula extends FoLtlBinaryFormula implements OrFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalOrFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_OR;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalOrFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlLocalOrFormula other = (FoLtlLocalOrFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
