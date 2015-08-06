package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlPredicate {

	private String name;
	private int arity;

	public FoLtlPredicate(String name, int arity){
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
