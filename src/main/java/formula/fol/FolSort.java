package formula.fol;

import formula.Sort;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 20/08/15.
 */
public class FolSort extends HashSet<FolConstant> implements Sort {

	public static final FolSort DEFAULT = new FolSort("default");

	private String name;

	public FolSort(String name){
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

		if (o instanceof FolSort){
			FolSort other = (FolSort) o;
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
	public FolSort clone(){
		FolSort res = new FolSort(this.getName());
		Iterator<FolConstant> i = this.iterator();

		while (i.hasNext()){
			FolConstant c = i.next();
			res.add(c);
		}

		return res;
	}

}
