package visitors.FOLTLVisitors;

import antlr4_generated.FOFormulaParserLexer;
import antlr4_generated.FOFormulaParserParser;
import antlr4_generated.FOLTLFormulaParserBaseVisitor;
import antlr4_generated.FOLTLFormulaParserParser;
import formula.foltl.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.FOLVisitors.FoLtlLocalVisitor;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlTemporalVisitor extends FOLTLFormulaParserBaseVisitor<FoLtlFormula> {

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = true;

	@Override
	public FoLtlFormula visitStart(@NotNull FOLTLFormulaParserParser.StartContext ctx) {
		return super.visitStart(ctx);
	}

	@Override
	public FoLtlFormula visitFoltlFormula(@NotNull FOLTLFormulaParserParser.FoltlFormulaContext ctx) {

		if (DEBUG){
			System.out.println("> parsing FO-LTL formula: " + ctx.getText() + "; " +
					"children: " + ctx.getChildCount());
		}

		return super.visitFoltlFormula(ctx);
	}

	@Override
	public FoLtlFormula visitAcrossQuantifiedFormula(@NotNull FOLTLFormulaParserParser.AcrossQuantifiedFormulaContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing across quantified temporal formula: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			String qf = ctx.getChild(0).getText();
			String var = ctx.getChild(1).getText();

			var = var.substring(1);

			FoLtlFormula nf = null;

			for (int i = 2; i < ctx.getChildCount(); i++) {

				ParseTree child = ctx.getChild(i);
				String t = child.getText();

				switch (t){

					case "(": case ")":
						break;

					default:
						nf = visit(child);
						break;

				}

			}

			switch (qf) {

				case "Forall":
					res = new FoLtlAcrossForallFormula(nf, new FoLtlVariable(var));
					break;

				case "Exists":
					res = new FoLtlAcrossExistsFormula(nf, new FoLtlVariable(var));
					break;

				default:
					res = null;
					break;

			}

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	/*
	@Override
	public FoLtlFormula visitTemporalFormula(@NotNull FOLTLFormulaParserParser.TemporalFormulaContext ctx) {

		FoLtlFormula res;

		if (ctx.getChildCount() > 1) {

			if (DEBUG) {
				System.out.println("> parsing temporal formula: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = null;

			for (int i = 0; i < ctx.getChildCount(); i++){

				String child = ctx.getChild(i).getText();

				switch (child){

					case "(": case ")":
						break;

					default:
						res = visit(ctx.getChild(i));
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
	public FoLtlFormula visitTemporalDoubleImplication(@NotNull FOLTLFormulaParserParser.TemporalDoubleImplicationContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal double implication: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlTempDoubleImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitTemporalImplication(@NotNull FOLTLFormulaParserParser.TemporalImplicationContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal implication: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlTempImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitTemporalDisjunction(@NotNull FOLTLFormulaParserParser.TemporalDisjunctionContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal disjunction: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlTempOrFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitTemporalConjunction(@NotNull FOLTLFormulaParserParser.TemporalConjunctionContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal conjunction: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlTempAndFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitWeakUntil(@NotNull FOLTLFormulaParserParser.WeakUntilContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing weak until: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlWeakUntilFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitRelease(@NotNull FOLTLFormulaParserParser.ReleaseContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing release: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlReleaseFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitUntil(@NotNull FOLTLFormulaParserParser.UntilContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing until: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlUntilFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitGlobally(@NotNull FOLTLFormulaParserParser.GloballyContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing globally: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = null;
			boolean op = false;

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();

				switch (child) {

					case "G": case "[]":
						op = true;
						break;

					case "(": case ")":
						break;

					default:
						if (op){
							res = new FoLtlGloballyFormula(visit(ctx.getChild(i)));
						} else {
							res = visitChildren(ctx);
						}
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitEventually(@NotNull FOLTLFormulaParserParser.EventuallyContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing eventually: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = null;
			boolean op = false;

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();

				switch (child) {

					case "F": case "<>":
						op = true;
						break;

					case "(": case ")":
						break;

					default:
						if (op){
							res = new FoLtlEventuallyFormula(visit(ctx.getChild(i)));
						} else {
							res = visitChildren(ctx);
						}
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitWeakNext(@NotNull FOLTLFormulaParserParser.WeakNextContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing weak next: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = null;
			boolean op = false;

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();

				switch (child) {

					case "WX":
						op = true;
						break;

					case "(": case ")":
						break;

					default:
						if (op){
							res = new FoLtlWeakNextFormula(visit(ctx.getChild(i)));
						} else {
							res = visitChildren(ctx);
						}
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitNext(@NotNull FOLTLFormulaParserParser.NextContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing next: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = null;
			boolean op = false;

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();

				switch (child) {

					case "X":
						op = true;
						break;

					case "(": case ")":
						break;

					default:
						if (op){
							res = new FoLtlNextFormula(visit(ctx.getChild(i)));
						} else {
							res = visitChildren(ctx);
						}
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitTemporalNegation(@NotNull FOLTLFormulaParserParser.TemporalNegationContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing temporal negation: " + ctx.getText());
			}

			res = null;

			boolean neg = false;

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "!":
						neg = true;
						break;

					case "(": case ")":
						break;

					default:
						if (neg) {
							res = new FoLtlTempNotFormula(visit(ctx.getChild(i)));
						} else {
							res = visit(ctx.getChild(i));
						}
						break;
				}
			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitLtlfAtom(@NotNull FOLTLFormulaParserParser.LtlfAtomContext ctx) {

		FoLtlFormula res = null;

		if (DEBUG){
			System.out.println("> parsing ltlf atom: " + ctx.getText() + "; " +
					"children: " + ctx.getChildCount());
		}

		for (int i = 0; i < ctx.getChildCount(); i++) {

			ParseTree child = ctx.getChild(i);
			String t = child.getText();

			switch (t) {

				case "LAST": case "Last": case "last":
					res = new FoLtlTempLastAtom();
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
	public FoLtlFormula visitLocalQuantifiedFormula(@NotNull FOLTLFormulaParserParser.LocalQuantifiedFormulaContext ctx) {
		FoLtlFormula res;

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

		FoLtlLocalVisitor localVisitor = new FoLtlLocalVisitor();
		res = localVisitor.visit(tree);

		return res;
	}
}
