package formulaa.foltl;

import formulaa.LocalFormula;
import formula.ltlf.LTLfLocalFormula;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

}
