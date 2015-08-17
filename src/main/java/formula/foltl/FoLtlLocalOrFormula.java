package formula.foltl;

import formula.OrFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalOrFormula extends FoLtlBinaryFormula implements OrFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalOrFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.LOCAL_OR;
	}

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

}
