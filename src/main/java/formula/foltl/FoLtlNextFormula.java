package formula.foltl;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlNextFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlNextFormula(FoLtlFormula nestedFormula){
		super(nestedFormula);
	}

	@Override
	public FoLtlFormulaType getFormulaType(){
		return FoLtlFormulaType.NEXT;
	}

	@Override
	public String stringOperator(){
		return "X";
	}

}
