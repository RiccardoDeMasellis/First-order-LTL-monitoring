package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempNotFormula;
import java.util.HashMap;

/**
 * Class that represents a FO-LTL temporal negation.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlTempNotFormula extends FoLtlUnaryFormula implements formulaa.NotFormula, FoLtlBoolOpTempFormula {

	public FoLtlTempNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.TEMP_NOT;
	}

	@Override
	public String stringOperator(){
		return "TeNOT";
	}

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula nested = this.getNestedFormula();
		return new LTLfTempNotFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
