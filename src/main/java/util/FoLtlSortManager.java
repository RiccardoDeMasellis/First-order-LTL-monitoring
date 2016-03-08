package util;

import language.foltl.FoLtlConstant;
import language.foltl.FoLtlFormula;
import language.foltl.FoLtlSort;
import language.foltl.FoLtlVariable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * FoLtlSortManager
 * <br>
 * Created by Simone Calciolari on 17/12/15.
 * @author Simone Calciolari.
 */
public class FoLtlSortManager {

	private LinkedHashSet<FoLtlConstant> domain;
	private LinkedHashSet<FoLtlSort> sorts;

	/**
	 * Empty constructor
	 * Initializes an empty domain
	 */
	protected FoLtlSortManager(){
		this.domain = new LinkedHashSet<>();
		this.sorts = new LinkedHashSet<>();
	}

	/**
	 * Constructor
	 * @param domain the domain of the current problem
	 */
	public FoLtlSortManager(LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
		this.sorts = new LinkedHashSet<>();
	}

	/**
	 * Parse the sort definition;
	 * @param input string input for the parser
	 * @return the parsed list of sorts
	 */
	public LinkedHashSet<FoLtlSort> parseSortDefinition(String input){
		this.sorts = ParsingUtils.parseSortDefinition(input, this.domain);
		return this.sorts;
	}

	/**
	 * Assigns the current sorts to the given formula
	 * @param formula the formula to which the sorts are to be assigned
	 * @param input string input for the parser;
	 * @return the formula with sorts assigned to its variables
	 */
	public FoLtlFormula assignSort(FoLtlFormula formula, String input){
		HashSet<FoLtlVariable> variables = new HashSet<>();
		variables.addAll(formula.getAcrossVariables());
		variables.addAll(formula.getLocalVariables());

		HashMap<FoLtlVariable, FoLtlSort> sortAssignment =
				ParsingUtils.parseSortAssignment(input, variables, this.sorts);

		for(FoLtlVariable v : sortAssignment.keySet()){
			formula.assignSort(v, sortAssignment.get(v));
		}

		return formula;
	}

	public void setDomain(LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
	}

	public void setSorts(LinkedHashSet<FoLtlSort> sorts){
		this.sorts = sorts;
	}

	public LinkedHashSet<FoLtlConstant> getDomain(){
		return domain;
	}

	public LinkedHashSet<FoLtlSort> getSorts(){
		return sorts;
	}
}
