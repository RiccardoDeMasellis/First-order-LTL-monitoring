package formulaa.foltl;

import formulaa.FormulaType;
import formulaa.Term;

/**
 * Abstract class that represents a FO-LTL term.
 * <p></p>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public abstract class FoLtlTerm implements Term {

	private String name;

	public FoLtlTerm(String name){
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

	/**
	 * Builds an instance with the desired properties.
	 * @param type the type of term desired.
	 * @param name the name of the term.
	 * @return the desired instance.
	 */
	public FoLtlTerm termFactory(FormulaType type, String name){
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
