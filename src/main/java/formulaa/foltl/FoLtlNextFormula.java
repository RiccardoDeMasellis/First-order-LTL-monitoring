package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfNextFormula;
import formula.ltlf.LTLfTempNotFormula;
import formulaa.FormulaType;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlNextFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlNextFormula(FoLtlFormula nestedFormula){
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.NEXT;
	}

	@Override
	public String stringOperator(){
		return "X";
	}

	@Override
	public FoLtlFormula nnf(){
		return new FoLtlNextFormula((FoLtlFormula) this.getNestedFormula().nnf());
	}

	// WARNING! We are working on finite paths: NOT(X phi) = WN NOT(phi)
	@Override
	public FoLtlFormula negate(){
		FoLtlFormula nested = (FoLtlFormula) this.getNestedFormula().negate();
		return new FoLtlWeakNextFormula(nested);
	}

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula nested = this.getNestedFormula();
		return new LTLfNextFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
