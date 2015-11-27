import formulaa.foltl.*;
import formulaa.foltl.semantics.FoLtlAssignment;
import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 19/08/15.
 */
public class FoLtlStructuresTest {

	@Test
	public void testSortOperations(){

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");
		FoLtlConstant e = new FoLtlConstant("e");

		FoLtlSort sort1 = new FoLtlSort("sort1");
		sort1.add(a);
		sort1.add(b);
		System.out.println(sort1.toString());

		FoLtlSort sort2 = new FoLtlSort("sort2");
		sort2.add(c);
		sort2.add(d);

		FoLtlVariable x = new FoLtlVariable("x", sort1);
		FoLtlVariable y = new FoLtlVariable("y", sort2);

		//EQUALS
		System.out.println("\nEQUALS TEST\n");
		FoLtlSort sort1bis = new FoLtlSort("sort1");
		sort1bis.add(b);

		assertNotEquals("", sort1, sort1bis);
		assertNotEquals("", sort1, sort2);

		sort2.clear();
		sort2.add(a);
		sort2.add(b);

		assertNotEquals("", sort1, sort2);
		System.out.println();

		sort1bis.clear();
		sort1bis.add(a);
		sort1bis.add(b);

		assertEquals("", sort1, sort1bis);
		assertEquals("", sort1.hashCode(), sort1bis.hashCode());


		//CLONE
		System.out.println("\nCLONE TEST\n");

		sort1bis = sort1.clone();

		assertEquals("", sort1, sort1bis);
		Assert.assertFalse(sort1 == sort1bis);

	}

	@Test
	public void testBasicSort(){

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");
		FoLtlConstant e = new FoLtlConstant("e");

		FoLtlSort sort1 = new FoLtlSort("sort1");
		sort1.add(a);
		sort1.add(b);
		System.out.println(sort1.toString());

		FoLtlSort sort2 = new FoLtlSort("sort2");
		sort2.add(c);
		sort2.add(d);

		FoLtlVariable x = new FoLtlVariable("x", sort1);
		FoLtlVariable y = new FoLtlVariable("y", sort2);

		FoLtlPredicate p = new FoLtlPredicate("P", 3);

		FoLtlLocalAtom pAtom = new FoLtlLocalAtom(p, x, e, y);

		System.out.println(pAtom.allSubstitutions().toString());

		sort1.add(e);

		System.out.println(pAtom.allSubstitutions().toString());

		sort1.clear();

		System.out.println(pAtom.allSubstitutions().toString());

	}

	@Test
	public void testParsingSort() {
		FoLtlFormula formula = parseFoLtlFormula("P(?x) && P(?x)");
		FoLtlLocalAtom left = (FoLtlLocalAtom) ((FoLtlLocalAndFormula) formula).getLeftFormula();
		FoLtlLocalAtom right = (FoLtlLocalAtom) ((FoLtlLocalAndFormula) formula).getRightFormula();

		Assert.assertTrue(left.getArguments().getFirst() == right.getArguments().getFirst());

		formula = parseFoLtlFormula("Forall ?x (G P(?x))");
		FoLtlVariable qvar = ((FoLtlAcrossForallFormula) formula).getQuantifiedVariable();
		FoLtlFormula nf = ((FoLtlAcrossForallFormula) formula).getNestedFormula();
		FoLtlLocalAtom atom = (FoLtlLocalAtom) ((FoLtlGloballyFormula) nf).getNestedFormula();

		Assert.assertTrue(qvar == atom.getArguments().getFirst());

		FoLtlLocalEqualityFormula eq = (FoLtlLocalEqualityFormula) parseFoLtlFormula("?x = ?x");
		Assert.assertTrue(eq.getLeftTerm() == eq.getRightTerm());

		System.out.println("\n*** SORT ASSIGNMENT TEST ***\n");

		formula = parseFoLtlFormula("Forall ?x (G P(?x, ?y))");

		formula.assignSort(new FoLtlVariable("x"), new FoLtlSort("sort"));

		qvar = ((FoLtlAcrossForallFormula) formula).getQuantifiedVariable();
		nf = ((FoLtlAcrossForallFormula) formula).getNestedFormula();
		atom = (FoLtlLocalAtom) ((FoLtlGloballyFormula) nf).getNestedFormula();

		Assert.assertTrue(qvar.getSort() == ((FoLtlVariable) atom.getArguments().getFirst()).getSort());
		assertEquals("", qvar.getSort(), ((FoLtlVariable) atom.getArguments().getFirst()).getSort());

	}

	@Test
	public void	testAssignmentParsing(){
		System.out.println("*** TEST ASSIGNMENT PARSING ***\n");

		FoLtlAssignment computed = parseFoltlAssignment("");
		FoLtlAssignment expected = new FoLtlAssignment();
		assertEquals("", expected, computed);

		computed = parseFoltlAssignment("?x <- a; ?y <- b;");
		expected = new FoLtlAssignment();
		expected.put(new FoLtlVariable("x"), new FoLtlConstant("a"));
		expected.put(new FoLtlVariable("y"), new FoLtlConstant("b"));
		assertEquals("", expected, computed);

		computed = parseFoltlAssignment("?x <- a; ?y <- b; ?x <- b;");
		expected = new FoLtlAssignment();
		expected.put(new FoLtlVariable("x"), new FoLtlConstant("a"));
		expected.put(new FoLtlVariable("y"), new FoLtlConstant("b"));
		expected.put(new FoLtlVariable("x"), new FoLtlConstant("b"));
		assertEquals("", expected, computed);
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

}
