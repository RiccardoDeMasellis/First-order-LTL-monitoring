package formulaa.foltl;

import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalVar;
import formulaa.LocalFormula;
import formula.ltlf.LTLfLocalFormula;
import net.sf.tweety.logics.fol.syntax.FolFormula;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public interface FoLtlLocalFormula extends FoLtlFormula, LocalFormula {

	LTLfLocalFormula propositionalize(LinkedHashSet<FoLtlConstant> domain, FoLtlAssignment assignment);

	@Override
	default LTLfFormula toLTLf(HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf,
														 HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl){
		LTLfFormula res = new LTLfLocalVar(this.getAtomicName());
		foltlTOltlf.put(this, res);
		ltlfTOfoltl.put(res, this);
		return res;
	}

	FolFormula toTweetyFol();

	String getAtomicName();
}
