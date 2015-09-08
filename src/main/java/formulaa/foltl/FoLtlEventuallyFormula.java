package formulaa.foltl;

import formula.ltlf.LTLfEventuallyFormula;
import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfTempNotFormula;

import java.util.HashMap;

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

	/**
	 * Returns the negation normal form of this formula
	 * @return
	 */
	//F(phi) == true U phi
	@Override
	public FoLtlFormula nnf(){
		FoLtlFormula nested = this.getNestedFormula().clone();
		return new FoLtlUntilFormula(new FoLtlLocalTrueAtom(), nested).nnf();
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
		return new LTLfEventuallyFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
