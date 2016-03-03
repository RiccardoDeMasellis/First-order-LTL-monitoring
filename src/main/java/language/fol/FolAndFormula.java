package language.fol;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolAndFormula extends FolBinaryFormula implements language.AndFormula, FolBooleanOpFormula {

	public FolAndFormula(FolFormula left, FolFormula right) {
		super(left, right);
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.FOL_AND;
	}

}
