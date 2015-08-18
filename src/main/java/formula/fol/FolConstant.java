package formula.fol;

import formula.Constant;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolConstant extends FolTerm implements Constant {

	public FolConstant(String name) {
		super(name);
	}

	@Override
	public FormulaType getTermType(){
		return FormulaType.FOL_CONSTANT;
	}

	@Override
	public String toString(){
		return super.getName();
	}

}
