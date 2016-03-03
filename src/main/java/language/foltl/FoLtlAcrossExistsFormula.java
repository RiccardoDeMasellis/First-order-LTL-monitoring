package language.foltl;

import language.ExistsQuantifiedFormula;
import language.foltl.semantics.FoLtlAssignment;
import language.rv.RVFormula;
import language.rv.RVOrFormula;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Class that represents a FOLTL across-state existential formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlAcrossExistsFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlAcrossExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.ACROSS_EXISTS;
	}

	@Override
	public String stringOperator(){
		return "xsExists";
	}

	@Override
	public RVFormula expandToRVFormula(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		RVFormula res = null;
		FoLtlFormula nested = this.getNestedFormula();
		FoLtlVariable v = this.getQuantifiedVariable();

		Iterator<FoLtlConstant> i;

		if (!v.getSort().isEmpty()){
			i = v.getSort().iterator();
		} else {
			i = domain.iterator();
		}

		while (i.hasNext()){
			FoLtlConstant c = i.next();
			assignment.put(v, c);

			RVFormula temp = nested.expandToRVFormula(domain, assignment);

			if (res == null){
				res = temp;
			} else {
				res = new RVOrFormula(temp, res);
			}

			assignment.remove(v);
		}

		return res;
	}

	@Override
	public FoLtlFormula temporalExpansion(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlFormula res = null;
		FoLtlFormula nested = this.getNestedFormula().clone();
		FoLtlVariable v = this.getQuantifiedVariable();

		Iterator<FoLtlConstant> i;

		if (!v.getSort().isEmpty()){
			i = v.getSort().iterator();
		} else {
			i = domain.iterator();
		}

		while (i.hasNext()){
			FoLtlConstant c = i.next();
			assignment.put(v, c);

			FoLtlFormula temp;

			if (nested instanceof FoLtlTemporalFormula){
				temp = ((FoLtlTemporalFormula) nested).temporalExpansion(domain, assignment);
			} else {
				temp = nested.substitute(assignment);
			}

			if (res == null){
				res = temp;
			} else {
				res = new FoLtlTempOrFormula(temp, res);
			}

			assignment.remove(v);

		}

		return res;
	}

}
