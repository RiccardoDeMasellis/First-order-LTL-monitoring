package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempAndFormula;
import formula.ltlf.LTLfTempImplFormula;
import formulaa.ImplFormula;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlTempImplFormula extends FoLtlBinaryFormula implements ImplFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempImplFormula(FoLtlFormula left, FoLtlFormula right) {
		super(left, right);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_IMPLICATION;
	}

	@Override
	public String stringOperator(){
		return "TeIMPL";
	}

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula left = this.getLeftFormula();
		FoLtlFormula right = this.getRightFormula();
		return new LTLfTempImplFormula(left.toLTLf(foltlTOltlf, ltlfTOfoltl), right.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
