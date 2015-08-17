package formula.foltl;

import formula.Term;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlTerm implements Cloneable, Term {

	private String name;

	public FoLtlTerm(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public abstract FoLtlFormulaType getTermType();

	@Override
	public String toString(){
		return this.getName();
	}

	@Override
	public int hashCode(){
		int res = this.getClass().hashCode();
		res = res * 31;
		res = res + (this.getName() != null ? this.getName().hashCode() : 0);
		return res;
	}

	public FoLtlTerm clone(){
		return termFactory(this.getTermType(), this.getName());
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTerm other = (FoLtlTerm) o;
			res = this.getName().equals(other.getName());
		}

		return res;
	}

	public FoLtlTerm termFactory(FoLtlFormulaType type, String name){
		FoLtlTerm res;

		switch(type){

			case LOCAL_CONSTANT:
				res = new FoLtlConstant(name);
				break;

			case LOCAL_VARIABLE:
				res = new FoLtlVariable(name);
				break;

			default:
				throw new RuntimeException("Unknown term type");

		}

		return res;
	}

}
