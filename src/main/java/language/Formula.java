package language;

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

	/**
	 * Converts this formula in negation normal form.
	 * @return a formula in negation normal form equivalent to the original.
	 */
	Formula nnf();

	/**
	 * Returns the negation of this formula
	 * @return a formula representing the negation of this formula
	 */
	Formula negate();

}
