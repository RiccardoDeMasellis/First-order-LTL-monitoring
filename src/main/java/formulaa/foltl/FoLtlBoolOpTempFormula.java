package formulaa.foltl;

import formulaa.OperatorType;
import formulaa.Formula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlBoolOpTempFormula extends FoLtlBoolOpFormula, FoLtlTemporalFormula {

	/**
	 * Builds an instance of a temporal boolean formula with the desired parameters
	 * @param op the boolean operator
	 * @param left the left sub formula (used as nested for NOT operator)
	 * @param right the right sub formula
	 * @return the desired instance
	 */
	@Override
	default FoLtlFormula boolFormulaFactory(OperatorType op, Formula left, Formula right){
		FoLtlFormula res;

		switch (op){

			case NOT:
				res = new FoLtlTempNotFormula((FoLtlFormula) left);
				break;

			case AND:
				res = new FoLtlTempAndFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case OR:
				res = new FoLtlTempOrFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case IMPL:
				res = new FoLtlTempImplFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			case DIMPL:
				res = new FoLtlTempDoubleImplFormula((FoLtlFormula) left, (FoLtlFormula) right);
				break;

			default:
				throw new RuntimeException("Unknown operator type");

		}

		return res;
	}

}
