package formulaa.foltl.semantics;

import formulaa.foltl.*;
import net.sf.tweety.logics.fol.semantics.HerbrandInterpretation;
import net.sf.tweety.logics.fol.syntax.FOLAtom;

import java.util.HashSet;

/**
 * FoLtlInterpretation
 * <br>
 * Created by Simone Calciolari on 29/02/16.
 * @author Simone Calciolari.
 */
public class FoLtlInterpretation extends HashSet<FoLtlAtomicFormula> {

	private HashSet<FoLtlConstant> domain;

	protected FoLtlInterpretation(){
		super();
		this.domain = new HashSet<>();
	}

	public FoLtlInterpretation(HashSet<FoLtlConstant> domain){
		super();
		this.domain = domain;

		for (FoLtlConstant c : this.domain){
			//Artificial equality for tweety translation
			this.add(new FoLtlLocalEqualityFormula(c, c));
		}
	}

	public HerbrandInterpretation toTweetyInterpretation(){
		HerbrandInterpretation hi = new HerbrandInterpretation();

		for (FoLtlAtomicFormula atom : this){
			hi.add((FOLAtom) atom.toTweetyFol());
		}

		return hi;
	}
}
