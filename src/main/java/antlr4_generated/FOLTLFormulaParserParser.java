// Generated from FOLTLFormulaParser.g4 by ANTLR 4.3

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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LAST=2, WEAKUNTIL=3, UNTIL=4, RELEASE=5, GLOBALLY=6, EVENTUALLY=7, 
		WEAKNEXT=8, NEXT=9, LPAREN=10, RPAREN=11, DOUBLEIMPLY=12, IMPLY=13, AND=14, 
		OR=15, NOT=16, FORALL=17, EXISTS=18, EQUAL=19, VARIABLE=20, CONSTANT=21, 
		PREPOSITION=22, WS=23, LSEPARATOR=24, RSEPARATOR=25;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", 
		"EVENTUALLY", "WEAKNEXT", "NEXT", "'('", "')'", "'<->'", "'->'", "AND", 
		"OR", "'!'", "'Forall'", "'Exists'", "'='", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"WS", "LSEPARATOR", "RSEPARATOR"
	};
	public static final int
		RULE_start = 0, RULE_acrossQuantifiedFormula = 1, RULE_temporalFormula = 2, 
		RULE_temporalDoubleImplication = 3, RULE_temporalImplication = 4, RULE_temporalDisjunction = 5, 
		RULE_temporalConjunction = 6, RULE_weakUntil = 7, RULE_release = 8, RULE_until = 9, 
		RULE_globally = 10, RULE_eventually = 11, RULE_weakNext = 12, RULE_next = 13, 
		RULE_notTemp = 14, RULE_ltlfAtom = 15, RULE_localQuantifiedFormula = 16, 
		RULE_localDoubleImplication = 17, RULE_localImplication = 18, RULE_localDisjunction = 19, 
		RULE_localConjunction = 20, RULE_localNegation = 21, RULE_predicate = 22, 
		RULE_equality = 23, RULE_predicateTuple = 24, RULE_term = 25;
	public static final String[] ruleNames = {
		"start", "acrossQuantifiedFormula", "temporalFormula", "temporalDoubleImplication", 
		"temporalImplication", "temporalDisjunction", "temporalConjunction", "weakUntil", 
		"release", "until", "globally", "eventually", "weakNext", "next", "notTemp", 
		"ltlfAtom", "localQuantifiedFormula", "localDoubleImplication", "localImplication", 
		"localDisjunction", "localConjunction", "localNegation", "predicate", 
		"equality", "predicateTuple", "term"
	};

	@Override
	public String getGrammarFileName() { return "FOLTLFormulaParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode EOF() { return getToken(FOLTLFormulaParserParser.EOF, 0); }
		public AcrossQuantifiedFormulaContext acrossQuantifiedFormula() {
			return getRuleContext(AcrossQuantifiedFormulaContext.class,0);
		}
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
			setState(52); acrossQuantifiedFormula();
			setState(53); match(EOF);
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
		public TerminalNode EXISTS() { return getToken(FOLTLFormulaParserParser.EXISTS, 0); }
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public TerminalNode FORALL() { return getToken(FOLTLFormulaParserParser.FORALL, 0); }
		public TemporalFormulaContext temporalFormula() {
			return getRuleContext(TemporalFormulaContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(FOLTLFormulaParserParser.VARIABLE, 0); }
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
		enterRule(_localctx, 2, RULE_acrossQuantifiedFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(55);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(56); match(VARIABLE);
				}
				break;
			}
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(59); match(LPAREN);
				}
				break;
			}
			setState(62); temporalFormula();
			setState(64);
			_la = _input.LA(1);
			if (_la==RPAREN) {
				{
				setState(63); match(RPAREN);
				}
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

	public static class TemporalFormulaContext extends ParserRuleContext {
		public TemporalDoubleImplicationContext temporalDoubleImplication() {
			return getRuleContext(TemporalDoubleImplicationContext.class,0);
		}
		public TemporalFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTemporalFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalFormulaContext temporalFormula() throws RecognitionException {
		TemporalFormulaContext _localctx = new TemporalFormulaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_temporalFormula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); temporalDoubleImplication();
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(FOLTLFormulaParserParser.DOUBLEIMPLY); }
		public List<TemporalImplicationContext> temporalImplication() {
			return getRuleContexts(TemporalImplicationContext.class);
		}
		public TemporalImplicationContext temporalImplication(int i) {
			return getRuleContext(TemporalImplicationContext.class,i);
		}
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
			setState(68); temporalImplication();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(69); match(DOUBLEIMPLY);
				setState(70); temporalImplication();
				}
				}
				setState(75);
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
		public List<TerminalNode> IMPLY() { return getTokens(FOLTLFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.IMPLY, i);
		}
		public List<TemporalDisjunctionContext> temporalDisjunction() {
			return getRuleContexts(TemporalDisjunctionContext.class);
		}
		public TemporalDisjunctionContext temporalDisjunction(int i) {
			return getRuleContext(TemporalDisjunctionContext.class,i);
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
			setState(76); temporalDisjunction();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(77); match(IMPLY);
				setState(78); temporalDisjunction();
				}
				}
				setState(83);
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
			setState(84); temporalConjunction();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(85); match(OR);
				setState(86); temporalConjunction();
				}
				}
				setState(91);
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
		public TerminalNode AND(int i) {
			return getToken(FOLTLFormulaParserParser.AND, i);
		}
		public List<TerminalNode> AND() { return getTokens(FOLTLFormulaParserParser.AND); }
		public WeakUntilContext weakUntil(int i) {
			return getRuleContext(WeakUntilContext.class,i);
		}
		public List<WeakUntilContext> weakUntil() {
			return getRuleContexts(WeakUntilContext.class);
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
			setState(92); weakUntil();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(93); match(AND);
				setState(94); weakUntil();
				}
				}
				setState(99);
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
		public List<TerminalNode> WEAKUNTIL() { return getTokens(FOLTLFormulaParserParser.WEAKUNTIL); }
		public TerminalNode WEAKUNTIL(int i) {
			return getToken(FOLTLFormulaParserParser.WEAKUNTIL, i);
		}
		public ReleaseContext release(int i) {
			return getRuleContext(ReleaseContext.class,i);
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
			setState(100); release();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WEAKUNTIL) {
				{
				{
				setState(101); match(WEAKUNTIL);
				setState(102); release();
				}
				}
				setState(107);
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
		public TerminalNode RELEASE(int i) {
			return getToken(FOLTLFormulaParserParser.RELEASE, i);
		}
		public UntilContext until(int i) {
			return getRuleContext(UntilContext.class,i);
		}
		public List<UntilContext> until() {
			return getRuleContexts(UntilContext.class);
		}
		public List<TerminalNode> RELEASE() { return getTokens(FOLTLFormulaParserParser.RELEASE); }
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
			setState(108); until();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(109); match(RELEASE);
				setState(110); until();
				}
				}
				setState(115);
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
		public GloballyContext globally(int i) {
			return getRuleContext(GloballyContext.class,i);
		}
		public TerminalNode UNTIL(int i) {
			return getToken(FOLTLFormulaParserParser.UNTIL, i);
		}
		public List<TerminalNode> UNTIL() { return getTokens(FOLTLFormulaParserParser.UNTIL); }
		public List<GloballyContext> globally() {
			return getRuleContexts(GloballyContext.class);
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
			setState(116); globally();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(117); match(UNTIL);
				setState(118); globally();
				}
				}
				setState(123);
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
			setState(125);
			_la = _input.LA(1);
			if (_la==GLOBALLY) {
				{
				setState(124); match(GLOBALLY);
				}
			}

			setState(127); eventually();
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
		public TerminalNode EVENTUALLY() { return getToken(FOLTLFormulaParserParser.EVENTUALLY, 0); }
		public WeakNextContext weakNext() {
			return getRuleContext(WeakNextContext.class,0);
		}
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
			setState(130);
			_la = _input.LA(1);
			if (_la==EVENTUALLY) {
				{
				setState(129); match(EVENTUALLY);
				}
			}

			setState(132); weakNext();
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
		public TerminalNode WEAKNEXT() { return getToken(FOLTLFormulaParserParser.WEAKNEXT, 0); }
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
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
			setState(135);
			_la = _input.LA(1);
			if (_la==WEAKNEXT) {
				{
				setState(134); match(WEAKNEXT);
				}
			}

			setState(137); next();
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
		public TerminalNode NEXT() { return getToken(FOLTLFormulaParserParser.NEXT, 0); }
		public NotTempContext notTemp() {
			return getRuleContext(NotTempContext.class,0);
		}
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
			setState(140);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(139); match(NEXT);
				}
			}

			setState(142); notTemp();
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

	public static class NotTempContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public TerminalNode RSEPARATOR() { return getToken(FOLTLFormulaParserParser.RSEPARATOR, 0); }
		public TerminalNode LSEPARATOR() { return getToken(FOLTLFormulaParserParser.LSEPARATOR, 0); }
		public LtlfAtomContext ltlfAtom() {
			return getRuleContext(LtlfAtomContext.class,0);
		}
		public TemporalFormulaContext temporalFormula() {
			return getRuleContext(TemporalFormulaContext.class,0);
		}
		public NotTempContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notTemp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitNotTemp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotTempContext notTemp() throws RecognitionException {
		NotTempContext _localctx = new NotTempContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_notTemp);
		int _la;
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144); ltlfAtom();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(145); match(NOT);
					}
				}

				setState(148); match(LSEPARATOR);
				setState(149); temporalFormula();
				setState(150); match(RSEPARATOR);
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
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public TerminalNode LAST() { return getToken(FOLTLFormulaParserParser.LAST, 0); }
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
			setState(156);
			switch (_input.LA(1)) {
			case LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); match(LAST);
				}
				break;
			case LPAREN:
			case NOT:
			case FORALL:
			case EXISTS:
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); localQuantifiedFormula();
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
		public TerminalNode EXISTS() { return getToken(FOLTLFormulaParserParser.EXISTS, 0); }
		public LocalDoubleImplicationContext localDoubleImplication() {
			return getRuleContext(LocalDoubleImplicationContext.class,0);
		}
		public TerminalNode FORALL() { return getToken(FOLTLFormulaParserParser.FORALL, 0); }
		public TerminalNode VARIABLE() { return getToken(FOLTLFormulaParserParser.VARIABLE, 0); }
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
			setState(160);
			_la = _input.LA(1);
			if (_la==FORALL || _la==EXISTS) {
				{
				setState(158);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(159); match(VARIABLE);
				}
			}

			setState(162); localDoubleImplication();
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(FOLTLFormulaParserParser.DOUBLEIMPLY); }
		public LocalImplicationContext localImplication(int i) {
			return getRuleContext(LocalImplicationContext.class,i);
		}
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
			setState(164); localImplication();
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165); match(DOUBLEIMPLY);
					setState(166); localImplication();
					}
					} 
				}
				setState(171);
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

	public static class LocalImplicationContext extends ParserRuleContext {
		public List<TerminalNode> IMPLY() { return getTokens(FOLTLFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(FOLTLFormulaParserParser.IMPLY, i);
		}
		public List<LocalDisjunctionContext> localDisjunction() {
			return getRuleContexts(LocalDisjunctionContext.class);
		}
		public LocalDisjunctionContext localDisjunction(int i) {
			return getRuleContext(LocalDisjunctionContext.class,i);
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
			setState(172); localDisjunction();
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173); match(IMPLY);
					setState(174); localDisjunction();
					}
					} 
				}
				setState(179);
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

	public static class LocalDisjunctionContext extends ParserRuleContext {
		public LocalConjunctionContext localConjunction(int i) {
			return getRuleContext(LocalConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FOLTLFormulaParserParser.OR); }
		public List<LocalConjunctionContext> localConjunction() {
			return getRuleContexts(LocalConjunctionContext.class);
		}
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
			setState(180); localConjunction();
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(181); match(OR);
					setState(182); localConjunction();
					}
					} 
				}
				setState(187);
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

	public static class LocalConjunctionContext extends ParserRuleContext {
		public LocalNegationContext localNegation(int i) {
			return getRuleContext(LocalNegationContext.class,i);
		}
		public TerminalNode AND(int i) {
			return getToken(FOLTLFormulaParserParser.AND, i);
		}
		public List<LocalNegationContext> localNegation() {
			return getRuleContexts(LocalNegationContext.class);
		}
		public List<TerminalNode> AND() { return getTokens(FOLTLFormulaParserParser.AND); }
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
			setState(188); localNegation();
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(189); match(AND);
					setState(190); localNegation();
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
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
			setState(197);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(196); match(NOT);
				}
			}

			setState(204);
			switch (_input.LA(1)) {
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				{
				setState(199); predicate();
				}
				break;
			case LPAREN:
				{
				setState(200); match(LPAREN);
				setState(201); localQuantifiedFormula();
				setState(202); match(RPAREN);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREPOSITION() { return getToken(FOLTLFormulaParserParser.PREPOSITION, 0); }
		public PredicateTupleContext predicateTuple() {
			return getRuleContext(PredicateTupleContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
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
		enterRule(_localctx, 44, RULE_predicate);
		try {
			setState(209);
			switch (_input.LA(1)) {
			case PREPOSITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(206); match(PREPOSITION);
				setState(207); predicateTuple();
				}
				break;
			case VARIABLE:
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(208); equality();
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); term();
			setState(212); match(EQUAL);
			setState(213); term();
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

	public static class PredicateTupleContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public PredicateTupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateTuple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitPredicateTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateTupleContext predicateTuple() throws RecognitionException {
		PredicateTupleContext _localctx = new PredicateTupleContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_predicateTuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(LPAREN);
			setState(216); term();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(217); match(T__0);
				setState(218); term();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224); match(RPAREN);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FOLTLFormulaParserParser.VARIABLE, 0); }
		public TerminalNode CONSTANT() { return getToken(FOLTLFormulaParserParser.CONSTANT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOLTLFormulaParserVisitor ) return ((FOLTLFormulaParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00e7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\5\3<\n\3\3\3\5\3?\n\3\3\3\3\3"+
		"\5\3C\n\3\3\4\3\4\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\6\3\6\3\6\7\6"+
		"R\n\6\f\6\16\6U\13\6\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\b\3\b\3\b\7"+
		"\bb\n\b\f\b\16\be\13\b\3\t\3\t\3\t\7\tj\n\t\f\t\16\tm\13\t\3\n\3\n\3\n"+
		"\7\nr\n\n\f\n\16\nu\13\n\3\13\3\13\3\13\7\13z\n\13\f\13\16\13}\13\13\3"+
		"\f\5\f\u0080\n\f\3\f\3\f\3\r\5\r\u0085\n\r\3\r\3\r\3\16\5\16\u008a\n\16"+
		"\3\16\3\16\3\17\5\17\u008f\n\17\3\17\3\17\3\20\3\20\5\20\u0095\n\20\3"+
		"\20\3\20\3\20\3\20\5\20\u009b\n\20\3\21\3\21\5\21\u009f\n\21\3\22\3\22"+
		"\5\22\u00a3\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u00aa\n\23\f\23\16\23\u00ad"+
		"\13\23\3\24\3\24\3\24\7\24\u00b2\n\24\f\24\16\24\u00b5\13\24\3\25\3\25"+
		"\3\25\7\25\u00ba\n\25\f\25\16\25\u00bd\13\25\3\26\3\26\3\26\7\26\u00c2"+
		"\n\26\f\26\16\26\u00c5\13\26\3\27\5\27\u00c8\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00cf\n\27\3\30\3\30\3\30\5\30\u00d4\n\30\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\7\32\u00de\n\32\f\32\16\32\u00e1\13\32\3\32\3"+
		"\32\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\2\4\3\2\23\24\3\2\26\27\u00e6\2\66\3\2\2\2\4;\3\2\2\2\6"+
		"D\3\2\2\2\bF\3\2\2\2\nN\3\2\2\2\fV\3\2\2\2\16^\3\2\2\2\20f\3\2\2\2\22"+
		"n\3\2\2\2\24v\3\2\2\2\26\177\3\2\2\2\30\u0084\3\2\2\2\32\u0089\3\2\2\2"+
		"\34\u008e\3\2\2\2\36\u009a\3\2\2\2 \u009e\3\2\2\2\"\u00a2\3\2\2\2$\u00a6"+
		"\3\2\2\2&\u00ae\3\2\2\2(\u00b6\3\2\2\2*\u00be\3\2\2\2,\u00c7\3\2\2\2."+
		"\u00d3\3\2\2\2\60\u00d5\3\2\2\2\62\u00d9\3\2\2\2\64\u00e4\3\2\2\2\66\67"+
		"\5\4\3\2\678\7\2\2\38\3\3\2\2\29:\t\2\2\2:<\7\26\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<>\3\2\2\2=?\7\f\2\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@B\5\6\4\2AC\7\r\2"+
		"\2BA\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DE\5\b\5\2E\7\3\2\2\2FK\5\n\6\2GH\7\16"+
		"\2\2HJ\5\n\6\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\t\3\2\2\2MK\3"+
		"\2\2\2NS\5\f\7\2OP\7\17\2\2PR\5\f\7\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST"+
		"\3\2\2\2T\13\3\2\2\2US\3\2\2\2V[\5\16\b\2WX\7\21\2\2XZ\5\16\b\2YW\3\2"+
		"\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\r\3\2\2\2][\3\2\2\2^c\5\20\t\2_"+
		"`\7\20\2\2`b\5\20\t\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\17\3\2"+
		"\2\2ec\3\2\2\2fk\5\22\n\2gh\7\5\2\2hj\5\22\n\2ig\3\2\2\2jm\3\2\2\2ki\3"+
		"\2\2\2kl\3\2\2\2l\21\3\2\2\2mk\3\2\2\2ns\5\24\13\2op\7\7\2\2pr\5\24\13"+
		"\2qo\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\23\3\2\2\2us\3\2\2\2v{\5\26"+
		"\f\2wx\7\6\2\2xz\5\26\f\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\25"+
		"\3\2\2\2}{\3\2\2\2~\u0080\7\b\2\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0082\5\30\r\2\u0082\27\3\2\2\2\u0083\u0085\7\t\2"+
		"\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\5\32\16\2\u0087\31\3\2\2\2\u0088\u008a\7\n\2\2\u0089\u0088\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\5\34\17\2\u008c\33\3\2"+
		"\2\2\u008d\u008f\7\13\2\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\5\36\20\2\u0091\35\3\2\2\2\u0092\u009b\5 \21"+
		"\2\u0093\u0095\7\22\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\7\32\2\2\u0097\u0098\5\6\4\2\u0098\u0099\7"+
		"\33\2\2\u0099\u009b\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0094\3\2\2\2\u009b"+
		"\37\3\2\2\2\u009c\u009f\7\4\2\2\u009d\u009f\5\"\22\2\u009e\u009c\3\2\2"+
		"\2\u009e\u009d\3\2\2\2\u009f!\3\2\2\2\u00a0\u00a1\t\2\2\2\u00a1\u00a3"+
		"\7\26\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a5\5$\23\2\u00a5#\3\2\2\2\u00a6\u00ab\5&\24\2\u00a7\u00a8\7"+
		"\16\2\2\u00a8\u00aa\5&\24\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac%\3\2\2\2\u00ad\u00ab\3\2\2\2"+
		"\u00ae\u00b3\5(\25\2\u00af\u00b0\7\17\2\2\u00b0\u00b2\5(\25\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\'\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb\5*\26\2\u00b7\u00b8\7\21\2"+
		"\2\u00b8\u00ba\5*\26\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc)\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c3\5,\27\2\u00bf\u00c0\7\20\2\2\u00c0\u00c2\5,\27\2\u00c1\u00bf\3"+
		"\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"+\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\7\22\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00ce\3\2\2\2\u00c9\u00cf\5.\30\2\u00ca\u00cb"+
		"\7\f\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00cd\7\r\2\2\u00cd\u00cf\3\2\2\2"+
		"\u00ce\u00c9\3\2\2\2\u00ce\u00ca\3\2\2\2\u00cf-\3\2\2\2\u00d0\u00d1\7"+
		"\30\2\2\u00d1\u00d4\5\62\32\2\u00d2\u00d4\5\60\31\2\u00d3\u00d0\3\2\2"+
		"\2\u00d3\u00d2\3\2\2\2\u00d4/\3\2\2\2\u00d5\u00d6\5\64\33\2\u00d6\u00d7"+
		"\7\25\2\2\u00d7\u00d8\5\64\33\2\u00d8\61\3\2\2\2\u00d9\u00da\7\f\2\2\u00da"+
		"\u00df\5\64\33\2\u00db\u00dc\7\3\2\2\u00dc\u00de\5\64\33\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\r\2\2\u00e3\63\3\2\2"+
		"\2\u00e4\u00e5\t\3\2\2\u00e5\65\3\2\2\2\34;>BKS[cks{\177\u0084\u0089\u008e"+
		"\u0094\u009a\u009e\u00a2\u00ab\u00b3\u00bb\u00c3\u00c7\u00ce\u00d3\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}