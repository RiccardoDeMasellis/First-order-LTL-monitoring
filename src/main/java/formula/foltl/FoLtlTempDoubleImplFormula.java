package formula.foltl;

import formula.DoubleImplFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempDoubleImplFormula extends FoLtlBinaryFormula implements DoubleImplFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempDoubleImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.TEMP_DOUBLE_IMPL;
	}

	@Override
	public String stringOperator(){
		return "Te<->";
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTempDoubleImplFormula other = (FoLtlTempDoubleImplFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}

}
