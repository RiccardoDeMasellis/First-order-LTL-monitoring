package formulaa;

/**
 * Created by Simone Calciolari on 20/08/15.
 */
public interface Sort extends Cloneable{

	String getName();

	void setName(String name);

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	Sort clone();

}
