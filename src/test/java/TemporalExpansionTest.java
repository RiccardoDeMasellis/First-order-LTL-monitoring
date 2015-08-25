import formula.foltl.*;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Simone Calciolari on 20/08/15.
 */
public class TemporalExpansionTest {

	@Test
	public void testTemporalExpansion(){

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");
		FoLtlConstant e = new FoLtlConstant("e");

		HashSet<FoLtlConstant> domain = new HashSet<>();
		domain.add(a);
		domain.add(b);
		domain.add(c);
		domain.add(d);
		domain.add(e);

		FoLtlSort sort1 = new FoLtlSort("sort1");
		sort1.add(a);
		sort1.add(b);

		FoLtlSort sort2 = new FoLtlSort("sort2");
		sort2.add(c);
		sort2.add(d);

		FoLtlVariable x = new FoLtlVariable("x", sort1);
		FoLtlVariable y = new FoLtlVariable("y", sort2);
		FoLtlVariable z = new FoLtlVariable("z");

		FoLtlPredicate p = new FoLtlPredicate("P", 1);
		FoLtlPredicate q = new FoLtlPredicate("Q", 2);

		FoLtlFormula glob = new FoLtlGloballyFormula(new FoLtlLocalAtom(q, x, z));

		FoLtlAcrossQuantifiedFormula test = new FoLtlAcrossExistsFormula(glob, z);
		test = new FoLtlAcrossForallFormula(test, x);

		System.out.println(test.temporalExpansion(domain, new FoLtlAssignment()));

	}

}
