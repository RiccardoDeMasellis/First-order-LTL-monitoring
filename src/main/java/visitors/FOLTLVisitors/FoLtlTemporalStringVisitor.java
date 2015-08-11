package visitors.FOLTLVisitors;

import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserBaseVisitor;
import antlr4_generated.FOLTLFormulaParserParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.FOLVisitors.FoLtlLocalStringVisitor;

/**
 * Created by Simone Calciolari on 03/08/15.
 */
public class FoLtlTemporalStringVisitor extends FOLTLFormulaParserBaseVisitor<String>{

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = true;

	@Override
	public String visitStart(@NotNull FOLTLFormulaParserParser.StartContext ctx) {
		return super.visitStart(ctx);
	}

	@Override
	public String visitFoltlFormula(@NotNull FOLTLFormulaParserParser.FoltlFormulaContext ctx) {

		if (DEBUG){
			System.out.println("\n> parsing FO-LTL formula: " + ctx.getText() + "; " +
					"children: " + ctx.getChildCount());
		}

		return super.visitFoltlFormula(ctx);
	}

	@Override
	public String visitAcrossQuantifiedFormula(@NotNull FOLTLFormulaParserParser.AcrossQuantifiedFormulaContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing across quantified temporal formula: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "xs" + ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + ": (";

			for (int i = 2; i < ctx.getChildCount(); i++){

				ParseTree child = ctx.getChild(i);
				String t = child.getText();

				switch (t){

					case "(": case ")":
						break;

					default:
						res = res + visit(child);
						break;

				}

			}

			res = res + ")";

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	/*
	@Override
	public String visitTemporalFormula(@NotNull FOLTLFormulaParserParser.TemporalFormulaContext ctx) {

		String res;

		if (ctx.getChildCount() > 1) {

			if (DEBUG) {
				System.out.println("> parsing temporal formula: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i < ctx.getChildCount(); i++){

				String child = ctx.getChild(i).getText();

				switch (child){

					case "(": case ")":
						//res = res + child;
						break;

					default:
						res = res + visit(ctx.getChild(i));
						break;

				}

			}

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}
	*/

	@Override
	public String visitTemporalDoubleImplication(@NotNull FOLTLFormulaParserParser.TemporalDoubleImplicationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal double implication: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") t" + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitTemporalImplication(@NotNull FOLTLFormulaParserParser.TemporalImplicationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal implication: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") t" + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitTemporalDisjunction(@NotNull FOLTLFormulaParserParser.TemporalDisjunctionContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal disjunction: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") t" + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitTemporalConjunction(@NotNull FOLTLFormulaParserParser.TemporalConjunctionContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal conjunction: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") t" + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitWeakUntil(@NotNull FOLTLFormulaParserParser.WeakUntilContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing weak until: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitRelease(@NotNull FOLTLFormulaParserParser.ReleaseContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing release: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitUntil(@NotNull FOLTLFormulaParserParser.UntilContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing until: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			String left;
			String right;
			res = "";

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitGlobally(@NotNull FOLTLFormulaParserParser.GloballyContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing globally: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "G": case "[]":
						res = res + child;
						break;

					default:
						res = res + " (" + visit(ctx.getChild(i)) + ")";
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitEventually(@NotNull FOLTLFormulaParserParser.EventuallyContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing eventually: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "F": case "<>":
						res = res + child;
						break;

					default:
						res = res + " (" + visit(ctx.getChild(i)) + ")";
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitWeakNext(@NotNull FOLTLFormulaParserParser.WeakNextContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing weak next: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "WX":
						res = res + child;
						break;

					default:
						res = res + " (" + visit(ctx.getChild(i)) + ")";
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitNext(@NotNull FOLTLFormulaParserParser.NextContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing next: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "X":
						res = res + child;
						break;

					default:
						res = res + " (" + visit(ctx.getChild(i)) + ")";
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitTemporalNegation(@NotNull FOLTLFormulaParserParser.TemporalNegationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal negation: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "!":
						res = res + "t" + child;
						break;

					case "(": case ")":
						res = res + child;
						break;

					default:
						res = res + visit(ctx.getChild(i));
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitLtlfAtom(@NotNull FOLTLFormulaParserParser.LtlfAtomContext ctx) {

		String res;

		if (DEBUG){
			System.out.println("> parsing ltlf atom: " + ctx.getText() + "; " +
					"children: " + ctx.getChildCount());
		}

		res = "";

		for (int i = 0; i < ctx.getChildCount(); i++) {

			ParseTree child = ctx.getChild(i);
			String t = child.getText();

			switch (t) {

				case "LAST": case "Last": case "last":
					res = t;
					break;

				case "(": case ")":
					break;

				default:
					res = visit(child);
					break;

			}

		}

		return res;
	}

	@Override
	public String visitLocalQuantifiedFormula(@NotNull FOLTLFormulaParserParser.LocalQuantifiedFormulaContext ctx) {

		String res;

		//Restores original input with white spaces, as described here:
		//http://stackoverflow.com/questions/16343288/how-do-i-get-the-original-text-that-an-antlr4-rule-matched

		int a = ctx.start.getStartIndex();
		int b = ctx.stop.getStopIndex();

		Interval interval = new Interval(a, b);

		String input = ctx.start.getInputStream().getText(interval);

		System.out.println();

		FOFormulaParserLexer foLexer = new FOFormulaParserLexer(new ANTLRInputStream(input));
		FOFormulaParserParser foParser = new FOFormulaParserParser(new CommonTokenStream(foLexer));

		ParseTree tree = foParser.localQuantifiedFormula();
		String output = tree.toStringTree(foParser);

		if (DEBUG){
			System.out.println("\n\n> parsing local fol formula: " + input);
			System.out.println("\n\t" + output);
			System.out.println();
		}

		FoLtlLocalStringVisitor folVisitor = new FoLtlLocalStringVisitor();
		res = folVisitor.visit(tree);

		return res;
	}

}
