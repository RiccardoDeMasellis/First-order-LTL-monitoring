package formula.foltl;

import formula.DoubleImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalDoubleImplFormula extends FoLtlBinaryFormula implements DoubleImplFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalDoubleImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_DOUBLE_IMPL;
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
