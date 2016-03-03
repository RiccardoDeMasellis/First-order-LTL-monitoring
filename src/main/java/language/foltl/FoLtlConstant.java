package language.foltl;

import language.Constant;

/**
 * Class that represents a FO-LTL constant.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlConstant extends FoLtlTerm implements Constant {

	public FoLtlConstant(String name){
		super(name);
	}

	@Override
	public language.FormulaType getTermType(){
		return language.FormulaType.LOCAL_CONSTANT;
	}

}
