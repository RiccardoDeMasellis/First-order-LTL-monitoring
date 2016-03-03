package util;

import antlr4_generated.*;
import language.fol.FolFormula;
import language.foltl.FoLtlConstant;
import language.foltl.FoLtlFormula;
import formula.ltlf.LTLfFormula;
import language.foltl.FoLtlSort;
import language.foltl.FoLtlVariable;
import language.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.commons.Formula;
import net.sf.tweety.logics.fol.parser.FolParser;
import net.sf.tweety.logics.fol.syntax.FolSignature;
import net.sf.tweety.logics.pl.parser.PlParser;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.AssignmentVisitors.AssignmentVisitor;
import visitors.FOLTLVisitors.*;
import visitors.FOLVisitors.*;
import visitors.LTLfVisitors.LTLfVisitor;
import visitors.SortVisitors.FoLtlSortAssignmentVisitor;
import visitors.SortVisitors.FoLtlSortDefinitionVisitor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Class that packs methods to encapsulates the parsing functionalities.
 * <br>
 * Created by Simone Calciolari on 31/08/15.
 * @author Simone Calciolari
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
	public static PropositionalFormula parseTweetyPropFormula(String input){
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

	/**
	 * Method to encapsulate the instructions needed to parse a given tweety fol formula
	 * @param preds predicate declarations
	 * @param input the input formula
	 * @param sig the parser signature
	 * @return the parsed formula
	 */
	public static net.sf.tweety.logics.fol.syntax.FolFormula
		parseTweetyFolFormula(String input, FolSignature sig, String... preds){
		Formula output = null;

		FolParser parser = new FolParser();
		Reader sr = new StringReader(input);

		parser.setSignature(sig);

		try {
			for (String pred : preds) {
				parser.parseTypeDeclaration(pred, sig);
			}
			output = parser.parseFormula(sr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(DEBUG) {
			System.out.println("\n> Parsed formula: " + output.toString());
			System.out.println("=============================================================================================");
		}

		return (net.sf.tweety.logics.fol.syntax.FolFormula) output;
	}

	public static FoLtlAssignment parseFoltlAssignment(String input){
		FoLtlAssignment output;

		//Instantiates default lexer and parser
		FoLtlAssignmentLexer lexer = new FoLtlAssignmentLexer(new ANTLRInputStream(input));
		FoLtlAssignmentParser parser = new FoLtlAssignmentParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.assignmentDefinition();

		if (DEBUG){
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Calling our own visitor
		AssignmentVisitor visitor = new AssignmentVisitor();
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed Assignment: " + output.toString());
		}

		return output;
	}

	public static LinkedHashSet<FoLtlSort> parseSortDefinition(String input, LinkedHashSet<FoLtlConstant> domain){
		LinkedHashSet<FoLtlSort> output;

		//Instantiates default lexer and parser
		FoLtlSortDefinitionLexer lexer = new FoLtlSortDefinitionLexer(new ANTLRInputStream(input));
		FoLtlSortDefinitionParser parser = new FoLtlSortDefinitionParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.sortDefinition();

		if (DEBUG){
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Calling our own visitor
		FoLtlSortDefinitionVisitor visitor = new FoLtlSortDefinitionVisitor(domain);
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed Sorts: " + output.toString());
		}

		return output;
	}

	public static HashMap<FoLtlVariable, FoLtlSort> parseSortAssignment(String input, HashSet<FoLtlVariable> variables,
																																			LinkedHashSet<FoLtlSort> sorts){
		HashMap<FoLtlVariable, FoLtlSort> output;

		//Instantiates default lexer and parser
		FoLtlSortAssignmentLexer lexer = new FoLtlSortAssignmentLexer(new ANTLRInputStream(input));
		FoLtlSortAssignmentParser parser = new FoLtlSortAssignmentParser(new CommonTokenStream(lexer));

		//Gets the parsing tree
		ParseTree tree = parser.sortAssignments();

		if (DEBUG){
			System.out.println("\n");
			String o = tree.toStringTree(parser);
			System.out.println("> Default parsing tree:\n> " + o + "\n");
		}

		//Calling our own visitor
		FoLtlSortAssignmentVisitor visitor = new FoLtlSortAssignmentVisitor(variables, sorts);
		output = visitor.visit(tree);

		if(DEBUG) {
			System.out.println("\n> Parsed Sorts: " + output.toString());
		}

		return output;
	}

	/**
	 * Simple method to quickly build a set of variables
	 * @param vars the variable names list
	 * @return the set containing variables with the given name
	 */
	public static HashSet<FoLtlVariable> parseVariableSet(String... vars){
		HashSet<FoLtlVariable> res = new HashSet<>();

		for (String var : vars){
			res.add(new FoLtlVariable(var));
		}

		return res;
	}

	/**
	 * Simple method to quickly build a set of constants
	 * @param cons the constants names list
	 * @return the set containing constants with the given name
	 */
	public static LinkedHashSet<FoLtlConstant> parseConstantSet(String... cons){
		LinkedHashSet<FoLtlConstant> res = new LinkedHashSet<>();

		for (String c : cons){
			res.add(new FoLtlConstant(c));
		}

		return res;
	}

	/**
	 * Simple method that takes a string (ideally an expression with round parenthesis) and
	 * returns a new string consisting of the input string, with a new line underneath with
	 * matching numbers on corresponding open and close parenthesis
	 * @param input the input string
	 * @return the output string
	 */
	public static String parenthesisMatcher(String input){
		String output = "";
		int count = 0;

		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '('){
				output = output + count;
				count++;
			} else if (input.charAt(i) == ')'){
				count--;
				output = output + count;
			} else {
				output = output + " ";
			}
		}

		return input + "\n" + output;
	}
}
