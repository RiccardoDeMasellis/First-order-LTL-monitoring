package formula.foltl;

import formula.DoubleImplFormula;
import formula.FormulaType;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalDoubleImplFormula;
import formula.ltlf.LTLfLocalFormula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalDoubleImplFormula extends FoLtlBinaryFormula implements DoubleImplFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalDoubleImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_DOUBLE_IMPL;
	}

	@Override
	public LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalDoubleImplFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlLocalDoubleImplFormula other = (FoLtlLocalDoubleImplFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
