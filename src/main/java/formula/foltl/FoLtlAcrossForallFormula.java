package formula.foltl;

import formula.FormulaType;
import formula.ForallQuantifiedFormula;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlAcrossForallFormula extends FoLtlQuantifiedFormula implements FoLtlAcrossQuantifiedFormula,
		ForallQuantifiedFormula {

	public FoLtlAcrossForallFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.ACROSS_FORALL;
	}

	@Override
	public String stringOperator(){
		return "xsForall";
	}

	@Override
	public FoLtlFormula temporalExpansion(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlFormula res = null;
		FoLtlVariable v = this.getQuantifiedVariable();

		if (!v.getSort().isEmpty()) {
			Iterator<FoLtlConstant> sort = v.getSort().iterator();

			while (sort.hasNext()){
				FoLtlConstant c = sort.next();
				assignment.put(v, c);

				FoLtlFormula temp = this.getNestedFormula().substitute(domain, assignment);

				if (res == null){
					res = temp;
				} else {
					res = new FoLtlTempAndFormula(temp, res);
				}

				assignment.remove(v);

			}

		} else {
			Iterator<FoLtlConstant> dom = domain.iterator();

			while (dom.hasNext()){
				FoLtlConstant c = dom.next();
				assignment.put(v, c);

				FoLtlFormula temp = this.getNestedFormula().substitute(domain, assignment);

				if (res == null){
					res = temp;
				} else {
					res = new FoLtlTempAndFormula(temp, res);
				}

				assignment.remove(v);

			}
		}

		return res;
	}

}
