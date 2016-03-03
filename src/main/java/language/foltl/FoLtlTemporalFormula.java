package language.foltl;

import language.TemporalFormula;
import language.foltl.semantics.FoLtlAssignment;

import java.util.HashSet;

/**
 * Interface that represents the generic FO-LTL temporal formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public interface FoLtlTemporalFormula extends FoLtlFormula, TemporalFormula {

	default FoLtlFormula temporalExpansion(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return this.substitute(assignment);
	}

}
