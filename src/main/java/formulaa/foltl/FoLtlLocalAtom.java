package formulaa.foltl;

import formulaa.LocalAtom;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalVar;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.commons.syntax.Constant;
import net.sf.tweety.logics.commons.syntax.Predicate;
import net.sf.tweety.logics.commons.syntax.Variable;
import net.sf.tweety.logics.fol.syntax.FOLAtom;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.*;

/**
 * Class that represents a FO-LTL first order atom.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlLocalAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, LocalAtom {

	private FoLtlPredicate predicate;
	private LinkedList<FoLtlTerm> arguments;

	//Keeps track of the maximum number of arguments, if = -1 is ignored (predicate not yet set)
	private int pArity;
	//Keeps track of the current argument number
	private int nArgs;

	/**
	 * Instantiates a new atom with no arguments, no predicate and unspecified arity.
	 */
	public FoLtlLocalAtom(){
		this.arguments = new LinkedList<>();
		this.pArity = -1;
		this.nArgs = 0;
	}

	/**
	 * Instantiates a new atom with a given predicate and no arguments.
	 * @param predicate the predicate for this atom.
	 */
	public FoLtlLocalAtom(FoLtlPredicate predicate){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		this.nArgs = 0;
	}

	/**
	 * Instantiates a new atom with a given predicate and the specified arguments.
	 * @param predicate the predicate for this atom.
	 * @param arguments the arguments.
	 * @throws RuntimeException if the given arguments are more than the predicate's arity allows.
	 */
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

	/**
	 * Instantiates a new atom with a given predicate and the specified collection of arguments.
	 * @param predicate the predicate for this atom.
	 * @param arguments the argument collection.
	 * @throws RuntimeException if the given arguments are more than the predicate's arity allows.
	 */
	public FoLtlLocalAtom(FoLtlPredicate predicate, Collection<FoLtlTerm> arguments){
		this.predicate = predicate;
		this.pArity = predicate.getArity();
		this.arguments = new LinkedList<>();
		int argSize = arguments.size();

		if (argSize <= this.pArity){
			this.arguments.addAll(arguments);
			this.nArgs = argSize;
		} else {
			throw new RuntimeException("Too many arguments");
		}
	}

	/**
	 * Allows to set the predicate for this atom.
	 * @param predicate the predicate to set.
	 * @throws RuntimeException if the predicate's arity is lower than the current number of arguments.
	 */
	public void setPredicate(FoLtlPredicate predicate){
		if (predicate.getArity() >= this.nArgs) {
			this.predicate = predicate;
			pArity = predicate.getArity();
		} else {
			throw new RuntimeException("Predicate arity is too low");
		}
	}

	/**
	 * Allows to add the given arguments to the atoms
	 * @param arguments the arguments to be added
	 * @throws RuntimeException if the given arguments are more than the predicate's arity allows.
	 */
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

	/**
	 * Returns the predicate.
	 * @return the FoLtlPredicate
	 */
	public FoLtlPredicate getPredicate(){
		return this.predicate;
	}

	/**
	 * Returns the argument list.
	 * @return a LinkedList containing the arguments (FoLtlTerm).
	 */
	public LinkedList<FoLtlTerm> getArguments(){
		return this.arguments;
	}

	@Override
	public void assignSort(FoLtlVariable variable, FoLtlSort sort){
		Iterator<FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm t = i.next();
			if (t.equals(variable)){
				((FoLtlVariable) t).setSort(sort);
			}
		}
	}

	@Override
	public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalAtom res = new FoLtlLocalAtom(this.getPredicate());

		Iterator<FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm next = i.next();

			if (next instanceof FoLtlVariable){
				FoLtlVariable v = (FoLtlVariable) next;
				FoLtlConstant t = assignment.get(v);

				if (t != null){
					res.addArguments(t);
				} else {
					res.addArguments(v);
				}
			} else {
				res.addArguments(next);
			}
		}

		return res;
	}

	/**
	 * Creates a deep copy of this atom, substituting all occurrences of x with t
	 * @param x the term to be substituted
	 * @param t the term to be inserted
	 * @return a new FoLtlAtom identical to this, but for all occurrences of x
	 */
	private FoLtlLocalAtom substitute(FoLtlTerm x, FoLtlTerm t){
		FoLtlLocalAtom res = new FoLtlLocalAtom(this.getPredicate());

		Iterator<FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm next = i.next();

			if (next.equals(x)){
				res.addArguments(t);
			} else {
				res.addArguments(next);
			}

		}

		return res;
	}

	/**
	 * Computes all the possible atoms that can be obtained by substituting each variable with a constant
	 * from the Sort it belongs to.
	 * @return an HashSet of FoLtlLocalAtom containing all the possible substitutions.
	 */
	public HashSet<FoLtlLocalAtom> allSubstitutions(){
		//The substitutions set
		HashSet<FoLtlLocalAtom> res = new HashSet<>();
		//First, adda clone of this Atom
		res.add((FoLtlLocalAtom) this.clone());

		Iterator<FoLtlTerm> args = this.getArguments().iterator();

		while (args.hasNext()){
			FoLtlTerm t = args.next();

			if (t instanceof FoLtlVariable){
				FoLtlVariable v = (FoLtlVariable) t;

				//If v's sort has elements, compute all substitutions
				if (!v.getSort().isEmpty()){
					//Temporary HashSet to take partial results
					HashSet<FoLtlLocalAtom> temp = new HashSet<>();
					//Move current partial results to temp
					temp.addAll(res);
					//Delete partial results from res
					res.clear();

					//Iterator over partial results set
					Iterator<FoLtlLocalAtom> subs = temp.iterator();

					while (subs.hasNext()){
						FoLtlLocalAtom la = subs.next();
						Iterator<FoLtlConstant> cons = v.getSort().iterator();

						while (cons.hasNext()){
							//For each constant c in v's sort, add to res a new substitution where
							//c takes the place of v
							FoLtlConstant c = cons.next();
							res.add(la.substitute(v, c));

						}
					}
				}
			}
		}

		return res;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		String name = this.getPredicate().toString().toLowerCase();

		FoLtlLocalAtom sub = (FoLtlLocalAtom) this.substitute(domain, assignment);
		Iterator<FoLtlTerm> i = sub.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm t = i.next();

			if (t instanceof FoLtlVariable){
				throw new RuntimeException("Found open variable");
			} else {
				name = name + "" + t.toString();
			}
		}

		return new LTLfLocalVar(name);
	}

	@Override
	public FolFormula toTweetyFol(){
		Predicate predicate = new Predicate(this.getPredicate().getName(), this.getPredicate().getArity());
		FOLAtom res = new FOLAtom(predicate);
		Iterator <FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm next = i.next();
			if (next instanceof FoLtlVariable){
				res.addArgument(new Variable(next.getName().toUpperCase()));
			} else {
				res.addArgument(new Constant(next.getName().toLowerCase()));
			}
		}

		return res;
	}

	@Override
	public String getAtomicName(){
		String res = this.getPredicate().getName().toLowerCase();
		Iterator <FoLtlTerm> i = this.getArguments().iterator();

		while (i.hasNext()){
			FoLtlTerm next = i.next();
			if (next instanceof FoLtlVariable){
				res = res + next.getName().toLowerCase();
			} else {
				res = res + next.getName().toLowerCase();
			}
		}

		return res;
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
	public formulaa.FormulaType getFormulaType() {
		return formulaa.FormulaType.LOCAL_ATOM;
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
