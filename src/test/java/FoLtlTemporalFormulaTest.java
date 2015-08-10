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

		//Parser test
		String input = "Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))";

		FOLTLFormulaParserLexer foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(input));
		FOLTLFormulaParserParser foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		ParseTree tree = foltlParser.acrossQuantifiedFormula();

		//Testing our own visitor
		FoLtlTemporalVisitor visitor = new FoLtlTemporalVisitor();
		System.out.println("\n===========================================================================================");
		FoLtlFormula output = visitor.visit(tree);
		System.out.println("\n" + output);

		Assert.assertEquals("", target.toString(), output.toString());

	}

}
