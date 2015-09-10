package formulaa.foltl;

import formulaa.Predicate;

/**
 * Class that represents a FO-LTL local true atom.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlPredicate implements Predicate {

	private String name;
	private int arity;

	public FoLtlPredicate(String name, int arity){
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
