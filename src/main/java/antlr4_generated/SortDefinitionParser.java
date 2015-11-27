// Generated from SortDefinition.g4 by ANTLR 4.5

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
public class SortDefinitionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, LS=6, VARIABLE=7, CONSTANT=8, 
		PREPOSITION=9, WS=10, SORTNAME=11;
	public static final int
		RULE_start = 0, RULE_sortDefinition = 1, RULE_sortDeclaration = 2, RULE_sortAssignment = 3;
	public static final String[] ruleNames = {
		"start", "sortDefinition", "sortDeclaration", "sortAssignment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='", "'{'", "','", "'}'", "'<-'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "LS", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"WS", "SORTNAME"
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
	public String getGrammarFileName() { return "SortDefinition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SortDefinitionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public SortDefinitionContext sortDefinition() {
			return getRuleContext(SortDefinitionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SortDefinitionParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SortDefinitionVisitor ) return ((SortDefinitionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			sortDefinition();
			setState(9);
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

	public static class SortDefinitionContext extends ParserRuleContext {
		public List<SortDeclarationContext> sortDeclaration() {
			return getRuleContexts(SortDeclarationContext.class);
		}
		public SortDeclarationContext sortDeclaration(int i) {
			return getRuleContext(SortDeclarationContext.class,i);
		}
		public List<SortAssignmentContext> sortAssignment() {
			return getRuleContexts(SortAssignmentContext.class);
		}
		public SortAssignmentContext sortAssignment(int i) {
			return getRuleContext(SortAssignmentContext.class,i);
		}
		public SortDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SortDefinitionVisitor ) return ((SortDefinitionVisitor<? extends T>)visitor).visitSortDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortDefinitionContext sortDefinition() throws RecognitionException {
		SortDefinitionContext _localctx = new SortDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sortDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SORTNAME) {
				{
				{
				setState(11);
				sortDeclaration();
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARIABLE) {
				{
				{
				setState(17);
				sortAssignment();
				}
				}
				setState(22);
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

	public static class SortDeclarationContext extends ParserRuleContext {
		public TerminalNode SORTNAME() { return getToken(SortDefinitionParser.SORTNAME, 0); }
		public List<TerminalNode> CONSTANT() { return getTokens(SortDefinitionParser.CONSTANT); }
		public TerminalNode CONSTANT(int i) {
			return getToken(SortDefinitionParser.CONSTANT, i);
		}
		public TerminalNode LS() { return getToken(SortDefinitionParser.LS, 0); }
		public SortDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SortDefinitionVisitor ) return ((SortDefinitionVisitor<? extends T>)visitor).visitSortDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortDeclarationContext sortDeclaration() throws RecognitionException {
		SortDeclarationContext _localctx = new SortDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sortDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(SORTNAME);
			setState(24);
			match(T__0);
			setState(25);
			match(T__1);
			setState(26);
			match(CONSTANT);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(27);
				match(T__2);
				setState(28);
				match(CONSTANT);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(T__3);
			setState(35);
			match(LS);
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

	public static class SortAssignmentContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(SortDefinitionParser.VARIABLE, 0); }
		public TerminalNode SORTNAME() { return getToken(SortDefinitionParser.SORTNAME, 0); }
		public TerminalNode LS() { return getToken(SortDefinitionParser.LS, 0); }
		public SortAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SortDefinitionVisitor ) return ((SortDefinitionVisitor<? extends T>)visitor).visitSortAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortAssignmentContext sortAssignment() throws RecognitionException {
		SortAssignmentContext _localctx = new SortAssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sortAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(VARIABLE);
			setState(38);
			match(T__4);
			setState(39);
			match(SORTNAME);
			setState(40);
			match(LS);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\7\3\17\n\3\f\3\16\3\22\13\3\3\3\7\3"+
		"\25\n\3\f\3\16\3\30\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2+\2\n\3\2\2\2"+
		"\4\20\3\2\2\2\6\31\3\2\2\2\b\'\3\2\2\2\n\13\5\4\3\2\13\f\7\2\2\3\f\3\3"+
		"\2\2\2\r\17\5\6\4\2\16\r\3\2\2\2\17\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2"+
		"\2\2\21\26\3\2\2\2\22\20\3\2\2\2\23\25\5\b\5\2\24\23\3\2\2\2\25\30\3\2"+
		"\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3\2\2\2\30\26\3\2\2\2\31\32\7\r"+
		"\2\2\32\33\7\3\2\2\33\34\7\4\2\2\34!\7\n\2\2\35\36\7\5\2\2\36 \7\n\2\2"+
		"\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$"+
		"%\7\6\2\2%&\7\b\2\2&\7\3\2\2\2\'(\7\t\2\2()\7\7\2\2)*\7\r\2\2*+\7\b\2"+
		"\2+\t\3\2\2\2\5\20\26!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}