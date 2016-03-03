package runtimeVerification;

import language.foltl.semantics.FoLtlAssignment;
import language.rv.RVTruthValue;
import rationals.State;
import util.Pair;

import java.util.HashMap;

/**
 * StateRVTrurhValueMap
 * <br>
 * Created by Simone Calciolari on 22/02/16.
 *
 * @author Simone Calciolari.
 */
public class StateRVTruthValueMap extends HashMap<Pair<State, FoLtlAssignment>, RVTruthValue> {
}
