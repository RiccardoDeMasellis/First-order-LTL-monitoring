package formulaa.foltl;

import formulaa.Variable;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlVariable extends FoLtlTerm implements Variable {

	private FoLtlSort sort;

	public FoLtlVariable(String name){
		super(name);
		this.sort = FoLtlSort.DEFAULT;
		FoLtlSort.DEFAULT.addVariable(this);
	}

	public FoLtlVariable(String name, FoLtlSort sort){
		super(name);
		this.setSort(sort);
	}

	public FoLtlSort getSort() {
		return sort;
	}

	public void setSort(FoLtlSort sort) {
		this.sort = sort;
		this.sort.addVariable(this);
	}

	@Override
	public formulaa.FormulaType getTermType(){
		return formulaa.FormulaType.LOCAL_VARIABLE;
	}

	@Override
	public String toString(){
		return "?" + super.toString();
	}
}
