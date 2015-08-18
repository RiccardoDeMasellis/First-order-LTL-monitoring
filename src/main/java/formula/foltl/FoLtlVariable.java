package formula.foltl;

import formula.FormulaType;
import formula.Variable;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlVariable extends FoLtlTerm implements Variable {

	public FoLtlVariable(String name){
		super(name);
	}

	@Override
	public FormulaType getTermType(){
		return FormulaType.LOCAL_VARIABLE;
	}

	@Override
	public String toString(){
		return "?" + super.toString();
	}

}
