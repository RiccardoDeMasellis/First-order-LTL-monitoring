package formulaa;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface BooleanOpFormula extends Formula {

	OperatorType getOpType();

	Formula boolFormulaFactory(OperatorType op,  Formula left, Formula right);

}
