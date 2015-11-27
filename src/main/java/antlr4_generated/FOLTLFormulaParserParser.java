// Generated from FOLTLFormulaParser.g4 by ANTLR 4.5

    package antlr4_generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOLTLFormulaParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LAST=2, WEAKUNTIL=3, UNTIL=4, RELEASE=5, GLOBALLY=6, EVENTUALLY=7, 
		WEAKNEXT=8, NEXT=9, LPAREN=10, RPAREN=11, DOUBLEIMPLY=12, IMPLY=13, AND=14, 
		OR=15, NOT=16, FORALL=17, EXISTS=18, EQUAL=19, FALSEATOM=20, TRUEATOM=21, 
		VARIABLE=22, CONSTANT=23, PREPOSITION=24, WS=25;
	public static final int
		RULE_start = 0, RULE_foltlFormula = 1, RULE_acrossQuantifiedFormula = 2, 
		RULE_temporalDoubleImplication = 3, RULE_temporalImplication = 4, RULE_temporalDisjunction = 5, 
		RULE_temporalConjunction = 6, RULE_weakUntil = 7, RULE_release = 8, RULE_until = 9, 
		RULE_globally = 10, RULE_eventually = 11, RULE_weakNext = 12, RULE_next = 13, 
		RULE_temporalNegation = 14, RULE_ltlfAtom = 15, RULE_localQuantifiedFormula = 16, 
		RULE_localDoubleImplication = 17, RULE_localImplication = 18, RULE_localDisjunction = 19, 
		RULE_localConjunction = 20, RULE_localNegation = 21, RULE_folAtom = 22, 
		RULE_equality = 23, RULE_predicate = 24;
	public static final String[] ruleNames = {
		"start", "foltlFormula", "acrossQuantifiedFormula", "temporalDoubleImplication", 
		"temporalImplication", "temporalDisjunction", "temporalConjunction", "weakUntil", 
		"release", "until", "globally", "eventually", "weakNext", "next", "temporalNegation", 
		"ltlfAtom", "localQuantifiedFormula", "localDoubleImplication", "localImplication", 
		"localDisjunction", "localConjunction", "localNegation", "folAtom", "equality", 
		"predicate"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, null, null, null, null, null, null, null, "'('", "')'", 
		"'<->'", "'->'", null, null, "'!'", "'Forall'", "'Exists'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", 
		"WEAKNEXT", "NEXT", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", 
		"OR", "NOT", "FORALL", "EXISTS", "EQUAL", "FALSEATOM", "TRUEATOM", "VARIABLE", 
		"CONSTANT", "PREPOSITION", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FOLTLFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOLTLFormulaParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public FoltlFormulaContext foltlFormula() {
			return getRuleContext(FoltlFormulaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FOLTLFormulaParserParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			foltlFormula();
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FoltlFormulaContext extends ParserRuleContext {
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public AcrossQuantifiedFormulaContext acrossQuantifiedFormula() {
			return getRuleContext(AcrossQuantifiedFormulaContext.class,0);
		}
		public FoltlFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foltlFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitFoltlFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FoltlFormulaContext foltlFormula() throws RecognitionException {
		FoltlFormulaContext _localctx = new FoltlFormulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_foltlFormula);
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				localQuantifiedFormula();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				acrossQuantifiedFormula();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AcrossQuantifiedFormulaContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public AcrossQuantifiedFormulaContext acrossQuantifiedFormula() {
			return getRuleContext(AcrossQuantifiedFormulaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public TerminalNode VARIABLE() { return getToken(FOLTLFormulaParserParser.VARIABLE, 0); }
		public TerminalNode FORALL() { return getToken(FOLTLFormulaParserParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(FOLTLFormulaParserParser.EXISTS, 0); }
		public TemporalDoubleImplicationContext temporalDoubleImplication() {
			return getRuleContext(TemporalDoubleImplicationContext.class,0);
		}
		public AcrossQuantifiedFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acrossQuantifiedFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitAcrossQuantifiedFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcrossQuantifiedFormulaContext acrossQuantifiedFormula() throws RecognitionException {
		AcrossQuantifiedFormulaContext _localctx = new AcrossQuantifiedFormulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_acrossQuantifiedFormula);
		int _la;
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(57);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(58);
				match(VARIABLE);
				}
				setState(60);
				match(LPAREN);
				setState(61);
				acrossQuantifiedFormula();
				setState(62);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				temporalDoubleImplication();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalDoubleImplicationContext extends ParserRuleContext {
		public List<TemporalImplicationContext> temporalImplication() {
			return getRuleContexts(TemporalImplicationContext.class);
		}
		public TemporalImplicationContext temporalImplication(int i) {
			return getRuleContext(TemporalImplicationContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(FOLTLFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.DOUBLEIMPLY, i);
		}
		public TemporalDoubleImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalDoubleImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalDoubleImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalDoubleImplicationContext temporalDoubleImplication() throws RecognitionException {
		TemporalDoubleImplicationContext _localctx = new TemporalDoubleImplicationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_temporalDoubleImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			temporalImplication();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(68);
				match(DOUBLEIMPLY);
				setState(69);
				temporalImplication();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalImplicationContext extends ParserRuleContext {
		public List<TemporalDisjunctionContext> temporalDisjunction() {
			return getRuleContexts(TemporalDisjunctionContext.class);
		}
		public TemporalDisjunctionContext temporalDisjunction(int i) {
			return getRuleContext(TemporalDisjunctionContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(FOLTLFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.IMPLY, i);
		}
		public TemporalImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalImplicationContext temporalImplication() throws RecognitionException {
		TemporalImplicationContext _localctx = new TemporalImplicationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_temporalImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			temporalDisjunction();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(76);
				match(IMPLY);
				setState(77);
				temporalDisjunction();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalDisjunctionContext extends ParserRuleContext {
		public List<TemporalConjunctionContext> temporalConjunction() {
			return getRuleContexts(TemporalConjunctionContext.class);
		}
		public TemporalConjunctionContext temporalConjunction(int i) {
			return getRuleContext(TemporalConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FOLTLFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FOLTLFormulaParserParser.OR, i);
		}
		public TemporalDisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalDisjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalDisjunctionContext temporalDisjunction() throws RecognitionException {
		TemporalDisjunctionContext _localctx = new TemporalDisjunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_temporalDisjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			temporalConjunction();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(84);
				match(OR);
				setState(85);
				temporalConjunction();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalConjunctionContext extends ParserRuleContext {
		public List<WeakUntilContext> weakUntil() {
			return getRuleContexts(WeakUntilContext.class);
		}
		public WeakUntilContext weakUntil(int i) {
			return getRuleContext(WeakUntilContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FOLTLFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FOLTLFormulaParserParser.AND, i);
		}
		public TemporalConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalConjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalConjunctionContext temporalConjunction() throws RecognitionException {
		TemporalConjunctionContext _localctx = new TemporalConjunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_temporalConjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			weakUntil();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(92);
				match(AND);
				setState(93);
				weakUntil();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeakUntilContext extends ParserRuleContext {
		public List<ReleaseContext> release() {
			return getRuleContexts(ReleaseContext.class);
		}
		public ReleaseContext release(int i) {
			return getRuleContext(ReleaseContext.class,i);
		}
		public List<TerminalNode> WEAKUNTIL() { return getTokens(FOLTLFormulaParserParser.WEAKUNTIL); }
		public TerminalNode WEAKUNTIL(int i) {
			return getToken(FOLTLFormulaParserParser.WEAKUNTIL, i);
		}
		public WeakUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weakUntil; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitWeakUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeakUntilContext weakUntil() throws RecognitionException {
		WeakUntilContext _localctx = new WeakUntilContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_weakUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			release();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WEAKUNTIL) {
				{
				{
				setState(100);
				match(WEAKUNTIL);
				setState(101);
				release();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReleaseContext extends ParserRuleContext {
		public List<UntilContext> until() {
			return getRuleContexts(UntilContext.class);
		}
		public UntilContext until(int i) {
			return getRuleContext(UntilContext.class,i);
		}
		public List<TerminalNode> RELEASE() { return getTokens(FOLTLFormulaParserParser.RELEASE); }
		public TerminalNode RELEASE(int i) {
			return getToken(FOLTLFormulaParserParser.RELEASE, i);
		}
		public ReleaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_release; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitRelease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReleaseContext release() throws RecognitionException {
		ReleaseContext _localctx = new ReleaseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_release);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			until();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(108);
				match(RELEASE);
				setState(109);
				until();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UntilContext extends ParserRuleContext {
		public List<GloballyContext> globally() {
			return getRuleContexts(GloballyContext.class);
		}
		public GloballyContext globally(int i) {
			return getRuleContext(GloballyContext.class,i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(FOLTLFormulaParserParser.UNTIL); }
		public TerminalNode UNTIL(int i) {
			return getToken(FOLTLFormulaParserParser.UNTIL, i);
		}
		public UntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_until; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntilContext until() throws RecognitionException {
		UntilContext _localctx = new UntilContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_until);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			globally();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(116);
				match(UNTIL);
				setState(117);
				globally();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GloballyContext extends ParserRuleContext {
		public EventuallyContext eventually() {
			return getRuleContext(EventuallyContext.class,0);
		}
		public TerminalNode GLOBALLY() { return getToken(FOLTLFormulaParserParser.GLOBALLY, 0); }
		public GloballyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globally; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitGlobally(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GloballyContext globally() throws RecognitionException {
		GloballyContext _localctx = new GloballyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_globally);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if (_la==GLOBALLY) {
				{
				setState(123);
				match(GLOBALLY);
				}
			}

			setState(126);
			eventually();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventuallyContext extends ParserRuleContext {
		public WeakNextContext weakNext() {
			return getRuleContext(WeakNextContext.class,0);
		}
		public TerminalNode EVENTUALLY() { return getToken(FOLTLFormulaParserParser.EVENTUALLY, 0); }
		public EventuallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventually; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitEventually(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventuallyContext eventually() throws RecognitionException {
		EventuallyContext _localctx = new EventuallyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eventually);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if (_la==EVENTUALLY) {
				{
				setState(128);
				match(EVENTUALLY);
				}
			}

			setState(131);
			weakNext();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WeakNextContext extends ParserRuleContext {
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public TerminalNode WEAKNEXT() { return getToken(FOLTLFormulaParserParser.WEAKNEXT, 0); }
		public WeakNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weakNext; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitWeakNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeakNextContext weakNext() throws RecognitionException {
		WeakNextContext _localctx = new WeakNextContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_weakNext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if (_la==WEAKNEXT) {
				{
				setState(133);
				match(WEAKNEXT);
				}
			}

			setState(136);
			next();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NextContext extends ParserRuleContext {
		public TemporalNegationContext temporalNegation() {
			return getRuleContext(TemporalNegationContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(FOLTLFormulaParserParser.NEXT, 0); }
		public NextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitNext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextContext next() throws RecognitionException {
		NextContext _localctx = new NextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_next);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(138);
				match(NEXT);
				}
			}

			setState(141);
			temporalNegation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalNegationContext extends ParserRuleContext {
		public LtlfAtomContext ltlfAtom() {
			return getRuleContext(LtlfAtomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TemporalDoubleImplicationContext temporalDoubleImplication() {
			return getRuleContext(TemporalDoubleImplicationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public TemporalNegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalNegation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalNegationContext temporalNegation() throws RecognitionException {
		TemporalNegationContext _localctx = new TemporalNegationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_temporalNegation);
		int _la;
		try {
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				ltlfAtom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(144);
					match(NOT);
					}
				}

				setState(147);
				match(LPAREN);
				setState(148);
				temporalDoubleImplication();
				setState(149);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LtlfAtomContext extends ParserRuleContext {
		public TerminalNode LAST() { return getToken(FOLTLFormulaParserParser.LAST, 0); }
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public LtlfAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltlfAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLtlfAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LtlfAtomContext ltlfAtom() throws RecognitionException {
		LtlfAtomContext _localctx = new LtlfAtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ltlfAtom);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(LAST);
				}
				break;
			case LPAREN:
			case NOT:
			case FORALL:
			case EXISTS:
			case FALSEATOM:
			case TRUEATOM:
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				localQuantifiedFormula();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalQuantifiedFormulaContext extends ParserRuleContext {
		public LocalDoubleImplicationContext localDoubleImplication() {
			return getRuleContext(LocalDoubleImplicationContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(FOLTLFormulaParserParser.VARIABLE, 0); }
		public TerminalNode FORALL() { return getToken(FOLTLFormulaParserParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(FOLTLFormulaParserParser.EXISTS, 0); }
		public LocalQuantifiedFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localQuantifiedFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalQuantifiedFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalQuantifiedFormulaContext localQuantifiedFormula() throws RecognitionException {
		LocalQuantifiedFormulaContext _localctx = new LocalQuantifiedFormulaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_localQuantifiedFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if (_la==FORALL || _la==EXISTS) {
				{
				setState(157);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(158);
				match(VARIABLE);
				}
			}

			setState(161);
			localDoubleImplication();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalDoubleImplicationContext extends ParserRuleContext {
		public List<LocalImplicationContext> localImplication() {
			return getRuleContexts(LocalImplicationContext.class);
		}
		public LocalImplicationContext localImplication(int i) {
			return getRuleContext(LocalImplicationContext.class,i);
		}
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(FOLTLFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.DOUBLEIMPLY, i);
		}
		public LocalDoubleImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDoubleImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalDoubleImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDoubleImplicationContext localDoubleImplication() throws RecognitionException {
		LocalDoubleImplicationContext _localctx = new LocalDoubleImplicationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_localDoubleImplication);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			localImplication();
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164);
					match(DOUBLEIMPLY);
					setState(165);
					localImplication();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalImplicationContext extends ParserRuleContext {
		public List<LocalDisjunctionContext> localDisjunction() {
			return getRuleContexts(LocalDisjunctionContext.class);
		}
		public LocalDisjunctionContext localDisjunction(int i) {
			return getRuleContext(LocalDisjunctionContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(FOLTLFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.IMPLY, i);
		}
		public LocalImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalImplicationContext localImplication() throws RecognitionException {
		LocalImplicationContext _localctx = new LocalImplicationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_localImplication);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			localDisjunction();
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(172);
					match(IMPLY);
					setState(173);
					localDisjunction();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalDisjunctionContext extends ParserRuleContext {
		public List<LocalConjunctionContext> localConjunction() {
			return getRuleContexts(LocalConjunctionContext.class);
		}
		public LocalConjunctionContext localConjunction(int i) {
			return getRuleContext(LocalConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FOLTLFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FOLTLFormulaParserParser.OR, i);
		}
		public LocalDisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDisjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDisjunctionContext localDisjunction() throws RecognitionException {
		LocalDisjunctionContext _localctx = new LocalDisjunctionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_localDisjunction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			localConjunction();
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(180);
					match(OR);
					setState(181);
					localConjunction();
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalConjunctionContext extends ParserRuleContext {
		public List<LocalNegationContext> localNegation() {
			return getRuleContexts(LocalNegationContext.class);
		}
		public LocalNegationContext localNegation(int i) {
			return getRuleContext(LocalNegationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FOLTLFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FOLTLFormulaParserParser.AND, i);
		}
		public LocalConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localConjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalConjunctionContext localConjunction() throws RecognitionException {
		LocalConjunctionContext _localctx = new LocalConjunctionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_localConjunction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			localNegation();
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(188);
					match(AND);
					setState(189);
					localNegation();
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalNegationContext extends ParserRuleContext {
		public FolAtomContext folAtom() {
			return getRuleContext(FolAtomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public LocalNegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localNegation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitLocalNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalNegationContext localNegation() throws RecognitionException {
		LocalNegationContext _localctx = new LocalNegationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_localNegation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(195);
				match(NOT);
				}
			}

			setState(203);
			switch (_input.LA(1)) {
			case FALSEATOM:
			case TRUEATOM:
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				{
				setState(198);
				folAtom();
				}
				break;
			case LPAREN:
				{
				setState(199);
				match(LPAREN);
				setState(200);
				localQuantifiedFormula();
				setState(201);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FolAtomContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode TRUEATOM() { return getToken(FOLTLFormulaParserParser.TRUEATOM, 0); }
		public TerminalNode FALSEATOM() { return getToken(FOLTLFormulaParserParser.FALSEATOM, 0); }
		public FolAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitFolAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FolAtomContext folAtom() throws RecognitionException {
		FolAtomContext _localctx = new FolAtomContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_folAtom);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case PREPOSITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				predicate();
				}
				break;
			case VARIABLE:
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				equality();
				}
				break;
			case TRUEATOM:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(TRUEATOM);
				}
				break;
			case FALSEATOM:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				match(FALSEATOM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(FOLTLFormulaParserParser.EQUAL, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(FOLTLFormulaParserParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLTLFormulaParserParser.VARIABLE, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(FOLTLFormulaParserParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOLTLFormulaParserParser.CONSTANT, i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(212);
			match(EQUAL);
			setState(213);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREPOSITION() { return getToken(FOLTLFormulaParserParser.PREPOSITION, 0); }
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(FOLTLFormulaParserParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLTLFormulaParserParser.VARIABLE, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(FOLTLFormulaParserParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOLTLFormulaParserParser.CONSTANT, i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(PREPOSITION);
			setState(216);
			match(LPAREN);
			setState(217);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(218);
				match(T__0);
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==VARIABLE || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00e6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4D\n\4\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\6\3\6\3\6\7\6Q\n\6\f"+
		"\6\16\6T\13\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\7\ba\n"+
		"\b\f\b\16\bd\13\b\3\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\n\3\n\3\n\7\n"+
		"q\n\n\f\n\16\nt\13\n\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\5"+
		"\f\177\n\f\3\f\3\f\3\r\5\r\u0084\n\r\3\r\3\r\3\16\5\16\u0089\n\16\3\16"+
		"\3\16\3\17\5\17\u008e\n\17\3\17\3\17\3\20\3\20\5\20\u0094\n\20\3\20\3"+
		"\20\3\20\3\20\5\20\u009a\n\20\3\21\3\21\5\21\u009e\n\21\3\22\3\22\5\22"+
		"\u00a2\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u00a9\n\23\f\23\16\23\u00ac"+
		"\13\23\3\24\3\24\3\24\7\24\u00b1\n\24\f\24\16\24\u00b4\13\24\3\25\3\25"+
		"\3\25\7\25\u00b9\n\25\f\25\16\25\u00bc\13\25\3\26\3\26\3\26\7\26\u00c1"+
		"\n\26\f\26\16\26\u00c4\13\26\3\27\5\27\u00c7\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00ce\n\27\3\30\3\30\3\30\3\30\5\30\u00d4\n\30\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u00df\n\32\f\32\16\32\u00e2\13"+
		"\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\2\4\3\2\23\24\3\2\30\31\u00e7\2\64\3\2\2\2\49\3\2\2\2\6C\3"+
		"\2\2\2\bE\3\2\2\2\nM\3\2\2\2\fU\3\2\2\2\16]\3\2\2\2\20e\3\2\2\2\22m\3"+
		"\2\2\2\24u\3\2\2\2\26~\3\2\2\2\30\u0083\3\2\2\2\32\u0088\3\2\2\2\34\u008d"+
		"\3\2\2\2\36\u0099\3\2\2\2 \u009d\3\2\2\2\"\u00a1\3\2\2\2$\u00a5\3\2\2"+
		"\2&\u00ad\3\2\2\2(\u00b5\3\2\2\2*\u00bd\3\2\2\2,\u00c6\3\2\2\2.\u00d3"+
		"\3\2\2\2\60\u00d5\3\2\2\2\62\u00d9\3\2\2\2\64\65\5\4\3\2\65\66\7\2\2\3"+
		"\66\3\3\2\2\2\67:\5\"\22\28:\5\6\4\29\67\3\2\2\298\3\2\2\2:\5\3\2\2\2"+
		";<\t\2\2\2<=\7\30\2\2=>\3\2\2\2>?\7\f\2\2?@\5\6\4\2@A\7\r\2\2AD\3\2\2"+
		"\2BD\5\b\5\2C;\3\2\2\2CB\3\2\2\2D\7\3\2\2\2EJ\5\n\6\2FG\7\16\2\2GI\5\n"+
		"\6\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\t\3\2\2\2LJ\3\2\2\2MR\5"+
		"\f\7\2NO\7\17\2\2OQ\5\f\7\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\13"+
		"\3\2\2\2TR\3\2\2\2UZ\5\16\b\2VW\7\21\2\2WY\5\16\b\2XV\3\2\2\2Y\\\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]b\5\20\t\2^_\7\20\2\2_a\5"+
		"\20\t\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\17\3\2\2\2db\3\2\2\2"+
		"ej\5\22\n\2fg\7\5\2\2gi\5\22\n\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2"+
		"\2k\21\3\2\2\2lj\3\2\2\2mr\5\24\13\2no\7\7\2\2oq\5\24\13\2pn\3\2\2\2q"+
		"t\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\23\3\2\2\2tr\3\2\2\2uz\5\26\f\2vw\7\6\2"+
		"\2wy\5\26\f\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\25\3\2\2\2|z\3"+
		"\2\2\2}\177\7\b\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\5\30\r\2\u0081\27\3\2\2\2\u0082\u0084\7\t\2\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\5\32\16\2\u0086\31\3\2"+
		"\2\2\u0087\u0089\7\n\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\5\34\17\2\u008b\33\3\2\2\2\u008c\u008e\7\13"+
		"\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\5\36\20\2\u0090\35\3\2\2\2\u0091\u009a\5 \21\2\u0092\u0094\7\22"+
		"\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\7\f\2\2\u0096\u0097\5\b\5\2\u0097\u0098\7\r\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0091\3\2\2\2\u0099\u0093\3\2\2\2\u009a\37\3\2\2\2\u009b\u009e"+
		"\7\4\2\2\u009c\u009e\5\"\22\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2"+
		"\u009e!\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\u00a2\7\30\2\2\u00a1\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\5$\23\2\u00a4"+
		"#\3\2\2\2\u00a5\u00aa\5&\24\2\u00a6\u00a7\7\16\2\2\u00a7\u00a9\5&\24\2"+
		"\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab%\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b2\5(\25\2\u00ae"+
		"\u00af\7\17\2\2\u00af\u00b1\5(\25\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\'\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00ba\5*\26\2\u00b6\u00b7\7\21\2\2\u00b7\u00b9\5*\26\2"+
		"\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb)\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c2\5,\27\2\u00be"+
		"\u00bf\7\20\2\2\u00bf\u00c1\5,\27\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3+\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00c7\7\22\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7\u00cd\3\2\2\2\u00c8\u00ce\5.\30\2\u00c9\u00ca\7\f\2\2\u00ca\u00cb"+
		"\5\"\22\2\u00cb\u00cc\7\r\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c8\3\2\2\2"+
		"\u00cd\u00c9\3\2\2\2\u00ce-\3\2\2\2\u00cf\u00d4\5\62\32\2\u00d0\u00d4"+
		"\5\60\31\2\u00d1\u00d4\7\27\2\2\u00d2\u00d4\7\26\2\2\u00d3\u00cf\3\2\2"+
		"\2\u00d3\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4/"+
		"\3\2\2\2\u00d5\u00d6\t\3\2\2\u00d6\u00d7\7\25\2\2\u00d7\u00d8\t\3\2\2"+
		"\u00d8\61\3\2\2\2\u00d9\u00da\7\32\2\2\u00da\u00db\7\f\2\2\u00db\u00e0"+
		"\t\3\2\2\u00dc\u00dd\7\3\2\2\u00dd\u00df\t\3\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\r\2\2\u00e4\63\3\2\2\2\339CJRZ"+
		"bjrz~\u0083\u0088\u008d\u0093\u0099\u009d\u00a1\u00aa\u00b2\u00ba\u00c2"+
		"\u00c6\u00cd\u00d3\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}