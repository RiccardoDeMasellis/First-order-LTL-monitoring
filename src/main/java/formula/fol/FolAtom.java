package formula.fol;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolAtom extends FolAtomicFormula {

	private FolPredicate predicate;

	private LinkedList<FolTerm> arguments;

	private int pArity;

	private int nArgs;

	public FolAtom(){
		this.arguments = new LinkedList<>();
		this.nArgs = 0;
	}

	public FolAtom(FolPredicate predicate){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		this.nArgs = 0;
	}

	public FolAtom(FolPredicate predicate, FolTerm... arguments){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		this.nArgs = 0;

		for (FolTerm arg : arguments){
			if (nArgs < pArity) {
				this.arguments.add(arg);
				nArgs++;
			} else {
				throw new RuntimeException("Too many arguments");
			}
		}

	}

	public void setPredicate(FolPredicate predicate){
		this.predicate = predicate;
	}

	public void addArguments(FolTerm... arguments){

		for (FolTerm arg : arguments){
			if (nArgs < pArity) {
				this.arguments.add(arg);
				nArgs++;
			} else {
				throw new RuntimeException("Too many arguments");
			}
		}

	}

	public FolPredicate getPredicate(){
		return this.predicate;
	}

	public LinkedList<FolTerm> getArguments(){
		return this.arguments;
	}

	public  String toString(){
		String s = predicate.toString() + "(";

		if (arguments.size() == pArity) {
			int j = 0;
			Iterator<FolTerm> i = arguments.iterator();

			while (i.hasNext()) {

				FolTerm arg = i.next();

				if (j > 0) {
					s = s + ", ";
				}

				s = s + arg.toString();

				j++;

			}
		} else {
			throw new RuntimeException("Incomplete argument list");
		}

		s = s +")";

		return s;
	}

}
