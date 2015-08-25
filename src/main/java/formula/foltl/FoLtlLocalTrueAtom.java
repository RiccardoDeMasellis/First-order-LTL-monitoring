package formula.foltl;

import formula.FormulaType;
import formula.TrueAtom;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalTrueAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, TrueAtom {

	@Override
	public String toString(){
		return "TRUE";
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_TRUE_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalFalseAtom();
	}

	@Override
	public LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalTrueFormula();
	}

}
