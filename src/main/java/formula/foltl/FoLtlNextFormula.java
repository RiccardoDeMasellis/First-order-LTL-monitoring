package formula.foltl;

import formula.FormulaType;

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

	@Override
	public FoLtlFormula negate(){
		return new FoLtlNextFormula((FoLtlFormula) this.getNestedFormula().negate());
	}

}
