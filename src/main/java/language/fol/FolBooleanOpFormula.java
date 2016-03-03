package language.fol;

import language.OperatorType;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface FolBooleanOpFormula extends FolFormula, language.BooleanOpFormula {

	@Override
	default FolFormula boolFormulaFactory(OperatorType op, language.Formula left, language.Formula right){
		FolFormula res;

		switch (op){

			case NOT:
				res = new FolNotFormula((FolFormula) left);
				break;

			case AND:
				res = new FolAndFormula((FolFormula) left, (FolFormula) right);
				break;

			case OR:
				res = new FolOrFormula((FolFormula) left, (FolFormula) right);
				break;

			case IMPL:
				res = new FolImplFormula((FolFormula) left, (FolFormula) right);
				break;

			case DIMPL:
				res = new FolDoubleImplFormula((FolFormula) left, (FolFormula) right);
				break;

			default:
				throw new RuntimeException("Unknown operator type");

		}

		return res;
	}

}
