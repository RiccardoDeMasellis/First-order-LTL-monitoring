package formulaa.foltl;

import formulaa.FormulaType;
import formulaa.ImplFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalImplFormula;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.LinkedHashSet;

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

	/**
	 * Given the domain and an assignment, transforms this formula into an equivalent propositional formula
	 * (Built with FLLOAT LTLf structures)
	 * @param domain the domain
	 * @param assignment a given assignment
	 * @return
	 */
	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalImplFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	@Override
	public String getAtomicName(){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return left.getAtomicName() + this.stringOperator().toLowerCase() + right.getAtomicName();
	}

}
