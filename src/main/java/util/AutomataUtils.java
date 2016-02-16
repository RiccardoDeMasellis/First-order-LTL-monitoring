package util;

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formulaa.foltl.FoLtlFormula;
import rationals.Automaton;
import utils.AutomatonUtils;

import java.util.HashMap;

import static automata.AutomataTranslator.ldlfAutomataToFoLtl;

/**
 * AutomataUtils
 * <br>
 * Created by Simone Calciolari on 16/02/16.
 * @author Simone Calciolari.
 */
public class AutomataUtils {

	public static Automaton buildFoLtlAutomaton(FoLtlFormula formula){

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltlfFormula = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LDLfFormula ldlfFormula = ltlfFormula.toLDLf();

		Automaton ldlAutomaton = AutomatonUtils.ldlf2Automaton(ldlfFormula, ldlfFormula.getSignature());
		return ldlfAutomataToFoLtl(ldlAutomaton, ltlfTOfoltl);
	}

}
