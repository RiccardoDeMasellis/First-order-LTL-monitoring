import formulaa.foltl.*;
import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlTemporalFormulaTest {

	//Boolean flag used to display extra information during the execution
	private static final boolean DEBUG = true;

	@Test
	public void testTemporalFormulaBuilding(){
		System.out.println("\n*** TEMPORAL FORMULA BUILDING TEST ***");

		//G P(a) & F Q(a, b)

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");

		FoLtlPredicate P = new FoLtlPredicate("P", 1);
		FoLtlPredicate Q = new FoLtlPredicate("Q", 2);

		FoLtlLocalAtom Pa = new FoLtlLocalAtom(P, a);
		FoLtlLocalAtom Qab = new FoLtlLocalAtom(Q, a, b);

		FoLtlFormula globPa = new FoLtlGloballyFormula(Pa);
		FoLtlFormula evnQab = new FoLtlEventuallyFormula(Qab);
		FoLtlFormula globAndEvn = new FoLtlTempAndFormula(globPa, evnQab);

		FoLtlFormula builtFormula = globAndEvn;

		Assert.assertEquals("", "(G(P(a))) TeAND (F(Q(a, b)))", builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());


		//P(a) & Q(b, d) U P(c) & Q(a, b)

		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");

		FoLtlLocalAtom Pc = new FoLtlLocalAtom(P, c);
		FoLtlLocalAtom Qbd = new FoLtlLocalAtom(Q, b, d);

		FoLtlFormula PaAndQbd = new FoLtlLocalAndFormula(Pa, Qbd);
		FoLtlFormula PcAndQab = new FoLtlLocalAndFormula(Pc, Qab);
		FoLtlFormula andUntiland = new FoLtlUntilFormula(PaAndQbd, PcAndQab);

		builtFormula = andUntiland;

		Assert.assertEquals("", "((P(a)) AND (Q(b, d))) U ((P(c)) AND (Q(a, b)))", builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());


		//(P(a) & P(b)) U ((X Q(c, c) & (P(c) U P(d)))

		FoLtlLocalAtom Pb = new FoLtlLocalAtom(P, b);
		FoLtlLocalAtom Pd = new FoLtlLocalAtom(P, d);
		FoLtlLocalAtom Qcc = new FoLtlLocalAtom(Q, c, c);

		FoLtlFormula PaAndPb = new FoLtlLocalAndFormula(Pa, Pb);
		FoLtlFormula PcUntPd = new FoLtlUntilFormula(Pc, Pd);
		FoLtlFormula nextQcc = new FoLtlNextFormula(Qcc);
		FoLtlFormula xqAndpUp = new FoLtlTempAndFormula(nextQcc, PcUntPd);
		FoLtlFormula andUand = new FoLtlUntilFormula(PaAndPb, xqAndpUp);

		builtFormula = andUand;

		Assert.assertEquals("", "((P(a)) AND (P(b))) U ((X(Q(c, c))) TeAND ((P(c)) U (P(d))))",
				builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());


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

		builtFormula = rel2;

		Assert.assertEquals("", "(((P(a)) AND (P(b))) U ((X(P(c))) TeAND (P(d)))) R (((WX((P(a)) -> (P(a)))) WU ((G(P(a))) " +
				"R (P(a)))) Te<-> ((P(a)) U (P(a))))",	builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());


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

		builtFormula = forallX;

		Assert.assertEquals("", "xsForall ?x: ((P(?x)) U (Exists ?y: ((NOT(?x = ?y)) AND (P(?y)))))",
				builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());

		//Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | G P(?y) U Q(?y, ?y))

		FoLtlLocalAtom Qxx = new FoLtlLocalAtom(Q, x, x);
		FoLtlLocalAtom Qyy = new FoLtlLocalAtom(Q, y, y);

		FoLtlFormula pxAndQxx = new FoLtlLocalAndFormula(Px, Qxx);
		FoLtlFormula gPy = new FoLtlGloballyFormula(Py);
		FoLtlFormula gpyUQyy = new FoLtlUntilFormula(gPy, Qyy);
		FoLtlFormula tor = new FoLtlTempOrFormula(pxAndQxx, gpyUQyy);
		FoLtlFormula forallY = new FoLtlAcrossForallFormula(tor, y);
		forallX = new FoLtlAcrossForallFormula(forallY, x);

		builtFormula = forallX;

		Assert.assertEquals("", "xsForall ?x: (xsForall ?y: (((P(?x)) AND (Q(?x, ?x))) TeOR ((G(P(?y))) U (Q(?y, ?y)))))",
				builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());

		//Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | FALSE U Q(?y, ?y))

		FoLtlFormula fsUQyy = new FoLtlUntilFormula(new FoLtlLocalFalseAtom(), Qyy);
		FoLtlFormula tor1 = new FoLtlTempOrFormula(pxAndQxx, fsUQyy);
		FoLtlFormula forallY1 = new FoLtlAcrossForallFormula(tor1, y);
		forallX = new FoLtlAcrossForallFormula(forallY1, x);

		builtFormula = forallX;

		Assert.assertEquals("", "xsForall ?x: (xsForall ?y: (((P(?x)) AND (Q(?x, ?x))) TeOR ((FALSE) U (Q(?y, ?y)))))",
				builtFormula.toString());

		System.out.println("\nBuilt formula: " + builtFormula.toString());

	}

	@Test
	public void testTemporalFormulaParsing(){
		System.out.println("\n\n*** TEMPORAL FORMULA PARSING TEST ***\n");

		//G P(a) & F Q(a, b)

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");

		FoLtlPredicate P = new FoLtlPredicate("P", 1);
		FoLtlPredicate Q = new FoLtlPredicate("Q", 2);

		FoLtlLocalAtom Pa = new FoLtlLocalAtom(P, a);
		FoLtlLocalAtom Qab = new FoLtlLocalAtom(Q, a, b);

		FoLtlFormula globPa = new FoLtlGloballyFormula(Pa);
		FoLtlFormula evnQab = new FoLtlEventuallyFormula(Qab);
		FoLtlFormula globAndEvn = new FoLtlTempAndFormula(globPa, evnQab);

		FoLtlFormula target = globAndEvn;

		Assert.assertEquals("", target,
				parseFoLtlFormula("G P(a) & F Q(a, b)"));


		//P(a) & Q(b, d) U P(c) & Q(a, b)

		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");

		FoLtlLocalAtom Pc = new FoLtlLocalAtom(P, c);
		FoLtlLocalAtom Qbd = new FoLtlLocalAtom(Q, b, d);

		FoLtlFormula PaAndQbd = new FoLtlLocalAndFormula(Pa, Qbd);
		FoLtlFormula PcAndQab = new FoLtlLocalAndFormula(Pc, Qab);
		FoLtlFormula andUntiland = new FoLtlUntilFormula(PaAndQbd, PcAndQab);

		target = andUntiland;

		Assert.assertEquals("", target,
				parseFoLtlFormula("P(a) & Q(b, d) U P(c) & Q(a, b)"));


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

		Assert.assertEquals("", target,
				parseFoLtlFormula("(P(a) & P(b)) U (X Q(c, c) & (P(c) U P(d)))"));


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

		Assert.assertEquals("", target,
				parseFoLtlFormula("(P(a) & P(b) U ((X P(c)) & P(d))) R (((WX P(a) -> P(a)) WU (G P(a) R P(a))) <-> P(a) U P(a))"));


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

		Assert.assertEquals("", target,
				parseFoLtlFormula("Forall ?x (P(?x) U Exists ?y !(?x = ?y) & P(?y))"));


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

		Assert.assertEquals("", target,
				parseFoLtlFormula("Forall ?x (Forall ?y (P(?x) & Q(?x, ?x) | G P(?y) U Q(?y, ?y)))"));

		//Forall ?x (Forall ?y P(?x) & Q(?x, ?x) | FALSE U Q(?y, ?y))

		FoLtlFormula fsUQyy = new FoLtlUntilFormula(new FoLtlGloballyFormula(new FoLtlLocalFalseAtom()), Qyy);
		FoLtlFormula tor1 = new FoLtlTempOrFormula(pxAndQxx, fsUQyy);
		FoLtlFormula forallY1 = new FoLtlAcrossForallFormula(tor1, y);
		forallX = new FoLtlAcrossForallFormula(forallY1, x);

		target = forallX;

		Assert.assertEquals("", target,
				parseFoLtlFormula("Forall ?x (Forall ?y (P(?x) & Q(?x, ?x) | G false U Q(?y, ?y)))"));

		//G P(a) U LAST
		target = new FoLtlUntilFormula(new FoLtlGloballyFormula(Pa), new FoLtlTempLastAtom());

		Assert.assertEquals("", target,
				parseFoLtlFormula("G P(a) U LAST"));

	}

}
