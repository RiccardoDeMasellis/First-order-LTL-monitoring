package formulaa.foltl;

import formulaa.AndFormula;
import formulaa.FormulaType;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalFormula;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalAndFormula extends FoLtlBinaryFormula implements AndFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_AND;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalAndFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlLocalAndFormula other = (FoLtlLocalAndFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/
}
