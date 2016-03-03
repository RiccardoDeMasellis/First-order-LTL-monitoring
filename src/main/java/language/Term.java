package language;

/**
 * Created by Simone Calciolari on 17/08/15.
 */
public interface Term extends Cloneable {

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	FormulaType getTermType();

	Term clone();

}
