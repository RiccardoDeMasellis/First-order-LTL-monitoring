package language.foltl;

import language.FormulaType;
import language.ImplFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalImplFormula;
import language.foltl.semantics.FoLtlAssignment;

import java.util.LinkedHashSet;

/**
 * Class that represents a FO-LTL local implication formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
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
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalImplFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	@Override
	public FoLtlLocalFormula quantifierExpansion(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula().clone();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula().clone();
		return new FoLtlLocalImplFormula(left.quantifierExpansion(domain, assignment),
				right.quantifierExpansion(domain, assignment));
	}

	@Override
	public String getAtomicName(){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return left.getAtomicName() + "_" + this.stringOperator().toUpperCase() + "_" + right.getAtomicName();
	}

}
