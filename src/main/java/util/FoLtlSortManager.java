package util;

import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlFormula;
import formulaa.foltl.FoLtlSort;
import formulaa.foltl.FoLtlVariable;

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

	public FoLtlSortManager(){
		this.domain = new LinkedHashSet<>();
		this.sorts = new LinkedHashSet<>();
	}

	public FoLtlSortManager(LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
		this.sorts = new LinkedHashSet<>();
	}

	public LinkedHashSet<FoLtlSort> parseSortDefinition(String input){
		this.sorts = ParsingUtils.parseSortDefinition(input, this.domain);;
		return this.sorts;
	}

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
