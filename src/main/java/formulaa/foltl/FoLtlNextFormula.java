package formulaa.foltl;

import formulaa.FormulaType;

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

}
