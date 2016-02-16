package runtimeVerification;

import automata.FoLtlEmptyTrace;
import automata.FoLtlLabel;
import formulaa.foltl.semantics.FoLtlAssignment;
import util.Pair;

import java.util.HashMap;

/**
 * SatisfiabilityMap
 * <br>
 * Created by Simone Calciolari on 16/02/16.
 * @author Simone Calciolari.
 */
public class SatisfiabilityMap extends HashMap<Pair<FoLtlLabel, FoLtlAssignment>, Boolean> {
}
