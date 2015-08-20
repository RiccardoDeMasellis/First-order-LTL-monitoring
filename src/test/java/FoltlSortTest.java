import formula.foltl.*;
import org.junit.Test;

/**
 * Created by Simone Calciolari on 19/08/15.
 */
public class FoltlSortTest {

	@Test
	public void testBasicSort(){

		FoLtlConstant a = new FoLtlConstant("a");
		FoLtlConstant b = new FoLtlConstant("b");
		FoLtlConstant c = new FoLtlConstant("c");
		FoLtlConstant d = new FoLtlConstant("d");
		FoLtlConstant e = new FoLtlConstant("e");

		FoLtlSort sort1 = new FoLtlSort("sort1");
		sort1.add(a);
		sort1.add(b);

		FoLtlSort sort2 = new FoLtlSort("sort2");
		sort2.add(c);
		sort2.add(d);

		FoLtlVariable x = new FoLtlVariable("x", sort1);
		FoLtlVariable y = new FoLtlVariable("y", sort2);

		FoLtlPredicate p = new FoLtlPredicate("P", 3);

		FoLtlLocalAtom pAtom = new FoLtlLocalAtom(p, x, e, y);

		System.out.println(pAtom.allSubstitutions().toString());

		sort1.add(e);

		System.out.println(pAtom.allSubstitutions().toString());

	}

}
