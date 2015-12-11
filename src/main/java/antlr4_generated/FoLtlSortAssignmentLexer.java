// Generated from FoLtlSortAssignment.g4 by ANTLR 4.5

	package antlr4_generated;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FoLtlSortAssignmentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, VARIABLE=3, CONSTANT=4, SORTNAME=5, WS=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "VARIABLE", "CONSTANT", "SORTNAME", "CHARACTER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<-'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "VARIABLE", "CONSTANT", "SORTNAME", "WS"
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


	public FoLtlSortAssignmentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FoLtlSortAssignment.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b9\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\5\4\31\n\4\3\4\7\4\34\n\4\f\4\16\4\37\13\4\3\5\5\5\"\n\5\3\5\7\5"+
		"%\n\5\f\5\16\5(\13\5\3\6\3\6\7\6,\n\6\f\6\16\6/\13\6\3\7\3\7\3\b\6\b\64"+
		"\n\b\r\b\16\b\65\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\2\17\b\3\2\5\4\2"+
		"\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\";\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\24\3\2\2"+
		"\2\7\26\3\2\2\2\t!\3\2\2\2\13)\3\2\2\2\r\60\3\2\2\2\17\63\3\2\2\2\21\22"+
		"\7>\2\2\22\23\7/\2\2\23\4\3\2\2\2\24\25\7=\2\2\25\6\3\2\2\2\26\30\7A\2"+
		"\2\27\31\t\2\2\2\30\27\3\2\2\2\31\35\3\2\2\2\32\34\5\r\7\2\33\32\3\2\2"+
		"\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\b\3\2\2\2\37\35\3\2\2"+
		"\2 \"\t\2\2\2! \3\2\2\2\"&\3\2\2\2#%\5\r\7\2$#\3\2\2\2%(\3\2\2\2&$\3\2"+
		"\2\2&\'\3\2\2\2\'\n\3\2\2\2(&\3\2\2\2)-\4C\\\2*,\5\r\7\2+*\3\2\2\2,/\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\f\3\2\2\2/-\3\2\2\2\60\61\t\3\2\2\61\16\3"+
		"\2\2\2\62\64\t\4\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3"+
		"\2\2\2\66\67\3\2\2\2\678\b\b\2\28\20\3\2\2\2\t\2\30\35!&-\65\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}