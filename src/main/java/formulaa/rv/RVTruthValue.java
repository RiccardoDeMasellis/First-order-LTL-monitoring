package formulaa.rv;

/**
 * RVTruthValue
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public abstract class RVTruthValue implements RVAtomicFormula{

	@Override
	public boolean equals(Object o) {
		return (o != null && this.getClass().equals(o.getClass()));
	}
}
