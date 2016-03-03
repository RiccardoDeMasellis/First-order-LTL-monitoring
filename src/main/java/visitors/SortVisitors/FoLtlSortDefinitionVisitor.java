package visitors.SortVisitors;

import antlr4_generated.FoLtlSortDefinitionBaseVisitor;
import antlr4_generated.FoLtlSortDefinitionParser;
import language.foltl.FoLtlConstant;
import language.foltl.FoLtlSort;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * FoLtlSortDefinitionVisitor
 * <br>
 * Created by Simone Calciolari on 11/12/15.
 * @author Simone Calciolari.
 */
public class FoLtlSortDefinitionVisitor extends FoLtlSortDefinitionBaseVisitor<LinkedHashSet<FoLtlSort>> {

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = false;

	private LinkedHashSet<FoLtlConstant> domain;
	//Set of constants already assigned to some sort
	private LinkedHashSet<FoLtlConstant> sortedConstants;
	//Set of already used sort names
	private HashSet<String> sortNames;

	public FoLtlSortDefinitionVisitor(LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
		this.sortedConstants = new LinkedHashSet<>();
		this.sortNames = new HashSet<>();
	}

	@Override
	public LinkedHashSet<FoLtlSort> visitStart(FoLtlSortDefinitionParser.StartContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public LinkedHashSet<FoLtlSort> visitSortDefinition(FoLtlSortDefinitionParser.SortDefinitionContext ctx) {
		LinkedHashSet<FoLtlSort> res = new LinkedHashSet<>();

		for (int i = 0; i < ctx.getChildCount(); i++){
			res.addAll(visit(ctx.getChild(i)));
		}

		if (!this.sortedConstants.equals(this.domain)){
			throw new RuntimeException("Some constants of the domain were not assigned to any sort");
		}

		return res;
	}

	@Override
	public LinkedHashSet<FoLtlSort> visitSortDeclaration(FoLtlSortDefinitionParser.SortDeclarationContext ctx) {
		LinkedHashSet<FoLtlSort> res = new LinkedHashSet<>();

		FoLtlSort sort;
		String sortName = ctx.getChild(0).getText();

		if (this.sortNames.contains(sortName)){
			throw new RuntimeException("Sort " + sortName + " has already been defined");
		} else {
			sort = new FoLtlSort(sortName);
			this.sortNames.add(sortName);
		}

		for (int i = 3; i < ctx.getChildCount(); i++){
			String txt = ctx.getChild(i).getText();

			switch (txt){
				case "}": case ",": case";":
					break;

				default:
					sort.add(this.getConstant(txt));
					break;
			}
		}

		res.add(sort);
		return res;
	}

	private FoLtlConstant getConstant(String name){
		FoLtlConstant res = null;

		for (FoLtlConstant c : this.domain){
			if (c.getName().equals(name)){

				if (this.sortedConstants.contains(c)){
					throw new RuntimeException("Constant " + name + " has already been assigned to some other sort");
				}

				this.sortedConstants.add(c);
				res = c;
			}
		}

		if (res == null){
			throw new RuntimeException("Constant " + name + " does not belong to the specified domain");
		}

		return res;
	}
}
