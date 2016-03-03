package language.foltl;

import language.TrueAtom;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalTrueFormula;
import language.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.Tautology;

import java.util.LinkedHashSet;

/**
 * Class that represents a FO-LTL local true atom.
 * <br>
 * Created by Simone Calciolari on 06/08/15.
 * @author Simone Calciolari
 */
public class FoLtlLocalTrueAtom extends FoLtlAtomicFormula implements FoLtlLocalFormula, TrueAtom {

	@Override
	public String getAtomicName(){
		return this.toString().toUpperCase();
	}

	@Override
	public language.FormulaType getFormulaType(){
		return language.FormulaType.LOCAL_TRUE_ATOM;
	}

	@Override
	public FoLtlFormula negate(){
		return new FoLtlLocalFalseAtom();
	}

	@Override
	public LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment){
		return new LTLfLocalTrueFormula();
	}

	@Override
	public FolFormula toTweetyFol(){
		return new Tautology();
	}

	@Override
	public String toString(){
		return "TRUE";
	}
}
