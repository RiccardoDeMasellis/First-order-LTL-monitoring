package formula.foltl;

import formula.OrFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempOrFormula extends FoLtlBinaryFormula implements OrFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempOrFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.TEMP_OR;
	}

	@Override
	public String stringOperator(){
		return "TeOR";
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTempOrFormula other = (FoLtlTempOrFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
