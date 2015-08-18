package formula.fol;

import formula.FormulaType;
import formula.LocalAtom;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolAtom extends FolAtomicFormula implements LocalAtom {

	private FolPredicate predicate;
	private LinkedList<FolTerm> arguments;

	//Keeps track of the maximum number of arguments, if = -1 is ignored (predicate not yet set)
	private int pArity;
	//Keeps track of the current argument number
	private int nArgs;

	public FolAtom(){
		this.arguments = new LinkedList<>();
		this.pArity = -1;
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
		if (predicate.getArity() >= this.nArgs) {
			this.predicate = predicate;
			pArity = predicate.getArity();
		} else {
			throw new RuntimeException("Predicate arity is too low");
		}
	}

	public void addArguments(FolTerm... arguments){

		for (FolTerm arg : arguments){
			if (nArgs < pArity || (pArity <= 0)) {
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

	@Override
	public  String toString(){
		String s = predicate.toString() + "(";

		if (arguments.size() == pArity  || pArity <= 0) {
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

	@Override
	public FormulaType getFormulaType() {
		return FormulaType.FOL_ATOM;
	}

	@Override
	public int hashCode(){
		int res;
		res = this.getPredicate() != null ? this.getPredicate().hashCode() : 0;

		Iterator<FolTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FolTerm t = i.next();
			res = 31 * res;
			res = res + (t != null ? t.hashCode() : 0);
		}

		return res;
	}

	@Override
	public FolFormula clone() {
		LinkedList<FolTerm> newArgs = new LinkedList<>();
		Iterator<FolTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FolTerm t = i.next();
			newArgs.add(t);
		}

		return this.formulaFactory(this.getFormulaType(), null, null, this.getPredicate().clone(), newArgs);

	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FolAtom other = (FolAtom) o;
			res = this.getPredicate().equals(other.getPredicate())
					&& this.getArguments().equals(other.getArguments());
		}

		return res;
	}

}
