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
		LTLfLocalFormula res = null;
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula().clone();
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

			LTLfLocalFormula temp = nested.propositionalize(domain, assignment);

			if (res == null){
				res = temp;
			} else {
				res = new LTLfLocalAndFormula(temp, res);
			}

			assignment.remove(v);

		}

		return res;
	}

}
