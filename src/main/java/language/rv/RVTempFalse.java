package language.rv;

/**
 * RVTempFalse
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 *
 * @author Simone Calciolari.
 */
public class RVTempFalse extends RVTruthValue {

	@Override
	public int ordinalValue(){
		return 2;
	}

	@Override
	public String toString(){
		return "RVTempFalse";
	}

	@Override
	public RVFormula clone() {
		return new RVTempFalse();
	}
}
