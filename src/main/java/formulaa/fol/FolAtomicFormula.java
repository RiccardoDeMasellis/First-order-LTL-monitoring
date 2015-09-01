package formulaa.fol;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public abstract class FolAtomicFormula implements FolFormula, formulaa.AtomicFormula {

	@Override
	public FolFormula negate(){
		return new FolNotFormula(this.clone());
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
	public FolFormula clone(){
		return this.formulaFactory(this.getFormulaType(), null, null, null, null);
	}

	/**
	 * used to obtain new instances of Fol atomic formulas
	 * @param type desired formula type
	 * @param left left term, used for equalities
	 * @param right right term, used for equalities
	 * @param predicate predicate, used for fol atoms
	 * @param arguments list of terms, used for fol atoms
	 * @return an instance of the desired atomic formula, with the desired parameters
	 */
	public FolFormula formulaFactory(formulaa.FormulaType type, FolTerm left, FolTerm right,
																		 FolPredicate predicate, LinkedList<FolTerm> arguments){

		FolFormula res;

		switch(type){

			case FOL_EQUALITY:
				res = new FolEqualityFormula(left, right);
				break;

			case FOL_ATOM:
				res = new FolAtom(predicate);
				Iterator<FolTerm> i = arguments.iterator();

				while (i.hasNext()){
					FolTerm t = i.next();
					((FolAtom) res).addArguments(t);
				}

				break;

			case FOL_TRUE_ATOM:
				res = new FolTrueAtom();
				break;

			case FOL_FALSE_ATOM:
				res = new FolFalseAtom();
				break;

			default:
				throw new RuntimeException("Unknown formula type");

		}

		return res;

	}

}
