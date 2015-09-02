package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempNotFormula;
import formula.ltlf.LTLfWeakNextFormula;
import formulaa.FormulaType;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlWeakNextFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlWeakNextFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.WEAK_NEXT;
	}

	@Override
	public String stringOperator() {
		return "WX";
	}

	// WARNING! We are working on finite paths! Just call nnf() recursively.
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = (FoLtlFormula)this.getNestedFormula().nnf();
		return new FoLtlWeakNextFormula(nested);
	}

	// WARNING! We are working on finite paths! NOT(X phi) = WX NOT(phi)
	@Override
	public FoLtlFormula negate(){
		FoLtlFormula nested = (FoLtlFormula)this.getNestedFormula().negate();
		return new FoLtlNextFormula(nested);
	}

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula nested = this.getNestedFormula();
		return new LTLfWeakNextFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
