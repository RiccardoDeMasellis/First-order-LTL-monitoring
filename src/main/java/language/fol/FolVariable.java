package language.fol;

import language.FormulaType;
import language.Variable;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolVariable extends FolTerm implements Variable {

	private FolSort sort;

	public FolVariable(String name) {
		super(name);
	}

	public FolVariable(String name, FolSort sort){
		super(name);
		this.sort = sort;
	}

	public FolSort getSort() {
		return sort;
	}

	public void setSort(FolSort sort) {
		this.sort = (FolSort) sort;
	}

	@Override
	public FormulaType getTermType(){
		return FormulaType.FOL_VARIABLE;
	}

	@Override
	public String toString(){
		return "?"+super.getName();
	}

}
