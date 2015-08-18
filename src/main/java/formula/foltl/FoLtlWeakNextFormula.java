package formula.foltl;

import formula.FormulaType;

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

	//WX (phi) == !(X (!phi))
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = this.getNestedFormula().clone();
		return (FoLtlFormula) new FoLtlNextFormula((FoLtlFormula) nested.negate()).nnf().negate();
	}

	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
	}

}
