package formulaa.rv;

/**
 * RVAndFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public class RVAndFormula extends RVBinaryFormula {

	public RVAndFormula(RVFormula left, RVFormula right){
		super(left, right);
	}

	@Override
	public RVFormula clone(){
		return new RVAndFormula(this.getLeftFormula().clone(),
				this.getRightFormula().clone());
	}

	@Override
	public String toString(){
		return "(" + this.getLeftFormula().toString() + ") rvAND (" + this.getRightFormula().toString() + ")";
	}
}
