package formulaa.rv;

import formulaa.foltl.semantics.FoLtlAssignment;
import java.util.HashMap;

/**
 * RVFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public interface RVFormula extends Cloneable {

	default RVTruthValue evaluate(){
		return this.evaluate(new HashMap<>());
	}

	RVTruthValue evaluate(HashMap<FoLtlAssignment, RVTruthValue> assignmentRVTruthMap);

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	RVFormula clone();
}
