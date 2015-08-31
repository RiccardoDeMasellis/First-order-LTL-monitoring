import org.junit.Assert;
import org.junit.Test;

import static util.ParsingUtils.*;

/**
 * Created by Simone Calciolari on 30/07/15.
 */
public class ParsingTest {

	//Boolean flag used to display extra information during the execution
	private static boolean DEBUG = true;

	@Test
	public void testLocalFormulaParsing() {
	System.out.println("\n\n\nLOCAL FORMULA PARSING TEST");

		//String folInput = "Exists ?k(Forall ?x ( (P(a) && !(Exists ?y Q(?x,a,?y))) -> (a = ?x) ) )";

		Assert.assertEquals("", "Exists ?x: (((P(?x)) && ((Q(?x, ?y)) && (?x = ?y))))",
				parseStringFoLtlLocalFormula("Exists ?x (P(?x) && Q(?x, ?y) && ?x = ?y)"));

	}

	@Test
	public void testTemporalFormulaParsing() {
		System.out.println("\nTEMPORAL FORMULA PARSING TEST\n");

		Assert.assertEquals("", "xsForall ?y: (G (P(?x)))", parseStringFoLtlFormula("Forall ?y (G P(?x))"));

		Assert.assertEquals("", "Forall ?y: (P(?x))", parseStringFoLtlFormula("Forall ?y P(?x)"));

		Assert.assertEquals("", "xsForall ?x: ((G (P(b))) U (X (t!(F (J(c))))))",
				parseStringFoLtlFormula("Forall ?x (G P(b) U X ! (F J(c)))"));

		Assert.assertEquals("", "Forall ?x: ((Exists ?y: ((((!(?x = ?y)) && (P(?x))) <-> (Q(a, b, ?y))))))",
				parseStringFoLtlFormula("Forall ?x (Exists ?y (!(?x = ?y) && P(?x) <-> Q(a, b, ?y)))"));

	}

}