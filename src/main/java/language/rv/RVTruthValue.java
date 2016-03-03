package language.rv;

import language.foltl.semantics.FoLtlAssignment;

import java.util.HashMap;

/**
 * RVTruthValue
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public abstract class RVTruthValue implements RVAtomicFormula {

	@Override
	public RVTruthValue evaluate(HashMap<FoLtlAssignment, RVTruthValue> assignmentRVTruthMap){
		return this;
	}

	public abstract int ordinalValue();

	public static RVTruthValue getByOrdinal(int ordinal){
		switch (ordinal){
			case 0:
				return new RVTrue();

			case 1:
				return new RVTempTrue();

			case 2:
				return new RVTempFalse();

			case 3:
				return new RVFalse();

			default:
				throw new RuntimeException("Unknown RVTruthValue ordinal number");
		}
	}

	@Override
	public boolean equals(Object o) {
		return (o != null && this.getClass().equals(o.getClass()));
	}

	@Override
	public abstract RVFormula clone();
}
