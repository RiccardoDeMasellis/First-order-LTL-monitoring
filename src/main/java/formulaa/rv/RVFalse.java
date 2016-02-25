package formulaa.rv;

/**
 * RVFalse
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 *
 * @author Simone Calciolari.
 */
public class RVFalse extends RVTruthValue {

	@Override
	public int ordinalValue(){
		return 3;
	}

	@Override
	public RVFormula clone() {
		return new RVFalse();
	}
}
