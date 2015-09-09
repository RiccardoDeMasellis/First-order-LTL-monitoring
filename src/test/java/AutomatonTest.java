import formula.ldlf.LDLfFormula;
import formula.ltlf.LTLfFormula;
import formulaa.foltl.FoLtlFormula;
import net.sf.tweety.logics.pl.semantics.PossibleWorld;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalSignature;
import org.junit.Test;
import rationals.Automaton;
import utils.AutomatonUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

import static util.ParsingUtils.*;

/**
 * AutomatonTest
 * <br>
 * Created by Simone Calciolari on 09/09/15.
 *
 * @author Simone Calciolari.
 */
public class AutomatonTest {

	@Test
	public void testAutomaton(){
		parseFoLtlFormula("P(a)");
		System.out.println();

		FoLtlFormula formula = parseFoLtlFormula("Forall ?x (G ((Exists ?y P(?y, a)) WU Q(?x, b)))");
		System.out.println(formula);

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		LTLfFormula ltLfFormula = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		System.out.println(ltLfFormula);
		System.out.println(foltlTOltlf);
		System.out.println(ltlfTOfoltl);

		LDLfFormula ldLfFormula = ltLfFormula.toLDLf();

		Automaton automaton = AutomatonUtils.ldlf2Automaton(ldLfFormula, ldLfFormula.getSignature());

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("ltlfAutomaton.gv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintStream ps = new PrintStream(fos);
		ps.println(AutomatonUtils.toDot(automaton));
		ps.flush();
		ps.close();

	}

	@Test
	public void testPossibleWorlds(){

		Proposition a = new Proposition("a");
		Proposition b = new Proposition("b");

		HashSet<Proposition> props = new HashSet<>();
		props.add(a);
		PossibleWorld pw = new PossibleWorld(props);
		System.out.println(pw);

		PropositionalSignature sig = new PropositionalSignature();
		sig.add(a);
		sig.add(b);
		System.out.println(sig);

		System.out.println(pw.getCompleteConjunction(sig));

	}

}
