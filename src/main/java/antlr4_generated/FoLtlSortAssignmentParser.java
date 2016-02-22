// Generated from FoLtlSortAssignment.g4 by ANTLR 4.5

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
public class FoLtlSortAssignmentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, VARIABLE=3, SORTNAME=4, WS=5;
	public static final int
		RULE_start = 0, RULE_sortAssignments = 1, RULE_sortAssignment = 2;
	public static final String[] ruleNames = {
		"start", "sortAssignments", "sortAssignment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<-'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "VARIABLE", "SORTNAME", "WS"
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
	public String getGrammarFileName() { return "FoLtlSortAssignment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FoLtlSortAssignmentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public SortAssignmentsContext sortAssignments() {
			return getRuleContext(SortAssignmentsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FoLtlSortAssignmentParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoLtlSortAssignmentVisitor ) return ((FoLtlSortAssignmentVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			sortAssignments();
			setState(7);
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

	public static class SortAssignmentsContext extends ParserRuleContext {
		public List<SortAssignmentContext> sortAssignment() {
			return getRuleContexts(SortAssignmentContext.class);
		}
		public SortAssignmentContext sortAssignment(int i) {
			return getRuleContext(SortAssignmentContext.class,i);
		}
		public SortAssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortAssignments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoLtlSortAssignmentVisitor ) return ((FoLtlSortAssignmentVisitor<? extends T>)visitor).visitSortAssignments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortAssignmentsContext sortAssignments() throws RecognitionException {
		SortAssignmentsContext _localctx = new SortAssignmentsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sortAssignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARIABLE) {
				{
				{
				setState(9);
				sortAssignment();
				}
				}
				setState(14);
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

	public static class SortAssignmentContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(FoLtlSortAssignmentParser.VARIABLE, 0); }
		public TerminalNode SORTNAME() { return getToken(FoLtlSortAssignmentParser.SORTNAME, 0); }
		public SortAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FoLtlSortAssignmentVisitor ) return ((FoLtlSortAssignmentVisitor<? extends T>)visitor).visitSortAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortAssignmentContext sortAssignment() throws RecognitionException {
		SortAssignmentContext _localctx = new SortAssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sortAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(VARIABLE);
			setState(16);
			match(T__0);
			setState(17);
			match(SORTNAME);
			setState(18);
			match(T__1);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\27\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\3\7\3\r\n\3\f\3\16\3\20\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\2\2\5\2\4\6\2\2\24\2\b\3\2\2\2\4\16\3\2\2\2\6\21\3\2\2\2\b"+
		"\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\r\5\6\4\2\f\13\3\2\2\2\r\20\3\2"+
		"\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\5\3\2\2\2\20\16\3\2\2\2\21\22\7\5\2"+
		"\2\22\23\7\3\2\2\23\24\7\6\2\2\24\25\7\4\2\2\25\7\3\2\2\2\3\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}