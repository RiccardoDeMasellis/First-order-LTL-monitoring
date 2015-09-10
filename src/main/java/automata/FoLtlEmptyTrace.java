package automata;

/**
 * Represents an epsilon label of transitions of a FO-LTL Automaton.
 * <br>
 * Created by Simone Calciolari on 10/09/15.
 * @author Simone Calciolari.
 */
public class FoLtlEmptyTrace implements FoLtlLabel {

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		else
			return this.getClass().equals(other.getClass());
	}

	@Override
	public String toString() {
		return "eps";
	}

}
