package formulaa.foltl;

import formulaa.TrueAtom;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;
import formulaa.foltl.semantics.FoLtlAssignment;
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

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	@Override
	public String getAtomicName(){
		return this.toString().toLowerCase();
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.LOCAL_TRUE_ATOM;
	}

	/**
	 * Returns the negation of this formula i.e. a FALSE atom
	 * @return
	 */
	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalFalseAtom();
	}

	/**
	 * Given the domain and an assignment, tranforms this formula into an equivalent propositional formula
	 * (Built with FLLOAT LTLf structures)
	 * @param domain the domain
	 * @param assignment a given assignment
	 * @return
	 */
	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalTrueFormula();
	}

	/**
	 * Translates this formula into an equivalent FolFormula using Tweety data structures
	 * @return
	 */
	@Override
	public FolFormula toTweetyFol(){
		return new Tautology();
	}
}
