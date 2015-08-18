package formula.foltl;

import formula.Constant;
import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlConstant extends FoLtlTerm implements Constant {

	public FoLtlConstant(String name){
		super(name);
	}

	@Override
	public FormulaType getTermType(){
		return FormulaType.LOCAL_CONSTANT;
	}

	public FoLtlConstant clone(){
		return new FoLtlConstant(this.getName());
	}

}
