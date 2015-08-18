package formula.foltl;

import formula.OperatorType;
import formula.Formula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlBoolOpTempFormula extends FoLtlBoolOpFormula, FoLtlTemporalFormula {

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
