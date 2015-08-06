package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlVariable extends FoLtlTerm {

	public FoLtlVariable(String name){
		super(name);
	}

	public String toString(){
		return "?" + super.getName();
	}

}
