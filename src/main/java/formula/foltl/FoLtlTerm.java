package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlTerm {

	private String name;

	public FoLtlTerm(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

}
