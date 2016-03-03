package language.fol;

import language.Constant;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolConstant extends FolTerm implements Constant {

	public FolConstant(String name) {
		super(name);
	}

	@Override
	public language.FormulaType getTermType(){
		return language.FormulaType.FOL_CONSTANT;
	}

	@Override
	public String toString(){
		return super.getName();
	}

}
