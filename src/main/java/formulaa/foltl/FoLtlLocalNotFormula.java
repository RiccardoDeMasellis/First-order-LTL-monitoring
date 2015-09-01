package formulaa.foltl;

import formulaa.FormulaType;
import formulaa.NotFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalNotFormula;

import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FoLtlLocalNotFormula extends FoLtlUnaryFormula implements NotFormula, FoLtlBoolOpLocalFormula{

	public FoLtlLocalNotFormula(FoLtlFormula nestedFormula) {
		super(nestedFormula);
	}

	@Override
	public FormulaType getFormulaType(){
		return FormulaType.LOCAL_NOT;
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		FoLtlLocalFormula nested = (FoLtlLocalFormula) this.getNestedFormula();
		return new LTLfLocalNotFormula(nested.propositionalize(domain, assignment));
	}

}
