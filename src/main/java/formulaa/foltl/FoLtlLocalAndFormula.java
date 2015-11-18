package formulaa.foltl;

import formulaa.AndFormula;
import formulaa.FormulaType;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalFormula;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.Conjunction;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.LinkedHashSet;

/**
 * Class that represents a local AND FO-LTL formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlLocalAndFormula extends FoLtlBinaryFormula implements AndFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalAndFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_AND;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalAndFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	@Override
	public FoLtlFormula quantifierExpansion(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula().clone();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula().clone();
		return new FoLtlLocalAndFormula(left.quantifierExpansion(domain, assignment),
				right.quantifierExpansion(domain, assignment));
	}

	@Override
	public FolFormula toTweetyFol(){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new Conjunction(left.toTweetyFol(), right.toTweetyFol());
	}

	@Override
	public String getAtomicName(){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return left.getAtomicName() + "_" + this.stringOperator().toUpperCase() + "_" + right.getAtomicName();
	}

	/*
	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlLocalAndFormula other = (FoLtlLocalAndFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/
}
