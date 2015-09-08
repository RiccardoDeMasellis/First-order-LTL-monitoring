import formulaa.foltl.*;
import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 12/08/15.
 */
public class FoLtlOperationTest {

	//Boolean flag used to display extra information during the execution
	private static final boolean DEBUG = false;

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
		//assertEquals("Equal arguments, inverted order bis", varXEqVarY, varYEqVarX2);
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
		//assertEquals("a AND b ; b AND a", aANDb, bANDa);
		assertEquals("a OR a ; a OR a", aORa, aORa2);
		//assertEquals("a OR b ; b OR a", aORb, bORa);
		assertEquals("a DI a ; a DI a", aDIa, aDIa2);
		//assertEquals("a DI b ; b DI a", aDIb, bDIa);
		assertEquals("a IM a ; a IM a", aIMa, aIMa2);

		System.out.println();

		assertNotEquals("a AND b ; b AND b", aANDb, bANDb);
		assertNotEquals("a AND b ; b AND a", aANDb, bANDa);
		assertNotEquals("a OR b ; b OR b", aORb, bORb);
		assertNotEquals("a OR b ; b OR a", aORb, bORa);
		assertNotEquals("a DI b ; b DI b", aDIb, bDIb);
		assertNotEquals("a DI b ; b DI a", aDIb, bDIa);
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
		//assertEquals("a tAND b ; b tAND a", atANDb, btANDa);
		assertEquals("a tOR a ; a tOR a", atORa, atORa2);
		//assertEquals("a tOR b ; b tOR a", atORb, btORa);
		assertEquals("a tDI a ; a tDI a", atDIa, atDIa2);
		//assertEquals("a tDI b ; b tDI a", atDIb, btDIa);
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

