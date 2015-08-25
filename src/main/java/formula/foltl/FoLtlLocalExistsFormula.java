package formula.foltl;

import formula.ExistsQuantifiedFormula;
import formula.FormulaType;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalOrFormula;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalExistsFormula extends FoLtlQuantifiedFormula implements FoLtlLocalQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlLocalExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_EXISTS;
	}

	@Override
	public LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlVariable v = this.getQuantifiedVariable();
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();

		LTLfLocalFormula res = null;

		if (!v.getSort().isEmpty()) {
			Iterator<FoLtlConstant> sort = v.getSort().iterator();

			while (sort.hasNext()){
				FoLtlConstant c = sort.next();
				assignment.put(v, c);

				LTLfLocalFormula temp = nested.propositionalize(domain, assignment);

				if (res == null){
					res = temp;
				} else {
					res = new LTLfLocalOrFormula(temp, res);
				}

				assignment.remove(v);

			}

		} else {
			Iterator<FoLtlConstant> dom = domain.iterator();

			while (dom.hasNext()){
				FoLtlConstant c = dom.next();
				assignment.put(v, c);

				LTLfLocalFormula temp = nested.propositionalize(domain, assignment);

				if (res == null){
					res = temp;
				} else {
					res = new LTLfLocalOrFormula(temp, res);
				}

				assignment.remove(v);

			}
		}

		return res;
	}

}
