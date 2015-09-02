package formulaa.foltl;

import formulaa.TemporalFormula;
import java.util.HashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlTemporalFormula extends FoLtlFormula, TemporalFormula {

	default FoLtlFormula temporalExpansion(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return this.substitute(domain, assignment);
	}

}
