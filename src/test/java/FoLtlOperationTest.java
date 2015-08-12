import org.junit.Assert;
import org.junit.Test;
import formula.foltl.*;

/**
 * Created by Simone Calciolari on 12/08/15.
 */
public class FoLtlOperationTest {

	@Test
	public void testEquals(){

		System.out.println("\n*** EQUALS TEST ***\n");

		System.out.println("BASIC COMPARISONS\n");

		//Term comparisons
		FoLtlTerm varX = new FoLtlVariable("x");
		FoLtlTerm varX2 = new FoLtlVariable("x");
		FoLtlTerm varY = new FoLtlVariable("y");
		FoLtlTerm conX = new FoLtlConstant("x");
		FoLtlTerm conX2 = new FoLtlConstant("x");
		FoLtlTerm conY = new FoLtlConstant("y");

		System.out.println("Term comparisons\n");

		assertEquals("Variables with the same name", varX, varX2);
		assertEquals("Constants with the same name", conX, conX2);

		System.out.println();

		assertNotEquals("Variables with different names", varX, varY);
		assertNotEquals("Constants with different names", conX, conY);
		assertNotEquals("Variable and constant with the same name", varX, conX);


		//Predicate comparisons
		FoLtlPredicate Par1 = new FoLtlPredicate("P", 1);
		FoLtlPredicate Par2 = new FoLtlPredicate("P", 2);
		FoLtlPredicate P1ar1 = new FoLtlPredicate("P", 1);
		FoLtlPredicate Qar1 = new FoLtlPredicate("Q", 1);
		FoLtlPredicate Qar2 = new FoLtlPredicate("Q", 2);

		System.out.println("\nPredicate comparisons\n");

		assertEquals("Predicates with the same name and arity", Par1, P1ar1);

		System.out.println();

		assertNotEquals("Predicates with the same name, but different arity", Par1, Par2);
		assertNotEquals("Predicates with different names, but the same arity", Par1, Qar1);


		System.out.println("\n\nATOMIC FORMULA COMPARISONS");

		//Atom comparisons
		FoLtlAtomicFormula fa = new FoLtlLocalFalseAtom();
		FoLtlAtomicFormula fab = new FoLtlLocalFalseAtom();
		FoLtlAtomicFormula ta = new FoLtlLocalTrueAtom();
		FoLtlAtomicFormula tab = new FoLtlLocalTrueAtom();
		FoLtlAtomicFormula la = new FoLtlTempLastAtom();
		FoLtlAtomicFormula lab = new FoLtlTempLastAtom();

		System.out.println("\nAtom comparisons\n");

		assertEquals("True local atoms", ta, tab);
		assertEquals("False local atoms", fa, fab);
		assertEquals("Last temporal atoms", la, lab);

		System.out.println();

		assertNotEquals("True and false atoms", fa, ta);
		assertNotEquals("True and last atoms", ta, la);
		assertNotEquals("False and last atoms", la, fa);


		//Atomic formula comparisons
		FoLtlPredicate L = new FoLtlPredicate("L", 5);

		FoLtlAtomicFormula PconX = new FoLtlLocalAtom(Par1, conX);
		FoLtlAtomicFormula PconX2 = new FoLtlLocalAtom(P1ar1, conX2);
		FoLtlAtomicFormula PconY = new FoLtlLocalAtom(Par1, conY);
		FoLtlAtomicFormula PvarX = new FoLtlLocalAtom(Par1, varX);
		FoLtlAtomicFormula PvarX2 = new FoLtlLocalAtom(P1ar1, varX2);
		FoLtlAtomicFormula PvarY = new FoLtlLocalAtom(Par1, varY);
		FoLtlAtomicFormula QvarX = new FoLtlLocalAtom(Qar1, varX);
		FoLtlAtomicFormula PconXvarX = new FoLtlLocalAtom(Par2, conX, varX);
		FoLtlAtomicFormula PconXvarX2 = new FoLtlLocalAtom(Par2, conX2, varX2);
		FoLtlAtomicFormula PvarXconX = new FoLtlLocalAtom(Par2, varX, conX);
		FoLtlAtomicFormula QvarXconX = new FoLtlLocalAtom(Qar2, varX, conX);

		FoLtlAtomicFormula LxyvYvXvX = new FoLtlLocalAtom(L, conX, conY, varY, varX2, varX);
		FoLtlAtomicFormula LxyvYvXvX2 = new FoLtlLocalAtom(L, conX, conY, varY, varX, varX2);
		FoLtlAtomicFormula LvXvYyvXx = new FoLtlLocalAtom(L, varX, varY, conY, varX2, conX2);

		System.out.println("\nLocal atom comparisons\n");

		assertEquals("Equal predicate, equal constant", PconX, PconX2);
		assertEquals("Equal predicate, equal variable", PvarX, PvarX2);
		assertEquals("Equal predicate, same argument list", PconXvarX, PconXvarX2);
		assertEquals("Longer argument list", LxyvYvXvX, LxyvYvXvX2);

		System.out.println();

		assertNotEquals("Equal predicate, different argument (var, var)", PvarX, PvarY);
		assertNotEquals("Equal predicate, different argument (con, con)", PconX, PconY);
		assertNotEquals("Equal predicate, different argument (con, var)", PconX, PvarX);
		assertNotEquals("Different predicate, same argument", PvarX, QvarX);
		assertNotEquals("Same predicate, same arguments, different order", PconXvarX, PvarXconX);
		assertNotEquals("Different predicate, same argument list", PvarXconX, QvarXconX);
		assertNotEquals("Longer argument list, different order", LxyvYvXvX, LvXvYyvXx);


		//Equality formula comparisons
		FoLtlAtomicFormula varXEqVarX2 = new FoLtlLocalEqualityFormula(varX, varX2);
		FoLtlAtomicFormula varXEqVarX22 = new FoLtlLocalEqualityFormula(varX, varX2);
		FoLtlAtomicFormula varX2EqVarX = new FoLtlLocalEqualityFormula(varX2, varX);
		FoLtlAtomicFormula varXEqVarY = new FoLtlLocalEqualityFormula(varX, varY);
		FoLtlAtomicFormula varYEqVarX2 = new FoLtlLocalEqualityFormula(varY, varX2);
		FoLtlAtomicFormula conXEqConX2 = new FoLtlLocalEqualityFormula(conX, conX2);
		FoLtlAtomicFormula conX2EqConX = new FoLtlLocalEqualityFormula(conX2, conX);

		System.out.println("\nEquality formula comparisons\n");

		assertEquals("Same arguments", varXEqVarX2, varXEqVarX22);
		assertEquals("Same arguments, inverted order", varXEqVarX2, varX2EqVarX);
		assertEquals("Equal arguments, inverted order bis", varXEqVarY, varYEqVarX2);
		assertEquals("Equal arguments (constants)", conXEqConX2, conX2EqConX);

		System.out.println();

		assertNotEquals("Different arguments", varXEqVarX2, varXEqVarY);
		assertNotEquals("Variable vs constants", varXEqVarX2, conXEqConX2);


		System.out.println("\n\nSINGLE BINARY OPERATOR FORMULA COMPARISONS\n");

		//Local boolean formulas

		FoLtlPredicate P = new FoLtlPredicate("P", 1);

		FoLtlLocalAtom Pa = new FoLtlLocalAtom(P, new FoLtlConstant("a"));
		FoLtlLocalAtom Pa2 = new FoLtlLocalAtom(P, new FoLtlConstant("a"));
		FoLtlLocalAtom Pb = new FoLtlLocalAtom(P, new FoLtlConstant("b"));
		FoLtlLocalAtom Pb2 = new FoLtlLocalAtom(P, new FoLtlConstant("b"));

		//Local AND
		FoLtlFormula aANDa = new FoLtlLocalAndFormula(Pa, Pa);
		FoLtlFormula aANDa2 = new FoLtlLocalAndFormula(Pa2, Pa2);
		FoLtlFormula aANDb = new FoLtlLocalAndFormula(Pa, Pb);
		FoLtlFormula bANDa = new FoLtlLocalAndFormula(Pb2, Pa2);
		FoLtlFormula bANDb = new FoLtlLocalAndFormula(Pb, Pb);

		//Local OR
		FoLtlFormula aORa = new FoLtlLocalOrFormula(Pa, Pa);
		FoLtlFormula aORa2 = new FoLtlLocalOrFormula(Pa2, Pa2);
		FoLtlFormula aORb = new FoLtlLocalOrFormula(Pa, Pb);
		FoLtlFormula bORa = new FoLtlLocalOrFormula(Pb2, Pa2);
		FoLtlFormula bORb = new FoLtlLocalOrFormula(Pb, Pb);

		//Local <->
		FoLtlFormula aDIa = new FoLtlLocalDoubleImplFormula(Pa, Pa);
		FoLtlFormula aDIa2 = new FoLtlLocalDoubleImplFormula(Pa2, Pa2);
		FoLtlFormula aDIb = new FoLtlLocalDoubleImplFormula(Pa, Pb);
		FoLtlFormula bDIa = new FoLtlLocalDoubleImplFormula(Pb2, Pa2);
		FoLtlFormula bDIb = new FoLtlLocalDoubleImplFormula(Pb, Pb);

		//Local ->
		FoLtlFormula aIMa = new FoLtlLocalImplFormula(Pa, Pa);
		FoLtlFormula aIMa2 = new FoLtlLocalImplFormula(Pa2, Pa2);
		FoLtlFormula aIMb = new FoLtlLocalImplFormula(Pa, Pb);
		FoLtlFormula bIMa = new FoLtlLocalImplFormula(Pb2, Pa2);
		FoLtlFormula bIMb = new FoLtlLocalImplFormula(Pb, Pb);

		assertEquals("a AND a ; a AND a", aANDa, aANDa2);
		assertEquals("a AND b ; b AND a", aANDb, bANDa);
		assertEquals("a OR a ; a OR a", aORa, aORa2);
		assertEquals("a OR b ; b OR a", aORb, bORa);
		assertEquals("a DI a ; a DI a", aDIa, aDIa2);
		assertEquals("a DI b ; b DI a", aDIb, bDIa);
		assertEquals("a IM a ; a IM a", aIMa, aIMa2);

		System.out.println();

		assertNotEquals("a AND b ; b AND b", aANDb, bANDb);
		assertNotEquals("a OR b ; b OR b", aORb, bORb);
		assertNotEquals("a DI b ; b DI b", aDIb, bDIb);
		assertNotEquals("a IM b ; b IM b", aIMb, bIMb);
		assertNotEquals("a IM b ; b IM a", aIMb, bIMa);

	}


	//<editor-fold desc="assertEquals">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param a first object to be compared
	 * @param b second object to be compared
	 */
	private static void assertEquals(String description, Object a, Object b) {

		try {
			Assert.assertEquals("", a, b);
			System.out.println("\t> " + description + ": EQUALS");
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertNotEquals">
	/**
	 * Wrapper for the Assert.assertNotEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param a first object to be compared
	 * @param b second object to be compared
	 */
	private static void assertNotEquals(String description, Object a, Object b) {

		try {
			Assert.assertNotEquals("", a, b);
			System.out.println("\t> " + description + ": NOT EQUALS");
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}
