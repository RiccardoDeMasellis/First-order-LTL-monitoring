package formula.foltl;

import formula.Formula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlFormula extends Formula, Cloneable {

	FoLtlFormulaType getFormulaType();

	FoLtlFormula clone();

}
