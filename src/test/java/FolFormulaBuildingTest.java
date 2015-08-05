import formula.fol.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Simone Calciolari on 05/08/15.
 */
public class FolFormulaBuildingTest {

	@Test
	public void testFolBuilding(){

		//Building very simple formulas
		//P(x)

		FolPredicate p = new FolPredicate("P", 1);
		FolConstant x = new FolConstant("x");
		FolAtom px = new FolAtom(p, x);

		String builtFormula = px.toString();

		Assert.assertEquals("", "P(x)", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

		//More difficult
		//P(x) && Q(a, b, ?c)

		FolPredicate q = new FolPredicate("Q", 3);
		FolConstant a = new FolConstant("a");
		FolConstant b = new FolConstant("b");
		FolVariable c = new FolVariable("c");
		FolAtom qabc = new FolAtom(q, a, b , c);

		FolFormula pANDq = new FolAndFormula(px, qabc);

		builtFormula = pANDq.toString();

		Assert.assertEquals("", "(P(x)) AND (Q(a, b, ?c))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

		//Even harder
		//Forall ?x: ((P(?x)) OR ((!(P(?x))) AND (Q(a, b, ?c))))

		px = new FolAtom(p, new FolVariable("x"));
		FolFormula notPx = new FolNotFormula(px);
		FolFormula nPxAndQabc = new FolAndFormula(notPx, qabc);
		FolFormula pxOretc = new FolOrFormula(px, nPxAndQabc);
		FolFormula forall = new FolForallQuantifiedFormula(pxOretc, new FolVariable("x"));

		builtFormula = forall.toString();

		Assert.assertEquals("", "Forall ?x: ((P(?x)) OR ((!(P(?x))) AND (Q(a, b, ?c))))", builtFormula);

		System.out.println("\nBuilt formula: " + builtFormula);

	}

}
