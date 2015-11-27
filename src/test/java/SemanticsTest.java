import static util.ParsingUtils.*;
import static util.TweetyTranslator.*;

import formula.ltlf.*;
import formulaa.foltl.*;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.commons.syntax.Constant;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.FolSignature;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

//import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * SemanticsTest
 * <br>
 * Created by Simone Calciolari on 27/11/15.
 * @author Simone Calciolari.
 */
public class SemanticsTest {

	@Test
	public void testSubstitution(){
		System.out.println("*** TEST ASSIGNMENT SUBSTITUTION ***\n");

		FoLtlFormula computed = parseFoLtlFormula("P(?x) & P(?y) || P(?x)");
		FoLtlAssignment assignment = parseFoltlAssignment("?x <- a; ?y <- b;");
		FoLtlFormula expcted = parseFoLtlFormula("(P(a) && P(b) || P(a))");
		assertEquals(computed.toString() + " <= " + assignment.toString(),
				expcted, computed.substitute(assignment));

		computed = parseFoLtlFormula("Q(?x, ?y, ?y, ?z, ?x)");
		assignment = parseFoltlAssignment("?x <- a; ?y <- b;");
		expcted = parseFoLtlFormula("Q(a, b, b, ?z, a)");
		assertEquals(computed.toString() + " <= " + assignment.toString(),
				expcted, computed.substitute(assignment));

		FoLtlLocalAtom fla = (FoLtlLocalAtom) computed.substitute(assignment);
		FoLtlTerm first = fla.getArguments().get(0);
		FoLtlTerm last = fla.getArguments().get(4);
		assertTrue("", first == last);

		computed = parseFoLtlFormula("?x = a");
		assignment = parseFoltlAssignment("?x <- a;");
		expcted = parseFoLtlFormula("(a = a)");
		assertEquals(computed.toString() + " <= " + assignment.toString(),
				expcted, computed.substitute(assignment));

		computed = parseFoLtlFormula("Forall ?x Q(?x, ?y)");
		assignment = parseFoltlAssignment("?y <- b;");
		expcted = parseFoLtlFormula("Forall ?x Q(?x, b)");
		assertEquals(computed.toString() + " <= " + assignment.toString(),
				expcted, computed.substitute(assignment));

		computed = parseFoLtlFormula("Forall ?x (P(?x) U Q(?y) & P(?z))");
		assignment = parseFoltlAssignment("?y <- b; ?z <- c;");
		expcted = parseFoLtlFormula("Forall ?x (P(?x) U (Q(b) & P(c)))");
		assertEquals(computed.toString() + " <= " + assignment.toString(),
				expcted, computed.substitute(assignment));
	}

	@Test
	public void testQuantifierExpansion(){
		System.out.println("*** QUANTIFIER EXPANSION TEST ***\n");

		//FoLtlAssignment assignment = new FoLtlAssignment();
		LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		FoLtlFormula expected = parseFoLtlFormula("P(a)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseFoLtlFormula("TRUE");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseFoLtlFormula("FALSE");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseFoLtlFormula("a = b");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = a");
		expected = parseFoLtlFormula("a = a");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		//Simple boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(b)");
		expected = parseFoLtlFormula("! P(b)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && P(b)");
		expected = parseFoLtlFormula("P(a) && P(b)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) | P(b)");
		expected = parseFoLtlFormula("P(a) || P(b)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(b)");
		expected = parseFoLtlFormula("P(a) -> P(b)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> P(b)");
		expected = parseFoLtlFormula("P(a) <-> P(b)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		//More intricate boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		expected = parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(a) -> P(a) -> P(a)");
		expected = parseFoLtlFormula("P(a) -> (P(a) -> (P(a) -> P(a)))");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("!(!(!P(a)))");
		expected = parseFoLtlFormula("!(!(!P(a)))");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		expected = parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		assertEquals("", expected, computed.quantifierExpansion(domain));

		//Testing quantifiers and substitutions
		domain.add(new FoLtlConstant("a"));
		domain.add(new FoLtlConstant("b"));

		String input = "Exists ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		expected = parseFoLtlFormula("P(b) || P(a)");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Forall ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		expected = parseFoLtlFormula("P(b) && P(a)");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Exists ?x P(?x) && P(d)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		expected = parseFoLtlFormula("(P(b) && P(d)) || (P(a) && P(d))");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Forall ?x P(?x) -> P(?z)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		expected = parseFoLtlFormula("(P(b) -> P(?z)) && (P(a) -> P(?z))");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Exists ?x (Exists ?y (P(?x) && P(?y)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		expected = parseFoLtlFormula("(P(b) & P(b) || (P(b) & P(a))) || ((P(a) & P(b)) | (P(a) & P(a)))");
		assertEquals(input, expected, computed.quantifierExpansion(domain));


		//Testing expansion with sorts
		FoLtlSort sortAB = new FoLtlSort("AB");
		sortAB.add(new FoLtlConstant("a"));
		sortAB.add(new FoLtlConstant("b"));

		FoLtlSort sortC = new FoLtlSort("C");
		sortC.add(new FoLtlConstant("c"));

		domain.add(new FoLtlConstant("c"));

		System.out.println("\nSORT EXPANSION TEST\n");

		input = "Exists ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseFoLtlFormula("P(b) || P(a)");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Exists ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		computed.assignSort(new FoLtlVariable("x"), sortC);
		expected = parseFoLtlFormula("P(c)");
		assertEquals(input, expected, computed.quantifierExpansion(domain));

		input = "Exists ?x (Exists ?y P(?x, ?y))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseFoLtlFormula("(P(b, c) || P(b, b) || P(b, a)) || (P(a, c) || P(a, b) || P(a, a))");
		assertEquals(input, expected, computed.quantifierExpansion(domain));
	}

