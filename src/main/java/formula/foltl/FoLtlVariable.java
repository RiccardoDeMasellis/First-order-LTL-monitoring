package formula.foltl;

import formula.Variable;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlVariable extends FoLtlTerm implements Variable {

	public FoLtlVariable(String name){
		super(name);
	}

	@Override
	public FoLtlFormulaType getTermType(){
		return FoLtlFormulaType.LOCAL_VARIABLE;
	}

	@Override
	public String toString(){
		return "?" + super.toString();
	}

}
