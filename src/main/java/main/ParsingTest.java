package main;

import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserLexer;
import antlr4_generated.FOLTLFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Simone Calciolari on 30/07/15.
 */
public class ParsingTest {

	public static void main(String[] args) {

		//FOL parsing test
		String folInput = "Forall ?x ( (P(a) && (Exists ?y Q(?x,a,?y))) -> (a = ?x) )";

		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(folInput));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		ParseTree tree = foParser.localQuantifiedFormula();

		System.out.println("\n");
		System.out.println(tree.toStringTree(foParser));
		System.out.println();

		//FOLTL parsing test

		String foltlInput = "Forall ?z ( G ( P(?z) ) )";

		FOLTLFormulaParserLexer foltlLexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(foltlInput));
		FOLTLFormulaParserParser foltlParser = new FOLTLFormulaParserParser(new CommonTokenStream(foltlLexer));

		tree = foltlParser.acrossQuantifiedFormula();

		System.out.println("\n");
		System.out.println(tree.toStringTree(foltlParser));

	}

}