	@Test
	public void testHashCode(){

		System.out.println("\n*** HASH CODE TEST ***\n");

		System.out.println("BASIC COMPARISONS\n");

		//Term comparisons
		FoLtlTerm varX = new FoLtlVariable("x");
		FoLtlTerm varX2 = new FoLtlVariable("x");
		FoLtlTerm varY = new FoLtlVariable("y");
		FoLtlTerm conX = new FoLtlConstant("x");
		FoLtlTerm conX2 = new FoLtlConstant("x");
		FoLtlTerm conY = new FoLtlConstant("y");

		System.out.println("Term comparisons\n");

		assertEquals("Variables with the same name", varX.hashCode(), varX2.hashCode());
		assertEquals("Constants with the same name", conX.hashCode(), conX2.hashCode());


		//Predicate comparisons
		FoLtlPredicate Par1 = new FoLtlPredicate("P", 1);
		FoLtlPredicate Par2 = new FoLtlPredicate("P", 2);
		FoLtlPredicate P1ar1 = new FoLtlPredicate("P", 1);
		FoLtlPredicate Qar1 = new FoLtlPredicate("Q", 1);
		FoLtlPredicate Qar2 = new FoLtlPredicate("Q", 2);

		System.out.println("\nPredicate comparisons\n");

		assertEquals("Predicates with the same name and arity", Par1.hashCode(), P1ar1.hashCode());


		System.out.println("\n\nATOMIC FORMULA COMPARISONS");

		//Atom comparisons
		FoLtlAtomicFormula fa = new FoLtlLocalFalseAtom();
		FoLtlAtomicFormula fab = new FoLtlLocalFalseAtom();
		FoLtlAtomicFormula ta = new FoLtlLocalTrueAtom();
		FoLtlAtomicFormula tab = new FoLtlLocalTrueAtom();
		FoLtlAtomicFormula la = new FoLtlTempLastAtom();
		FoLtlAtomicFormula lab = new FoLtlTempLastAtom();

		System.out.println("\nAtom comparisons\n");

		assertEquals("True local atoms", ta.hashCode(), tab.hashCode());
		assertEquals("False local atoms", fa.hashCode(), fab.hashCode());
		assertEquals("Last temporal atoms", la.hashCode(), lab.hashCode());


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

		assertEquals("Equal predicate, equal constant", PconX.hashCode(), PconX2.hashCode());
		assertEquals("Equal predicate, equal variable", PvarX.hashCode(), PvarX2.hashCode());
		assertEquals("Equal predicate, same argument list", PconXvarX.hashCode(), PconXvarX2.hashCode());
		assertEquals("Longer argument list", LxyvYvXvX.hashCode(), LxyvYvXvX2.hashCode());


		//Equality formula comparisons
		FoLtlAtomicFormula varXEqVarX2 = new FoLtlLocalEqualityFormula(varX, varX2);
		FoLtlAtomicFormula varXEqVarX22 = new FoLtlLocalEqualityFormula(varX, varX2);
		FoLtlAtomicFormula varX2EqVarX = new FoLtlLocalEqualityFormula(varX2, varX);
		FoLtlAtomicFormula varXEqVarY = new FoLtlLocalEqualityFormula(varX, varY);
		FoLtlAtomicFormula varYEqVarX2 = new FoLtlLocalEqualityFormula(varY, varX2);
		FoLtlAtomicFormula conXEqConX2 = new FoLtlLocalEqualityFormula(conX, conX2);
		FoLtlAtomicFormula conX2EqConX = new FoLtlLocalEqualityFormula(conX2, conX);

		System.out.println("\nEquality formula comparisons\n");

		assertEquals("Same arguments", varXEqVarX2.hashCode(), varXEqVarX22.hashCode());
		assertEquals("Same arguments, inverted order", varXEqVarX2.hashCode(), varX2EqVarX.hashCode());
		//assertEquals("Equal arguments, inverted order bis", varXEqVarY.hashCode(), varYEqVarX2.hashCode());
		assertEquals("Equal arguments (constants)", conXEqConX2.hashCode(), conX2EqConX.hashCode());

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

		//Local OR
		FoLtlFormula aORa = new FoLtlLocalOrFormula(Pa, Pa);
		FoLtlFormula aORa2 = new FoLtlLocalOrFormula(Pa2, Pa2);
		FoLtlFormula aORb = new FoLtlLocalOrFormula(Pa, Pb);
		FoLtlFormula bORa = new FoLtlLocalOrFormula(Pb2, Pa2);

		//Local <->
		FoLtlFormula aDIa = new FoLtlLocalDoubleImplFormula(Pa, Pa);
		FoLtlFormula aDIa2 = new FoLtlLocalDoubleImplFormula(Pa2, Pa2);
		FoLtlFormula aDIb = new FoLtlLocalDoubleImplFormula(Pa, Pb);
		FoLtlFormula bDIa = new FoLtlLocalDoubleImplFormula(Pb2, Pa2);

		//Local ->
		FoLtlFormula aIMa = new FoLtlLocalImplFormula(Pa, Pa);
		FoLtlFormula aIMa2 = new FoLtlLocalImplFormula(Pa2, Pa2);

		System.out.println("Local binary boolean operator comparisons\n");

		assertEquals("a AND a ; a AND a", aANDa.hashCode(), aANDa2.hashCode());
		//assertEquals("a AND b ; b AND a", aANDb, bANDa);
		assertEquals("a OR a ; a OR a", aORa.hashCode(), aORa2.hashCode());
		//assertEquals("a OR b ; b OR a", aORb, bORa);
		assertEquals("a DI a ; a DI a", aDIa.hashCode(), aDIa2.hashCode());
		//assertEquals("a DI b ; b DI a", aDIb, bDIa);
		assertEquals("a IM a ; a IM a", aIMa.hashCode(), aIMa2.hashCode());


		//Temporal binary boolean operators

		// Temporal AND
		FoLtlFormula atANDa = new FoLtlTempAndFormula(Pa, Pa);
		FoLtlFormula atANDa2 = new FoLtlTempAndFormula(Pa2, Pa2);
		FoLtlFormula atANDb = new FoLtlTempAndFormula(Pa, Pb);
		FoLtlFormula btANDa = new FoLtlTempAndFormula(Pb2, Pa2);

		//Temporal OR
		FoLtlFormula atORa = new FoLtlTempOrFormula(Pa, Pa);
		FoLtlFormula atORa2 = new FoLtlTempOrFormula(Pa2, Pa2);
		FoLtlFormula atORb = new FoLtlTempOrFormula(Pa, Pb);
		FoLtlFormula btORa = new FoLtlTempOrFormula(Pb2, Pa2);

		//Temporal <->
		FoLtlFormula atDIa = new FoLtlTempDoubleImplFormula(Pa, Pa);
		FoLtlFormula atDIa2 = new FoLtlTempDoubleImplFormula(Pa2, Pa2);
		FoLtlFormula atDIb = new FoLtlTempDoubleImplFormula(Pa, Pb);
		FoLtlFormula btDIa = new FoLtlTempDoubleImplFormula(Pb2, Pa2);

		//Temporal ->
		FoLtlFormula atIMa = new FoLtlTempImplFormula(Pa, Pa);
		FoLtlFormula atIMa2 = new FoLtlTempImplFormula(Pa2, Pa2);

		System.out.println("\nTemporal binary boolean operator comparisons\n");

		assertEquals("a tAND a ; a tAND a", atANDa.hashCode(), atANDa2.hashCode());
		//assertEquals("a tAND b ; b tAND a", atANDb, btANDa);
		assertEquals("a tOR a ; a tOR a", atORa.hashCode(), atORa2.hashCode());
		//assertEquals("a tOR b ; b tOR a", atORb, btORa);
		assertEquals("a tDI a ; a tDI a", atDIa.hashCode(), atDIa2.hashCode());
		//assertEquals("a tDI b ; b tDI a", atDIb, btDIa);
		assertEquals("a tIM a ; a tIM a", atIMa.hashCode(), atIMa2.hashCode());


		//Temporal binary operators

		//WeakUntil
		FoLtlFormula aWUa = new FoLtlWeakUntilFormula(Pa, Pa);
		FoLtlFormula aWUa2 = new FoLtlWeakUntilFormula(Pa2, Pa2);

		//Release
		FoLtlFormula aRa = new FoLtlReleaseFormula(Pa, Pa);
		FoLtlFormula aRa2 = new FoLtlReleaseFormula(Pa2, Pa2);

		//Until
		FoLtlFormula aUa = new FoLtlUntilFormula(Pa, Pa);
		FoLtlFormula aUa2 = new FoLtlUntilFormula(Pa2, Pa2);

		System.out.println("\nTemporal binary operator comparisons\n");

		assertEquals("a WU a ; a WU a", aWUa.hashCode(), aWUa2.hashCode());
		assertEquals("a R a ; a R a", aRa.hashCode(), aRa2.hashCode());
		assertEquals("a U a ; a U a", aUa.hashCode(), aUa2.hashCode());


		System.out.println("\n\nSINGLE UNARY OPERATOR FORMULA COMPARISONS\n");

		//Unary operators

		//Local not
		FoLtlFormula nA = new FoLtlLocalNotFormula(Pa);
		FoLtlFormula nA2 = new FoLtlLocalNotFormula(Pa);

		//Temporal not
		FoLtlFormula tnA = new FoLtlTempNotFormula(Pa);
		FoLtlFormula tnA2 = new FoLtlTempNotFormula(Pa);

		//Unary temporal operators

		//Globally
		FoLtlFormula gA = new FoLtlGloballyFormula(Pa);
		FoLtlFormula gA2 = new FoLtlGloballyFormula(Pa);

		//Eventually
		FoLtlFormula fA = new FoLtlEventuallyFormula(Pa);
		FoLtlFormula fA2 = new FoLtlEventuallyFormula(Pa);

		//Weak next
		FoLtlFormula wxA = new FoLtlWeakNextFormula(Pa);
		FoLtlFormula wxA2 = new FoLtlWeakNextFormula(Pa);

		//next
		FoLtlFormula xA = new FoLtlNextFormula(Pa);
		FoLtlFormula xA2 = new FoLtlNextFormula(Pa);

		System.out.println("\nUnary operator comparisons");

		assertEquals("NOT a ; NOT a", nA.hashCode(), nA2.hashCode());
		assertEquals("tNOT a ; tNOT a", tnA.hashCode(), tnA2.hashCode());
		assertEquals("G a ; G a", gA.hashCode(), gA2.hashCode());
		assertEquals("F a ; F a", fA.hashCode(), fA2.hashCode());
		assertEquals("WX a ; WX a", wxA.hashCode(), wxA2.hashCode());
		assertEquals("X a ; X a", xA.hashCode(), xA2.hashCode());


		//Quantified formulas
		System.out.println("\n\nQUANTIFIED FORMULAS");

		FoLtlVariable vx = new FoLtlVariable("x");
		FoLtlVariable vy = new FoLtlVariable("y");
		FoLtlVariable vx2 = new FoLtlVariable("x");

		FoLtlLocalAtom px = new FoLtlLocalAtom(P, vx);
		FoLtlLocalAtom py = new FoLtlLocalAtom(P, vy);
		FoLtlLocalAtom px2 = new FoLtlLocalAtom(P, vx);

		//Local quantifiers
		FoLtlFormula forallXpx = new FoLtlLocalForallFormula(px, vx);
		FoLtlFormula forallXpx2 = new FoLtlLocalForallFormula(px2, vx2);

		FoLtlFormula existsXpx = new FoLtlLocalExistsFormula(px, vx);
		FoLtlFormula existsXpx2 = new FoLtlLocalExistsFormula(px2, vx2);

		//Across state quantifiers
		FoLtlFormula xsForallXpx = new FoLtlAcrossForallFormula(px, vx);
		FoLtlFormula xsForallXpx2 = new FoLtlAcrossForallFormula(px2, vx2);

		FoLtlFormula xsExistsXpx = new FoLtlAcrossExistsFormula(px, vx);
		FoLtlFormula xsExistsXpx2 = new FoLtlAcrossExistsFormula(px2, vx2);

		System.out.println("\nQuantified formula comparisons\n");

		assertEquals("Forall x px ; Forall x px", forallXpx.hashCode(), forallXpx2.hashCode());
		assertEquals("Exists x px ; Exists x px", existsXpx.hashCode(), existsXpx2.hashCode());
		assertEquals("xsForall x px ; xsForall x px", xsForallXpx.hashCode(), xsForallXpx2.hashCode());
		assertEquals("xsExists x px ; xsExists x px", xsExistsXpx.hashCode(), xsExistsXpx2.hashCode());

	}

