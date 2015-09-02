package formulaa.foltl;

import formulaa.FalseAtom;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;
import net.sf.tweety.logics.fol.syntax.Contradiction;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.Tautology;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalFalseAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, FalseAtom {

	@Override
	public String toString(){
		return "FALSE";
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_FALSE_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalTrueAtom();
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalFalseFormula();
	}

	@Override
	public FolFormula toTweetyFol(){
		return new Contradiction();
	}

}
