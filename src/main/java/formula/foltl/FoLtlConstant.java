package formula.foltl;

import formula.Constant;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlConstant extends FoLtlTerm implements Constant {

	public FoLtlConstant(String name){
		super(name);
	}

	@Override
	public FoLtlFormulaType getTermType(){
		return FoLtlFormulaType.LOCAL_CONSTANT;
	}

	public FoLtlConstant clone(){
		return new FoLtlConstant(this.getName());
	}

}
