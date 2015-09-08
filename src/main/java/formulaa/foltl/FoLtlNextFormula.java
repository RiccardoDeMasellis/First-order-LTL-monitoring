package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfNextFormula;
import formula.ltlf.LTLfTempNotFormula;
import formulaa.FormulaType;

import java.util.HashMap;

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

	/**
	 * Returns the negation normal form of this formula
	 * @return
	 */
	@Override
	public FoLtlFormula nnf(){
		return new FoLtlNextFormula((FoLtlFormula) this.getNestedFormula().nnf());
	}

	/**
	 * Returns the negation of this formula
	 * @return
	 */
	// WARNING! We are working on finite paths: NOT(X phi) = WN NOT(phi)
	@Override
	public FoLtlFormula negate(){
		FoLtlFormula nested = (FoLtlFormula) this.getNestedFormula().negate();
		return new FoLtlWeakNextFormula(nested);
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
		return new LTLfNextFormula(nested.toLTLf(foltlTOltlf, ltlfTOfoltl));
	}

}
