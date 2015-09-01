package formulaa.fol;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolAndFormula extends FolBinaryFormula implements formulaa.AndFormula, FolBooleanOpFormula {

	public FolAndFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.FOL_AND;
	}

}
