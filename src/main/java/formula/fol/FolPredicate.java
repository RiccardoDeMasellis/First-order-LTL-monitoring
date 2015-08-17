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

	public String toString(){
		return this.name;
	}

	public int getArity(){
		return this.arity;
	}

}
