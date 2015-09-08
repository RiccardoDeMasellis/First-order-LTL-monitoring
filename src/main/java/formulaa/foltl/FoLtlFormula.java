package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formulaa.Formula;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlFormula extends Formula {

	/**
	 * Given the domain and an assignment substitutes all the variables in this Formula
	 * according to the assignment
	 * @param domain the domain
	 * @param assignment the assignment
	 * @return a new FoltlFormula where variables are substituted by constants according to the given assignment
	 */
	FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	/**
	 * Translates this formula into a FLLOAT LTLf formula, where to every original local (FOL) formula
	 * corresponds an atomic proposition.
	 * @param foltlTOltlf a map that allows to transform foltl local formulas to ltlf atomic proposition
	 * @param ltlfTOfoltl a map that allows to do the inverse
	 * @return the newly built LTLf formula
	 */
	LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf, HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl);

	/**
	 * Given a variable and a sort, assigns the sort to every occurrence of such variable
	 * @param variable the variable
	 * @param sort the sort
	 */
	void assignSort(FoLtlVariable variable, FoLtlSort sort);

	//Both the following methods ignore open variables
	//(which shouldn't be there at all btw)

	/**
	 * Returns all the across quantified variables
	 * @return
	 */
	HashSet<FoLtlVariable> getAcrossVariables();

	/**
	 * Returns all the local quantified variables
	 * @return
	 */
	HashSet<FoLtlVariable> getLocalVariables();

	FoLtlFormula clone();

}
