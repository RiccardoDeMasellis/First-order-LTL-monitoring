package visitors.FOLVisitors;

import antlr4_generated.FOFormulaParserBaseVisitor;
import antlr4_generated.FOFormulaParserParser;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Simone Calciolari on 03/08/15.
 */
public class FoLtlLocalStringVisitor extends FOFormulaParserBaseVisitor<String>{

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = true;

	@Override
	public String visitStart(@NotNull FOFormulaParserParser.StartContext ctx) {

		if (DEBUG){
			System.out.println("> parsing local fol formula: " + ctx.getText() + "; " +
					"children: " + ctx.getChildCount());
		}

		return visitChildren(ctx);
	}

	@Override
	public String visitLocalQuantifiedFormula(@NotNull FOFormulaParserParser.LocalQuantifiedFormulaContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local quantified formula: " + ctx.getText() + ";" +
						" children: " + ctx.getChildCount());
			}

			res = ctx.getChild(0).getText() + " " +
					ctx.getChild(1).getText() +  ": (" + visit(ctx.getChild(2)) + ")";

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitLocalDoubleImplication(@NotNull FOFormulaParserParser.LocalDoubleImplicationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local double implication: " + ctx.getText() + ";" +
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
	public String visitLocalImplication(@NotNull FOFormulaParserParser.LocalImplicationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local implication: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
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
					left = visit(ctx.getChild(i-2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitLocalDisjunction(@NotNull FOFormulaParserParser.LocalDisjunctionContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local disjunction: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
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
					left = visit(ctx.getChild(i-2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitLocalConjunction(@NotNull FOFormulaParserParser.LocalConjunctionContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local conjunction: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
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
					left = visit(ctx.getChild(i-2));
				}

				res = "(" + left + ") " + ctx.getChild(i-1).getText() + " (" + right + ")";

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitLocalNegation(@NotNull FOFormulaParserParser.LocalNegationContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local negation: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i< ctx.getChildCount(); i++) {

				String child = ctx.getChild(i).getText();
				switch (child) {

					case "!": case "(": case ")":
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
	public String visitFolAtom(@NotNull FOFormulaParserParser.FolAtomContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public String visitPredicate(@NotNull FOFormulaParserParser.PredicateContext ctx) {
		String res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing predicate: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = "";

			for (int i = 0; i < ctx.getChildCount(); i++){

				res = res +ctx.getChild(i).getText();

			}

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public String visitEquality(@NotNull FOFormulaParserParser.EqualityContext ctx) {
		String res;

		if (ctx.getChildCount() == 3){

			if (DEBUG){
				System.out.println("> parsing local equality: " + ctx.getText() + "; " +
						"children: " + ctx.getChildCount());
			}

			res = ctx.getChild(0).getText() + " = " + ctx.getChild(2).getText();
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

}
