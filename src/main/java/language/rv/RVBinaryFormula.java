package language.rv;

/**
 * RVBinaryFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public abstract class RVBinaryFormula implements RVFormula {

	private RVFormula left;
	private RVFormula right;

	protected RVBinaryFormula(RVFormula left, RVFormula right){
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object o){
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			RVBinaryFormula other = (RVBinaryFormula) o;
			res = this.getLeftFormula().equals(other.getLeftFormula())
					&& this.getRightFormula().equals(other.getRightFormula());
		}

		return res;
	}

	@Override
	public abstract RVFormula clone();

	@Override
	public int hashCode(){
		int res;
		res = this.getLeftFormula() != null ? this.getLeftFormula().hashCode() : 0;
		res = res * 31;
		res = res + (this.getRightFormula() != null ? this.getRightFormula().hashCode() : 0);
		return res;
	}

	public RVFormula getLeftFormula() {
		return left;
	}

	public RVFormula getRightFormula() {
		return right;
	}
}
