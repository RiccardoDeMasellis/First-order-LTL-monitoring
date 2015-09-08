package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalVar;
import formulaa.LocalFormula;
import formula.ltlf.LTLfLocalFormula;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	/**
	 * Given the domain and an assignment, tranforms this formula into an equivalent propositional formula
	 * (Built with FLLOAT LTLf structures)
	 * @param domain the domain
	 * @param assignment a given assignment
	 * @return
	 */
	LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	/**
	 * Translates this formula into a FLLOAT LTLf formula, where to every original local (FOL) formula
	 * corresponds an atomic proposition.
	 * @param foltlTOltlf a map that allows to transform foltl local formulas to ltlf atomic proposition
	 * @param ltlfTOfoltl a map that allows to do the inverse
	 * @return the newly built LTLf formula
	 */
	@Override
	default LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														 HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		LTLfFormula res = new LTLfLocalVar(this.getAtomicName());
		foltlTOltlf.put(this, res);
		ltlfTOfoltl.put(res, this);
		return res;
	}

	/**
	 * Translates this formula into an equivalent FolFormula using Tweety data structures
	 * @return
	 */
	FolFormula toTweetyFol();

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return
	 */
	String getAtomicName();
}
