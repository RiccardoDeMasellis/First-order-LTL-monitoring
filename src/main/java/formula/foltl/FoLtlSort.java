package formula.foltl;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 19/08/15.
 */
public class FoLtlSort extends HashSet<FoLtlConstant> {

	public static final FoLtlSort DEFAULT = new FoLtlSort("default");

	private String name;

	public FoLtlSort(String name){
		super();
		this.setName(name);
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return "SORT " + this.getName() + "::" + super.toString();
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o instanceof FoLtlSort){
			FoLtlSort other = (FoLtlSort) o;
			res = this.getName().equals(other.getName())
					&& super.equals(o);
		}

		return res;
	}

	@Override
	public int hashCode(){
		int res = this.getName() != null ? this.getName().hashCode() : 0;
		res = res * 31;
		res = res + super.hashCode();
		return res;
	}

	@Override
	public FoLtlSort clone(){
		FoLtlSort res = new FoLtlSort(this.getName());
		Iterator<FoLtlConstant> i = this.iterator();

		while (i.hasNext()){
			FoLtlConstant c = i.next();
			res.add(c);
		}

		return res;
	}

}
