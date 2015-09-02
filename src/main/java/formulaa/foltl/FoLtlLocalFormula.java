package formulaa.foltl;

import formulaa.LocalFormula;
import formula.ltlf.LTLfLocalFormula;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	FolFormula toTweetyFol();

}
