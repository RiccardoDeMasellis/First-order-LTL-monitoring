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
		System.out.println("\n");
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
		System.out.println("\n");
		output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

		System.out.println();

	}

	@Test
	public void testFolBuilding(){

		System.out.println("\n***FORMULA BUILDING TEST***");

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

	}

}
