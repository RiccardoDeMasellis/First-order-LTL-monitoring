package formulaa.foltl;

import formulaa.Formula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlFormula extends Formula {

	FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	FoLtlFormula clone();

}
