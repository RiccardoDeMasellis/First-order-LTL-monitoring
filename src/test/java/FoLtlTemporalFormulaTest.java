import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import formula.foltl.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.FOLTLVisitors.FoLtlTemporalStringVisitor;
import visitors.FOLTLVisitors.FoLtlTemporalVisitor;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlTemporalFormulaTest {

	private static final boolean DEBUG = true;

	@Test
	public void testTemporalFormulaBuilding(){
		System.out.println("*** TEMPORAL FORMULA BUILDING TEST ***");
	}

	@Test
	public void testTemporalFormulaParsing(){
		System.out.println("*** TEMPORAL FORMULA PARSING TEST ***");

		//Even harder
		//Forall ?x: (Exists ?y: ((!(?x = ?y)) AND ((P(?x)) <-> (Q(a, b, ?y)))))

		FoLtlPredicate p = new FoLtlPredicate("P", 1);
		FoLtlVariable x = new FoLtlVariable("x");
		FoLtlLocalAtom px = new FoLtlLocalAtom(p, x);

		FoLtlPredicate q = new FoLtlPredicate("Q", 3);
		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlVariable y = new FoLtlVariable("y");
		FoLtlLocalAtom qaby = new FoLtlLocalAtom(q, a, b , y);

		FoLtlFormula eq = new FoLtlLocalEqualityFormula(x, y);
		FoLtlFormula nEq = new FoLtlLocalNotFormula(eq);
		FoLtlFormula and = new FoLtlLocalAndFormula(nEq, px);
		FoLtlFormula dImpl = new FoLtlLocalDoubleImplFormula(and, qaby);
		FoLtlFormula exists = new FoLtlLocalExistsFormula(dImpl, y);
		FoLtlFormula forall = new FoLtlLocalForallFormula(exists, x);

		FoLtlFormula target = forall;

		Assert.assertEquals("", target.toString(),
				parseTemporalFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));

	}

	//<editor-fold desc="parseTemporalFormula">
	/**
	 * Method to encapsulate the instructions needed to parse a given temporal foltl formula
	 * @param input the input formula
	 * @return a String representing the parsing result
	 */
	private static String parseTemporalFormula(String input){

		String output;

		//Instantiates lexer and parser
		FOLTLFormulaParserLexer foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(input));
		FOLTLFormulaParserParser foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		//Creates the parsing tree
		ParseTree tree = foltlParser.foltlFormula();

		if (DEBUG) {
			System.out.println("\n");
			output = tree.toStringTree(foltlParser);
			System.out.println("> Default parsing tree:\n> " + output);
		}

		//Testing our own visitor
		FoLtlTemporalVisitor temporalVisitor = new FoLtlTemporalVisitor();
		output = temporalVisitor.visit(tree).toString();

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
		}

		System.out.println("=============================================================================================");

		return output;
	}
	//</editor-fold>

}
