import formulaa.foltl.*;
import org.fest.assertions.ThrowableAssert;
import org.junit.Assert;
import org.junit.Test;
import util.FoLtlSortManager;

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
					"Expected: RuntimeException: Constant c does not belong to the specified domain\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Constant c does not belong to the specified domain",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a, b}; Sort2 := {b};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant b has already been assigned to some other sort\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Constant b has already been assigned to some other sort",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Some constants of the domain were not assigned to any sort\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Some constants of the domain were not assigned to any sort",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a}; Sort1 := {b};";
		try {
			parseSortDefinition(input, domain);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Sort Sort1 has already been defined\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Sort Sort1 has already been defined",
					"RuntimeException: " + e.getMessage());
		}
	}

	@Test
	public void testSortAssignmentParsing(){
		System.out.println("*** SORT ASSIGNMENT PARSING TEST *** \n");

		//Declaring stuff
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");

		HashSet<FoLtlVariable> variables = parseVariableSet("x", "y");
		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlVariable z = new FoLtlVariable("z");

		LinkedHashSet<FoLtlSort> sorts = parseSortDefinition("Sort1 := {a}; Sort2 := {b};", domain);
		FoLtlSort sort1 = new FoLtlSort("Sort1");
		sort1.add(a);

		FoLtlSort sort2 = new FoLtlSort("Sort2");
		sort2.add(b);

		String input = "?x <- Sort1; ?y <-Sort2;";
		HashMap<FoLtlVariable, FoLtlSort> computed = parseSortAssignment(input, variables, sorts);
		HashMap<FoLtlVariable, FoLtlSort> expected = new HashMap<>();
		expected.put(x, sort1);
		expected.put(y, sort2);
		assertEquals(input, expected, computed);

		input = "?x <- Sort1; ?y <-Sort1;";
		computed = parseSortAssignment(input, variables, sorts);
		expected = new HashMap<>();
		expected.put(x, sort1);
		expected.put(y, sort1);
		assertEquals(input, expected, computed);


		System.out.println("Testing exceptions\n");

		input = "?x <- Sort1;";
		try {
			parseSortAssignment(input, variables, sorts);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Not all variables were sorted\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Not all variables were sorted",
					"RuntimeException: " + e.getMessage());
		}

		input = "?x <- Sort1; ?y <-Sort1; ?z <- Sort2;";
		try {
			parseSortAssignment(input, variables, sorts);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Variable ?z was not specified\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Variable ?z was not specified",
					"RuntimeException: " + e.getMessage());
		}

		input = "?x <- Sort1; ?y <- Sort3;";
		try {
			parseSortAssignment(input, variables, sorts);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Sort Sort3 was not specified\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Sort Sort3 was not specified",
					"RuntimeException: " + e.getMessage());
		}

		input = "?x <- Sort1; ?y <-Sort1; ?x <- Sort2;";
		try {
			parseSortAssignment(input, variables, sorts);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Variable ?x has already been sorted\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Variable ?x has already been sorted",
					"RuntimeException: " + e.getMessage());
		}

	}

	@Test
	public void testSortManagerDefinition(){
		System.out.println("*** SORT MANAGER DEFINITION TEST *** \n");

		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b");

		FoLtlSortManager sortManager = new FoLtlSortManager(domain);

		String input = "Sort1 := {a}; Sort2 := {b};";
		LinkedHashSet<FoLtlSort> computed = sortManager.parseSortDefinition(input);
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
		sortManager.setDomain(domain);
		computed = sortManager.parseSortDefinition(input);
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
		sortManager.setDomain(domain);

		input = "Sort1 := {a, c}; Sort2 := {b};";
		try {
			sortManager.parseSortDefinition(input);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant c does not belong to the specified domain\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Constant c does not belong to the specified domain",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a, b}; Sort2 := {b};";
		try {
			sortManager.parseSortDefinition(input);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Constant b has already been assigned to some other sort\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Constant b has already been assigned to some other sort",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a};";
		try {
			sortManager.parseSortDefinition(input);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Some constants of the domain were not assigned to any sort\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Some constants of the domain were not assigned to any sort",
					"RuntimeException: " + e.getMessage());
		}

		input = "Sort1 := {a}; Sort1 := {b};";
		try {
			sortManager.parseSortDefinition(input);
			Assert.fail(input + "\n" +
					"FAIL: Exception not thrown\n" +
					"Expected: RuntimeException: Sort Sort1 has already been defined\n");
		} catch (RuntimeException e){
			assertEquals(input, "RuntimeException: Sort Sort1 has already been defined",
					"RuntimeException: " + e.getMessage());
		}
	}

	@Test
	public void testSortManagerAssignment(){
		System.out.println("*** TEST SORT MANAGER ASSIGNMENT ***\n");

		//Declaring stuff
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b", "c");

		FoLtlSortManager sortManager = new FoLtlSortManager(domain);
		sortManager.parseSortDefinition("Sort1 := {a, b}; Sort2 := {c};");

		FoLtlSort sort1 = new FoLtlSort("Sort1");
		sort1.add(new FoLtlConstant("a"));
		sort1.add(new FoLtlConstant("b"));

		FoLtlSort sort2 = new FoLtlSort("Sort2");
		sort2.add(new FoLtlConstant("c"));

		String finput = "Forall ?x (P(?x))";
		String sinput = "?x <- Sort1;";
		FoLtlFormula formula = parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		HashMap<FoLtlVariable, FoLtlSort> sortAssignment = new HashMap<>();
		sortAssignment.put(new FoLtlVariable("x"), sort1);
		System.out.println("Formula: " + formula + "; SortAssignment: " + sinput + "\n");
		for (FoLtlVariable v : formula.getLocalVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}
		for (FoLtlVariable v : formula.getAcrossVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}

		finput = "Forall ?x (Exists ?y (P(?x, ?y)))";
		sinput = "?x <- Sort1; ?y <- Sort2;";
		formula = parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		sortAssignment = new HashMap<>();
		sortAssignment.put(new FoLtlVariable("x"), sort1);
		sortAssignment.put(new FoLtlVariable("y"), sort2);
		System.out.println("Formula: " + formula + "; SortAssignment: " + sinput + "\n");
		for (FoLtlVariable v : formula.getLocalVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}
		for (FoLtlVariable v : formula.getAcrossVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}

		finput = "Forall ?x (G (Exists ?y (P(?x, ?y))))";
		sinput = "?x <- Sort1; ?y <- Sort2;";
		formula = parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		sortAssignment = new HashMap<>();
		sortAssignment.put(new FoLtlVariable("x"), sort1);
		sortAssignment.put(new FoLtlVariable("y"), sort2);
		System.out.println("Formula: " + formula + "; SortAssignment: " + sinput + "\n");
		for (FoLtlVariable v : formula.getLocalVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}
		for (FoLtlVariable v : formula.getAcrossVariables()){
			assertEquals("Variable: " + v.toString(), sortAssignment.get(v), v.getSort());
		}

	}

	@Test
	public void testSortExpansion(){
		System.out.println("*** TEST SORT EXPANSION ***\n");

		//Declaring stuff
		LinkedHashSet<FoLtlConstant> domain = parseConstantSet("a", "b", "c");

		FoLtlSortManager sortManager = new FoLtlSortManager(domain);
		sortManager.parseSortDefinition("Sort1 := {a, b}; Sort2 := {c};");

		FoLtlSort sort1 = new FoLtlSort("Sort1");
		sort1.add(new FoLtlConstant("a"));
		sort1.add(new FoLtlConstant("b"));

		FoLtlSort sort2 = new FoLtlSort("Sort2");
		sort2.add(new FoLtlConstant("c"));

		String finput = "Forall ?x (P(?x))";
		String sinput = "?x <- Sort1;";
		FoLtlLocalFormula formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("P(b) && P(a)"),
				formula.quantifierExpansion(domain));

		finput = "Exists ?x (P(?x))";
		sinput = "?x <- Sort1;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("P(b) || P(a)"),
				formula.quantifierExpansion(domain));

		finput = "Forall ?x (P(?x))";
		sinput = "?x <- Sort2;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("P(c)"),
				formula.quantifierExpansion(domain));

		finput = "Exists ?x (P(?x))";
		sinput = "?x <- Sort2;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("P(c)"),
				formula.quantifierExpansion(domain));

		finput = "Exists ?x (P(?x) && P(c))";
		sinput = "?x <- Sort1;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("(P(b) && P(c)) || (P(a) && P(c))"),
				formula.quantifierExpansion(domain));

		finput = "Exists ?x P(?x)";
		sinput = "?x <- Sort1;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		FoLtlLocalFormula nnf = (FoLtlLocalFormula) formula.nnf();
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("P(b) | P(a)"),
				nnf.quantifierExpansion(domain));

		finput = "!(Exists ?x P(?x))";
		sinput = "?x <- Sort1;";
		formula = (FoLtlLocalFormula) parseFoLtlFormula(finput);
		sortManager.assignSort(formula, sinput);
		nnf = (FoLtlLocalFormula) formula.nnf();
		assertEquals("Formula: " + formula + "; SortAssignment: " + sinput, parseFoLtlFormula("!P(b) && !P(a)"),
				nnf.quantifierExpansion(domain));


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
