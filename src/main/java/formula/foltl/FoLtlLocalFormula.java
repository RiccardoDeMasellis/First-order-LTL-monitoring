package formula.foltl;

import formula.LocalFormula;
import formula.LocalFormulaType;
import formula.ltlf.LTLfLocalFormula;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	LTLfLocalFormula propositionalize(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

}
