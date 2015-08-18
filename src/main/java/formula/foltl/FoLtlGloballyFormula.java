package formula.foltl;

import formula.FormulaType;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlGloballyFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlGloballyFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.GLOBALLY;
	}

	@Override
	public String stringOperator() {
		return "G";
	}

	//G(phi) == false R phi
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = this.getNestedFormula().clone();
		return new FoLtlReleaseFormula(new FoLtlLocalFalseAtom(), nested).nnf();
	}

	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
	}

}
