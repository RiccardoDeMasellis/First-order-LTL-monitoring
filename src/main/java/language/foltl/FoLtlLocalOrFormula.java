package language.foltl;

import language.OrFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalOrFormula;
import language.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.Disjunction;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.LinkedHashSet;

/**
 * Class that represents a FO-LTL local OR formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlLocalOrFormula extends FoLtlBinaryFormula implements OrFormula, FoLtlBoolOpLocalFormula {

	public FoLtlLocalOrFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.LOCAL_OR;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new LTLfLocalOrFormula(left.propositionalize(domain, assignment), right.propositionalize(domain, assignment));
	}

	@Override
	public FoLtlLocalFormula quantifierExpansion(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula().clone();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula().clone();
		return new FoLtlLocalOrFormula(left.quantifierExpansion(domain, assignment),
				right.quantifierExpansion(domain, assignment));
	}

	@Override
	public FolFormula toTweetyFol(){
		FoLtlLocalFormula left = (FoLtlLocalFormula) this.getLeftFormula();
		FoLtlLocalFormula right = (FoLtlLocalFormula) this.getRightFormula();
		return new Disjunction(left.toTweetyFol(), right.toTweetyFol());
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
			FoLtlLocalOrFormula other = (FoLtlLocalOrFormula) o;
			res = (this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula()))
					|| (this.getLeftFormula().equals(other.getRightFormula())
					&& this.getRightFormula().equals(other.getLeftFormula()));
		}

		return res;
	}
	*/

}
