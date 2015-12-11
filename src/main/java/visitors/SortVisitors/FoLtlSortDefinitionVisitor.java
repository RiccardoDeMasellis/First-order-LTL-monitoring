package visitors.SortVisitors;

import antlr4_generated.FoLtlSortDefinitionBaseVisitor;
import antlr4_generated.FoLtlSortDefinitionParser;
import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlSort;
import formulaa.foltl.FoLtlVariable;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.Iterator;
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

	private LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();
	//Set of constants already assigned to some sort
	private LinkedHashSet<FoLtlConstant> sortedConstants = new LinkedHashSet<>();

	public FoLtlSortDefinitionVisitor(LinkedHashSet<FoLtlConstant> domain){
		this.domain = domain;
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
		FoLtlSort sort = new FoLtlSort(ctx.getChild(0).getText());

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
		Iterator<FoLtlConstant> i = this.domain.iterator();

		while(i.hasNext()){
			FoLtlConstant c = i.next();
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
