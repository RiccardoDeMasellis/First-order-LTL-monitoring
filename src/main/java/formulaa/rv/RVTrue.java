package formulaa.rv;

/**
 * RVTrue
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 *
 * @author Simone Calciolari.
 */
public class RVTrue extends RVTruthValue {

	@Override
	public RVFormula clone(){
		return new RVTrue();
	}
}
