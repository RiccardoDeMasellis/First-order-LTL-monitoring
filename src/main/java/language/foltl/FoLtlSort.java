package language.foltl;

import language.Sort;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Class that represents a FO-LTL sort.
 * <br>
 * Created by Simone Calciolari on 19/08/15.
 * @author Simone Calciolari
 */
public class FoLtlSort extends LinkedHashSet<FoLtlConstant> implements Sort {

	/**
	 * The default sort assigned to all variables when not specified otherwise.
	 */
	public static final FoLtlSort DEFAULT = new FoLtlSort("default");

	private String name;
	private HashSet<FoLtlVariable> variables;

	public FoLtlSort(String name){
		super();
		this.setName(name);
		this.variables = new HashSet<>();
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public void addVariable(FoLtlVariable v){
		this.variables.add(v);
	}

	public HashSet<FoLtlVariable> getVariables(){
		return this.variables;
	}

	@Override
	public String toString(){
		return "SORT " + this.getName() + "::" + super.toString() + "::" + this.getVariables().toString();
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
		Iterator<FoLtlVariable> vars = this.variables.iterator();

		while (i.hasNext()){
			FoLtlConstant c = i.next();
			res.add(c);
		}

		while (vars.hasNext()){
			FoLtlVariable v = vars.next();
			res.addVariable(v);
		}

		return res;
	}

}
