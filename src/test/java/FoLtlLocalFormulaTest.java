import formulaa.foltl.*;
import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlLocalFormulaTest {

	//Boolean flag; displays extra information during the execution when set to true;
	private static final boolean DEBUG = true;

	@Test
	public void testLocalFormulaParsing(){
		System.out.println("\n*** LOCAL FORMULA PARSING TEST ***");

		FoLtlFormula target;

		//Building very simple formulas
		//P(?x)

		FoLtlPredicate p = new FoLtlPredicate("P", 1);
		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlLocalAtom px = new FoLtlLocalAtom(p, x);

		target = px;

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("P(?x)"));


		//More difficult
		//P(?x) && Q(a, b, ?y)

		FoLtlPredicate q = new FoLtlPredicate("Q", 3);
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlLocalAtom qaby = new FoLtlLocalAtom(q, a, b , y);

		FoLtlFormula pAndQ = new FoLtlLocalAndFormula(px, qaby);

		target = pAndQ;

		Assert.assertEquals("", target, parseFoLtlLocalFormula("P(?x) && Q(a, b, ?y)"));


		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FoLtlFormula eq = new FoLtlLocalEqualityFormula(x, y);
		FoLtlFormula nEq = new FoLtlLocalNotFormula(eq);
		FoLtlFormula and = new FoLtlLocalAndFormula(nEq, px);
		FoLtlFormula dImpl = new FoLtlLocalDoubleImplFormula(and, qaby);
		FoLtlFormula exists = new FoLtlLocalExistsFormula(dImpl, y);
		FoLtlFormula forall = new FoLtlLocalForallFormula(exists, x);

		target = forall;

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));


		//Further tests

		//Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))

		x = new FoLtlVariable("x");
		y = new FoLtlVariable("y");

		FoLtlPredicate bag = new FoLtlPredicate("Bag", 1);
		FoLtlPredicate coin = new FoLtlPredicate("Coin", 1);
		FoLtlPredicate conts = new FoLtlPredicate("Contains", 2);

		FoLtlLocalAtom bagX = new FoLtlLocalAtom(bag, x);
		FoLtlLocalAtom coinY = new FoLtlLocalAtom(coin, y);
		FoLtlLocalAtom contsXY = new FoLtlLocalAtom(conts, x, y);

		FoLtlFormula coinAndConts = new FoLtlLocalAndFormula(coinY, contsXY);
		FoLtlFormula existsY = new FoLtlLocalExistsFormula(coinAndConts, y);
		FoLtlFormula impl = new FoLtlLocalImplFormula(bagX, existsY);
		FoLtlFormula forallX = new FoLtlLocalForallFormula(impl, x);

		target = forallX;

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("Forall ?x (Bag(?x) -> (Exists ?y (Coin(?y) && Contains(?x, ?y))))"));


		//Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND (Forall ?y: ((Buyer(?y)) AND (Bought(?y, s)) -> (?x = ?y)))))

		FoLtlConstant s = new FoLtlConstant("s");

		FoLtlPredicate buyer = new FoLtlPredicate("Buyer", 1);
		FoLtlPredicate bought = new FoLtlPredicate("Bought", 2);

		FoLtlFormula buyerX = new FoLtlLocalAtom(buyer, x);
		FoLtlFormula buyerY = new FoLtlLocalAtom(buyer, y);
		FoLtlFormula boughtXS = new FoLtlLocalAtom(bought, x, s);
		FoLtlFormula boughtYS = new FoLtlLocalAtom(bought, y, s);
		FoLtlFormula xEqY = new FoLtlLocalEqualityFormula(x, y);

		FoLtlFormula buyAndBoughtY = new FoLtlLocalAndFormula(buyerY, boughtYS);
		impl = new FoLtlLocalImplFormula(buyAndBoughtY, xEqY);
		FoLtlFormula forallY = new FoLtlLocalForallFormula(impl, y);
		FoLtlFormula boughtAndForall = new FoLtlLocalAndFormula(boughtXS, forallY);
		FoLtlFormula buyAndBoughtX = new FoLtlLocalAndFormula(buyerX, boughtAndForall);
		FoLtlFormula existsX = new FoLtlLocalExistsFormula(buyAndBoughtX, x);

		target = existsX;

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("Exists ?x (Buyer(?x) && Bought(?x, s) && (Forall ?y (Buyer(?y) && Bought(?y, s) -> ?x = ?y)))"));


		//Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))

		FoLtlPredicate S = new FoLtlPredicate("S", 1);
		FoLtlPredicate L = new FoLtlPredicate("L", 2);

		FoLtlFormula sX = new FoLtlLocalAtom(S, x);
		FoLtlFormula sY = new FoLtlLocalAtom(S, y);
		FoLtlFormula lXY = new FoLtlLocalAtom(L, x, y);
		xEqY = new FoLtlLocalEqualityFormula(x, y);

		nEq = new FoLtlLocalNotFormula(xEqY);
		FoLtlFormula neqAndL = new FoLtlLocalAndFormula(nEq, lXY);
		FoLtlFormula sAndAnd = new FoLtlLocalAndFormula(sY, neqAndL);
		existsY = new FoLtlLocalExistsFormula(sAndAnd, y);
		FoLtlFormula sImplEx = new FoLtlLocalImplFormula(sX, existsY);
		forallX = new FoLtlLocalForallFormula(sImplEx, x);

		target = forallX;

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("Forall ?x (S(?x) -> (Exists ?y (S(?y) && !(?x = ?y) && L(?x, ?y))))"));

		//false and true atoms

		FoLtlFormula f = new FoLtlLocalFalseAtom();
		FoLtlFormula t = new FoLtlLocalTrueAtom();

		FoLtlFormula and1 = new FoLtlLocalAndFormula(t, t);
		FoLtlFormula and2 = new FoLtlLocalAndFormula(f, and1);
		FoLtlFormula or1 = new FoLtlLocalOrFormula(and2, f);
		impl = new FoLtlLocalImplFormula(or1, f);
		FoLtlFormula and3 = new FoLtlLocalAndFormula(t, f);
		target = new FoLtlLocalDoubleImplFormula(impl, and3);

		Assert.assertEquals("", target,
				parseFoLtlLocalFormula("false && true && TRUE || FALSE -> FALSE <-> True && False"));

	}

	@Test
	public void testLocalFormulaBuilding(){

		System.out.println("\n\n\n\n*** LOCAL FORMULA BUILDING TEST ***");

		//Building very simple formulas
		//P(x)

		FoLtlPredicate p = new FoLtlPredicate("P", 1);
		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlLocalAtom px = new FoLtlLocalAtom(p, x);

		String builtFormula = px.toString();

		Assert.assertEquals("", "P(?x)", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//More difficult
		//P(x) && Q(a, b, ?y)

		FoLtlPredicate q = new FoLtlPredicate("Q", 3);
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlLocalAtom qaby = new FoLtlLocalAtom(q, a, b , y);

		FoLtlFormula pAndQ = new FoLtlLocalAndFormula(px, qaby);

		builtFormula = pAndQ.toString();

		Assert.assertEquals("", "(P(?x)) AND (Q(a, b, ?y))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Even harder
		//Forall ?x: (Exists ?y: (((!(?x = ?y)) AND (P(?x))) <-> (Q(a, b, ?y))))

		FoLtlFormula eq = new FoLtlLocalEqualityFormula(x, y);
		FoLtlFormula nEq = new FoLtlLocalNotFormula(eq);
		FoLtlFormula and = new FoLtlLocalAndFormula(nEq, px);
		FoLtlFormula dImpl = new FoLtlLocalDoubleImplFormula(and, qaby);
		FoLtlFormula exists = new FoLtlLocalExistsFormula(dImpl, y);
		FoLtlFormula forall = new FoLtlLocalForallFormula(exists, x);

		builtFormula = forall.toString();

		Assert.assertEquals("", "Forall ?x: (Exists ?y: (((NOT(?x = ?y)) AND (P(?x))) DIMPL (Q(a, b, ?y))))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Further tests

		//Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))

		x = new FoLtlVariable("x");
		y = new FoLtlVariable("y");

		FoLtlPredicate bag = new FoLtlPredicate("Bag", 1);
		FoLtlPredicate coin = new FoLtlPredicate("Coin", 1);
		FoLtlPredicate conts = new FoLtlPredicate("Contains", 2);

		FoLtlLocalAtom bagX = new FoLtlLocalAtom(bag, x);
		FoLtlLocalAtom coinY = new FoLtlLocalAtom(coin, y);
		FoLtlLocalAtom contsXY = new FoLtlLocalAtom(conts, x, y);

		FoLtlFormula coinAndConts = new FoLtlLocalAndFormula(coinY, contsXY);
		FoLtlFormula existsY = new FoLtlLocalExistsFormula(coinAndConts, y);
		FoLtlFormula impl = new FoLtlLocalImplFormula(bagX, existsY);
		FoLtlFormula forallX = new FoLtlLocalForallFormula(impl, x);

		builtFormula = forallX.toString();

		Assert.assertEquals("", "Forall ?x: ((Bag(?x)) IMPL (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND (Forall ?y: ((Buyer(?y)) AND (Bought(?y, s)) -> (?x = ?y)))))

		FoLtlConstant s = new FoLtlConstant("s");

		FoLtlPredicate buyer = new FoLtlPredicate("Buyer", 1);
		FoLtlPredicate bought = new FoLtlPredicate("Bought", 2);

		FoLtlFormula buyerX = new FoLtlLocalAtom(buyer, x);
		FoLtlFormula buyerY = new FoLtlLocalAtom(buyer, y);
		FoLtlFormula boughtXS = new FoLtlLocalAtom(bought, x, s);
		FoLtlFormula boughtYS = new FoLtlLocalAtom(bought, y, s);
		FoLtlFormula xEqY = new FoLtlLocalEqualityFormula(x, y);

		FoLtlFormula buyAndBoughtY = new FoLtlLocalAndFormula(buyerY, boughtYS);
		impl = new FoLtlLocalImplFormula(buyAndBoughtY, xEqY);
		FoLtlFormula forallY = new FoLtlLocalForallFormula(impl, y);
		FoLtlFormula boughtAndForall = new FoLtlLocalAndFormula(boughtXS, forallY);
		FoLtlFormula buyAndBoughtX = new FoLtlLocalAndFormula(buyerX, boughtAndForall);
		FoLtlFormula existsX = new FoLtlLocalExistsFormula(buyAndBoughtX, x);

		builtFormula = existsX.toString();

		Assert.assertEquals("", "Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND " +
						"(Forall ?y: (((Buyer(?y)) AND (Bought(?y, s))) IMPL (?x = ?y)))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))

		FoLtlPredicate S = new FoLtlPredicate("S", 1);
		FoLtlPredicate L = new FoLtlPredicate("L", 2);

		FoLtlFormula sX = new FoLtlLocalAtom(S, x);
		FoLtlFormula sY = new FoLtlLocalAtom(S, y);
		FoLtlFormula lXY = new FoLtlLocalAtom(L, x, y);
		xEqY = new FoLtlLocalEqualityFormula(x, y);

		nEq = new FoLtlLocalNotFormula(xEqY);
		FoLtlFormula neqAndL = new FoLtlLocalAndFormula(nEq, lXY);
		FoLtlFormula sAndAnd = new FoLtlLocalAndFormula(sY, neqAndL);
		existsY = new FoLtlLocalExistsFormula(sAndAnd, y);
		FoLtlFormula sImplEx = new FoLtlLocalImplFormula(sX, existsY);
		forallX = new FoLtlLocalForallFormula(sImplEx, x);

		builtFormula = forallX.toString();

		Assert.assertEquals("", "Forall ?x: ((S(?x)) IMPL (Exists ?y: ((S(?y)) AND ((NOT(?x = ?y)) AND (L(?x, ?y))))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

	}

}
