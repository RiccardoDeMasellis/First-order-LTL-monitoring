package formulaa.foltl;

import formulaa.Constant;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlConstant extends FoLtlTerm implements Constant {

	public FoLtlConstant(String name){
		super(name);
	}

	@Override
	public formulaa.FormulaType getTermType(){
		return formulaa.FormulaType.LOCAL_CONSTANT;
	}

}
