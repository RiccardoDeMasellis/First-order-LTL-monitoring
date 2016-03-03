package runtimeVerification;

import language.foltl.semantics.FoLtlAssignment;
import rationals.State;
import util.Pair;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ReachabilityMap
 * <br>
 * Created by Simone Calciolari on 22/02/16.
 *
 * @author Simone Calciolari.
 */
public class ReachabilityMap extends HashMap<Pair<State, FoLtlAssignment>, HashSet<State>> {

	@Override
	public String toString(){
		String res = "";

		for (Pair<State, FoLtlAssignment> pair : this.keySet()){
			res = res + "State " + pair.getFirst() + "; Assignment: " + pair.getSecond() + "\n";
			res = res + "Reachable states: " + this.get(pair) + "\n\n";
		}

		return res;
	}
}
