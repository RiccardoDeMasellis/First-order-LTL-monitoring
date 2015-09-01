package formulaa.fol;

import formulaa.Constant;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolConstant extends FolTerm implements Constant {

	public FolConstant(String name) {
		super(name);
	}

	@Override
	public formulaa.FormulaType getTermType(){
		return formulaa.FormulaType.FOL_CONSTANT;
	}

	@Override
	public String toString(){
		return super.getName();
	}

}
