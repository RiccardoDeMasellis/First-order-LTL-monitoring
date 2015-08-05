package formula.fol;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolTerm {

	private String name;

	public FolTerm(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

}
