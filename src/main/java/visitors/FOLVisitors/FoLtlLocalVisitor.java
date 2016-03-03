package visitors.FOLVisitors;

import antlr4_generated.FOFormulaParserBaseVisitor;
import antlr4_generated.FOFormulaParserParser;
import language.foltl.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Simone Calciolari on 10/08/15.
 */
public class FoLtlLocalVisitor extends FOFormulaParserBaseVisitor<FoLtlFormula> {

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = false;

	//Set of already encountered Variables and Constants
	private HashSet<FoLtlConstant> constants = new HashSet<>();
	private HashSet<FoLtlVariable> variables = new HashSet<>();

	public FoLtlLocalVisitor(){
		super();
	}

	public FoLtlLocalVisitor(HashSet<FoLtlConstant> constants, HashSet<FoLtlVariable> variables){
		super();
		this.constants = constants;
		this.variables = variables;
	}

	@Override
	public FoLtlFormula visitStart(@NotNull FOFormulaParserParser.StartContext ctx) {

		if (DEBUG){
			System.out.println("> parsing local fol formula: " + ctx.getText());
		}

		return visitChildren(ctx);
	}

	@Override
	public FoLtlFormula visitLocalQuantifiedFormula(@NotNull FOFormulaParserParser.LocalQuantifiedFormulaContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local quantified formula: " + ctx.getText());
			}

			String qf = ctx.getChild(0).getText();
			String var = ctx.getChild(1).getText();

			var = var.substring(1);

			FoLtlVariable qvar = this.getVariable(var);

			switch (qf){

				case "Forall":
					res = new FoLtlLocalForallFormula(visit(ctx.getChild(2)), qvar);
					break;

				case "Exists":
					res = new FoLtlLocalExistsFormula(visit(ctx.getChild(2)), qvar);
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
	public FoLtlFormula visitLocalDoubleImplication(@NotNull FOFormulaParserParser.LocalDoubleImplicationContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local double implication: " + ctx.getText());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlLocalDoubleImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitLocalImplication(@NotNull FOFormulaParserParser.LocalImplicationContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local implication: " + ctx.getText());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlLocalImplFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitLocalDisjunction(@NotNull FOFormulaParserParser.LocalDisjunctionContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local disjunction: " + ctx.getText());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlLocalOrFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitLocalConjunction(@NotNull FOFormulaParserParser.LocalConjunctionContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing local conjunction: " + ctx.getText());
			}

			FoLtlFormula right;
			FoLtlFormula left;

			res = visit(ctx.getChild(ctx.getChildCount() - 1));

			for (int i = ctx.getChildCount() - 1; i >= 2; i -= 2){

				right = res;
				left = visit(ctx.getChild(i - 2));

				res = new FoLtlLocalAndFormula(left, right);

			}
		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitLocalNegation(@NotNull FOFormulaParserParser.LocalNegationContext ctx) {
		FoLtlFormula res;

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
							res = new FoLtlLocalNotFormula(visit(ctx.getChild(i)));
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
	public FoLtlFormula visitFolAtom(@NotNull FOFormulaParserParser.FolAtomContext ctx) {
		FoLtlFormula res;

		ParseTree child = ctx.getChild(0);
		String t = child.getText();

		switch (t){

			case "TRUE": case "True": case "true":
				res = new FoLtlLocalTrueAtom();
				break;

			case "FALSE": case "False": case "false":
				res = new FoLtlLocalFalseAtom();
				break;

			default:
				res = visitChildren(ctx);
				break;

		}

		return res;
	}

	@Override
	public FoLtlFormula visitPredicate(@NotNull FOFormulaParserParser.PredicateContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() > 1){

			if (DEBUG){
				System.out.println("> parsing predicate: " + ctx.getText());
			}

			res = new FoLtlLocalAtom();

			for (int i = 1; i < ctx.getChildCount(); i++){

				String t = ctx.getChild(i).getText();

				switch (t){

					case "(": case ",": case ")":
						break;

					default:

						if (t.charAt(0) == '?'){
							((FoLtlLocalAtom) res).addArguments(this.getVariable(t.substring(1)));
						} else {
							((FoLtlLocalAtom) res).addArguments(this.getConstant(t));
						}

						break;

				}

			}

			String predicateName = ctx.getChild(0).getText();
			int arity = ((FoLtlLocalAtom) res).getArguments().size();

			((FoLtlLocalAtom) res).setPredicate(new FoLtlPredicate(predicateName, arity));

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlFormula visitEquality(@NotNull FOFormulaParserParser.EqualityContext ctx) {
		FoLtlFormula res;

		if (ctx.getChildCount() == 3){

			if (DEBUG){
				System.out.println("> parsing local equality: " + ctx.getText());
			}

			FoLtlTerm left;
			FoLtlTerm right;

			String t = ctx.getChild(0).getText();

			if (t.charAt(0) == '?'){
				left = this.getVariable(t.substring(1));
			} else {
				left = this.getConstant(t);
			}

			t = ctx.getChild(2).getText();
			if (t.charAt(0) == '?'){
				right = this.getVariable(t.substring(1));
			} else {
				right = this.getConstant(t);
			}

			res = new FoLtlLocalEqualityFormula(left, right);

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	private FoLtlVariable getVariable(String name){
		FoLtlVariable res = null;
		Iterator<FoLtlVariable> i = this.variables.iterator();

		while(i.hasNext()){
			FoLtlVariable v = i.next();
			if (v.getName().equals(name)){
				res = v;
			}
		}

		if (res == null){
			res = new FoLtlVariable(name);
			variables.add(res);
		}

		return res;
	}

	private FoLtlConstant getConstant(String name){
		FoLtlConstant res = null;
		Iterator<FoLtlConstant> i = this.constants.iterator();

		while(i.hasNext()){
			FoLtlConstant v = i.next();
			if (v.getName().equals(name)){
				res = v;
			}
		}

		if (res == null){
			res = new FoLtlConstant(name);
			constants.add(res);
		}

		return res;
	}

}
