package formulaa.foltl;

import formulaa.QuantifiedFormula;
import formulaa.foltl.semantics.FoLtlAssignment;

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

	/**
	 * Given the domain and an assignment substitutes all the variables in this Formula
	 * according to the assignment
	 * @param domain the domain
	 * @param assignment the assignment
	 * @return a new FoltlFormula where variables are substituted by constants according to the given assignment
	 */
	@Override
	public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().substitute(domain, assignment),
				(FoLtlVariable) this.getQuantifiedVariable().clone());
	}

	/**
	 * Given a variable and a sort, assigns the sort to every occurrence of such variable
	 * @param variable the variable
	 * @param sort the sort
	 */
	@Override
	public void assignSort(FoLtlVariable variable, FoLtlSort sort){
		FoLtlVariable qvar = this.getQuantifiedVariable();
		if (qvar.equals(variable)){
			qvar.setSort(sort);
		} else {
			this.getNestedFormula().assignSort(variable, sort);
		}
	}

	/**
	 * Returns all the across quantified variables
	 * @return
	 */
	@Override
	public HashSet<FoLtlVariable> getAcrossVariables(){
		HashSet<FoLtlVariable> res = this.getNestedFormula().getAcrossVariables();

		if (this instanceof FoLtlAcrossQuantifiedFormula){
			res.add(this.getQuantifiedVariable());
		}

		return res;
	}

	/**
	 * Returns all the local quantified variables
	 * @return
	 */
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
