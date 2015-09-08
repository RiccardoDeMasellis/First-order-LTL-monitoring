package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfGloballyFormula;
import formula.ltlf.LTLfTempNotFormula;

import java.util.HashMap;

/**
 * Created by Simone Calciolari on 06/08/15.
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

	/**
	 * Returns the negation normal form of this formula
	 * @return
	 */
	//G(phi) == false R phi
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = this.getNestedFormula().clone();
		return new FoLtlReleaseFormula(new FoLtlLocalFalseAtom(), nested).nnf();
	}

	/**
	 * Returns the negation of this formula
	 * @return
	 */
	@Override
	public FoLtlFormula negate(){
		return (FoLtlFormula) this.nnf().negate();
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
		return new LTLfGloballyFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
