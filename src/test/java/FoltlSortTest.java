import formula.foltl.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Simone Calciolari on 19/08/15.
 */
public class FoltlSortTest {

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

		sort1bis.add(a);

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
			System.out.println(description + ": NOT EQUALS");
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}
