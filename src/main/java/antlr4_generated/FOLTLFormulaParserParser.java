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
		PREPOSITION=22, WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", 
		"EVENTUALLY", "WEAKNEXT", "NEXT", "'('", "')'", "'<->'", "'->'", "AND", 
		"OR", "'!'", "'Forall'", "'Exists'", "'='", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"WS"
	};
	public static final int
		RULE_start = 0, RULE_foltlFormula = 1, RULE_acrossQuantifiedFormula = 2, 
		RULE_temporalFormula = 3, RULE_temporalDoubleImplication = 4, RULE_temporalImplication = 5, 
		RULE_temporalDisjunction = 6, RULE_temporalConjunction = 7, RULE_weakUntil = 8, 
		RULE_release = 9, RULE_until = 10, RULE_globally = 11, RULE_eventually = 12, 
		RULE_weakNext = 13, RULE_next = 14, RULE_temporalNegation = 15, RULE_ltlfAtom = 16, 
		RULE_localQuantifiedFormula = 17, RULE_localDoubleImplication = 18, RULE_localImplication = 19, 
		RULE_localDisjunction = 20, RULE_localConjunction = 21, RULE_localNegation = 22, 
		RULE_folAtom = 23, RULE_equality = 24, RULE_predicate = 25;
	public static final String[] ruleNames = {
		"start", "foltlFormula", "acrossQuantifiedFormula", "temporalFormula", 
		"temporalDoubleImplication", "temporalImplication", "temporalDisjunction", 
		"temporalConjunction", "weakUntil", "release", "until", "globally", "eventually", 
		"weakNext", "next", "temporalNegation", "ltlfAtom", "localQuantifiedFormula", 
		"localDoubleImplication", "localImplication", "localDisjunction", "localConjunction", 
		"localNegation", "folAtom", "equality", "predicate"
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
			setState(52); foltlFormula();
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
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55); localQuantifiedFormula();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); acrossQuantifiedFormula();
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
		public TerminalNode EXISTS() { return getToken(FOLTLFormulaParserParser.EXISTS, 0); }
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
		enterRule(_localctx, 4, RULE_acrossQuantifiedFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(59);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(60); match(VARIABLE);
				}
				break;
			}
			setState(63); temporalFormula();
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
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public AcrossQuantifiedFormulaContext acrossQuantifiedFormula() {
			return getRuleContext(AcrossQuantifiedFormulaContext.class,0);
		}
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
		enterRule(_localctx, 6, RULE_temporalFormula);
		try {
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65); match(LPAREN);
				setState(66); acrossQuantifiedFormula();
				setState(67); match(RPAREN);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); temporalDoubleImplication();
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
		enterRule(_localctx, 8, RULE_temporalDoubleImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); temporalImplication();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(73); match(DOUBLEIMPLY);
				setState(74); temporalImplication();
				}
				}
				setState(79);
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
		enterRule(_localctx, 10, RULE_temporalImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); temporalDisjunction();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(81); match(IMPLY);
				setState(82); temporalDisjunction();
				}
				}
				setState(87);
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
		enterRule(_localctx, 12, RULE_temporalDisjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); temporalConjunction();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(89); match(OR);
				setState(90); temporalConjunction();
				}
				}
				setState(95);
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
		enterRule(_localctx, 14, RULE_temporalConjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); weakUntil();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(97); match(AND);
				setState(98); weakUntil();
				}
				}
				setState(103);
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
		enterRule(_localctx, 16, RULE_weakUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); release();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WEAKUNTIL) {
				{
				{
				setState(105); match(WEAKUNTIL);
				setState(106); release();
				}
				}
				setState(111);
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
		enterRule(_localctx, 18, RULE_release);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); until();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RELEASE) {
				{
				{
				setState(113); match(RELEASE);
				setState(114); until();
				}
				}
				setState(119);
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
		enterRule(_localctx, 20, RULE_until);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); globally();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==UNTIL) {
				{
				{
				setState(121); match(UNTIL);
				setState(122); globally();
				}
				}
				setState(127);
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
		enterRule(_localctx, 22, RULE_globally);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if (_la==GLOBALLY) {
				{
				setState(128); match(GLOBALLY);
				}
			}

			setState(131); eventually();
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
		enterRule(_localctx, 24, RULE_eventually);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_la = _input.LA(1);
			if (_la==EVENTUALLY) {
				{
				setState(133); match(EVENTUALLY);
				}
			}

			setState(136); weakNext();
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
		enterRule(_localctx, 26, RULE_weakNext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if (_la==WEAKNEXT) {
				{
				setState(138); match(WEAKNEXT);
				}
			}

			setState(141); next();
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
		public TemporalNegationContext temporalNegation() {
			return getRuleContext(TemporalNegationContext.class,0);
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
		enterRule(_localctx, 28, RULE_next);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if (_la==NEXT) {
				{
				setState(143); match(NEXT);
				}
			}

			setState(146); temporalNegation();
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
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public LtlfAtomContext ltlfAtom() {
			return getRuleContext(LtlfAtomContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public TemporalFormulaContext temporalFormula() {
			return getRuleContext(TemporalFormulaContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_temporalNegation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(148); match(NOT);
				}
				break;
			}
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(151); ltlfAtom();
				}
				break;

			case 2:
				{
				setState(152); match(LPAREN);
				setState(153); temporalFormula();
				setState(154); match(RPAREN);
				}
				break;
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

	public static class LtlfAtomContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
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
		enterRule(_localctx, 32, RULE_ltlfAtom);
		try {
			setState(166);
			switch (_input.LA(1)) {
			case LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); match(LAST);
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
				setState(160);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(159); match(LPAREN);
					}
					break;
				}
				setState(162); localQuantifiedFormula();
				setState(164);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(163); match(RPAREN);
					}
					break;
				}
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
		enterRule(_localctx, 34, RULE_localQuantifiedFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if (_la==FORALL || _la==EXISTS) {
				{
				setState(168);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(169); match(VARIABLE);
				}
			}

			setState(172); localDoubleImplication();
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
		enterRule(_localctx, 36, RULE_localDoubleImplication);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174); localImplication();
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175); match(DOUBLEIMPLY);
					setState(176); localImplication();
					}
					} 
				}
				setState(181);
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
		enterRule(_localctx, 38, RULE_localImplication);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182); localDisjunction();
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183); match(IMPLY);
					setState(184); localDisjunction();
					}
					} 
				}
				setState(189);
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
		enterRule(_localctx, 40, RULE_localDisjunction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190); localConjunction();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191); match(OR);
					setState(192); localConjunction();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 42, RULE_localConjunction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198); localNegation();
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(199); match(AND);
					setState(200); localNegation();
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public TerminalNode NOT() { return getToken(FOLTLFormulaParserParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
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
		enterRule(_localctx, 44, RULE_localNegation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(206); match(NOT);
				}
			}

			setState(214);
			switch (_input.LA(1)) {
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				{
				setState(209); folAtom();
				}
				break;
			case LPAREN:
				{
				setState(210); match(LPAREN);
				setState(211); localQuantifiedFormula();
				setState(212); match(RPAREN);
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
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
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
		enterRule(_localctx, 46, RULE_folAtom);
		try {
			setState(218);
			switch (_input.LA(1)) {
			case PREPOSITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); predicate();
				}
				break;
			case VARIABLE:
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(217); equality();
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
		public TerminalNode CONSTANT(int i) {
			return getToken(FOLTLFormulaParserParser.CONSTANT, i);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(FOLTLFormulaParserParser.VARIABLE); }
		public List<TerminalNode> CONSTANT() { return getTokens(FOLTLFormulaParserParser.CONSTANT); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLTLFormulaParserParser.VARIABLE, i);
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
		enterRule(_localctx, 48, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(221); match(EQUAL);
			setState(222);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode PREPOSITION() { return getToken(FOLTLFormulaParserParser.PREPOSITION, 0); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOLTLFormulaParserParser.CONSTANT, i);
		}
		public TerminalNode LPAREN() { return getToken(FOLTLFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOLTLFormulaParserParser.RPAREN, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(FOLTLFormulaParserParser.VARIABLE); }
		public List<TerminalNode> CONSTANT() { return getTokens(FOLTLFormulaParserParser.CONSTANT); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOLTLFormulaParserParser.VARIABLE, i);
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
		enterRule(_localctx, 50, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(PREPOSITION);
			setState(225); match(LPAREN);
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(227); match(T__0);
				setState(228);
				_la = _input.LA(1);
				if ( !(_la==VARIABLE || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234); match(RPAREN);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00ef\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\5\3<\n\3\3\4\3\4\5\4@\n\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\5\5I\n\5\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6"+
		"\3\7\3\7\3\7\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\3\b\7\b^\n\b\f\b\16\ba\13"+
		"\b\3\t\3\t\3\t\7\tf\n\t\f\t\16\ti\13\t\3\n\3\n\3\n\7\nn\n\n\f\n\16\nq"+
		"\13\n\3\13\3\13\3\13\7\13v\n\13\f\13\16\13y\13\13\3\f\3\f\3\f\7\f~\n\f"+
		"\f\f\16\f\u0081\13\f\3\r\5\r\u0084\n\r\3\r\3\r\3\16\5\16\u0089\n\16\3"+
		"\16\3\16\3\17\5\17\u008e\n\17\3\17\3\17\3\20\5\20\u0093\n\20\3\20\3\20"+
		"\3\21\5\21\u0098\n\21\3\21\3\21\3\21\3\21\3\21\5\21\u009f\n\21\3\22\3"+
		"\22\5\22\u00a3\n\22\3\22\3\22\5\22\u00a7\n\22\5\22\u00a9\n\22\3\23\3\23"+
		"\5\23\u00ad\n\23\3\23\3\23\3\24\3\24\3\24\7\24\u00b4\n\24\f\24\16\24\u00b7"+
		"\13\24\3\25\3\25\3\25\7\25\u00bc\n\25\f\25\16\25\u00bf\13\25\3\26\3\26"+
		"\3\26\7\26\u00c4\n\26\f\26\16\26\u00c7\13\26\3\27\3\27\3\27\7\27\u00cc"+
		"\n\27\f\27\16\27\u00cf\13\27\3\30\5\30\u00d2\n\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u00d9\n\30\3\31\3\31\5\31\u00dd\n\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\7\33\u00e8\n\33\f\33\16\33\u00eb\13\33\3\33\3"+
		"\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\2\4\3\2\23\24\3\2\26\27\u00f0\2\66\3\2\2\2\4;\3\2\2\2\6?\3\2\2\2\b"+
		"H\3\2\2\2\nJ\3\2\2\2\fR\3\2\2\2\16Z\3\2\2\2\20b\3\2\2\2\22j\3\2\2\2\24"+
		"r\3\2\2\2\26z\3\2\2\2\30\u0083\3\2\2\2\32\u0088\3\2\2\2\34\u008d\3\2\2"+
		"\2\36\u0092\3\2\2\2 \u0097\3\2\2\2\"\u00a8\3\2\2\2$\u00ac\3\2\2\2&\u00b0"+
		"\3\2\2\2(\u00b8\3\2\2\2*\u00c0\3\2\2\2,\u00c8\3\2\2\2.\u00d1\3\2\2\2\60"+
		"\u00dc\3\2\2\2\62\u00de\3\2\2\2\64\u00e2\3\2\2\2\66\67\5\4\3\2\678\7\2"+
		"\2\38\3\3\2\2\29<\5$\23\2:<\5\6\4\2;9\3\2\2\2;:\3\2\2\2<\5\3\2\2\2=>\t"+
		"\2\2\2>@\7\26\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\b\5\2B\7\3\2\2\2C"+
		"D\7\f\2\2DE\5\6\4\2EF\7\r\2\2FI\3\2\2\2GI\5\n\6\2HC\3\2\2\2HG\3\2\2\2"+
		"I\t\3\2\2\2JO\5\f\7\2KL\7\16\2\2LN\5\f\7\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2"+
		"\2OP\3\2\2\2P\13\3\2\2\2QO\3\2\2\2RW\5\16\b\2ST\7\17\2\2TV\5\16\b\2US"+
		"\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2YW\3\2\2\2Z_\5\20\t\2"+
		"[\\\7\21\2\2\\^\5\20\t\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\17\3"+
		"\2\2\2a_\3\2\2\2bg\5\22\n\2cd\7\20\2\2df\5\22\n\2ec\3\2\2\2fi\3\2\2\2"+
		"ge\3\2\2\2gh\3\2\2\2h\21\3\2\2\2ig\3\2\2\2jo\5\24\13\2kl\7\5\2\2ln\5\24"+
		"\13\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\23\3\2\2\2qo\3\2\2\2rw"+
		"\5\26\f\2st\7\7\2\2tv\5\26\f\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2"+
		"x\25\3\2\2\2yw\3\2\2\2z\177\5\30\r\2{|\7\6\2\2|~\5\30\r\2}{\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\27\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0084\7\b\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\5\32\16\2\u0086\31\3\2\2\2\u0087\u0089\7\t"+
		"\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\5\34\17\2\u008b\33\3\2\2\2\u008c\u008e\7\n\2\2\u008d\u008c\3\2"+
		"\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\5\36\20\2\u0090"+
		"\35\3\2\2\2\u0091\u0093\7\13\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2"+
		"\2\u0093\u0094\3\2\2\2\u0094\u0095\5 \21\2\u0095\37\3\2\2\2\u0096\u0098"+
		"\7\22\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009e\3\2\2\2"+
		"\u0099\u009f\5\"\22\2\u009a\u009b\7\f\2\2\u009b\u009c\5\b\5\2\u009c\u009d"+
		"\7\r\2\2\u009d\u009f\3\2\2\2\u009e\u0099\3\2\2\2\u009e\u009a\3\2\2\2\u009f"+
		"!\3\2\2\2\u00a0\u00a9\7\4\2\2\u00a1\u00a3\7\f\2\2\u00a2\u00a1\3\2\2\2"+
		"\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\5$\23\2\u00a5\u00a7"+
		"\7\r\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a0\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a9#\3\2\2\2\u00aa\u00ab\t\2\2\2"+
		"\u00ab\u00ad\7\26\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00af\5&\24\2\u00af%\3\2\2\2\u00b0\u00b5\5(\25\2\u00b1"+
		"\u00b2\7\16\2\2\u00b2\u00b4\5(\25\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\'\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00bd\5*\26\2\u00b9\u00ba\7\17\2\2\u00ba\u00bc\5*\26\2"+
		"\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be)\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c5\5,\27\2\u00c1"+
		"\u00c2\7\21\2\2\u00c2\u00c4\5,\27\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6+\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00cd\5.\30\2\u00c9\u00ca\7\20\2\2\u00ca\u00cc\5.\30\2"+
		"\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce-\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\7\22\2\2\u00d1"+
		"\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d8\3\2\2\2\u00d3\u00d9\5\60"+
		"\31\2\u00d4\u00d5\7\f\2\2\u00d5\u00d6\5$\23\2\u00d6\u00d7\7\r\2\2\u00d7"+
		"\u00d9\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d9/\3\2\2\2"+
		"\u00da\u00dd\5\64\33\2\u00db\u00dd\5\62\32\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\61\3\2\2\2\u00de\u00df\t\3\2\2\u00df\u00e0\7\25\2"+
		"\2\u00e0\u00e1\t\3\2\2\u00e1\63\3\2\2\2\u00e2\u00e3\7\30\2\2\u00e3\u00e4"+
		"\7\f\2\2\u00e4\u00e9\t\3\2\2\u00e5\u00e6\7\3\2\2\u00e6\u00e8\t\3\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7\r\2\2\u00ed"+
		"\65\3\2\2\2\36;?HOW_gow\177\u0083\u0088\u008d\u0092\u0097\u009e\u00a2"+
		"\u00a6\u00a8\u00ac\u00b5\u00bd\u00c5\u00cd\u00d1\u00d8\u00dc\u00e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}