package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface Formula extends Cloneable{

	@Override
	String toString();

	@Override
	boolean equals(Object o);

	@Override
	int hashCode();

	FormulaType getFormulaType();

	Formula clone();

	Formula nnf();

	Formula negate();

}
