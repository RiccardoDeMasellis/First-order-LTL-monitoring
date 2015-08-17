package formula.foltl;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula {

	private FoLtlPredicate predicate;
	private LinkedList<FoLtlTerm> arguments;

	//Keeps track of the maximum number of arguments, if = -1 is ignored (predicate not yet set)
	private int pArity;
	//Keeps track of the current argument number
	private int nArgs;

	public FoLtlLocalAtom(){
		this.arguments = new LinkedList<>();
		this.pArity = -1;
		this.nArgs = 0;
	}

	public FoLtlLocalAtom(FoLtlPredicate predicate){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		this.nArgs = 0;
	}

	public FoLtlLocalAtom(FoLtlPredicate predicate, FoLtlTerm... arguments){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		this.nArgs = 0;

		for (FoLtlTerm arg : arguments){
			if (nArgs < pArity) {
				this.arguments.add(arg);
				nArgs++;
			} else {
				throw new RuntimeException("Too many arguments");
			}
		}

	}

	public void setPredicate(FoLtlPredicate predicate){
		if (predicate.getArity() >= this.nArgs) {
			this.predicate = predicate;
			pArity = predicate.getArity();
		} else {
			throw new RuntimeException("Predicate arity is too low");
		}
	}

	public void addArguments(FoLtlTerm... arguments){

		for (FoLtlTerm arg : arguments){
			if (nArgs < pArity || (pArity <= 0)) {
				this.arguments.add(arg);
				nArgs++;
			} else {
				throw new RuntimeException("Too many arguments");
			}
		}

	}

	public FoLtlPredicate getPredicate(){
		return this.predicate;
	}

	public LinkedList<FoLtlTerm> getArguments(){
		return this.arguments;
	}

	@Override
	public  String toString(){
		String s = predicate.toString() + "(";

		if (arguments.size() == pArity  || pArity <= 0) {
			int j = 0;
			Iterator<FoLtlTerm> i = arguments.iterator();

			while (i.hasNext()) {

				FoLtlTerm arg = i.next();

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
	public FoLtlFormulaType getFormulaType() {
		return FoLtlFormulaType.LOCAL_ATOM;
	}

	@Override
	public int hashCode(){
		int res;
		res = this.getPredicate() != null ? this.getPredicate().hashCode() : 0;

		Iterator<FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm t = i.next();
			res = 31 * res;
			res = res + (t != null ? t.hashCode() : 0);
		}

		return res;
	}

	@Override
	public FoLtlFormula clone() {
		LinkedList<FoLtlTerm> newArgs = new LinkedList<>();
		Iterator<FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm t = i.next();
			newArgs.add(t);
		}

		return this.formulaFactory(this.getFormulaType(), null, null, this.getPredicate().clone(), newArgs);

	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			FoLtlLocalAtom other = (FoLtlLocalAtom) o;
			res = this.getPredicate().equals(other.getPredicate())
					&& this.getArguments().equals(other.getArguments());
		}

		return res;
	}
}
