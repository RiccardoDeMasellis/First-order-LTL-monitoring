package language;

/**
 * Created by Simone Calciolari on 12/08/15.
 */
public interface AtomicFormula extends Formula {

	@Override
	default Formula nnf(){
		return this.clone();
	}

}
