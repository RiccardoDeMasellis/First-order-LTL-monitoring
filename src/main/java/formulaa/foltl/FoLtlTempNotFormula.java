package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempNotFormula;
import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
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

	/**
	 * Translates this formula into a FLLOAT LTLf formula, where to every original local (FOL) formula
	 * corresponds an atomic proposition.
	 * @param foltlTOltlf a map that allows to transform foltl local formulas to ltlf atomic proposition
	 * @param ltlfTOfoltl a map that allows to do the inverse
	 * @return the newly built LTLf formula
	 */
	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula nested = this.getNestedFormula();
		return new LTLfTempNotFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
