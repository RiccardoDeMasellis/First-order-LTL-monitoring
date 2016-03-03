package language.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalVar;
import language.LocalFormula;
import formula.ltlf.LTLfLocalFormula;
import language.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.pl.sat.Sat4jSolver;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Interface that represents the generic FO-LTL local formula.
 * <br>
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

	/**
	 *
	 * Given the domain and an assignment, tranforms this formula into an equivalent one
	 * where the quantifiers are expanded as conjunctions (Forall) or Disjunctions(Exists)
	 * @param domain the domain
	 * @param assignment the given assignment
	 * @return a FoLtlLocalFormula equivalent to this formula.
	 */
	FoLtlLocalFormula quantifierExpansion(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	/**
	 *
	 * Given the domain and an assignment, tranforms this formula into an equivalent one
	 * where the quantifiers are expanded as conjunctions (Forall) or Disjunctions(Exists)
	 * @param domain the domain
	 * @return a FoLtlLocalFormula equivalent to this formula.
	 */
	default FoLtlLocalFormula quantifierExpansion(LinkedHashSet<FoLtlConstant> domain){
		return this.quantifierExpansion(domain, new FoLtlAssignment());
	}

	/**
	 * Given the domain and an assignment, transforms this formula into an equivalent propositional
	 * formula, and tells whether such formula is satisfiable or not
	 * @param domain the domain
	 * @param assignment an assignment
	 * @return true if the formula is satisfiable, false otherwise
	 */
	default boolean isSatisfiable(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		//Expand the local quantifiers (if any)
		FoLtlFormula expFormula = this.quantifierExpansion(domain);
		//Compute the substitution
		FoLtlLocalFormula subsFormula = (FoLtlLocalFormula) expFormula.substitute(assignment);
		//Transform in propositional
		PropositionalFormula propFormula = subsFormula.propositionalize(domain, assignment).toTweetyProp();

		//Call Sat4jSolver
		Sat4jSolver sjs = new Sat4jSolver();
		HashSet<PropositionalFormula> propFormulaSet = new HashSet<>();
		propFormulaSet.add(propFormula);

		return sjs.isSatisfiable(propFormulaSet);
	}

	@Override
	default LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														 HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){

		String atomicName = this.getAtomicName();
		LTLfFormula res = new LTLfLocalVar(atomicName);
		int i = 0;
		boolean exit = false;

		do {
			FoLtlFormula prev = ltlfTOfoltl.get(res);
			if (prev != null && !prev.equals(res)){
				res = new LTLfLocalVar(atomicName + i);
				i++;
			} else {
				exit = true;
			}
		} while (!exit);

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
