package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfGloballyFormula;
import formula.ltlf.LTLfTempNotFormula;

import java.util.HashMap;

/**
 * Class that represents a FO-LTL globally formula.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlGloballyFormula extends FoLtlUnaryFormula implements FoLtlTempOpTempFormula {

	public FoLtlGloballyFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public formulaa.FormulaType getFormulaType(){
		return formulaa.FormulaType.GLOBALLY;
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

	@Override
	public LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		FoLtlFormula nested = this.getNestedFormula();
		return new LTLfGloballyFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
