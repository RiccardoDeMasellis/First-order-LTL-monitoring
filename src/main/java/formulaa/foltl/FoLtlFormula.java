package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formulaa.Formula;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlFormula extends Formula {

	FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf, HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl);

	void assignSort(FoLtlVariable variable, FoLtlSort sort);

	//Both the following methods ignore open variables
	//(which shouldn't be there at all btw)
	HashSet<FoLtlVariable> getAcrossVariables();

	HashSet<FoLtlVariable> getLocalVariables();

	FoLtlFormula clone();

}
