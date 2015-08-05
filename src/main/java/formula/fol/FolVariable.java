package formula.fol;

import formula.Variable;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolVariable extends FolTerm implements Variable {

	public FolVariable(String name) {
		super(name);
	}

	public String toString(){
		return "?"+super.getName();
	}

}
