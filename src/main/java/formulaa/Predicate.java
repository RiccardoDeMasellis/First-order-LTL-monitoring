package formulaa;

/**
 * Created by Simone Calciolari on 17/08/15.
 */
public interface Predicate extends Cloneable {

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	Predicate clone();

}
