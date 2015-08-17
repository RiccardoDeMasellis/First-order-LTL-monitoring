package formula.fol;

import formula.Term;

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

}
