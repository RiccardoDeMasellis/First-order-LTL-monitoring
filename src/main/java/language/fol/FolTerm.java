package language.fol;

import language.Term;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolTerm implements Term {

	private String name;

	public FolTerm(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

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

	public FolTerm clone(){
		return termFactory(this.getTermType(), this.getName());
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolTerm other = (FolTerm) o;
			res = this.getName().equals(other.getName());
		}

		return res;
	}

	public FolTerm termFactory(language.FormulaType type, String name){
		FolTerm res;

		switch(type){

			case LOCAL_CONSTANT:
				res = new FolConstant(name);
				break;

			case LOCAL_VARIABLE:
				res = new FolVariable(name);
				break;

			default:
				throw new RuntimeException("Unknown term type");

		}

		return res;
	}

}
