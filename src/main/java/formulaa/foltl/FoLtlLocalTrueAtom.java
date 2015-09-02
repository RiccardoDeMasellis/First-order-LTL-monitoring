package formulaa.foltl;

import formulaa.TrueAtom;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.Tautology;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalTrueAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, TrueAtom {

	@Override
	public String toString(){
		return "TRUE";
	}

	@Override
	public String getAtomicName(){
		return this.toString();
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_TRUE_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalFalseAtom();
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalTrueFormula();
	}

	@Override
	public FolFormula toTweetyFol(){
		return new Tautology();
	}
}
