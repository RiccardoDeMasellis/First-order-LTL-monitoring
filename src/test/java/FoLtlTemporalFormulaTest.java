import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import formula.foltl.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.FOLTLVisitors.FoLtlTemporalVisitor;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlTemporalFormulaTest {

	@Test
	public void testTemporalFormulaBuilding(){
		System.out.println("*** TEMPORAL FORMULA BUILDING TEST ***");
	}

	@Test
	public void testTemporalFormulaParsing(){
		System.out.println("*** TEMPORAL FORMULA PARSING TEST ***");

		FoLtlFormula target;

		//Building very simple formulas
		//P(?x)

		FoLtlPredicate p = new FoLtlPredicate("P", 1);
		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlLocalAtom px = new FoLtlLocalAtom(p, x);

		target = px;

		//Parser test
		String folInput = "(((P(?x))))";

		FOLTLFormulaParserLexer foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		FOLTLFormulaParserParser foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		ParseTree tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		FoLtlTemporalVisitor visitor = new FoLtlTemporalVisitor();
		System.out.println("\n");
		FoLtlFormula output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


		//More difficult
		//P(?x) && Q(a, b, ?y)

		FoLtlPredicate q = new FoLtlPredicate("Q", 3);
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlLocalAtom qaby = new FoLtlLocalAtom(q, a, b , y);

		FoLtlFormula pAndQ = new FoLtlLocalAndFormula(px, qaby);

		target = pAndQ;

		//Parser test
		folInput = "P(?x) && Q(a, b, ?y)";

		foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FoLtlFormula eq = new FoLtlLocalEqualityFormula(x, y);
		FoLtlFormula nEq = new FoLtlLocalNotFormula(eq);
		FoLtlFormula and = new FoLtlLocalAndFormula(nEq, px);
		FoLtlFormula dImpl = new FoLtlLocalDoubleImplFormula(and, qaby);
		FoLtlFormula exists = new FoLtlLocalExistsFormula(dImpl, y);
		FoLtlFormula forall = new FoLtlLocalForallFormula(exists, x);

		target = forall;

		//Parser test
		folInput = "Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))";

		foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


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

		//Parser test
		folInput = "Forall ?x (Bag(?x) -> (Exists ?y (Coin(?y) && Contains(?x, ?y))))";

		foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


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

		//Parser test
		folInput = "Exists ?x (Buyer(?x) && Bought(?x, s) && (Forall ?y (Buyer(?y) && Bought(?y, s) -> ?x = ?y)))";

		foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


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

		//Parser test
		folInput = "Forall ?x (S(?x) -> (Exists ?y (S(?y) && !(?x = ?y) && L(?x, ?y))))";

		foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(folInput));
		foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

	}

}
