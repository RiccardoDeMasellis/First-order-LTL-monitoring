import static util.ParsingUtils.*;

import formula.ltlf.LTLfFormula;
import formulaa.foltl.*;
import net.sf.tweety.logics.commons.syntax.Constant;
import net.sf.tweety.logics.commons.syntax.Sort;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.FolSignature;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by Simone Calciolari on 31/08/15.
 */
public class ConversionsTest {

	@Test
	public void testPropositionalization(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		parseLTLfFormula("pa");
		System.out.println("\n\n*** FOLTL LOCAL FORMULA PROPOSITIONALIZATION TEST ***\n");

		FoLtlAssignment assignment = new FoLtlAssignment();
		LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();

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
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(b)");
		expected = parseLTLfFormula("!pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

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
		expected = parseLTLfFormula("pb || pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseLTLfFormula("pb && pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x) && P(d)");
		expected = parseLTLfFormula("(pb && pd) || (pa && pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x) -> P(d)");
		expected = parseLTLfFormula("(pb -> pd) && (pa -> pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y (P(?x) && P(?y)))");
		expected = parseLTLfFormula("((pb && pb) || (pb && pa)) || ((pa && pb) || (pa && pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));


		//Testing expansion with sorts

		FoLtlSort sortAB = new FoLtlSort("AB");
		sortAB.add(new FoLtlConstant("a"));
		sortAB.add(new FoLtlConstant("b"));

		FoLtlSort sortC = new FoLtlSort("C");
		sortC.add(new FoLtlConstant("c"));

		domain.add(new FoLtlConstant("c"));

		System.out.println("\nSORT PROPOSITIONALIZATION TEST\n");

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseLTLfFormula("pb || pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		computed.assignSort(new FoLtlVariable("x"), sortC);
		expected = parseLTLfFormula("pc");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y P(?x, ?y))");
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseLTLfFormula("(pbc || pbb || pba) || (pac || pab || paa)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

	}

	@Test
	public void testTweetyProps(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		parseLTLfFormula("pa");
		System.out.println("\n\n*** FOLTL LOCAL FORMULA TWEETY TRANSLATION TEST ***\n");

		FoLtlAssignment assignment = new FoLtlAssignment();
		LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		PropositionalFormula expected = parseTweetyFormula("pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseTweetyFormula("+");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseTweetyFormula("-");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseTweetyFormula("-");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = a");
		expected = parseTweetyFormula("+");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//Simple boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(b)");
		expected = parseTweetyFormula("! pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && P(b)");
		expected = parseTweetyFormula("pa && pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) | P(b)");
		expected = parseTweetyFormula("pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(b)");
		expected = parseTweetyFormula("!pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> P(b)");
		expected = parseTweetyFormula("(!pa || pb) && (!pb || pa)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//More intricate boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		expected = parseTweetyFormula("(!pp && (!qa || vr)) || js");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> (P(a) -> (P(a) -> P(a)))");
		expected = parseTweetyFormula("!pa || (!pa || (!pa || (pa)))");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("!(!(!P(a)))");
		expected = parseTweetyFormula("! (!(! pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		expected = parseTweetyFormula("(!pa || !pc && (!pb && !pd)) || ps && prst");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//Testing quantifiers and substitutions
		domain.add(new FoLtlConstant("a"));
		domain.add(new FoLtlConstant("b"));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		expected = parseTweetyFormula("pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseTweetyFormula("pa && pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x) && P(d)");
		expected = parseTweetyFormula("pa && pd || pb && pd");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x) -> P(d)");
		expected = parseTweetyFormula("(!pa || pd) && (!pb || pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y (P(?x) && P(?y)))");
		expected = parseTweetyFormula("(pa && pa || pa && pb) || (pb && pa || pb && pb)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

	}

	@Test
	public void testTweetyFols(){

		//Get parser warnings out of the way
		parseFoLtlFormula("P(a)");

		System.out.println("\n*** TWEETY FOL TRANSLATION TEST ***\n");

		FolSignature signature = new FolSignature();
		signature.add(new Constant("a"));
		signature.add(new Constant("b"));

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		FolFormula expected = parseTweetyFolFormula("type (P (Thing))\n", "P(a)", signature);
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseTweetyFolFormula("type (P (Thing))\n", "+", signature);
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseTweetyFolFormula("type (P (Thing))\n", "-", signature);
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseTweetyFolFormula("type (Eq (Thing, Thing))\n", "Eq(a, b)", signature);
		assertEquals("", expected, computed.toTweetyFol());


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
