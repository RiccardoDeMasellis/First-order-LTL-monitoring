package formulaa.foltl;

import formulaa.ExistsQuantifiedFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalOrFormula;
import net.sf.tweety.logics.commons.syntax.Variable;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalExistsFormula extends FoLtlQuantifiedFormula implements FoLtlLocalQuantifiedFormula,
		ExistsQuantifiedFormula {

	public FoLtlLocalExistsFormula(FoLtlFormula nestedFormula, FoLtlVariable quantifiedVariable){
		super(nestedFormula, quantifiedVariable);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_EXISTS;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
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
				res = new LTLfLocalOrFormula(temp, res);
			}

			assignment.remove(v);

		}

		return res;
	}

	@Override
	public FolFormula toTweetyFol(){
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();
		return new net.sf.tweety.logics.fol.syntax.ExistsQuantifiedFormula(nested.toTweetyFol(),
				new Variable(this.getQuantifiedVariable().getName().toUpperCase()));
	}

}
