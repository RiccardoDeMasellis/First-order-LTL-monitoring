package formula.fol;

import formula.Predicate;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolPredicate implements Predicate {

	private String name;
	private int arity;

	public FolPredicate(String name, int arity){
		this.name = name;
		this.arity = arity;
	}

	public String getName(){
		return this.name;
	}

	public int getArity(){
		return this.arity;
	}

	@Override
	public String toString(){
		return this.getName();
	}

	@Override
	public int hashCode(){
		int res = this.getName() != null ? this.getName().hashCode() : 0;
		res = res * 31;
		res = res + this.getArity();
		res = res * 31;
		return res;
	}

	@Override
	public FolPredicate clone(){
		return new FolPredicate(this.getName(), this.getArity());
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolPredicate other = (FolPredicate) o;
			res = this.getName().equals(other.getName())
					&& this.getArity() == other.getArity();
		}

		return res;
	}

}
