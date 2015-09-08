package formulaa.foltl;

import formulaa.FormulaType;
import formulaa.UnaryFormula;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlUnaryFormula implements FoLtlFormula, UnaryFormula {

	private FoLtlFormula nestedFormula;

	public FoLtlUnaryFormula(FoLtlFormula nestedFormula){
		this.nestedFormula = nestedFormula;
	}

	@Override
	public FoLtlFormula getNestedFormula(){
		return this.nestedFormula;
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
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().substitute(domain, assignment));
	}

	/**
	 * Given a variable and a sort, assigns the sort to every occurrence of such variable
	 * @param variable the variable
	 * @param sort the sort
	 */
	@Override
	public void assignSort(FoLtlVariable variable, FoLtlSort sort){
		this.getNestedFormula().assignSort(variable, sort);
	}

	/**
	 * Returns all the across quantified variables
	 * @return
	 */
	@Override
	public HashSet<FoLtlVariable> getAcrossVariables(){
		return this.getNestedFormula().getAcrossVariables();
	}

	/**
	 * Returns all the local quantified variables
	 * @return
	 */
	@Override
	public HashSet<FoLtlVariable> getLocalVariables(){
		return this.getNestedFormula().getLocalVariables();
	}

	@Override
	public String toString(){
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
			FoLtlUnaryFormula other = (FoLtlUnaryFormula) o;
			res = this.getNestedFormula().equals(other.getNestedFormula());
		}

		return res;
	}

	@Override
	public FoLtlFormula clone(){
		return this.formulaFactory(this.getFormulaType(), this.getNestedFormula().clone());
	}

	/**
	 * Used to get an instance with the desired properties
	 * @param type the operator type
	 * @param nested the nested sub formula
	 * @return the desired instance
	 */
	public FoLtlFormula formulaFactory(FormulaType type, FoLtlFormula nested){

		FoLtlFormula res;

		switch(type){

			case GLOBALLY:
				res = new FoLtlGloballyFormula(nested);
				break;

			case EVENTUALLY:
				res = new FoLtlEventuallyFormula(nested);
				break;

			case WEAK_NEXT:
				res = new FoLtlWeakNextFormula(nested);
				break;

			case NEXT:
				res = new FoLtlNextFormula(nested);
				break;

			case TEMP_NOT:
				res = new FoLtlTempNotFormula(nested);
				break;

			case LOCAL_NOT:
				res = new FoLtlLocalNotFormula(nested);
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

}
