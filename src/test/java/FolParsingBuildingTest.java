import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import visitors.FOLVisitors.LocalFOLVisitor;
import visitors.FOLVisitors.LocalFolBuilderVisitor;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolParsingBuildingTest {

	@Test
	public void testFolParsingBuild(){
		//FOL parsing test
		//String folInput = "Exists ?k(Forall ?x ( (P(a) && !(Exists ?y Q(?x,a,?y))) -> (a = ?x) ) )";
		String folInput = "Exists ?x ( P(?x) && Q(?x, ?y) && ?x = ?y)";

		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		ParseTree tree = foParser.localQuantifiedFormula();

		System.out.println("\n");
		String output = tree.toStringTree(foParser);
		System.out.println("\n" + output + "\n" );
		System.out.println();

		//Testing our own visitor
		LocalFolBuilderVisitor visitor = new LocalFolBuilderVisitor();
		System.out.println("Custom visitor test:\n");
		System.out.println("\n" + visitor.visit(tree) + "\n\n");
	}

}
