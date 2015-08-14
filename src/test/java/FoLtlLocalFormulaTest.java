import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import formula.foltl.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.FOLTLVisitors.FoLtlTemporalVisitor;
import visitors.FOLVisitors.FoLtlLocalVisitor;

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
				parseLocalFormula("P(?x)"));


		//More difficult
		//P(?x) && Q(a, b, ?y)

		FoLtlPredicate q = new FoLtlPredicate("Q", 3);
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlLocalAtom qaby = new FoLtlLocalAtom(q, a, b , y);

		FoLtlFormula pAndQ = new FoLtlLocalAndFormula(px, qaby);

		target = pAndQ;

		Assert.assertEquals("", target, parseLocalFormula("P(?x) && Q(a, b, ?y)"));


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
				parseLocalFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));


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
				parseLocalFormula("Forall ?x (Bag(?x) -> (Exists ?y (Coin(?y) && Contains(?x, ?y))))"));


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
				parseLocalFormula("Exists ?x (Buyer(?x) && Bought(?x, s) && (Forall ?y (Buyer(?y) && Bought(?y, s) -> ?x = ?y)))"));


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
				parseLocalFormula("Forall ?x (S(?x) -> (Exists ?y (S(?y) && !(?x = ?y) && L(?x, ?y))))"));

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

		Assert.assertEquals("", "Forall ?x: (Exists ?y: (((!(?x = ?y)) AND (P(?x))) <-> (Q(a, b, ?y))))", builtFormula);

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

		Assert.assertEquals("", "Forall ?x: ((Bag(?x)) -> (Exists ?y: ((Coin(?y)) AND (Contains(?x, ?y)))))",
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
						"(Forall ?y: (((Buyer(?y)) AND (Bought(?y, s))) -> (?x = ?y)))))",
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

		Assert.assertEquals("", "Forall ?x: ((S(?x)) -> (Exists ?y: ((S(?y)) AND ((!(?x = ?y)) AND (L(?x, ?y))))))",
				builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

	}

	//<editor-fold desc="parseLocalFormula">
	/**
	 * Method to encapsulate the instructions needed to parse a given local foltl formula
	 * @param input the input formula
	 * @return the String interpretation of the output given by the visitor
	 */
	private static FoLtlFormula parseLocalFormula(String input){

		FoLtlFormula output;

		//Instantiates lexer and parser
		FOFormulaParserLexer lexer = new FOFormulaParserLexer(new ANTLRInputStream(input));
		FOFormulaParserParser parser = new FOFormulaParserParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.localQuantifiedFormula();


		if (DEBUG) {
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Testing our own visitor
		FoLtlLocalVisitor visitor = new FoLtlLocalVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
		}

		System.out.println("=============================================================================================");

		return output;
	}
	//</editor-fold>

}