	@Test
	public void testClone(){

		System.out.println("\n*** CLONE TEST ***\n");

		System.out.println("BASIC COMPARISONS\n");

		//Term comparisons
		FoLtlTerm varX = new FoLtlVariable("x");
		FoLtlTerm conX = new FoLtlConstant("x");

		System.out.println("Term clone\n");

		assertEquals("Variable", varX, varX.clone());
		Assert.assertFalse(varX == varX.clone());

		assertEquals("Constant", conX, conX.clone());
		Assert.assertFalse(conX == conX.clone());


		//Predicate comparisons
		FoLtlPredicate p = new FoLtlPredicate("P", 2);

		System.out.println("\nPredicate clone\n");

		assertEquals("Predicate", p, p.clone());
		Assert.assertFalse(p == p.clone());


		System.out.println("\n\nATOMIC FORMULA COMPARISONS");


		//Atom comparisons
		FoLtlAtomicFormula fa = new FoLtlLocalFalseAtom();
		FoLtlAtomicFormula ta = new FoLtlLocalTrueAtom();
		FoLtlAtomicFormula la = new FoLtlTempLastAtom();

		System.out.println("\nAtom comparisons\n");

		assertEquals("False", fa, fa.clone());
		Assert.assertFalse(fa == fa.clone());

		assertEquals("True", ta, ta.clone());
		Assert.assertFalse(ta == ta.clone());

		assertEquals("Last", la, la.clone());
		Assert.assertFalse(la == la.clone());


		//Atomic formula comparisons
		FoLtlPredicate L = new FoLtlPredicate("L", 5);

		FoLtlLocalAtom Lxxxxx = new FoLtlLocalAtom(L, varX, conX, varX, conX, varX);

		System.out.println("\nLocal atom comparisons\n");

		assertEquals("Local atom", Lxxxxx, Lxxxxx.clone());
		Assert.assertFalse(Lxxxxx == Lxxxxx.clone());


		//Equality formula comparisons
		FoLtlFormula eq = new FoLtlLocalEqualityFormula(conX, varX);

		System.out.println("\nEquality formula comparisons\n");

		assertEquals("Equality", eq, eq.clone());
		Assert.assertFalse(eq == eq.clone());


		System.out.println("\n\nSINGLE BINARY OPERATOR FORMULA COMPARISONS\n");

		//Local binary boolean operators

		FoLtlPredicate P = new FoLtlPredicate("P", 1);

		FoLtlLocalAtom Pa = new FoLtlLocalAtom(P, new FoLtlConstant("a"));

		//Local AND
		FoLtlFormula aANDa = new FoLtlLocalAndFormula(Pa, Pa);

		//Local OR
		FoLtlFormula aORa = new FoLtlLocalOrFormula(Pa, Pa);

		//Local <->
		FoLtlFormula aDIa = new FoLtlLocalDoubleImplFormula(Pa, Pa);

		//Local ->
		FoLtlFormula aIMa = new FoLtlLocalImplFormula(Pa, Pa);

		System.out.println("Local binary boolean operator comparisons\n");

		assertEquals("AND", aANDa, aANDa.clone());
		Assert.assertFalse(aANDa == aANDa.clone());

		assertEquals("OR", aORa, aORa.clone());
		Assert.assertFalse(aORa == aORa.clone());

		assertEquals("IMPL", aIMa, aIMa.clone());
		Assert.assertFalse(aIMa == aIMa.clone());

		assertEquals("DIMPL", aDIa, aDIa.clone());
		Assert.assertFalse(aDIa == aDIa.clone());


		//Temporal binary boolean operators

		// Temporal AND
		FoLtlFormula atANDa = new FoLtlTempAndFormula(Pa, Pa);

		//Temporal OR
		FoLtlFormula atORa = new FoLtlTempOrFormula(Pa, Pa);

		//Temporal <->
		FoLtlFormula atDIa = new FoLtlTempDoubleImplFormula(Pa, Pa);

		//Temporal ->
		FoLtlFormula atIMa = new FoLtlTempImplFormula(Pa, Pa);

		System.out.println("\nTemporal binary boolean operator comparisons\n");

		assertEquals("TeAND", atANDa, atANDa.clone());
		Assert.assertFalse(atANDa == atANDa.clone());

		assertEquals("TeOR", atORa, atORa.clone());
		Assert.assertFalse(atORa == atORa.clone());

		assertEquals("TeIMPL", atIMa, atIMa.clone());
		Assert.assertFalse(atIMa == atIMa.clone());

		assertEquals("TeDIMPL", atDIa, atDIa.clone());
		Assert.assertFalse(atDIa == atDIa.clone());



		//Temporal binary operators

		//WeakUntil
		FoLtlFormula aWUa = new FoLtlWeakUntilFormula(Pa, Pa);

		//Release
		FoLtlFormula aRa = new FoLtlReleaseFormula(Pa, Pa);

		//Until
		FoLtlFormula aUa = new FoLtlUntilFormula(Pa, Pa);

		System.out.println("\nTemporal binary operator comparisons\n");

		assertEquals("WU", aWUa, aWUa.clone());
		Assert.assertFalse(aWUa == aWUa.clone());

		assertEquals("R", aRa, aRa.clone());
		Assert.assertFalse(aRa == aRa.clone());

		assertEquals("U", aUa, aUa.clone());
		Assert.assertFalse(aUa == aUa.clone());


		System.out.println("\n\nSINGLE UNARY OPERATOR FORMULA COMPARISONS\n");

		//Unary operators

		//Local not
		FoLtlFormula nA = new FoLtlLocalNotFormula(Pa);

		//Temporal not
		FoLtlFormula tnA = new FoLtlTempNotFormula(Pa);

		//Unary temporal operators

		//Globally
		FoLtlFormula gA = new FoLtlGloballyFormula(Pa);

		//Eventually
		FoLtlFormula fA = new FoLtlEventuallyFormula(Pa);

		//Weak next
		FoLtlFormula wxA = new FoLtlWeakNextFormula(Pa);

		//next
		FoLtlFormula xA = new FoLtlNextFormula(Pa);

		System.out.println("\nUnary operator comparisons");

		assertEquals("NOT", nA, nA.clone());
		Assert.assertFalse(nA == nA.clone());

		assertEquals("TeNOT", tnA, tnA.clone());
		Assert.assertFalse(tnA == tnA.clone());

		assertEquals("G", gA, gA.clone());
		Assert.assertFalse(gA == gA.clone());

		assertEquals("F", fA, fA.clone());
		Assert.assertFalse(fA == fA.clone());

		assertEquals("WX", wxA, wxA.clone());
		Assert.assertFalse(wxA == wxA.clone());

		assertEquals("X", xA, xA.clone());
		Assert.assertFalse(xA == xA.clone());


		//Quantified formulas
		System.out.println("\n\nQUANTIFIED FORMULAS");

		FoLtlVariable vx = new FoLtlVariable("x");

		FoLtlLocalAtom px = new FoLtlLocalAtom(P, vx);

		//Local quantifiers
		FoLtlFormula forallXpx = new FoLtlLocalForallFormula(px, vx);

		FoLtlFormula existsXpx = new FoLtlLocalExistsFormula(px, vx);

		//Across state quantifiers
		FoLtlFormula xsForallXpx = new FoLtlAcrossForallFormula(px, vx);

		FoLtlFormula xsExistsXpx = new FoLtlAcrossExistsFormula(px, vx);

		System.out.println("\nQuantified formula comparisons\n");

		assertEquals("Forall", forallXpx, forallXpx.clone());
		Assert.assertFalse(forallXpx == forallXpx.clone());

		assertEquals("Exists", existsXpx, existsXpx.clone());
		Assert.assertFalse(existsXpx == existsXpx.clone());

		assertEquals("xsForall", xsForallXpx, xsForallXpx.clone());
		Assert.assertFalse(xsForallXpx == xsForallXpx.clone());

		assertEquals("xsExists", xsExistsXpx, xsExistsXpx.clone());
		Assert.assertFalse(xsExistsXpx == xsExistsXpx.clone());

		System.out.println("\n\nBIGGER FORMULAS\n");

		//G P(a) & F Q(a, b)

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");

		P = new FoLtlPredicate("P", 1);
		FoLtlPredicate Q = new FoLtlPredicate("Q", 2);

		Pa = new FoLtlLocalAtom(P, a);
		FoLtlLocalAtom Qab = new FoLtlLocalAtom(Q, a, b);

		FoLtlFormula globPa = new FoLtlGloballyFormula(Pa);
		FoLtlFormula evnQab = new FoLtlEventuallyFormula(Qab);
		FoLtlFormula globAndEvn = new FoLtlTempAndFormula(globPa, evnQab);

		FoLtlFormula target = globAndEvn;

		assertEquals("G P(a) & F Q(a, b)", target, target.clone());
		Assert.assertFalse(target == target.clone());


		//P(a) & Q(b, d) U P(c) & Q(a, b)

		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");

		FoLtlLocalAtom Pc = new FoLtlLocalAtom(P, c);
		FoLtlLocalAtom Qbd = new FoLtlLocalAtom(Q, b, d);

		FoLtlFormula PaAndQbd = new FoLtlLocalAndFormula(Pa, Qbd);
		FoLtlFormula PcAndQab = new FoLtlLocalAndFormula(Pc, Qab);
		FoLtlFormula andUntiland = new FoLtlUntilFormula(PaAndQbd, PcAndQab);

		target = andUntiland;

		assertEquals("P(a) & Q(b, d) U P(c) & Q(a, b)", target, target.clone());
		Assert.assertFalse(target == target.clone());


		//(P(a) & P(b)) U ((X Q(c, c) & (P(c) U P(d)))

		FoLtlLocalAtom Pb = new FoLtlLocalAtom(P, b);
		FoLtlLocalAtom Pd = new FoLtlLocalAtom(P, d);
		FoLtlLocalAtom Qcc = new FoLtlLocalAtom(Q, c, c);

		FoLtlFormula PaAndPb = new FoLtlLocalAndFormula(Pa, Pb);
		FoLtlFormula PcUntPd = new FoLtlUntilFormula(Pc, Pd);
		FoLtlFormula nextQcc = new FoLtlNextFormula(Qcc);
		FoLtlFormula xqAndpUp = new FoLtlTempAndFormula(nextQcc, PcUntPd);
		FoLtlFormula andUand = new FoLtlUntilFormula(PaAndPb, xqAndpUp);

		target = andUand;

		assertEquals("(P(a) & P(b)) U ((X Q(c, c) & (P(c) U P(d)))", target, target.clone());
		Assert.assertFalse(target == target.clone());


		//((P(a) & P(b)) U ((X P(c)) & (P(d)))) R
		// 			( ((WX (P(a) -> P(a))) WU (G P(a) R P(a))) <-> (P(a) U P(a)) )

		FoLtlFormula and1 = new FoLtlLocalAndFormula(Pa, Pb);
		FoLtlFormula next1 = new FoLtlNextFormula(Pc);
		FoLtlFormula and2 = new FoLtlTempAndFormula(next1, Pd);
		FoLtlFormula unt1 = new FoLtlUntilFormula(and1, and2);
		FoLtlFormula impl1 = new FoLtlLocalImplFormula(Pa, Pa);
		FoLtlFormula wNext1 = new FoLtlWeakNextFormula(impl1);
		FoLtlFormula glob1 = new FoLtlGloballyFormula(Pa);
		FoLtlFormula rel1 = new FoLtlReleaseFormula(glob1, Pa);
		FoLtlFormula wUnt1 = new FoLtlWeakUntilFormula(wNext1, rel1);
		FoLtlFormula unt2 = new FoLtlUntilFormula(Pa, Pa);
		FoLtlFormula dImpl1 = new FoLtlTempDoubleImplFormula(wUnt1, unt2);
		FoLtlFormula rel2 = new FoLtlReleaseFormula(unt1, dImpl1);

		target = rel2;

		assertEquals("((P(a) & P(b)) U ((X P(c)) & (P(d)))) R \n" +
				"\t( ((WX (P(a) -> P(a))) WU (G P(a) R P(a))) <-> (P(a) U P(a)) )", target, target.clone());
		Assert.assertFalse(target == target.clone());


		//Forall ?x ((P(?x)) U (Exists ?y ((!(?x = ?y)) && (P(?y)))))

		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlVariable y = new FoLtlVariable("y");

		FoLtlLocalAtom Px = new FoLtlLocalAtom(P, x);
		FoLtlLocalAtom Py = new FoLtlLocalAtom(P, y);

		FoLtlFormula xEQy = new FoLtlLocalEqualityFormula(x, y);
		FoLtlFormula neq = new FoLtlLocalNotFormula(xEQy);
		FoLtlFormula and = new FoLtlLocalAndFormula(neq, Py);

		FoLtlFormula existsY = new FoLtlLocalExistsFormula(and, y);
		FoLtlFormula until = new FoLtlUntilFormula(Px, existsY);
		FoLtlFormula forallX = new FoLtlAcrossForallFormula(until, x);

		target = forallX;

		assertEquals("Forall ?x ((P(?x)) U (Exists ?y ((!(?x = ?y)) && (P(?y)))))", target, target.clone());
		Assert.assertFalse(target == target.clone());


		//Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | G P(?y) U Q(?y, ?y))

		FoLtlLocalAtom Qxx = new FoLtlLocalAtom(Q, x, x);
		FoLtlLocalAtom Qyy = new FoLtlLocalAtom(Q, y, y);

		FoLtlFormula pxAndQxx = new FoLtlLocalAndFormula(Px, Qxx);
		FoLtlFormula gPy = new FoLtlGloballyFormula(Py);
		FoLtlFormula gpyUQyy = new FoLtlUntilFormula(gPy, Qyy);
		FoLtlFormula tor = new FoLtlTempOrFormula(pxAndQxx, gpyUQyy);
		FoLtlFormula forallY = new FoLtlAcrossForallFormula(tor, y);
		forallX = new FoLtlAcrossForallFormula(forallY, x);

		target = forallX;

		assertEquals("Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | G P(?y) U Q(?y, ?y))", target, target.clone());
		Assert.assertFalse(target == target.clone());

		//Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | FALSE U Q(?y, ?y))

		FoLtlFormula fsUQyy = new FoLtlUntilFormula(new FoLtlGloballyFormula(new FoLtlLocalFalseAtom()), Qyy);
		FoLtlFormula tor1 = new FoLtlTempOrFormula(pxAndQxx, fsUQyy);
		FoLtlFormula forallY1 = new FoLtlAcrossForallFormula(tor1, y);
		forallX = new FoLtlAcrossForallFormula(forallY1, x);

		target = forallX;

		assertEquals("Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | FALSE U Q(?y, ?y))", target, target.clone());
		Assert.assertFalse(target == target.clone());

		//G P(a) U LAST
		target = new FoLtlUntilFormula(new FoLtlGloballyFormula(Pa), new FoLtlTempLastAtom());

		assertEquals("G P(a) U LAST", target, target.clone());
		Assert.assertFalse(target == target.clone());

	}

