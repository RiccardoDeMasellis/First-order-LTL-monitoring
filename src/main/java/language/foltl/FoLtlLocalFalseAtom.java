package language.foltl;

import language.FalseAtom;
import formula.ltlf.LTLfLocalFalseFormula;
import formula.ltlf.LTLfLocalFormula;
import language.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.Contradiction;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.LinkedHashSet;

/**
 * Class that represents a FO-LTL local false atom.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlLocalFalseAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, FalseAtom {

	@Override
	public String getAtomicName(){
		return this.toString().toUpperCase();
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.LOCAL_FALSE_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalTrueAtom();
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalFalseFormula();
	}

	@Override
	public FolFormula toTweetyFol(){
		return new Contradiction();
	}

	@Override
	public String toString(){
		return "FALSE";
	}

}
