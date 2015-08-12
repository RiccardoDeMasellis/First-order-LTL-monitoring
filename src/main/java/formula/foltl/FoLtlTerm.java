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

	@Override
	public String toString(){
		return this.getName();
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlTerm other = (FoLtlTerm) o;
			res = this.getName().equals(other.getName());
		}

		return res;
	}

}
