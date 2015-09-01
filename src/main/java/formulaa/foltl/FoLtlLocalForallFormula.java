package formulaa.foltl;

import formulaa.ForallQuantifiedFormula;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalFormula;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalForallFormula extends FoLtlQuantifiedFormula implements FoLtlLocalQuantifiedFormula,
		ForallQuantifiedFormula {

	public FoLtlLocalForallFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_FORALL;
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
					res = new LTLfLocalAndFormula(temp, res);
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
					res = new LTLfLocalAndFormula(temp, res);
				}

				assignment.remove(v);

			}
		}

		return res;
	}

}
