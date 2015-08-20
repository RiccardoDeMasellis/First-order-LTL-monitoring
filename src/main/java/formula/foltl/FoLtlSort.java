package formula.foltl;

import java.util.HashSet;

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

}
