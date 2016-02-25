package formulaa.rv;

/**
 * RVFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public interface RVFormula extends Cloneable {

	RVTruthValue evaluate();

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	RVFormula clone();
}
