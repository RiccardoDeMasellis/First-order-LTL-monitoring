package formulaa.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempAndFormula extends FoLtlBinaryFormula implements formulaa.AndFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_AND;
	}

	@Override
	public String stringOperator(){
		return "TeAND";
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTempAndFormula other = (FoLtlTempAndFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
