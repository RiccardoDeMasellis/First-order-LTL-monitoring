package visitors.FOLVisitors;

import antlr4_generated.FOFormulaParserBaseVisitor;
import antlr4_generated.FOFormulaParserParser;
import language.fol.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolVisitor extends FOFormulaParserBaseVisitor<FolFormula> {

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = true;

	@Override
	public FolFormula visitStart(@NotNull FOFormulaParserParser.StartContext ctx) {

		if (DEBUG){
			System.out.println("> parsing local fol formula: " + ctx.getText());
		}

		return visitChildren(ctx);
	}

	@Override
	public FolFormula visitLocalQuantifiedFormula(@NotNull FOFormulaParserParser.LocalQuantifiedFormulaContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local quantified formula: " + ctx.getText());
			}

			String qf = ctx.getChild(0).getText();
			String var = ctx.getChild(1).getText();

			var = var.substring(1);

			switch (qf){

				case "Forall":
					res = new FolForallQuantifiedFormula(visit(ctx.getChild(2)), new FolVariable(var));
					break;

				case "Exists":
					res = new FolExistsQuantifiedFormula(visit(ctx.getChild(2)), new FolVariable(var));
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

	@Override
	public FolFormula visitLocalDoubleImplication(@NotNull FOFormulaParserParser.LocalDoubleImplicationContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local double implication: " + ctx.getText());
			}

			FolFormula left;
			FolFormula right;
			res = null;

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = new FolDoubleImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FolFormula visitLocalImplication(@NotNull FOFormulaParserParser.LocalImplicationContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local implication: " + ctx.getText());
			}

			FolFormula left;
			FolFormula right;
			res = null;

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = new FolImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FolFormula visitLocalDisjunction(@NotNull FOFormulaParserParser.LocalDisjunctionContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local disjunction: " + ctx.getText());
			}

			FolFormula left;
			FolFormula right;
			res = null;

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = new FolOrFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FolFormula visitLocalConjunction(@NotNull FOFormulaParserParser.LocalConjunctionContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local conjunction: " + ctx.getText());
			}

			FolFormula left;
			FolFormula right;
			res = null;

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				if (i == ctx.getChildCount() - 1){
					right = visit(ctx.getChild(i));
					left = visit(ctx.getChild(i-2));
				} else {
					right = res;
					left = visit(ctx.getChild(i - 2));
				}

				res = new FolAndFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FolFormula visitLocalNegation(@NotNull FOFormulaParserParser.LocalNegationContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local negation: " + ctx.getText());
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
							res = new FolNotFormula(visit(ctx.getChild(i)));
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
	public FolFormula visitFolAtom(@NotNull FOFormulaParserParser.FolAtomContext ctx) {
		FolFormula res;

		ParseTree child = ctx.getChild(0);
		String t = child.getText();

		switch (t){

			case "TRUE": case "True": case "true":
				res = new FolTrueAtom();
				break;

			case "FALSE": case "False": case "false":
				res = new FolFalseAtom();
				break;

			default:
				res = visitChildren(ctx);
				break;

		}

		return res;
	}

	@Override
	public FolFormula visitPredicate(@NotNull FOFormulaParserParser.PredicateContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing predicate: " + ctx.getText());
			}

			res = new FolAtom();

			for (int i = 1; i < ctx.getChildCount(); i++){

				String t = ctx.getChild(i).getText();

				switch (t){

					case "(": case ",": case ")":
						break;

					default:

						if (t.charAt(0) == '?'){
							((FolAtom) res).addArguments(new FolVariable(t.substring(1)));
						} else {
							((FolAtom) res).addArguments(new FolConstant(t));
						}

						break;

				}

			}

			String predicateName = ctx.getChild(0).getText();
			int arity = ((FolAtom) res).getArguments().size();

			((FolAtom) res).setPredicate(new FolPredicate(predicateName, arity));

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FolFormula visitEquality(@NotNull FOFormulaParserParser.EqualityContext ctx) {
		FolFormula res;

		if (ctx.getChildCount() == 3){

			if (DEBUG){
				System.out.println("> parsing local equality: " + ctx.getText());
			}

			FolTerm left;
			FolTerm right;

			String t = ctx.getChild(0).getText();
			if (t.charAt(0) == '?'){
				left = new FolVariable(t.substring(1));
			} else {
				left = new FolConstant(t);
			}

			t = ctx.getChild(2).getText();
			if (t.charAt(0) == '?'){
				right = new FolVariable(t.substring(1));
			} else {
				right = new FolConstant(t);
			}

			res = new FolEqualityFormula(left, right);

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

}
