package formula.fol;

import formula.Constant;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolConstant extends FolTerm implements Constant {

	public FolConstant(String name) {
		super(name);
	}

	public String toString(){
		return super.getName();
	}

}
