package formula;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public interface BooleanOpFormula extends Formula {

	Formula boolFormulaFactory(OperatorType op,  Formula left, Formula right);

}
