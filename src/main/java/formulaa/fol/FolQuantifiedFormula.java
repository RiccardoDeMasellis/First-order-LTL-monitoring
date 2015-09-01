package formulaa.fol;

import formulaa.*;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolQuantifiedFormula implements FolFormula, QuantifiedFormula{

	private FolFormula nestedFormula;
	private FolVariable quantifiedVariable;

	public FolQuantifiedFormula(FolFormula nestedFormula, FolVariable quantifiedVariable){
		this.nestedFormula = nestedFormula;
		this.quantifiedVariable = quantifiedVariable;
	}

	public FolFormula getNestedFormula(){
		return this.nestedFormula;
	}

	public FolVariable getQuantifiedVariable(){
		return this.quantifiedVariable;
	}

	@Override
	public String toString() {
		return this.stringOperator() + " " + this.getQuantifiedVariable() + ": (" + this.getNestedFormula() + ")";
	}

	@Override
	public int hashCode(){
		int res = this.getClass().hashCode();
		res = 31 * res;
		res = res + (this.getNestedFormula() != null ? this.getNestedFormula().hashCode() : 0);
		res = 31 * res;
		res = res + (this.getQuantifiedVariable() != null ? this.getQuantifiedVariable().hashCode() : 0);
		return res;
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolQuantifiedFormula other = (FolQuantifiedFormula) o;
			res = this.stringOperator().equals(other.stringOperator())
					&& this.getNestedFormula().equals(other.getNestedFormula())
					&& this.getQuantifiedVariable().equals(other.getQuantifiedVariable());
		}

		return res;
	}

	@Override
	public FolFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone(),
				(FolVariable) this.getQuantifiedVariable().clone());
	}

	@Override
	public FolFormula quantifiedFormulaFactory(OperatorType quantifier, formulaa.Formula nestedFormula, Variable qvar){
		FolFormula res;

		switch (quantifier){

			case FORALL:
				res = new FolForallQuantifiedFormula((FolFormula) nestedFormula, (FolVariable) qvar);
				break;

			case EXISTS:
				res = new FolExistsQuantifiedFormula((FolFormula) nestedFormula, (FolVariable) qvar);
				break;

			default:
				throw new RuntimeException("Unknown quantifier");

		}

		return res;
	}

	public FolFormula formulaFactory(formulaa.FormulaType type, FolFormula nested, FolVariable qvar){

		FolFormula res;

		switch(type){

			case FOL_EXISTS:
				res = new FolExistsQuantifiedFormula(nested, qvar);
				break;

			case FOL_FORALL:
				res = new FolForallQuantifiedFormula(nested, qvar);
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

}
