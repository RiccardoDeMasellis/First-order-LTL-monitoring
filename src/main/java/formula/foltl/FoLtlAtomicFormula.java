package formula.foltl;

import formula.AtomicFormula;
import formula.FormulaType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public abstract class FoLtlAtomicFormula implements FoLtlFormula, AtomicFormula {

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalNotFormula(this.clone());
	}

	@Override
	public boolean equals(Object o){
		return (o != null && this.getClass().equals(o.getClass()));
	}

	@Override
	public int hashCode(){
		return this.getClass().hashCode();
	}

	@Override
	public FoLtlFormula clone(){
		return this.formulaFactory(this.getFormulaType(), null, null, null, null);
	}

	@Override
	 public FoLtlFormula substitute(HashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return this.clone();
	}

	/**
	 * used to obtain new instances of FoLtl atomic formulas
	 * @param type desired formula type
	 * @param left left term, used for equalities
	 * @param right right term, used for equalities
	 * @param predicate predicate, used for fol atoms
	 * @param arguments list of terms, used for fol atoms
	 * @return an instance of the desired atomic formula, with the desired parameters
	 */
	public FoLtlFormula formulaFactory(FormulaType type, FoLtlTerm left, FoLtlTerm right,
																		 FoLtlPredicate predicate, LinkedList<FoLtlTerm> arguments){

		FoLtlFormula res;

		switch(type){

			case TEMP_LAST_ATOM:
				res = new FoLtlTempLastAtom();
				break;

			case LOCAL_EQUALITY:
				res = new FoLtlLocalEqualityFormula(left, right);
				break;

			case LOCAL_ATOM:
				res = new FoLtlLocalAtom(predicate);
				Iterator<FoLtlTerm> i = arguments.iterator();

				while (i.hasNext()){
					FoLtlTerm t = i.next();
					((FoLtlLocalAtom) res).addArguments(t);
				}

				break;

			case LOCAL_TRUE_ATOM:
				res = new FoLtlLocalTrueAtom();
				break;

			case LOCAL_FALSE_ATOM:
				res = new FoLtlLocalFalseAtom();
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

	
}
