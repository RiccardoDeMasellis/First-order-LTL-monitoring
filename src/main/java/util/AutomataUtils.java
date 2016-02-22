package util;

import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlFormula;
import rationals.Automaton;
import rationals.transformations.ToDFA;
import utils.AutomatonUtils;

import java.util.HashMap;
import java.util.LinkedHashSet;

import static automata.AutomataTranslator.ldlfAutomataToFoLtl;

/**
 * AutomataUtils
 * <br>
 * Created by Simone Calciolari on 16/02/16.
 * @author Simone Calciolari.
 */
public class AutomataUtils {

	public static Automaton buildFoLtlAutomaton(FoLtlFormula formula, LinkedHashSet<FoLtlConstant> domain){

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltlfFormula = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LDLfFormula ldlfFormula = ltlfFormula.toLDLf();

		Automaton ldlAutomaton = AutomatonUtils.ldlf2Automaton(ldlfFormula, ldlfFormula.getSignature());

		//Minimization
		ldlAutomaton = new ToDFA<>().transform(ldlAutomaton);

		return ldlfAutomataToFoLtl(ldlAutomaton, ltlfTOfoltl, domain);
	}

}
