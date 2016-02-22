package runtimeVerification;

import formulaa.foltl.semantics.FoLtlAssignment;
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
}
