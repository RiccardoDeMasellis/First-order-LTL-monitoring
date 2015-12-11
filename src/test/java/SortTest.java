import formulaa.foltl.FoLtlConstant;
import org.junit.Assert;
import org.junit.Test;
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

		System.out.println(parseSortDefinition("Sort1 := {a}; Sort2 := {b};", domain));
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
