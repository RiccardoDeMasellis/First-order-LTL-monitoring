package formulaa.foltl;

import formulaa.OperatorType;
import net.sf.tweety.logics.fol.syntax.FolFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlBoolOpLocalFormula extends FoLtlBoolOpFormula, FoLtlLocalFormula {

	/**
	 * Translates this formula into an equivalent FolFormula using Tweety data structures
	 * @return
	 */
	@Override
	default FolFormula toTweetyFol(){
		return ((FoLtlLocalFormula) this.nnf()).toTweetyFol();
	}

	/**
	 * Builds an instance of a local boolean formula with the desired parameters
	 * @param op the boolean operator
	 * @param left the left sub formula (used as nested for NOT operator)
	 * @param right the right sub formula
 	 * @return the desired instance
	 */
	@Override
	default FoLtlFormula boolFormulaFactory(OperatorType op, formulaa.Formula left, formulaa.Formula right){
		FoLtlFormula res;

		switch (op){

			case NOT:
				res = new FoLtlLocalNotFormula((FoLtlFormula) left);
				break;

			case AND:
				res = new FoLtlLocalAndFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case OR:
				res = new FoLtlLocalOrFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case IMPL:
				res = new FoLtlLocalImplFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case DIMPL:
				res = new FoLtlLocalDoubleImplFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			default:
				throw new RuntimeException("Unknown operator type");

		}

		return res;
	}

}
