package formulaa.foltl;

import formulaa.ExistsQuantifiedFormula;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Class that represents a FOLTL across-state existential formula.
 * <p>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlAcrossExistsFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlAcrossExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.ACROSS_EXISTS;
	}

	@Override
	public String stringOperator(){
		return "xsExists";
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
				temp = nested.substitute(domain, assignment);
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
