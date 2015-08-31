import formula.ltlf.LTLfFormula;
import formula.ltlf.LTLfLocalAndFormula;
import formula.ltlf.LTLfLocalFormula;
import formula.ltlf.LTLfLocalVar;
import org.junit.Test;

/**
 * Created by Simone Calciolari on 31/08/15.
 */
public class FLLOATIntegrationTest {

	@Test
	public void testFlloatIntegration(){

		LTLfLocalFormula f = new LTLfLocalAndFormula(new LTLfLocalVar("a"), new LTLfLocalVar("a"));
		f.toTweetyProp();

	}

}
