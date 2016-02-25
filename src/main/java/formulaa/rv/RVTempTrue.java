package formulaa.rv;

/**
 * RVTempTrue
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 *
 * @author Simone Calciolari.
 */
public class RVTempTrue extends RVTruthValue {

	@Override
	public RVFormula clone(){
		return new RVTempTrue();
	}
}
