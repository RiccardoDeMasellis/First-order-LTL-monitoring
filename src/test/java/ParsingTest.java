import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import visitors.FOLTLVisitors.FoLtlTemporalStringVisitor;
import visitors.FOLVisitors.FoLtlLocalStringVisitor;

/**
 * Created by Simone Calciolari on 30/07/15.
 */
public class ParsingTest {

	@Test
	public void folParsingTest() {

		//FOL parsing test

		System.out.println("\nFOL PARSING TEST");

		//String folInput = "Exists ?k(Forall ?x ( (P(a) && !(Exists ?y Q(?x,a,?y))) -> (a = ?x) ) )";
		String folInput = "Exists ?x ( P(?x) && Q(?x, ?y) && ?x = ?y)";

		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		ParseTree tree = foParser.localQuantifiedFormula();

		String output = tree.toStringTree(foParser);
		System.out.println("\n" + output + "\n" );
		System.out.println();

		//Testing our own visitor
		FoLtlLocalStringVisitor visitor = new FoLtlLocalStringVisitor();
		System.out.println("Custom visitor test:\n");
		System.out.println("\n" + visitor.visit(tree) + "\n\n");

	}

	@Test
	public void foltlParsingTest() {
		//FOLTL parsing test

		System.out.println("\nFO-LTL PARSING TEST\n");

		String foltlInput = "Forall ?y ( G Exists ?z P(?z) U T(t) )";

		FOLTLFormulaParserLexer foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(foltlInput));
		FOLTLFormulaParserParser foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		ParseTree tree = foltlParser.acrossQuantifiedFormula();

		System.out.println("\n");
		String output = tree.toStringTree(foltlParser);
		System.out.println("\n" + output + "\n" );
		System.out.println();

		//Testing our own visitor
		FoLtlTemporalStringVisitor temporalVisitor = new FoLtlTemporalStringVisitor();
		System.out.println("\nCustom visitor test:\n");
		System.out.println("\n" + temporalVisitor.visit(tree));
	}

}