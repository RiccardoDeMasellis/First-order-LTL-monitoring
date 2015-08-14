package formula.foltl;

import formula.AtomicFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlAtomicFormula implements FoLtlFormula, AtomicFormula {

	@Override
	public boolean equals(Object o){
		return (o != null && this.getClass().equals(o.getClass()));
	}
	
}
