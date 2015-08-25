package formula.foltl;

import formula.FormulaType;
import formula.ImplFormula;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalImplFormula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalImplFormula extends FoLtlBinaryFormula implements ImplFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_IMPLICATION;
	}

	@Override
	public LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalImplFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

}
