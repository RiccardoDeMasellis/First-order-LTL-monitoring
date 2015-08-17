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

		//Local binary boolean operators

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

		System.out.println("Local binary boolean operator comparisons\n");

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


		//Temporal binary boolean operators

		// Temporal AND
		FoLtlFormula atANDa = new FoLtlTempAndFormula(Pa, Pa);
		FoLtlFormula atANDa2 = new FoLtlTempAndFormula(Pa2, Pa2);
		FoLtlFormula atANDb = new FoLtlTempAndFormula(Pa, Pb);
		FoLtlFormula btANDa = new FoLtlTempAndFormula(Pb2, Pa2);
		FoLtlFormula btANDb = new FoLtlTempAndFormula(Pb, Pb);

		//Temporal OR
		FoLtlFormula atORa = new FoLtlTempOrFormula(Pa, Pa);
		FoLtlFormula atORa2 = new FoLtlTempOrFormula(Pa2, Pa2);
		FoLtlFormula atORb = new FoLtlTempOrFormula(Pa, Pb);
		FoLtlFormula btORa = new FoLtlTempOrFormula(Pb2, Pa2);
		FoLtlFormula btORb = new FoLtlTempOrFormula(Pb, Pb);

		//Temporal <->
		FoLtlFormula atDIa = new FoLtlTempDoubleImplFormula(Pa, Pa);
		FoLtlFormula atDIa2 = new FoLtlTempDoubleImplFormula(Pa2, Pa2);
		FoLtlFormula atDIb = new FoLtlTempDoubleImplFormula(Pa, Pb);
		FoLtlFormula btDIa = new FoLtlTempDoubleImplFormula(Pb2, Pa2);
		FoLtlFormula btDIb = new FoLtlTempDoubleImplFormula(Pb, Pb);

		//Temporal ->
		FoLtlFormula atIMa = new FoLtlTempImplFormula(Pa, Pa);
		FoLtlFormula atIMa2 = new FoLtlTempImplFormula(Pa2, Pa2);
		FoLtlFormula atIMb = new FoLtlTempImplFormula(Pa, Pb);
		FoLtlFormula btIMa = new FoLtlTempImplFormula(Pb2, Pa2);
		FoLtlFormula btIMb = new FoLtlTempImplFormula(Pb, Pb);

		System.out.println("\nTemporal binary boolean operator comparisons\n");

		assertEquals("a tAND a ; a tAND a", atANDa, atANDa2);
		assertEquals("a tAND b ; b tAND a", atANDb, btANDa);
		assertEquals("a tOR a ; a tOR a", atORa, atORa2);
		assertEquals("a tOR b ; b tOR a", atORb, btORa);
		assertEquals("a tDI a ; a tDI a", atDIa, atDIa2);
		assertEquals("a tDI b ; b tDI a", atDIb, btDIa);
		assertEquals("a tIM a ; a tIM a", atIMa, atIMa2);

		System.out.println();

		assertNotEquals("a tAND b ; b tAND b", atANDb, btANDb);
		assertNotEquals("a tOR b ; b tOR b", atORb, btORb);
		assertNotEquals("a tDI b ; b tDI b", atDIb, btDIb);
		assertNotEquals("a tIM b ; b tIM b", atIMb, btIMb);
		assertNotEquals("a tIM b ; b tIM a", atIMb, btIMa);


		//Temporal binary operators

		//WeakUntil
		FoLtlFormula aWUa = new FoLtlWeakUntilFormula(Pa, Pa);
		FoLtlFormula aWUa2 = new FoLtlWeakUntilFormula(Pa2, Pa2);
		FoLtlFormula aWUb = new FoLtlWeakUntilFormula(Pa, Pb);
		FoLtlFormula bWUa = new FoLtlWeakUntilFormula(Pb2, Pa2);
		FoLtlFormula bWUb = new FoLtlWeakUntilFormula(Pb, Pb);

		//Release
		FoLtlFormula aRa = new FoLtlReleaseFormula(Pa, Pa);
		FoLtlFormula aRa2 = new FoLtlReleaseFormula(Pa2, Pa2);
		FoLtlFormula aRb = new FoLtlReleaseFormula(Pa, Pb);
		FoLtlFormula bRa = new FoLtlReleaseFormula(Pb2, Pa2);
		FoLtlFormula bRb = new FoLtlReleaseFormula(Pb, Pb);

		//Until
		FoLtlFormula aUa = new FoLtlUntilFormula(Pa, Pa);
		FoLtlFormula aUa2 = new FoLtlUntilFormula(Pa2, Pa2);
		FoLtlFormula aUb = new FoLtlUntilFormula(Pa, Pb);
		FoLtlFormula bUa = new FoLtlUntilFormula(Pb2, Pa2);
		FoLtlFormula bUb = new FoLtlUntilFormula(Pb, Pb);

		System.out.println("\nTemporal binary operator comparisons\n");

		assertEquals("a WU a ; a WU a", aWUa, aWUa2);
		assertEquals("a R a ; a R a", aRa, aRa2);
		assertEquals("a U a ; a U a", aUa, aUa2);

		System.out.println();

		assertNotEquals("a WU b ; b WU b", aWUb, bWUb);
		assertNotEquals("a WU b ; b WU a", aWUb, bWUa);
		assertNotEquals("a R b ; b R b", aRb, bRb);
		assertNotEquals("a R b ; b R a", aRb, bRa);
		assertNotEquals("a U b ; b U b", aUb, bUb);
		assertNotEquals("a U b ; b U a", aUb, bUa);

		//comparing different fomrula types

		System.out.println("\nSame left/right subformulas, different operators\n");

		assertNotEquals("AND ; tAND", aANDa, atANDa);
		assertNotEquals("AND ; OR", aANDa, aORa);
		assertNotEquals("tDI ; WU", atDIa, aWUa);
		assertNotEquals("U ; R", aUa, aRa);
		assertNotEquals("tAND ; tOR", atANDa, atORa);
		assertNotEquals("IM ; tIM", atIMa, aIMa);


		System.out.println("\n\nSINGLE UNARY OPERATOR FORMULA COMPARISONS\n");

		//Unary operators

		//Local not
		FoLtlFormula nA = new FoLtlLocalNotFormula(Pa);
		FoLtlFormula nA2 = new FoLtlLocalNotFormula(Pa);
		FoLtlFormula nB = new FoLtlLocalNotFormula(Pb);

		//Temporal not
		FoLtlFormula tnA = new FoLtlTempNotFormula(Pa);
		FoLtlFormula tnA2 = new FoLtlTempNotFormula(Pa);
		FoLtlFormula tnB = new FoLtlTempNotFormula(Pb);

		//Unary temporal operators

		//Globally
		FoLtlFormula gA = new FoLtlGloballyFormula(Pa);
		FoLtlFormula gA2 = new FoLtlGloballyFormula(Pa);
		FoLtlFormula gB = new FoLtlGloballyFormula(Pb);

		//Eventually
		FoLtlFormula fA = new FoLtlEventuallyFormula(Pa);
		FoLtlFormula fA2 = new FoLtlEventuallyFormula(Pa);
		FoLtlFormula fB = new FoLtlEventuallyFormula(Pb);

		//Weak next
		FoLtlFormula wxA = new FoLtlWeakNextFormula(Pa);
		FoLtlFormula wxA2 = new FoLtlWeakNextFormula(Pa);
		FoLtlFormula wxB = new FoLtlWeakNextFormula(Pb);

		//next
		FoLtlFormula xA = new FoLtlNextFormula(Pa);
		FoLtlFormula xA2 = new FoLtlNextFormula(Pa);
		FoLtlFormula xB = new FoLtlNextFormula(Pb);

		System.out.println("\nUnary operator comparisons");

		assertEquals("NOT a ; NOT a", nA, nA2);
		assertEquals("tNOT a ; tNOT a", tnA, tnA2);
		assertEquals("G a ; G a", gA, gA2);
		assertEquals("F a ; F a", fA, fA2);
		assertEquals("WX a ; WX a", wxA, wxA2);
		assertEquals("X a ; X a", xA, xA2);

		System.out.println();

		assertNotEquals("NOT a ; NOT b", nA, nB);
		assertNotEquals("tNOT a ; tNOT b", tnA, tnB);
		assertNotEquals("G a ; G b", gA, gB);
		assertNotEquals("F a ; F b", fA, fB);
		assertNotEquals("WX a ; WX b", wxA, wxB);
		assertNotEquals("X a ; X b", xA, xB);

		System.out.println("\nSame nested subformulas, different operators\n");

		assertNotEquals("NOT ; tNOT", nA, tnA);
		assertNotEquals("NOT ; G", nA, gA);
		assertNotEquals("G ; X", gA, xA);
		assertNotEquals("X ; WX", xA, wxA);
		assertNotEquals("F ; NOT", fA, nA);


		//Quantified formulas
		System.out.println("\n\nQUANTIFIED FORMULAS");

		FoLtlVariable vx = new FoLtlVariable("x");
		FoLtlVariable vy = new FoLtlVariable("y");
		FoLtlVariable vx2 = new FoLtlVariable("x");
		FoLtlVariable vy2 = new FoLtlVariable("y");

		FoLtlLocalAtom px = new FoLtlLocalAtom(P, vx);
		FoLtlLocalAtom py = new FoLtlLocalAtom(P, vy);
		FoLtlLocalAtom px2 = new FoLtlLocalAtom(P, vx);
		FoLtlLocalAtom py2 = new FoLtlLocalAtom(P, vy);

		//Local quantifiers
		FoLtlFormula forallXpx = new FoLtlLocalForallFormula(px, vx);
		FoLtlFormula forallXpx2 = new FoLtlLocalForallFormula(px2, vx2);
		FoLtlFormula forallYpx = new FoLtlLocalForallFormula(px, vy);
		FoLtlFormula forallXpy = new FoLtlLocalForallFormula(py, vx);

		FoLtlFormula existsXpx = new FoLtlLocalExistsFormula(px, vx);
		FoLtlFormula existsXpx2 = new FoLtlLocalExistsFormula(px2, vx2);
		FoLtlFormula existsYpx = new FoLtlLocalExistsFormula(px, vy);
		FoLtlFormula existsXpy = new FoLtlLocalExistsFormula(py, vx);

		//Across state quantifiers
		FoLtlFormula xsForallXpx = new FoLtlAcrossForallFormula(px, vx);
		FoLtlFormula xsForallXpx2 = new FoLtlAcrossForallFormula(px2, vx2);
		FoLtlFormula xsForallYpx = new FoLtlAcrossForallFormula(px, vy);
		FoLtlFormula xsForallXpy = new FoLtlAcrossForallFormula(py, vx);

		FoLtlFormula xsExistsXpx = new FoLtlAcrossExistsFormula(px, vx);
		FoLtlFormula xsExistsXpx2 = new FoLtlAcrossExistsFormula(px2, vx2);
		FoLtlFormula xsExistsYpx = new FoLtlAcrossExistsFormula(px, vy);
		FoLtlFormula xsExistsXpy = new FoLtlAcrossExistsFormula(py, vx);

		System.out.println("\nQuantified formula comparisons\n");

		assertEquals("Forall x px ; Forall x px", forallXpx, forallXpx2);
		assertEquals("Exists x px ; Exists x px", existsXpx, existsXpx2);
		assertEquals("xsForall x px ; xsForall x px", xsForallXpx, xsForallXpx2);
		assertEquals("xsExists x px ; xsExists x px", xsExistsXpx, xsExistsXpx2);

		System.out.println();

		assertNotEquals("Forall x px ; Forall x py", forallXpx, forallXpy);
		assertNotEquals("Forall x px ; Forall y px", forallXpx, forallYpx);
		assertNotEquals("Exists x px ; Exists x py", existsXpx, existsXpy);
		assertNotEquals("Exists x px ; Exists y px", existsXpx, existsYpx);
		assertNotEquals("xsForall x px ; xsForall x py", xsForallXpx, xsForallXpy);
		assertNotEquals("xsForall x px ; xsForall y px", xsForallXpx, xsForallYpx);
		assertNotEquals("xsExists x px ; xsExists x py", xsExistsXpx, xsExistsXpy);
		assertNotEquals("xsExists x px ; xsExists y px", xsExistsXpx, xsExistsYpx);

		System.out.println();

		assertNotEquals("Forall x px ; Exists x px", forallXpx, existsXpx);
		assertNotEquals("Forall x px ; xsForall x px", forallXpx, xsForallXpx);
		assertNotEquals("Exists x px ; xsExists x px", existsXpx, xsExistsXpx);
		assertNotEquals("xsForall x px ; xsExists x px", xsForallXpx, xsExistsXpx);

	}


	//<editor-fold desc="assertEquals" defaultstate="collapsed">
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

	//<editor-fold desc="assertNotEquals" defaultstate="collapsed">
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
