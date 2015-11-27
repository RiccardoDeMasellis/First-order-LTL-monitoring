// Generated from FOFormulaParser.g4 by ANTLR 4.5

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
public class FOFormulaParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, DOUBLEIMPLY=4, IMPLY=5, AND=6, OR=7, NOT=8, 
		FORALL=9, EXISTS=10, EQUAL=11, FALSEATOM=12, TRUEATOM=13, VARIABLE=14, 
		CONSTANT=15, PREPOSITION=16, WS=17;
	public static final int
		RULE_start = 0, RULE_localQuantifiedFormula = 1, RULE_localDoubleImplication = 2, 
		RULE_localImplication = 3, RULE_localDisjunction = 4, RULE_localConjunction = 5, 
		RULE_localNegation = 6, RULE_folAtom = 7, RULE_equality = 8, RULE_predicate = 9;
	public static final String[] ruleNames = {
		"start", "localQuantifiedFormula", "localDoubleImplication", "localImplication", 
		"localDisjunction", "localConjunction", "localNegation", "folAtom", "equality", 
		"predicate"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "'<->'", "'->'", null, null, "'!'", "'Forall'", 
		"'Exists'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", "OR", "NOT", 
		"FORALL", "EXISTS", "EQUAL", "FALSEATOM", "TRUEATOM", "VARIABLE", "CONSTANT", 
		"PREPOSITION", "WS"
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
	public String getGrammarFileName() { return "FOFormulaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FOFormulaParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FOFormulaParserParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			localQuantifiedFormula();
			setState(21);
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

	public static class LocalQuantifiedFormulaContext extends ParserRuleContext {
		public LocalDoubleImplicationContext localDoubleImplication() {
			return getRuleContext(LocalDoubleImplicationContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(FOFormulaParserParser.VARIABLE, 0); }
		public TerminalNode FORALL() { return getToken(FOFormulaParserParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(FOFormulaParserParser.EXISTS, 0); }
		public LocalQuantifiedFormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localQuantifiedFormula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalQuantifiedFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalQuantifiedFormulaContext localQuantifiedFormula() throws RecognitionException {
		LocalQuantifiedFormulaContext _localctx = new LocalQuantifiedFormulaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_localQuantifiedFormula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_la = _input.LA(1);
			if (_la==FORALL || _la==EXISTS) {
				{
				setState(23);
				_la = _input.LA(1);
				if ( !(_la==FORALL || _la==EXISTS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(24);
				match(VARIABLE);
				}
			}

			setState(27);
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
		public List<TerminalNode> DOUBLEIMPLY() { return getTokens(FOFormulaParserParser.DOUBLEIMPLY); }
		public TerminalNode DOUBLEIMPLY(int i) {
			return getToken(FOFormulaParserParser.DOUBLEIMPLY, i);
		}
		public LocalDoubleImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDoubleImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalDoubleImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDoubleImplicationContext localDoubleImplication() throws RecognitionException {
		LocalDoubleImplicationContext _localctx = new LocalDoubleImplicationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_localDoubleImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			localImplication();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOUBLEIMPLY) {
				{
				{
				setState(30);
				match(DOUBLEIMPLY);
				setState(31);
				localImplication();
				}
				}
				setState(36);
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

	public static class LocalImplicationContext extends ParserRuleContext {
		public List<LocalDisjunctionContext> localDisjunction() {
			return getRuleContexts(LocalDisjunctionContext.class);
		}
		public LocalDisjunctionContext localDisjunction(int i) {
			return getRuleContext(LocalDisjunctionContext.class,i);
		}
		public List<TerminalNode> IMPLY() { return getTokens(FOFormulaParserParser.IMPLY); }
		public TerminalNode IMPLY(int i) {
			return getToken(FOFormulaParserParser.IMPLY, i);
		}
		public LocalImplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localImplication; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalImplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalImplicationContext localImplication() throws RecognitionException {
		LocalImplicationContext _localctx = new LocalImplicationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_localImplication);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			localDisjunction();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPLY) {
				{
				{
				setState(38);
				match(IMPLY);
				setState(39);
				localDisjunction();
				}
				}
				setState(44);
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

	public static class LocalDisjunctionContext extends ParserRuleContext {
		public List<LocalConjunctionContext> localConjunction() {
			return getRuleContexts(LocalConjunctionContext.class);
		}
		public LocalConjunctionContext localConjunction(int i) {
			return getRuleContext(LocalConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FOFormulaParserParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FOFormulaParserParser.OR, i);
		}
		public LocalDisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDisjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDisjunctionContext localDisjunction() throws RecognitionException {
		LocalDisjunctionContext _localctx = new LocalDisjunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_localDisjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			localConjunction();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(46);
				match(OR);
				setState(47);
				localConjunction();
				}
				}
				setState(52);
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

	public static class LocalConjunctionContext extends ParserRuleContext {
		public List<LocalNegationContext> localNegation() {
			return getRuleContexts(LocalNegationContext.class);
		}
		public LocalNegationContext localNegation(int i) {
			return getRuleContext(LocalNegationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FOFormulaParserParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FOFormulaParserParser.AND, i);
		}
		public LocalConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localConjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalConjunctionContext localConjunction() throws RecognitionException {
		LocalConjunctionContext _localctx = new LocalConjunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_localConjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			localNegation();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(54);
				match(AND);
				setState(55);
				localNegation();
				}
				}
				setState(60);
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

	public static class LocalNegationContext extends ParserRuleContext {
		public FolAtomContext folAtom() {
			return getRuleContext(FolAtomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FOFormulaParserParser.LPAREN, 0); }
		public LocalQuantifiedFormulaContext localQuantifiedFormula() {
			return getRuleContext(LocalQuantifiedFormulaContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FOFormulaParserParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(FOFormulaParserParser.NOT, 0); }
		public LocalNegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localNegation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitLocalNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalNegationContext localNegation() throws RecognitionException {
		LocalNegationContext _localctx = new LocalNegationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localNegation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(61);
				match(NOT);
				}
			}

			setState(69);
			switch (_input.LA(1)) {
			case FALSEATOM:
			case TRUEATOM:
			case VARIABLE:
			case CONSTANT:
			case PREPOSITION:
				{
				setState(64);
				folAtom();
				}
				break;
			case LPAREN:
				{
				setState(65);
				match(LPAREN);
				setState(66);
				localQuantifiedFormula();
				setState(67);
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
		public TerminalNode TRUEATOM() { return getToken(FOFormulaParserParser.TRUEATOM, 0); }
		public TerminalNode FALSEATOM() { return getToken(FOFormulaParserParser.FALSEATOM, 0); }
		public FolAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitFolAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FolAtomContext folAtom() throws RecognitionException {
		FolAtomContext _localctx = new FolAtomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_folAtom);
		try {
			setState(75);
			switch (_input.LA(1)) {
			case PREPOSITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				predicate();
				}
				break;
			case VARIABLE:
			case CONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				equality();
				}
				break;
			case TRUEATOM:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(TRUEATOM);
				}
				break;
			case FALSEATOM:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
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
		public TerminalNode EQUAL() { return getToken(FOFormulaParserParser.EQUAL, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(FOFormulaParserParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOFormulaParserParser.VARIABLE, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(FOFormulaParserParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOFormulaParserParser.CONSTANT, i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(78);
			match(EQUAL);
			setState(79);
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
		public TerminalNode PREPOSITION() { return getToken(FOFormulaParserParser.PREPOSITION, 0); }
		public TerminalNode LPAREN() { return getToken(FOFormulaParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FOFormulaParserParser.RPAREN, 0); }
		public List<TerminalNode> VARIABLE() { return getTokens(FOFormulaParserParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(FOFormulaParserParser.VARIABLE, i);
		}
		public List<TerminalNode> CONSTANT() { return getTokens(FOFormulaParserParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(FOFormulaParserParser.CONSTANT, i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FOFormulaParserVisitor ) return ((FOFormulaParserVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(PREPOSITION);
			setState(82);
			match(LPAREN);
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==CONSTANT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(84);
				match(T__0);
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==VARIABLE || _la==CONSTANT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23`\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\5\3\34\n\3\3\3\3\3\3\4\3\4\3\4\7\4#\n\4\f\4\16\4&\13"+
		"\4\3\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\6\3\6\3\6\7\6\63\n\6\f\6\16\6"+
		"\66\13\6\3\7\3\7\3\7\7\7;\n\7\f\7\16\7>\13\7\3\b\5\bA\n\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\bH\n\b\3\t\3\t\3\t\3\t\5\tN\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\13\3\13\3\13\2\2\f\2\4\6"+
		"\b\n\f\16\20\22\24\2\4\3\2\13\f\3\2\20\21`\2\26\3\2\2\2\4\33\3\2\2\2\6"+
		"\37\3\2\2\2\b\'\3\2\2\2\n/\3\2\2\2\f\67\3\2\2\2\16@\3\2\2\2\20M\3\2\2"+
		"\2\22O\3\2\2\2\24S\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31"+
		"\32\t\2\2\2\32\34\7\20\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35"+
		"\36\5\6\4\2\36\5\3\2\2\2\37$\5\b\5\2 !\7\6\2\2!#\5\b\5\2\" \3\2\2\2#&"+
		"\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\7\3\2\2\2&$\3\2\2\2\',\5\n\6\2()\7\7\2"+
		"\2)+\5\n\6\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\t\3\2\2\2.,\3\2"+
		"\2\2/\64\5\f\7\2\60\61\7\t\2\2\61\63\5\f\7\2\62\60\3\2\2\2\63\66\3\2\2"+
		"\2\64\62\3\2\2\2\64\65\3\2\2\2\65\13\3\2\2\2\66\64\3\2\2\2\67<\5\16\b"+
		"\289\7\b\2\29;\5\16\b\2:8\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\r\3\2"+
		"\2\2><\3\2\2\2?A\7\n\2\2@?\3\2\2\2@A\3\2\2\2AG\3\2\2\2BH\5\20\t\2CD\7"+
		"\4\2\2DE\5\4\3\2EF\7\5\2\2FH\3\2\2\2GB\3\2\2\2GC\3\2\2\2H\17\3\2\2\2I"+
		"N\5\24\13\2JN\5\22\n\2KN\7\17\2\2LN\7\16\2\2MI\3\2\2\2MJ\3\2\2\2MK\3\2"+
		"\2\2ML\3\2\2\2N\21\3\2\2\2OP\t\3\2\2PQ\7\r\2\2QR\t\3\2\2R\23\3\2\2\2S"+
		"T\7\22\2\2TU\7\4\2\2UZ\t\3\2\2VW\7\3\2\2WY\t\3\2\2XV\3\2\2\2Y\\\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\5\2\2^\25\3\2\2\2\13\33"+
		"$,\64<@GMZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}