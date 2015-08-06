import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import formula.fol.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.FOLVisitors.LocalFolBuilderVisitor;

/**
 * Created by Simone Calciolari on 06/08/15.
 */
public class FolBuildingTest {

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

		//Parser test
		String folInput = "P(?x)";

		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		ParseTree tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		LocalFolBuilderVisitor visitor = new LocalFolBuilderVisitor();
		System.out.println("\n");
		FolFormula output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


		//More difficult
		//P(?x) && Q(a, b, ?y)

		FolPredicate q = new FolPredicate("Q", 3);
		FolConstant a = new FolConstant("a");
		FolConstant b = new FolConstant("b");
		FolVariable y = new FolVariable("y");
		FolAtom qaby = new FolAtom(q, a, b , y);

		FolFormula pAndQ = new FolAndFormula(px, qaby);

		target = pAndQ;

		//Parser test
		folInput = "P(?x) && Q(a, b, ?y)";

		foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		visitor = new LocalFolBuilderVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());


		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FolFormula eq = new FolEqualityFormula(x, y);
		FolFormula nEq = new FolNotFormula(eq);
		FolFormula and = new FolAndFormula(nEq, px);
		FolFormula dImpl = new FolDoubleImplFormula(and, qaby);
		FolFormula exists = new FolExistsQuantifiedFormula(dImpl, y);
		FolFormula forall = new FolForallQuantifiedFormula(exists, x);

		target = forall;

		//Parser test
		folInput = "Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))";

		foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		visitor = new LocalFolBuilderVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

		System.out.println();


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

		//Parser test
		folInput = "Forall ?x (Bag(?x) -> (Exists ?y (Coin(?y) && Contains(?x, ?y))))";

		foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		visitor = new LocalFolBuilderVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

		System.out.println();


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

		//Parser test
		folInput = "Exists ?x (Buyer(?x) && Bought(?x, s) && (Forall ?y (Buyer(?y) && Bought(?y, s) -> ?x = ?y)))";

		foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		visitor = new LocalFolBuilderVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

		System.out.println();


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

		//Parser test
		folInput = "Forall ?x (S(?x) -> (Exists ?y (S(?y) && !(?x = ?y) && L(?x, ?y))))";

		foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		tree = foParser.localQuantifiedFormula();

		//Testing our own visitor
		visitor = new LocalFolBuilderVisitor();
		System.out.println("\n===========================================================================================");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

		System.out.println();

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

		Assert.assertEquals("", "Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))", builtFormula);

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

		Assert.assertEquals("", "Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))",
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
						"(Forall ?y: (((Buyer(?y)) AND (Bought(?y, s))) -> (?x = ?y)))))",
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

		Assert.assertEquals("", "Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

	}

}
