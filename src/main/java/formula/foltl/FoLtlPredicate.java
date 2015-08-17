package formula.foltl;

import formula.Predicate;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlPredicate implements Cloneable, Predicate {

	private String name;
	private int arity;

	public FoLtlPredicate(String name, int arity){
		this.name = name;
		this.arity = arity;
	}

	public String toString(){
		return this.getName();
	}

	public String getName(){
		return this.name;
	}

	public int getArity(){
		return this.arity;
	}

	public FoLtlPredicate clone(){
		return new FoLtlPredicate(this.getName(), this.getArity());
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlPredicate other = (FoLtlPredicate) o;
			res = this.getName().equals(other.getName())
					&& this.getArity() == other.getArity();
		}

		return res;
	}
}
