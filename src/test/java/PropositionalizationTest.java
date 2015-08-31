import static util.ParsingUtils.*;

import formula.foltl.*;
import formula.ltlf.LTLfFormula;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 31/08/15.
 */
public class PropositionalizationTest {

	@Test
	public void testPropositionalization(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		parseLTLfFormula("pa");
		System.out.println("\n\n*** FOLTL LOCAL FORMULA PROPOSITIONALIZATION TEST ***\n");

		FoLtlAssignment assignment = new FoLtlAssignment();
		HashSet<FoLtlConstant> domain = new HashSet<>();

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		LTLfFormula expected = parseLTLfFormula("pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseLTLfFormula("TRUE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseLTLfFormula("FALSE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseLTLfFormula("false");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = a");
		expected = parseLTLfFormula("TRUE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//Simple boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && P(b)");
		expected = parseLTLfFormula("pa & pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) | P(b)");
		expected = parseLTLfFormula("pa | pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(b)");
		expected = parseLTLfFormula("pa -> pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> P(b)");
		expected = parseLTLfFormula("pa <-> pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//More intricate boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		expected = parseLTLfFormula("pp || qa && ! vr -> js");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> (P(a) -> (P(a) -> P(a)))");
		expected = parseLTLfFormula("pa -> (pa -> (pa -> pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("!(!(!P(a)))");
		expected = parseLTLfFormula("!(!(!pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		expected = parseLTLfFormula("pa && (pc || (pb | pd)) -> (ps && prst)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//Testing quantifiers and substitutions
		domain.add(new FoLtlConstant("a"));
		domain.add(new FoLtlConstant("b"));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		expected = parseLTLfFormula("pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseLTLfFormula("pa && pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x) && P(d)");
		expected = parseLTLfFormula("(pa && pd) || (pb && pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x) -> P(d)");
		expected = parseLTLfFormula("(pa -> pd) && (pb -> pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y (P(?x) && P(?y)))");
		expected = parseLTLfFormula("((pa && pa) || (pa && pb)) || ((pb && pa) || (pb && pb))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));





	}

	//<editor-fold desc="assertEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertEquals(String description, Object expected, Object computed) {

		try {
			Assert.assertEquals(description, expected, computed);
			System.out.println(description + ": EQUALS");
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

		try {
			Assert.assertNotEquals("", expected, computed);
			System.out.println("\t> " + description + ": NOT EQUALS");
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}