	@Test
	public void testNnf(){

		System.out.println("\n*** NEGATION NORMAL FORM TEST ***\n");

		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		System.out.println("\n");

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable x = new FoLtlVariable("x");

		FoLtlPredicate p = new FoLtlPredicate("P", 1);

		FoLtlLocalAtom pa = new FoLtlLocalAtom(p, a);
		FoLtlLocalAtom pb = new FoLtlLocalAtom(p, b);

		//LOCAL FORMULAS
		System.out.println("\nLOCAL FORMULAS\n");

		//FALSE
		assertEquals("FALSE", new FoLtlLocalFalseAtom(), new FoLtlLocalFalseAtom().nnf());

		//!P(a)
		assertEquals("NOT(P(a))", new FoLtlLocalNotFormula(pa), new FoLtlLocalNotFormula(pa).nnf());

		//a = b
		assertEquals("a = b", new FoLtlLocalEqualityFormula(a, b), new FoLtlLocalEqualityFormula(a, b).nnf());

		//P(a) && P(B)
		assertEquals("P(a) AND P(b)", new FoLtlLocalAndFormula(pa, pb), new FoLtlLocalAndFormula(pa, pb).nnf());

		//P(a) -> P(b)
		FoLtlFormula aIMPLb = new FoLtlLocalImplFormula(pa, pb);

		FoLtlFormula target = new FoLtlLocalOrFormula(new FoLtlLocalNotFormula(pa), pb);
		FoLtlFormula input = aIMPLb;

		assertEquals(input.toString(), target, input.nnf());

		//P(a) <-> P(b)
		input = new FoLtlLocalDoubleImplFormula(pa, pb);
		target = parseFoLtlFormula("(! P(a) || P(b)) && (! P(b) || P(a))");

		assertEquals(input.toString(), target, input.nnf());

		//! (P(a) && P(b))
		input = new FoLtlLocalNotFormula(new FoLtlLocalAndFormula(pa, pb));
		target = parseFoLtlFormula("! P(a) || ! P(b)");

		assertEquals(input.toString(), target, input.nnf());

		//(P(a) -> P(b)) && P(a)
		input = new FoLtlLocalAndFormula(new FoLtlLocalImplFormula(pa, pb), pa);
		target = parseFoLtlFormula("(! P(a) || P(b)) && P(a)");

		assertEquals(input.toString(), target, input.nnf());

		//! (Forall x P(a))
		input = new FoLtlLocalNotFormula(new FoLtlLocalForallFormula(pa, x));
		target = parseFoLtlFormula("Exists ?x (! P(a))");

		assertEquals(input.toString(), target, input.nnf());

		//! (Exists x P(a))
		input = new FoLtlLocalNotFormula(new FoLtlLocalExistsFormula(pa, x));
		target = parseFoLtlFormula("Forall ?x (! P(a))");

		assertEquals(input.toString(), target, input.nnf());

		//!Forall x (P(a) -> P(b))
		input = new FoLtlLocalNotFormula(new FoLtlLocalForallFormula(aIMPLb, x));
		target = parseFoLtlFormula("Exists ?x (P(a) && !P(b))");

		assertEquals(input.toString(), target, input.nnf());


		//TEMPORAL FORMULAS
		System.out.println("\nTEMPORAL FORMULAS\n");

		//X P(a)
		input = new FoLtlNextFormula(pa);
		target = parseFoLtlFormula("X P(a)");

		assertEquals(input.toString(), target, input.nnf());

		//WX P(a)
		input = new FoLtlWeakNextFormula(pa);
		target = parseFoLtlFormula("WX P(a)");

		assertEquals(input.toString(), target, input.nnf());

		//a U b
		input = new FoLtlUntilFormula(pa, pb);
		target = parseFoLtlFormula("P(a) U P(b)");

		assertEquals(input.toString(), target, input.nnf());

		//a R b
		input = new FoLtlReleaseFormula(pa, pb);
		target = parseFoLtlFormula("P(a) R P(b)");

		assertEquals(input.toString(), target, input.nnf());

		//G a
		input = new FoLtlGloballyFormula(pa);
		target = parseFoLtlFormula("FALSE R P(a)");

		assertEquals(input.toString(), target, input.nnf());

		//F a
		input = new FoLtlEventuallyFormula(pa);
		target = parseFoLtlFormula("TRUE U P(a)");

		assertEquals(input.toString(), target, input.nnf());

		//a WU b
		input = new FoLtlWeakUntilFormula(pa, pb);
		target = parseFoLtlFormula("P(b) R (P(a) || P(b))");

		assertEquals(input.toString(), target, input.nnf());

		//Input: !(P(a) & P(b)) & G(!( P(a) <-> P(b) ))
		//Expected: (! P(a) || ! P(b)) && (false R ((P(a) && ! P(b)) || (P(b) && ! P(a))))
		input = parseFoLtlFormula("!(P(a) & P(b)) & G(!( P(a) <-> P(b) ))");
		target = parseFoLtlFormula("((!(P(a))) || (!(P(b)))) && ((false) R (((P(a)) && (!(P(b)))) || ((P(b)) && (!(P(a))))))");

		assertEquals(input.toString(), target, input.nnf());

		//Input: !((X P(a)) <-> P(b) )
		//Expected: ((X P(a)) && (! P(b))) || ((P(b)) && (WX (! P(a))))
		input = parseFoLtlFormula("!((X P(a)) <-> P(b))");
		target = parseFoLtlFormula("((X P(a)) && (! P(b))) || ((P(b)) && (WX (! P(a))))");

		assertEquals(input.toString(), target, input.nnf());

		//Input: !( G( G( (WX false) R (G true) )))
		//Expected: (TRUE) U ((TRUE) U ((X TRUE) U (TRUE U FALSE)))
		input = parseFoLtlFormula("!( G( G( (WX false) R (G true) )))");
		target = parseFoLtlFormula("(TRUE) U ((TRUE) U ((X TRUE) U (TRUE U FALSE)))");

		assertEquals(input.toString(), target, input.nnf());

		//Input: F( G( (WX false) <-> (G (!(P(a) & P(b))))))
		//Expected: TRUE U (FALSE R (((X TRUE) || (FALSE R ((! P(a)) || (! P(b))))) && ((TRUE U (P(a) && P(b))) || (WX FALSE))))
		input = parseFoLtlFormula("F( G( (WX false) <-> (G (!(P(a) & P(b))))))");
		target = parseFoLtlFormula("TRUE U (FALSE R " +
				"(((X TRUE) || (FALSE R ((! P(a)) || (! P(b))))) && ((TRUE U (P(a) && P(b))) || (WX FALSE))))");

		assertEquals(input.toString(), target, input.nnf());

	}

