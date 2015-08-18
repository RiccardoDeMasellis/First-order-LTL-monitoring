package formula.fol;

import formula.FormulaType;
import formula.Variable;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolVariable extends FolTerm implements Variable {

	public FolVariable(String name) {
		super(name);
	}

	@Override
	public FormulaType getTermType(){
		return FormulaType.FOL_VARIABLE;
	}

	@Override
	public String toString(){
		return "?"+super.getName();
	}

}
