import formulaa.fol.*;
import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FolFormulaTest {

	//Boolean flag; displays extra information during the execution when set to true;
	private static final boolean DEBUG = true;

	@Test
	public void testFolParsingBuild(){
		System.out.println("\n***FORMULA PARSING TEST***");

		FolFormula target;

		//Building very simple formulas
		//P(?x)

		FolPredicate p = new FolPredicate("P", 1);
		FolVariable x = new FolVariable("x");
		FolAtom px = new FolAtom(p, x);

		target = px;

		Assert.assertEquals("", target,
				parseFolFormula("P(?x)"));


		//More difficult
		//P(?x) && Q(a, b, ?y)

		FolPredicate q = new FolPredicate("Q", 3);
		FolConstant a = new FolConstant("a");
		FolConstant b = new FolConstant("b");
		FolVariable y = new FolVariable("y");
		FolAtom qaby = new FolAtom(q, a, b , y);

		FolFormula pAndQ = new FolAndFormula(px, qaby);

		target = pAndQ;

		Assert.assertEquals("", target, parseFolFormula("P(?x) && Q(a, b, ?y)"));


		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FolFormula eq = new FolEqualityFormula(x, y);
		FolFormula nEq = new FolNotFormula(eq);
		FolFormula and = new FolAndFormula(nEq, px);
		FolFormula dImpl = new FolDoubleImplFormula(and, qaby);
		FolFormula exists = new FolExistsQuantifiedFormula(dImpl, y);
		FolFormula forall = new FolForallQuantifiedFormula(exists, x);

		target = forall;

		Assert.assertEquals("", target,
				parseFolFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));


		//Further tests

		//Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))

		x = new FolVariable("x");
		y = new FolVariable("y");

		FolPredicate bag = new FolPredicate("Bag", 1);
		FolPredicate coin = new FolPredicate("Coin", 1);
		FolPredicate conts = new FolPredicate("Contains", 2);

		FolAtom bagX = new FolAtom(bag, x);
		FolAtom coinY = new FolAtom(coin, y);
		FolAtom contsXY = new FolAtom(conts, x, y);

		FolFormula coinAndConts = new FolAndFormula(coinY, contsXY);
		FolFormula existsY = new FolExistsQuantifiedFormula(coinAndConts, y);
		FolFormula impl = new FolImplFormula(bagX, existsY);
		FolFormula forallX = new FolForallQuantifiedFormula(impl, x);

		target = forallX;

		Assert.assertEquals("", target,
				parseFolFormula("Forall ?x (Bag(?x) -> (Exists ?y (Coin(?y) && Contains(?x, ?y))))"));


		//Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND (Forall ?y: ((Buyer(?y)) AND (Bought(?y, s)) -> (?x = ?y)))))

		FolConstant s = new FolConstant("s");

		FolPredicate buyer = new FolPredicate("Buyer", 1);
		FolPredicate bought = new FolPredicate("Bought", 2);

		FolFormula buyerX = new FolAtom(buyer, x);
		FolFormula buyerY = new FolAtom(buyer, y);
		FolFormula boughtXS = new FolAtom(bought, x, s);
		FolFormula boughtYS = new FolAtom(bought, y, s);
		FolFormula xEqY = new FolEqualityFormula(x, y);

		FolFormula buyAndBoughtY = new FolAndFormula(buyerY, boughtYS);
		impl = new FolImplFormula(buyAndBoughtY, xEqY);
		FolFormula forallY = new FolForallQuantifiedFormula(impl, y);
		FolFormula boughtAndForall = new FolAndFormula(boughtXS, forallY);
		FolFormula buyAndBoughtX = new FolAndFormula(buyerX, boughtAndForall);
		FolFormula existsX = new FolExistsQuantifiedFormula(buyAndBoughtX, x);

		target = existsX;

		Assert.assertEquals("", target,
				parseFolFormula("Exists ?x (Buyer(?x) && Bought(?x, s) && (Forall ?y (Buyer(?y) && Bought(?y, s) -> ?x = ?y)))"));


		//Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))

		FolPredicate S = new FolPredicate("S", 1);
		FolPredicate L = new FolPredicate("L", 2);

		FolFormula sX = new FolAtom(S, x);
		FolFormula sY = new FolAtom(S, y);
		FolFormula lXY = new FolAtom(L, x, y);
		xEqY = new FolEqualityFormula(x, y);

		nEq = new FolNotFormula(xEqY);
		FolFormula neqAndL = new FolAndFormula(nEq, lXY);
		FolFormula sAndAnd = new FolAndFormula(sY, neqAndL);
		existsY = new FolExistsQuantifiedFormula(sAndAnd, y);
		FolFormula sImplEx = new FolImplFormula(sX, existsY);
		forallX = new FolForallQuantifiedFormula(sImplEx, x);

		target = forallX;

		Assert.assertEquals("", target,
				parseFolFormula("Forall ?x (S(?x) -> (Exists ?y (S(?y) && !(?x = ?y) && L(?x, ?y))))"));

	}

	@Test
	public void testFolBuilding(){

		System.out.println("\n\n\n\n***FORMULA BUILDING TEST***");

		//Building very simple formulas
		//P(x)

		FolPredicate p = new FolPredicate("P", 1);
		FolVariable x = new FolVariable("x");
		FolAtom px = new FolAtom(p, x);

		String builtFormula = px.toString();

		Assert.assertEquals("", "P(?x)", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//More difficult
		//P(x) && Q(a, b, ?c)

		FolPredicate q = new FolPredicate("Q", 3);
		FolConstant a = new FolConstant("a");
		FolConstant b = new FolConstant("b");
		FolVariable y = new FolVariable("y");
		FolAtom qaby = new FolAtom(q, a, b , y);

		FolFormula pAndQ = new FolAndFormula(px, qaby);

		builtFormula = pAndQ.toString();

		Assert.assertEquals("", "(P(?x)) AND (Q(a, b, ?y))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FolFormula dImpl = new FolDoubleImplFormula(px, qaby);
		FolFormula eq = new FolEqualityFormula(x, y);
		FolFormula nEq = new FolNotFormula(eq);
		FolFormula and = new FolAndFormula(nEq, dImpl);
		FolFormula exists = new FolExistsQuantifiedFormula(and, y);
		FolFormula forall = new FolForallQuantifiedFormula(exists, x);

		builtFormula = forall.toString();

		Assert.assertEquals("", "Forall ?x: (Exists ?y: ((NOT(?x = ?y)) AND ((P(?x)) DIMPL (Q(a, b, ?y)))))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Further tests

		//Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))

		x = new FolVariable("x");
		y = new FolVariable("y");

		FolPredicate bag = new FolPredicate("Bag", 1);
		FolPredicate coin = new FolPredicate("Coin", 1);
		FolPredicate conts = new FolPredicate("Contains", 2);

		FolAtom bagX = new FolAtom(bag, x);
		FolAtom coinY = new FolAtom(coin, y);
		FolAtom contsXY = new FolAtom(conts, x, y);

		FolFormula coinAndConts = new FolAndFormula(coinY, contsXY);
		FolFormula existsY = new FolExistsQuantifiedFormula(coinAndConts, y);
		FolFormula impl = new FolImplFormula(bagX, existsY);
		FolFormula forallX = new FolForallQuantifiedFormula(impl, x);

		builtFormula = forallX.toString();

		Assert.assertEquals("", "Forall ?x: ((Bag(?x)) IMPL (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND (Forall ?y: ((Buyer(?y)) AND (Bought(?y, s)) -> (?x = ?y)))))

		FolConstant s = new FolConstant("s");

		FolPredicate buyer = new FolPredicate("Buyer", 1);
		FolPredicate bought = new FolPredicate("Bought", 2);

		FolFormula buyerX = new FolAtom(buyer, x);
		FolFormula buyerY = new FolAtom(buyer, y);
		FolFormula boughtXS = new FolAtom(bought, x, s);
		FolFormula boughtYS = new FolAtom(bought, y, s);
		FolFormula xEqY = new FolEqualityFormula(x, y);

		FolFormula buyAndBoughtY = new FolAndFormula(buyerY, boughtYS);
		impl = new FolImplFormula(buyAndBoughtY, xEqY);
		FolFormula forallY = new FolForallQuantifiedFormula(impl, y);
		FolFormula boughtAndForall = new FolAndFormula(boughtXS, forallY);
		FolFormula buyAndBoughtX = new FolAndFormula(buyerX, boughtAndForall);
		FolFormula existsX = new FolExistsQuantifiedFormula(buyAndBoughtX, x);

		builtFormula = existsX.toString();

		Assert.assertEquals("", "Exists ?x: ((Buyer(?x)) AND ((Bought(?x, s)) AND " +
						"(Forall ?y: (((Buyer(?y)) AND (Bought(?y, s))) IMPL (?x = ?y)))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);


		//Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))

		FolPredicate S = new FolPredicate("S", 1);
		FolPredicate L = new FolPredicate("L", 2);

		FolFormula sX = new FolAtom(S, x);
		FolFormula sY = new FolAtom(S, y);
		FolFormula lXY = new FolAtom(L, x, y);
		xEqY = new FolEqualityFormula(x, y);

		nEq = new FolNotFormula(xEqY);
		FolFormula neqAndL = new FolAndFormula(nEq, lXY);
		FolFormula sAndAnd = new FolAndFormula(sY, neqAndL);
		existsY = new FolExistsQuantifiedFormula(sAndAnd, y);
		FolFormula sImplEx = new FolImplFormula(sX, existsY);
		forallX = new FolForallQuantifiedFormula(sImplEx, x);

		builtFormula = forallX.toString();

		Assert.assertEquals("", "Forall ?x: ((S(?x)) IMPL (Exists ?y: ((S(?y)) AND ((NOT(?x = ?y)) AND (L(?x, ?y))))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

	}

}
