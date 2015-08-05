package formula.fol;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolConstant extends FolTerm {

	public FolConstant(String name) {
		super(name);
	}

	public String toString(){
		return super.getName();
	}

}
