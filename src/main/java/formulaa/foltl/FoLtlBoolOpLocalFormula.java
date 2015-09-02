package formulaa.foltl;

import formulaa.OperatorType;
import net.sf.tweety.logics.fol.syntax.FolFormula;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlBoolOpLocalFormula extends FoLtlBoolOpFormula, FoLtlLocalFormula {

	@Override
	default FolFormula toTweetyFol(){
		return ((FoLtlLocalFormula) this.nnf()).toTweetyFol();
	}

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
