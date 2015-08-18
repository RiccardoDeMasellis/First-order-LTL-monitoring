package formula.foltl;

import formula.OperatorType;
import formula.Formula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlBoolOpLocalFormula extends FoLtlBoolOpFormula, FoLtlLocalFormula {

	@Override
	default FoLtlFormula boolFormulaFactory(OperatorType op, Formula left, Formula right){
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
