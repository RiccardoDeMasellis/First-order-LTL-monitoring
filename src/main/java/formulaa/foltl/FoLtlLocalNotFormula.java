package formulaa.foltl;

import formulaa.FormulaType;
import formulaa.NotFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalNotFormula;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.Negation;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpLocalFormula{

	public FoLtlLocalNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_NOT;
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
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();
		return new LTLfLocalNotFormula(nested.propositionalize(domain, assignment));
	}

	/**
	 * Translates this formula into an equivalent FolFormula using Tweety data structures
	 * @return
	 */
	@Override
	public FolFormula toTweetyFol(){
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();
		return new Negation(nested.toTweetyFol());
	}

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	@Override
	public String getAtomicName(){
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();
		return this.stringOperator().toLowerCase() + nested.getAtomicName();
	}

}
