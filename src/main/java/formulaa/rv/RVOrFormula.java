package formulaa.rv;

/**
 * RVOrFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public class RVOrFormula extends RVBinaryFormula {

	public RVOrFormula(RVFormula left, RVFormula right){
		super(left, right);
	}

	@Override
	public RVTruthValue evaluate(){

		RVTruthValue left = this.getLeftFormula().evaluate();
		RVTruthValue right = this.getRightFormula().evaluate();

		if (left.ordinalValue() < right.ordinalValue()){
			return left;
		} else {
			return right;
		}
	}

	@Override
	public RVFormula clone(){
		return new RVOrFormula(this.getLeftFormula().clone(),
				this.getRightFormula().clone());
	}

	@Override
	public String toString(){
		return "(" + this.getLeftFormula().toString() + ") rvOR (" + this.getRightFormula().toString() + ")";
	}
}