	@Test
	public void testStisfiability(){
		System.out.println("*** SATISFIABILITY TEST *** \n");

		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");

		System.out.println("Domain: " + domain.toString() + "\n");

		FoLtlAssignment assignment = new FoLtlAssignment();

		//<editor-fold desc="Simple satisfiable formulas" defaultstate="collapsed">
		String input = "P(a)";
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "TRUE";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "a = a";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "! P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) && P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) && ! P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) | P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) -> P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) <-> P(b)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "((P(a) -> Q(a)) -> P(a)) -> P(a)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "! (P(a) | Q(a) -> P(a) & Q(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "(P(a) <-> Q(a)) -> (!Q(a) <-> P(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "(C(a) -> A(a)) & (!C(a) -> B(a)) & (!(A(a) -> !B(a)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "(P(a) || K(a)) & (!K(a) | !V(a)) & (Q(a) | !V(a)) & (!Q(a) | S(a)) " +
				"& (!S(a) | !K(a) | M(a)) & (!M(a) | K(a) | !S(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "(A(a) | B(a) | D(a)) & (!A(a) | B(a) | !C(a)) " +
				"& (!A(a) | C(a) | D(a)) & (!A(a) | !B(a) | C(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "!((A(a) & B(a) -> C(a)) -> (A(a) -> C(a)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

		//<editor-fold desc="Simple unsatisfiable formulas" defaultstate="collapsed">
		input = "false";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "a = b";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "P(a) & !P(a)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "!P(a) <-> P(a)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "! (((P(a) -> Q(b)) -> P(a)) -> P(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "! (((A(a) & B(a)) -> C(a)) -> ((A(a) -> C(a)) | (B(a) -> C(a))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "! (((A(a) -> B(a)) -> A(a)) -> A(a))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "! ((A(a) -> B(a)) -> (!A(a) | B(a)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "! ((A(a) -> B(a)) -> (!A(a) | B(a)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "!(!(A(a) -> B(a)) -> (A(a) & !B(a)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

		//<editor-fold desc="Satisfiable formula with quantifiers" defaultstate="collapsed">
		input = "Exists ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "Forall ?x P(?x)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "Exists ?x (Exists ?y (P(?x) && P(?y)))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		//D = {1, 2}
		input = "!((Forall ?x (Exists ?y (P(?x, ?y)))) -> (Forall ?y (Exists ?x (P(?x, ?y)))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "((Forall ?x (Forall ?y (P(?x) & P(?y) -> Q(?x, ?y))))" +
				" -> (Forall ?x (P(?x) -> (Exists ?y (Q(?x, ?y))))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "(P(a, b) <-> (Exists ?x (Exists ?y (P(?x, ?y)))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));

		input = "((Forall ?x (Forall ?y (Forall ?z (P(?x, ?y) & P(?x, ?z) -> P(?y, ?z))))) " +
				"-> (Forall ?x ((Exists ?w (P(?w, ?x))) -> P(?x, ?x))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertTrue(computed + " is satisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

		//<editor-fold desc="Unsatisfiable formulas with quantifiers" defaultstate="collapsed">
		input = "(Forall ?x P(?x)) && !P(a)";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "!((Forall ?x (Forall ?y (P(?x) & P(?y) -> Q(?x, ?y))))" +
				" -> (Forall ?x (P(?x) -> (Exists ?y (Q(?x, ?y))))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));

		input = "!((Forall ?x (Forall ?y (Forall ?z (P(?x, ?y) & P(?x, ?z) -> P(?y, ?z))))) " +
				"-> (Forall ?x ((Exists ?w (P(?w, ?x))) -> P(?x, ?x))))";
		computed = (FoLtlLocalFormula) parseFoLtlFormula(input);
		assertFalse(computed + " is unsatisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

		//<editor-fold desc="Satisfiable formulas with assignments" defaultstate="collapsed">
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(?x) & (P(?y) || !P(?x))");
		assignment = parseFoltlAssignment("?x <- a; ?y <- b;");
		assertTrue(computed.substitute(assignment) + " is satisfiable", computed.isSatisfiable(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (P(?x) && P(?y))");
		assignment = parseFoltlAssignment("?y <- b;");
		assertTrue(computed.substitute(assignment) + " is satisfiable", computed.isSatisfiable(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (P(?x) && !P(?y))");
		assignment = parseFoltlAssignment("?y <- b;");
		assertTrue(computed.substitute(assignment) + " is satisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

		//<editor-fold desc="Satisfiable formulas with assignments" defaultstate="collapsed">
		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x (P(?x) && !P(?y))");
		assignment = parseFoltlAssignment("?y <- b;");
		assertFalse(computed.substitute(assignment) + " is unsatisfiable", computed.isSatisfiable(domain, assignment));
		//</editor-fold>

	}


	//<editor-fold desc="assertEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertEquals";
		}

		try {
			Assert.assertEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertNotEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertNotEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertNotEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertNotEquals";
		}

		try {
			Assert.assertNotEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertTrue" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertTrue method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param condition boolean condition to be tested
	 */
	private static void assertTrue(String description, boolean condition) {

		if (description.equals("")){
			description = "assertTrue";
		}

		try {
			Assert.assertTrue(description, condition);
			System.out.println("SUCCESS: " + description);
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertFalse" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertFalse method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param condition boolean condition to be tested
	 */
	private static void assertFalse(String description, boolean condition) {

		if (description.equals("")){
			description = "assertFalse";
		}

		try {
			Assert.assertFalse(description, condition);
			System.out.println("SUCCESS: " + description);
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>
}