	@Test
	public void testNegate(){

		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		System.out.println("\n");

		System.out.println("\n*** NEGATION TEST ***\n\n");

		//Atomic formulas

		//FALSE ATOM
		FoLtlFormula input = parseFoLtlFormula("FALSE");
		FoLtlFormula target = parseFoLtlFormula("TRUE");
		assertEquals(input.toString(), target, input.negate());

		//TRUE ATOM
		input = parseFoLtlFormula("TRUE");
		target = parseFoLtlFormula("FALSE");
		assertEquals(input.toString(), target, input.negate());

		//LAST ATOM
		input = parseFoLtlFormula("LAST");
		target = parseFoLtlFormula("X (TRUE)");
		assertEquals(input.toString(), target, input.negate());

		//LOCAL ATOM
		input = parseFoLtlFormula("P(a)");
		target = parseFoLtlFormula("!P(a)");
		assertEquals(input.toString(), target, input.negate());

		//EQUALITY ATOM
		input = parseFoLtlFormula("a = ?x");
		target = parseFoLtlFormula("!(a = ?x)");
		assertEquals(input.toString(), target, input.negate());


		//Local boolean formulas

		//AND
		input = parseFoLtlFormula("P(a) & P(b)");
		target = parseFoLtlFormula("!P(a) | !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//OR
		input = parseFoLtlFormula("P(a) | P(b)");
		target = parseFoLtlFormula("!P(a) & !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//IMPLICATION
		input = parseFoLtlFormula("P(a) -> P(b)");
		target = parseFoLtlFormula("P(a) & !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//DOUBLE IMPLICATION
		input = parseFoLtlFormula("P(a) <-> P(b)");
		target = parseFoLtlFormula("P(a) && !P(b) || P(b) && !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//NEGATION
		input = parseFoLtlFormula("! P(a)");
		target = parseFoLtlFormula("P(a)");
		assertEquals(input.toString(), target, input.negate());


		//Temporal operators

		//X
		input = parseFoLtlFormula("X P(a)");
		target = parseFoLtlFormula("WX !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//WX
		input = parseFoLtlFormula("WX P(a)");
		target = parseFoLtlFormula("X !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//U
		input = parseFoLtlFormula("P(a) U P(b)");
		target = parseFoLtlFormula("!P(a) R !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//R
		input = parseFoLtlFormula("P(a) R P(b)");
		target = parseFoLtlFormula("!P(a) U !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//G
		input = parseFoLtlFormula("G P(a)");
		target = parseFoLtlFormula("TRUE U !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//F
		input = parseFoLtlFormula("F P(a)");
		target = parseFoLtlFormula("FALSE R !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//WU
		input = parseFoLtlFormula("P(a) WU P(b)");
		target = parseFoLtlFormula("!P(b) U !P(a) && !P(b) ");
		assertEquals(input.toString(), target, input.negate());


		//Temporal boolean formulas

		//AND
		input = parseFoLtlFormula("X P(a) & X P(b)");
		target = parseFoLtlFormula("WX !P(a) | WX !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//OR
		input = parseFoLtlFormula("X P(a) | X P(b)");
		target = parseFoLtlFormula("WX !P(a) & WX !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//IMPLICATION
		input = parseFoLtlFormula("X P(a) -> X P(b)");
		target = parseFoLtlFormula("X P(a) & WX !P(b)");
		assertEquals(input.toString(), target, input.negate());

		//DOUBLE IMPLICATION
		input = parseFoLtlFormula("X P(a) <-> X P(b)");
		target = parseFoLtlFormula("X P(a) && WX !P(b) || X P(b) && WX !P(a)");
		assertEquals(input.toString(), target, input.negate());

		//NEGATION
		input = parseFoLtlFormula("! (X P(a))");
		target = parseFoLtlFormula("X P(a)");
		assertEquals(input.toString(), target, input.negate());


		//Quantified formulas

		//EXISTS
		input = parseFoLtlFormula("Exists ?x P(x)");
		target = parseFoLtlFormula("Forall ?x ! P(x)");
		assertEquals(input.toString(), target, input.negate());

		//FORALL
		input = parseFoLtlFormula("Forall ?x P(x)");
		target = parseFoLtlFormula("Exists ?x ! P(x)");
		assertEquals(input.toString(), target, input.negate());

		//ACROSS EXISTS
		input = parseFoLtlFormula("Exists ?x (X P(x))");
		target = parseFoLtlFormula("Forall ?x (WX ! P(x))");
		assertEquals(input.toString(), target, input.negate());

		//ACROSS FORALL
		input = parseFoLtlFormula("Forall ?x (X P(x))");
		target = parseFoLtlFormula("Exists ?x (WX ! P(x))");
		assertEquals(input.toString(), target, input.negate());


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
