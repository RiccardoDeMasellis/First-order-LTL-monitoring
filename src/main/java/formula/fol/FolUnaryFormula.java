package formula.fol;

import formula.FormulaType;
import formula.UnaryFormula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolUnaryFormula implements FolFormula, UnaryFormula {

	private FolFormula nestedFormula;

	public FolUnaryFormula(FolFormula nestedFormula){
		this.nestedFormula = nestedFormula;
	}

	@Override
	public FolFormula getNestedFormula(){
		return this.nestedFormula;
	}

	@Override
	public String toString() {
		return this.stringOperator() + "(" + getNestedFormula() + ")";
	}

	@Override
	public int hashCode(){
		return this.getNestedFormula() != null ? this.getNestedFormula().hashCode() : 0;
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolUnaryFormula other = (FolUnaryFormula) o;
			res = this.getNestedFormula().equals(other.getNestedFormula());
		}

		return res;
	}

	@Override
	public FolFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone());
	}

	public FolFormula formulaFactory(FormulaType type, FolFormula nested){

		FolFormula res;

		switch(type){

			case FOL_NOT:
				res = new FolNotFormula(nested);
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

}
