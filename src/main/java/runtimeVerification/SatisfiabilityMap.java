package runtimeVerification;

import automata.FoLtlLabel;
import language.foltl.FoLtlFormula;
import language.foltl.FoLtlVariable;
import language.foltl.semantics.FoLtlAssignment;
import util.Pair;

import java.util.HashMap;

/**
 * SatisfiabilityMap
 * <br>
 * Created by Simone Calciolari on 16/02/16.
 * @author Simone Calciolari.
 */
public class SatisfiabilityMap extends HashMap<Pair<FoLtlLabel, FoLtlAssignment>, Boolean> {

	@Override
	public String toString(){
		String res = "";

		for (Pair<FoLtlLabel, FoLtlAssignment> pair : this.keySet()){

			FoLtlLabel label = pair.getFirst();

			if (label instanceof FoLtlFormula){
				FoLtlAssignment assignment = pair.getSecond();

				for (FoLtlVariable v : assignment.keySet()){
					res = res + v.toString() + " <- " + assignment.get(v).toString() + "\n";
				}

				res = res + label.toString() + ": ";

				if (this.get(pair)){
					res = res + "SATISFIABLE\n";
				} else {
					res = res + "UNSATISFIABLE\n";
				}
			}
		}

		return res;
	}
}
