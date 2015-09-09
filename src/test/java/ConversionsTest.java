import static util.ParsingUtils.*;
import static util.TweetyTranslator.*;

import formula.ltlf.*;
import formulaa.foltl.*;
import formulaa.foltl.semantics.FoLtlAssignment;
import net.sf.tweety.logics.commons.syntax.Constant;
import net.sf.tweety.logics.fol.syntax.FolFormula;
import net.sf.tweety.logics.fol.syntax.FolSignature;
import net.sf.tweety.logics.pl.syntax.Conjunction;
import net.sf.tweety.logics.pl.syntax.Disjunction;
import net.sf.tweety.logics.pl.syntax.Proposition;
import net.sf.tweety.logics.pl.syntax.PropositionalFormula;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by Simone Calciolari on 31/08/15.
 */
public class ConversionsTest {

	@Test
	public void testPropositionalization(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		parseLTLfFormula("pa");
		System.out.println("\n\n*** FOLTL LOCAL FORMULA PROPOSITIONALIZATION TEST ***\n");

		FoLtlAssignment assignment = new FoLtlAssignment();
		LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		LTLfFormula expected = parseLTLfFormula("pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseLTLfFormula("TRUE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseLTLfFormula("FALSE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseLTLfFormula("false");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = a");
		expected = parseLTLfFormula("TRUE");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//Simple boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(b)");
		expected = parseLTLfFormula("!pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && P(b)");
		expected = parseLTLfFormula("pa & pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) | P(b)");
		expected = parseLTLfFormula("pa | pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(b)");
		expected = parseLTLfFormula("pa -> pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> P(b)");
		expected = parseLTLfFormula("pa <-> pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//More intricate boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		expected = parseLTLfFormula("pp || qa && ! vr -> js");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> (P(a) -> (P(a) -> P(a)))");
		expected = parseLTLfFormula("pa -> (pa -> (pa -> pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("!(!(!P(a)))");
		expected = parseLTLfFormula("!(!(!pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		expected = parseLTLfFormula("pa && (pc || (pb | pd)) -> (ps && prst)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		//Testing quantifiers and substitutions
		domain.add(new FoLtlConstant("a"));
		domain.add(new FoLtlConstant("b"));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		expected = parseLTLfFormula("pb || pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseLTLfFormula("pb && pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x) && P(d)");
		expected = parseLTLfFormula("(pb && pd) || (pa && pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x) -> P(d)");
		expected = parseLTLfFormula("(pb -> pd) && (pa -> pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y (P(?x) && P(?y)))");
		expected = parseLTLfFormula("((pb && pb) || (pb && pa)) || ((pa && pb) || (pa && pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment));


		//Testing expansion with sorts

		FoLtlSort sortAB = new FoLtlSort("AB");
		sortAB.add(new FoLtlConstant("a"));
		sortAB.add(new FoLtlConstant("b"));

		FoLtlSort sortC = new FoLtlSort("C");
		sortC.add(new FoLtlConstant("c"));

		domain.add(new FoLtlConstant("c"));

		System.out.println("\nSORT PROPOSITIONALIZATION TEST\n");

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseLTLfFormula("pb || pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		computed.assignSort(new FoLtlVariable("x"), sortC);
		expected = parseLTLfFormula("pc");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y P(?x, ?y))");
		computed.assignSort(new FoLtlVariable("x"), sortAB);
		expected = parseLTLfFormula("(pbc || pbb || pba) || (pac || pab || paa)");
		assertEquals("", expected, computed.propositionalize(domain, assignment));

	}

	@Test
	public void testTweetyProps(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");
		parseLTLfFormula("pa");
		System.out.println("\n\n*** FOLTL LOCAL FORMULA TWEETY TRANSLATION TEST ***\n");

		FoLtlAssignment assignment = new FoLtlAssignment();
		LinkedHashSet<FoLtlConstant> domain = new LinkedHashSet<>();

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		PropositionalFormula expected = parseTweetyFormula("pa");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseTweetyFormula("+");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseTweetyFormula("-");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseTweetyFormula("-");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = a");
		expected = parseTweetyFormula("+");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//Simple boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(b)");
		expected = parseTweetyFormula("! pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && P(b)");
		expected = parseTweetyFormula("pa && pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) | P(b)");
		expected = parseTweetyFormula("pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> P(b)");
		expected = parseTweetyFormula("!pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> P(b)");
		expected = parseTweetyFormula("(!pa || pb) && (!pb || pa)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//More intricate boolean conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(p) || Q(a) && ! V(r) -> J(s)");
		expected = parseTweetyFormula("(!pp && (!qa || vr)) || js");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> (P(a) -> (P(a) -> P(a)))");
		expected = parseTweetyFormula("!pa || (!pa || (!pa || (pa)))");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("!(!(!P(a)))");
		expected = parseTweetyFormula("! (!(! pa))");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(s) && P(rst)");
		expected = parseTweetyFormula("(!pa || !pc && (!pb && !pd)) || ps && prst");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		//Testing quantifiers and substitutions
		domain.add(new FoLtlConstant("a"));
		domain.add(new FoLtlConstant("b"));

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		expected = parseTweetyFormula("pa || pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseTweetyFormula("pa && pb");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x) && P(d)");
		expected = parseTweetyFormula("pa && pd || pb && pd");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x) -> P(d)");
		expected = parseTweetyFormula("(!pa || pd) && (!pb || pd)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x (Exists ?y (P(?x) && P(?y)))");
		expected = parseTweetyFormula("(pa && pa || pa && pb) || (pb && pa || pb && pb)");
		assertEquals("", expected, computed.propositionalize(domain, assignment).toTweetyProp());

	}

	@Test
	public void testTweetyFols(){

		//Get parser warnings out of the way
		parseFoLtlFormula("P(a)");

		System.out.println("\n*** TWEETY FOL TRANSLATION TEST ***\n");

		FolSignature signature = new FolSignature();
		signature.add(new Constant("a"));
		signature.add(new Constant("b"));
		signature.add(new Constant("c"));
		signature.add(new Constant("d"));

		//Atom conversions
		FoLtlLocalFormula computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a)");
		FolFormula expected = parseTweetyFolFormula("P(a)", signature, "type (P (Thing))\n");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("TRUE");
		expected = parseTweetyFolFormula("+", signature);
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("FALSE");
		expected = parseTweetyFolFormula("-", signature);
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("a = b");
		expected = parseTweetyFolFormula("Eq(a, b)", signature, "type (Eq (Thing, Thing))\n" );
		assertEquals("", expected, computed.toTweetyFol());

		//Basic boolean operations
		computed = (FoLtlLocalFormula) parseFoLtlFormula("! P(a)");
		expected = parseTweetyFolFormula("! P(a)", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && Q(b)");
		expected = parseTweetyFolFormula("P(a) && Q(b)", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) || Q(b)");
		expected = parseTweetyFolFormula("P(a) || Q(b)", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) -> Q(b)");
		expected = parseTweetyFolFormula("!P(a) || Q(b)", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) <-> Q(b)");
		expected = parseTweetyFolFormula("(!P(a) || Q(b)) && (!Q(b) || P(a))", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		//Quantified formulas
		computed = (FoLtlLocalFormula) parseFoLtlFormula("Forall ?x P(?x)");
		expected = parseTweetyFolFormula("forall X : (P(X))", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("Exists ?x P(?x)");
		expected = parseTweetyFolFormula("exists X : (P(X))", signature, "type (P (Thing))", "type (Q ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		//More Intricate conversions
		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(b) || Q(a) && ! V(a) -> J(b)");
		expected = parseTweetyFolFormula("!P(b) && (!Q(a) || V(a)) || J(b)", signature,
				"type (P (Thing))", "type (Q ( Thing ))", "type (V (Thing))", "type (J ( Thing ))");
		assertEquals("", expected, computed.toTweetyFol());

		computed = (FoLtlLocalFormula) parseFoLtlFormula("P(a) && (P(c) || P(b) || P(d)) -> P(c) && P(a)");
		expected = parseTweetyFolFormula("(!P(a) || !P(c) && (!P(b) && !P(d))) || P(c) && P(a)", signature, "type (P (Thing))");
		assertEquals("", expected, computed.toTweetyFol());



	}

	@Test
	public void testVeriableRetrieve(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(a)");

		System.out.println("\n*** TEST VARIABLE RETRIEVAL ***\n");

		FoLtlFormula formula = parseFoLtlFormula("Exists ?x (G (Forall ?y P(?x, ?y, ?z)))");
		HashSet<FoLtlVariable> localVars = parseVariableSet("y");
		HashSet<FoLtlVariable> acrossVars = parseVariableSet("x");
		System.out.println("Formula: " + formula);
		assertEquals("Local variables", localVars, formula.getLocalVariables());
		assertEquals("Across variables", acrossVars, formula.getAcrossVariables());

		formula = parseFoLtlFormula("Exists ?x ( (Forall ?y P(?x, ?y, ?z)))");
		localVars = parseVariableSet("x", "y");
		acrossVars = parseVariableSet();
		System.out.println("Formula: " + formula);
		assertEquals("Local variables", localVars, formula.getLocalVariables());
		assertEquals("Across variables", acrossVars, formula.getAcrossVariables());

		formula = parseFoLtlFormula("Exists ?x ( Forall ?z ( G (Forall ?y P(?x, ?y, ?z))))");
		localVars = parseVariableSet("y");
		acrossVars = parseVariableSet("x", "z");
		System.out.println("Formula: " + formula);
		assertEquals("Local variables", localVars, formula.getLocalVariables());
		assertEquals("Across variables", acrossVars, formula.getAcrossVariables());

		formula = parseFoLtlFormula("Exists ?x (Forall ?y ((P(?x) && (Forall ?k Q(?k))) U (Exists ?z P(?x, ?y, ?z))))");
		localVars = parseVariableSet("z", "k");
		acrossVars = parseVariableSet("x", "y");
		System.out.println("Formula: " + formula);
		assertEquals("Local variables", localVars, formula.getLocalVariables());
		assertEquals("Across variables", acrossVars, formula.getAcrossVariables());

	}

	@Test
	public void testLTLfTranslation(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(abcd)");
		parseLTLfFormula("a");

		System.out.println("\n\n*** LTLf TRANSLATION TEST ***\n");

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		FoLtlFormula formula = parseFoLtlFormula("G P(a)");
		LTLfFormula computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LTLfFormula expected = parseLTLfFormula("G P_a");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		LTLfGloballyFormula glob = (LTLfGloballyFormula) expected;
		LTLfFormula atom = glob.getNestedFormula();
		FoLtlFormula reverse = new FoLtlGloballyFormula(ltlfTOfoltl.get(atom));
		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("Forall ?x (P(?x) U (P(?x) && Q(tau)))");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("P_?x U P_?x_AND_Q_tau");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		LTLfUntilFormula unt = (LTLfUntilFormula) expected;
		LTLfFormula leftatom = unt.getLeftFormula();
		LTLfFormula rightatom = unt.getRightFormula();

		reverse = new FoLtlAcrossForallFormula(new FoLtlUntilFormula(ltlfTOfoltl.get(leftatom), ltlfTOfoltl.get(rightatom)),
				new FoLtlVariable("x"));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("Forall ?x (P(?x) U (Exists ?y T(?x, ?y))))");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("P_?x U Exists_?y_T_?x_?y");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		unt = (LTLfUntilFormula) expected;
		leftatom = unt.getLeftFormula();
		rightatom = unt.getRightFormula();

		reverse = new FoLtlAcrossForallFormula(new FoLtlUntilFormula(ltlfTOfoltl.get(leftatom), ltlfTOfoltl.get(rightatom)),
				new FoLtlVariable("x"));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("Forall ?x (Exists ?y (P(?x) && (P(?y) U (Exists ?z P(?z)))))");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("P_?x && (P_?y U Exists_?z_P_?z)");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		LTLfTempAndFormula teand = (LTLfTempAndFormula) expected;
		unt = (LTLfUntilFormula) teand.getRightFormula();
		atom = teand.getLeftFormula();
		leftatom = unt.getLeftFormula();
		rightatom = unt.getRightFormula();

		reverse = new FoLtlAcrossForallFormula(
				new FoLtlAcrossExistsFormula(new FoLtlTempAndFormula(ltlfTOfoltl.get(atom),
							new FoLtlUntilFormula(ltlfTOfoltl.get(leftatom), ltlfTOfoltl.get(rightatom))),
						new FoLtlVariable("y")),
				new FoLtlVariable("x"));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("Forall ?y (P(?y) && Q(a, b, ?y) U (P(a) U (G (Exists ?x P(?x)))))");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("P_?y_AND_Q_a_b_?y U (P_a U (G Exists_?x_P_?x))");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		unt = (LTLfUntilFormula) expected;
		atom = unt.getLeftFormula();
		LTLfUntilFormula unt2 = (LTLfUntilFormula) unt.getRightFormula();
		LTLfFormula atom2 = unt2.getLeftFormula();
		glob = (LTLfGloballyFormula) unt2.getRightFormula();
		LTLfFormula atom3 = glob.getNestedFormula();

		reverse = new FoLtlGloballyFormula(ltlfTOfoltl.get(atom3));
		reverse = new FoLtlUntilFormula(ltlfTOfoltl.get(atom2), reverse);
		reverse = new FoLtlUntilFormula(ltlfTOfoltl.get(atom), reverse);
		reverse = new FoLtlAcrossForallFormula(reverse, new FoLtlVariable("y"));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("P(?x) U P(x)");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("P_?x U P_x");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		unt = (LTLfUntilFormula) expected;
		leftatom = unt.getLeftFormula();
		rightatom = unt.getRightFormula();

		reverse = new FoLtlUntilFormula(ltlfTOfoltl.get(leftatom), ltlfTOfoltl.get(rightatom));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("?x1234 = asdrubale U P(x)");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("?x1234_EQ_asdrubale U P_x");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		unt = (LTLfUntilFormula) expected;
		leftatom = unt.getLeftFormula();
		rightatom = unt.getRightFormula();

		reverse = new FoLtlUntilFormula(ltlfTOfoltl.get(leftatom), ltlfTOfoltl.get(rightatom));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();


		formula = parseFoLtlFormula("Forall ?x (Exists ?y ((?x = ?y) U (X (Exists ?z (Q(?x, ?z) && P(?y))))))");
		computed = formula.toLTLf(foltlTOltlf, ltlfTOfoltl);
		expected = parseLTLfFormula("?x_EQ_?y U X Exists_?z_Q_?x_?z_AND_P_?y");

		System.out.println("FO-LTL -> LTLf: " + foltlTOltlf);
		System.out.println("LTLf -> FO-LTL: " + ltlfTOfoltl);
		System.out.println();
		assertEquals("Translation", expected, computed);

		unt = (LTLfUntilFormula) expected;
		atom = unt.getLeftFormula();
		LTLfNextFormula next = (LTLfNextFormula) unt.getRightFormula();
		atom2 = next.getNestedFormula();

		reverse = new FoLtlNextFormula(ltlfTOfoltl.get(atom2));
		reverse = new FoLtlUntilFormula(ltlfTOfoltl.get(atom), reverse);
		reverse = new FoLtlAcrossExistsFormula(reverse, new FoLtlVariable("y"));
		reverse = new FoLtlAcrossForallFormula(reverse, new FoLtlVariable("x"));

		assertEquals("Reverse translation", formula, reverse);

		System.out.println();

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();
	}

	@Test
	public void testTweetyPropToLTLf(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(abcd)");
		parseLTLfFormula("a");
		System.out.println();

		LinkedList<PropositionalFormula> props = new LinkedList<>();
		props.add(new Proposition("a"));
		props.add(new Proposition("b"));
		props.add(new Proposition("c"));
		props.add(new Proposition("d"));
		props.add(new Proposition("e"));

		PropositionalFormula pf = new Conjunction(props);
		System.out.println(tweetyPropToLTLf(pf));

		pf = new Disjunction(props);
		System.out.println(tweetyPropToLTLf(pf));

	}

	@Test
	public void testLTLfToFoLtl(){
		//Used only to get parser's warning messages out of the way
		parseFoLtlFormula("P(abcd)");
		parseLTLfFormula("a");
		System.out.println();

		HashMap<FoLtlFormula, LTLfFormula> foltlTOltlf = new HashMap<>();
		HashMap<LTLfFormula, FoLtlFormula> ltlfTOfoltl = new HashMap<>();

		FoLtlFormula original = parseFoLtlFormula("Forall ?x (Exists ?y ((?x = ?y) U (X (Exists ?z (Q(?x, ?z) && P(?y))))))");
		FoLtlFormula expected = original;

		//Get rid of the across-state quantifiers
		while (expected instanceof FoLtlAcrossQuantifiedFormula){
			expected = (FoLtlFormula) ((FoLtlAcrossQuantifiedFormula) expected).getNestedFormula();
		}

		LTLfFormula translated = original.toLTLf(foltlTOltlf, ltlfTOfoltl);
		LTLfFormula computed = parseLTLfFormula("?x_EQ_?y U X Exists_?z_Q_?x_?z_AND_P_?y");

		assertEquals("", expected, ltlfToFoLtl(computed, ltlfTOfoltl));

		foltlTOltlf.clear();
		ltlfTOfoltl.clear();
	}

	//<editor-fold desc="assertEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertEquals";
		}

		try {
			Assert.assertEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

	//<editor-fold desc="assertNotEquals" defaultstate="collapsed">
	/**
	 * Wrapper for the Assert.assertNotEquals method, used to print some description also in case of success
	 * @param description brief description of the current test case
	 * @param expected first object to be compared
	 * @param computed second object to be compared
	 */
	private static void assertNotEquals(String description, Object expected, Object computed) {

		if (description.equals("")){
			description = "assertNotEquals";
		}

		try {
			Assert.assertNotEquals(description, expected, computed);
			System.out.println(description + ": SUCCESS");
			System.out.println("\t> Expected: " + expected.toString());
			System.out.println("\t> Computed: " + computed.toString());
			System.out.println();
		} catch (AssertionError e){
			throw e;
		}

	}
	//</editor-fold>

}
