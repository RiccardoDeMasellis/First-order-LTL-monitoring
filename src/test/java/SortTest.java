import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlSort;
import formulaa.foltl.FoLtlVariable;
import org.fest.assertions.ThrowableAssert;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static util.ParsingUtils.*;

/**
 * SortTest
 * <br>
 * Created by Simone Calciolari on 11/12/15.
 * @author Simone Calciolari.
 */
public class SortTest {

	@Test
	public void testSortDefinitionParsing(){
		System.out.println("*** SORT DEFINITION PARSING TEST *** \n");

		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");

		String input = "Sort1 := {a}; Sort2 := {b};";
		LinkedHashSet<FoLtlSort> computed = parseSortDefinition(input, domain);
		LinkedHashSet<FoLtlSort> expected = new LinkedHashSet<>();
		FoLtlSort sort = new FoLtlSort("Sort1");
		sort.addAll(parseConstantSet("a"));
		expected.add(sort);
		sort = new FoLtlSort("Sort2");
		sort.addAll(parseConstantSet("b"));
		expected.add(sort);
		assertEquals(input, expected, computed);

		domain = parseConstantSet("a", "b", "c", "d");
		input = "Sort1 := {a, c}; Sort2 := {b}; Sort3 := {d};";
		computed = parseSortDefinition(input, domain);
		expected = new LinkedHashSet<>();
		sort = new FoLtlSort("Sort1");
		sort.addAll(parseConstantSet("a", "c"));
		expected.add(sort);
		sort = new FoLtlSort("Sort2");
		sort.addAll(parseConstantSet("b"));
		expected.add(sort);
		sort = new FoLtlSort("Sort3");
		sort.addAll(parseConstantSet("d"));
		expected.add(sort);
		assertEquals(input, expected, computed);


		//Testing exceptions
		System.out.println("\nTesting exceptions\n");

		domain = parseConstantSet("a", "b");
		input = "Sort1 := {a, c}; Sort2 := {b};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant not in domain\n");
		} catch (RuntimeException e){
			System.out.println(input);
			System.out.println("\t> Thrown: " + e.getMessage() + "\n");
		}

		domain = parseConstantSet("a", "b");
		input = "Sort1 := {a, b}; Sort2 := {b};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant already sorted\n");
		} catch (RuntimeException e){
			System.out.println(input);
			System.out.println("\t> Thrown: " + e.getMessage() + "\n");
		}

		domain = parseConstantSet("a", "b");
		input = "Sort1 := {a};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant not sorted\n");
		} catch (RuntimeException e){
			System.out.println(input);
			System.out.println("\t> Thrown: " + e.getMessage() + "\n");
		}
	}

	@Test
	public void testSortAssignmentParsing(){
		System.out.println("*** SORT ASSIGNMENT PARSING TEST *** \n");

		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");
		HashSet<FoLtlVariable> variables = parseVariableSet("x", "y", "z");
		LinkedHashSet<FoLtlSort> sorts = parseSortDefinition("Sort1 := {a}; Sort2 := {b};", domain);

		System.out.println(parseSortAssignment("?x <- Sort1; ?y <- Sort1; ?z <- Sort2;", variables, sorts));

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
