import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import visitors.FOLTLVisitors.FoLtlTemporalStringVisitor;
import visitors.FOLVisitors.FoLtlLocalStringVisitor;

/**
 * Created by Simone Calciolari on 30/07/15.
 */
public class ParsingTest {

	//Boolean flag used to display extra information during the execution
	private static boolean DEBUG = true;

	@Test
	public void testLocalFormulaParsing() {
	System.out.println("\n\n\nLOCAL FORMULA PARSING TEST");

		//String folInput = "Exists ?k(Forall ?x ( (P(a) && !(Exists ?y Q(?x,a,?y))) -> (a = ?x) ) )";

		Assert.assertEquals("", "Exists ?x: (((P(?x)) && ((Q(?x, ?y)) && (?x = ?y))))",
				parseLocalFormula("Exists ?x (P(?x) && Q(?x, ?y) && ?x = ?y)"));

	}

	@Test
	public void testTemporalFormulaParsing() {
		System.out.println("\nTEMPORAL FORMULA PARSING TEST\n");

		Assert.assertEquals("", "xsForall ?y: (G (P(?x)))", parseTemporalFormula("Forall ?y (G P(?x))"));

		Assert.assertEquals("", "Forall ?y: (P(?x))", parseTemporalFormula("Forall ?y P(?x)"));

		Assert.assertEquals("", "xsForall ?x: ((G (P(b))) U (X (t!(F (J(c))))))",
				parseTemporalFormula("Forall ?x (G P(b) U X ! (F J(c)))"));

		Assert.assertEquals("", "Forall ?x: ((Exists ?y: ((((!(?x = ?y)) && (P(?x))) <-> (Q(a, b, ?y))))))",
				parseTemporalFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));

	}


	//<editor-fold desc="parseTemporalFormula" defaultstate="collapsed">
	/**
	 * Method to encapsulate the instructions needed to parse a given temporal foltl formula
	 * @param input the input formula
	 * @return the String returned as output by the visitor
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
		FoLtlTemporalStringVisitor temporalVisitor = new FoLtlTemporalStringVisitor();
		output = temporalVisitor.visit(tree);

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
		}

		System.out.println("=============================================================================================");

		return output;
	}
	//</editor-fold>

	//<editor-fold desc="parseLocalFormula" defaultstate="collapsed">
	/**
	 * Method to encapsulate the instructions needed to parse a given local foltl formula
	 * @param input the input formula
	 * @return the String returned as output by the visitor
	 */
	private static String parseLocalFormula(String input){

		String output;

		//Instantiates lexer and parser
		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(input));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		//Creates the parsing tree
		ParseTree tree = foParser.localQuantifiedFormula();

		if (DEBUG) {
			System.out.println("\n");
			output = tree.toStringTree(foParser);
			System.out.println("> Default parsing tree:\n> " + output + "\n");
		}

		//Testing our own visitor
		FoLtlLocalStringVisitor temporalVisitor = new FoLtlLocalStringVisitor();
		output = temporalVisitor.visit(tree);

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
		}

		System.out.println("=============================================================================================");

		return output;
	}
	//</editor-fold>

}