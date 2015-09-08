package formulaa.foltl;

import formulaa.Constant;

/**
 * Class that represents a FO-LTL constant.
 * <p></p>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
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
