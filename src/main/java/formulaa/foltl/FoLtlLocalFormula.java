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
 * Interface that represents the generic FO-LTL local formula.
 * <p></p>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	/**
	 * Given the domain and an assignment, tranforms this formula into an equivalent propositional formula
	 * (Built with FLLOAT LTLf structures)
	 * @param domain the domain
	 * @param assignment a given assignment
	 * @return a LTLfLocalFormula equivalent to this formula.
	 */
	LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

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
	 * @return a net.sf.tweety.logics.fol.syntax.FolFormula logically equivalent to the original
	 */
	FolFormula toTweetyFol();

	/**
	 * Gets a string representation of this formula usable as a name for an atomic proposition
	 * @return a String representing this formula
	 */
	String getAtomicName();
}
