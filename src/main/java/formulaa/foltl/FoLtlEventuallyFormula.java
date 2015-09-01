package formulaa.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlEventuallyFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlEventuallyFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.EVENTUALLY;
	}

	@Override
	public String stringOperator() {
		return "F";
	}

	//F(phi) == true U phi
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = this.getNestedFormula().clone();
		return new FoLtlUntilFormula(new FoLtlLocalTrueAtom(), nested).nnf();
	}

	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
	}

}
