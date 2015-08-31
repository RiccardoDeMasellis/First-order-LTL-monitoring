package util;

import antlr4_generated.*;
import formula.fol.FolFormula;
import formula.foltl.FoLtlFormula;
import formula.ltlf.LTLfFormula;
import net.sf.tweety.logics.pl.parser.PlParser;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.FOLTLVisitors.*;
import visitors.FOLVisitors.*;
import visitors.LTLfVisitors.LTLfVisitor;

import java.io.Reader;
import java.io.StringReader;

/**
 * Class that packs methods to encapsulates the parsing functionalities
 * Created by Simone Calciolari on 31/08/15.
 */
public class ParsingUtils {

	//Boolean flag used to display extra information during the execution
	private static final boolean DEBUG = false;

	/**
	 * Method to encapsulate the instructions needed to parse a given foltl formula
	 * @param input the input formula
	 * @return the parsed formula
	 */
	public static FoLtlFormula parseFoLtlFormula(String input){
		FoLtlFormula output;

		//Instantiates lexer and parser
		FOLTLFormulaParserLexer lexer = new FOLTLFormulaParserLexer(new ANTLRInputStream(input));
		FOLTLFormulaParserParser parser = new FOLTLFormulaParserParser(new CommonTokenStream(lexer));

		//Creates the parsing tree
		ParseTree tree = parser.foltlFormula();

		if (DEBUG) {
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o);
		}

		//Calling our own visitor
		FoLtlTemporalVisitor temporalVisitor = new FoLtlTemporalVisitor();
		output = temporalVisitor.visit(tree);

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
			System.out.println("=============================================================================================");
		}

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given foltl local formula
	 * @param input the input formula
	 * @return the parsed formula
	 */
	public static FoLtlFormula parseFoLtlLocalFormula(String input){
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

		//Calling our own visitor
		FoLtlLocalVisitor visitor = new FoLtlLocalVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
			System.out.println("=============================================================================================");
		}

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given Fol formula
	 * @param input the input formula
	 * @return the parsed formula
	 */
	public static FolFormula parseFolFormula(String input){
		FolFormula output;

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

		//Calling our own visitor
		FolVisitor visitor = new FolVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output);
		}

		System.out.println("=============================================================================================");

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given foltl formula
	 * @param input the input formula
	 * @return the String returned as output by the visitor
	 */
	public static String parseStringFoLtlFormula(String input){
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

		//Calling our own visitor
		FoLtlTemporalStringVisitor temporalVisitor = new FoLtlTemporalStringVisitor();
		output = temporalVisitor.visit(tree);

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
			System.out.println("=============================================================================================");
		}

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given foltl local formula
	 * @param input the input formula
	 * @return the String returned as output by the visitor
	 */
	public static String parseStringFoLtlLocalFormula(String input){
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

		//Calling our own visitor
		FoLtlLocalStringVisitor temporalVisitor = new FoLtlLocalStringVisitor();
		output = temporalVisitor.visit(tree);

		if (DEBUG){
			System.out.println("\n> Parsed formula: " + output);
			System.out.println("=============================================================================================");
		}

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given LTLf formula
	 * @param input the input formula
	 * @return the parsed formula
	 */
	public static LTLfFormula parseLTLfFormula(String input){
		LTLfFormula output;

		//Instantiates lexer and parser
		LTLfFormulaParserLexer lexer = new LTLfFormulaParserLexer(new ANTLRInputStream(input));
		LTLfFormulaParserParser parser = new LTLfFormulaParserParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.expression();

		if (DEBUG){
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Calling our own visitor
		LTLfVisitor visitor = new LTLfVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
			System.out.println("=============================================================================================");
		}

		return output;
	}

	/**
	 * Method to encapsulate the instructions needed to parse a given tweety propositional formula
	 * @param input the input formula
	 * @return the parsed formula
	 */
	public static PropositionalFormula parseTweetyFormula(String input){
		PropositionalFormula output;

		PlParser parser = new PlParser();
		Reader sr = new StringReader(input);

		output = parser.parseFormula(sr);

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
			System.out.println("=============================================================================================");
		}

		return output;
	}

}
