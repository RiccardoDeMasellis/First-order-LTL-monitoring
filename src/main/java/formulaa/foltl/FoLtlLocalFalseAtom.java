package formulaa.foltl;

import formulaa.FalseAtom;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;

import java.util.HashSet;

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
	public LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalFalseFormula();
	}

}
