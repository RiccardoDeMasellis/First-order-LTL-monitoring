package formulaa.foltl;

import formulaa.QuantifiedFormula;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.HashSet;

/**
 * Abstract class that represents the generic FO-LTL quantified formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
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
	public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().substitute(domain, assignment),
				(FoLtlVariable) this.getQuantifiedVariable().clone());
	}

	@Override
	public void assignSort(FoLtlVariable variable, FoLtlSort sort){
		FoLtlVariable qvar = this.getQuantifiedVariable();
		if (qvar.equals(variable)){
			qvar.setSort(sort);
		} else {
			this.getNestedFormula().assignSort(variable, sort);
		}
	}

	@Override
	public HashSet<FoLtlVariable> getAcrossVariables(){
		HashSet<FoLtlVariable> res = this.getNestedFormula().getAcrossVariables();

		if (this instanceof FoLtlAcrossQuantifiedFormula){
			res.add(this.getQuantifiedVariable());
		}

		return res;
	}

	@Override
	public HashSet<FoLtlVariable> getLocalVariables(){
		HashSet<FoLtlVariable> res = this.getNestedFormula().getLocalVariables();

		if (this instanceof FoLtlLocalQuantifiedFormula){
			res.add(this.getQuantifiedVariable());
		}

		return res;
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

	/**
	 * Used to get instances with the desired properties
	 * @param type the quantifier type
	 * @param nested the quantified formula
	 * @param qvar the quantified variable
	 * @return the desired instances
	 */
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
