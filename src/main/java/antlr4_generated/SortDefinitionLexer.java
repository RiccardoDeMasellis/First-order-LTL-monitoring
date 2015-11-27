// Generated from SortDefinition.g4 by ANTLR 4.5

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
public class SortDefinitionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, LS=6, VARIABLE=7, CONSTANT=8, 
		PREPOSITION=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "LS", "VARIABLE", "CONSTANT", 
		"PREPOSITION", "CHARACTER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':='", "'{'", "','", "'}'", "'<-'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "LS", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"WS"
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


	public SortDefinitionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SortDefinition.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fJ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\5\b*\n\b\3\b\7\b-\n\b\f\b\16\b\60\13\b\3\t\5\t\63\n\t\3\t\7\t\66"+
		"\n\t\f\t\16\t9\13\t\3\n\3\n\7\n=\n\n\f\n\16\n@\13\n\3\13\3\13\3\f\6\f"+
		"E\n\f\r\f\16\fF\3\f\3\f\2\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\2\27\f\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"L\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\34\3\2"+
		"\2\2\7\36\3\2\2\2\t \3\2\2\2\13\"\3\2\2\2\r%\3\2\2\2\17\'\3\2\2\2\21\62"+
		"\3\2\2\2\23:\3\2\2\2\25A\3\2\2\2\27D\3\2\2\2\31\32\7<\2\2\32\33\7?\2\2"+
		"\33\4\3\2\2\2\34\35\7}\2\2\35\6\3\2\2\2\36\37\7.\2\2\37\b\3\2\2\2 !\7"+
		"\177\2\2!\n\3\2\2\2\"#\7>\2\2#$\7/\2\2$\f\3\2\2\2%&\7=\2\2&\16\3\2\2\2"+
		"\')\7A\2\2(*\t\2\2\2)(\3\2\2\2*.\3\2\2\2+-\5\25\13\2,+\3\2\2\2-\60\3\2"+
		"\2\2.,\3\2\2\2./\3\2\2\2/\20\3\2\2\2\60.\3\2\2\2\61\63\t\2\2\2\62\61\3"+
		"\2\2\2\63\67\3\2\2\2\64\66\5\25\13\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3"+
		"\2\2\2\678\3\2\2\28\22\3\2\2\29\67\3\2\2\2:>\4C\\\2;=\5\25\13\2<;\3\2"+
		"\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\24\3\2\2\2@>\3\2\2\2AB\t\3\2\2B\26"+
		"\3\2\2\2CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2H"+
		"I\b\f\2\2I\30\3\2\2\2\t\2).\62\67>F\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}