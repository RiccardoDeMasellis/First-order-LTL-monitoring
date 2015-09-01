package formulaa.foltl;

import formulaa.QuantifiedFormula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlQuantifiedFormula implements FoLtlFormula, QuantifiedFormula {

	private FoLtlFormula nestedFormula;
	private FoLtlVariable quantifiedVariable;

	public FoLtlQuantifiedFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		this.nestedFormula = nestedFormula;
		this.quantifiedVariable = quantifiedVariable;
	}

	public FoLtlFormula getNestedFormula(){
		return this.nestedFormula;
	}

	public FoLtlVariable getQuantifiedVariable(){
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
			FoLtlQuantifiedFormula other = (FoLtlQuantifiedFormula) o;
			res = this.stringOperator().equals(other.stringOperator())
					&& this.getNestedFormula().equals(other.getNestedFormula())
					&& this.getQuantifiedVariable().equals(other.getQuantifiedVariable());
		}

		return res;
	}

	@Override
	public FoLtlFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone(),
				(FoLtlVariable) this.getQuantifiedVariable().clone());
	}

	@Override
	public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlFormula res;

		if (this instanceof FoLtlAcrossQuantifiedFormula) {
			res = ((FoLtlAcrossQuantifiedFormula) this).temporalExpansion(domain, assignment);
		} else {
			res = this.formulaFactory(this.getFormulaType(), this.getNestedFormula().substitute(domain, assignment),
					(FoLtlVariable) this.getQuantifiedVariable().clone());
		}

		return res;
	}

	public FoLtlFormula formulaFactory(formulaa.FormulaType type, FoLtlFormula nested, FoLtlVariable qvar){

		FoLtlFormula res;

		switch(type){

			case ACROSS_EXISTS:
				res = new FoLtlAcrossExistsFormula(nested, qvar);
				break;

			case ACROSS_FORALL:
				res = new FoLtlAcrossForallFormula(nested, qvar);
				break;

			case LOCAL_EXISTS:
				res = new FoLtlLocalExistsFormula(nested, qvar);
				break;

			case LOCAL_FORALL:
				res = new FoLtlLocalForallFormula(nested, qvar);
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

}
