package visitors.AssignmentVisitors;

import antlr4_generated.FoLtlAssignmentBaseVisitor;
import antlr4_generated.FoLtlAssignmentParser;
import formulaa.foltl.FoLtlConstant;
import formulaa.foltl.FoLtlVariable;
import formulaa.foltl.semantics.FoLtlAssignment;

import java.util.HashSet;
import java.util.Iterator;

/**
 * AssignmentVisitor
 * <br>
 * Created by Simone Calciolari on 27/11/15.
 * @author Simone Calciolari.
 */
public class AssignmentVisitor extends FoLtlAssignmentBaseVisitor<FoLtlAssignment>{

	//Variable to activate debug mode (Displays extra info during the parsing process)
	private static final boolean DEBUG = false;

	//Set of already encountered Variables and Constants
	private HashSet<FoLtlConstant> constants = new HashSet<>();
	private HashSet<FoLtlVariable> variables = new HashSet<>();

	@Override
	public FoLtlAssignment visitStart(FoLtlAssignmentParser.StartContext ctx){
		return visitChildren(ctx);
	}

	@Override
	public FoLtlAssignment visitAssignmentDefinition(FoLtlAssignmentParser.AssignmentDefinitionContext ctx){
		FoLtlAssignment res;

		if (ctx.getChildCount() > 0){
			res = new FoLtlAssignment();

			for (int i = 0; i < ctx.getChildCount(); i++){
				res.putAll(visit(ctx.getChild(i)));

				if (DEBUG){
					System.out.println(res);
				}
			}

		} else {
			res = visitChildren(ctx);
		}

		return res;
	}

	@Override
	public FoLtlAssignment visitVariableAssignment(FoLtlAssignmentParser.VariableAssignmentContext ctx){
		FoLtlAssignment res = new FoLtlAssignment();

		FoLtlVariable v = getVariable(ctx.getChild(0).getText().substring(1));
		FoLtlConstant c = getConstant(ctx.getChild(2).getText());
		res.put(v, c);

		if (DEBUG){
			System.out.println("Parsing variable assignment:");
			System.out.println("\t" + v + "<-" + c);
			System.out.println("\t" + res + "\n");
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
