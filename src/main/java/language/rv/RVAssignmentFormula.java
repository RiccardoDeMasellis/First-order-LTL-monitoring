package language.rv;

import language.foltl.semantics.FoLtlAssignment;

import java.util.HashMap;

/**
 * RVAssignmentFormula
 * <br>
 * Created by Simone Calciolari on 25/02/16.
 * @author Simone Calciolari.
 */
public class RVAssignmentFormula implements RVAtomicFormula {

	private FoLtlAssignment assignment;

	public RVAssignmentFormula(FoLtlAssignment assignment){
		this.assignment = assignment;
	}

	@Override
	public RVTruthValue evaluate(HashMap<FoLtlAssignment, RVTruthValue> assignmentRVTruthMap){
		RVTruthValue res = assignmentRVTruthMap.get(this.assignment);

		if (res == null){
			throw new RuntimeException("Cannot evaluate this assignment");
		}

		return res;
	}

	@Override
	public String toString() {
		return "(" + this.assignment.toString() + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o != null && this.getClass().equals(o.getClass())){
			RVAssignmentFormula other = (RVAssignmentFormula) o;
			res = this.assignment.equals(other.getAssignment());
		}

		return res;
	}

	@Override
	public int hashCode() {
		return this.assignment.hashCode();
	}

	@Override
	public RVFormula clone(){
		return new RVAssignmentFormula(this.assignment);
	}

	public FoLtlAssignment getAssignment(){
		return assignment;
	}
}
