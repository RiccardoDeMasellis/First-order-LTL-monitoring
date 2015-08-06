// Generated from FOLTLFormulaParser.g4 by ANTLR 4.3

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
public class FOLTLFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LAST=2, WEAKUNTIL=3, UNTIL=4, RELEASE=5, GLOBALLY=6, EVENTUALLY=7, 
		WEAKNEXT=8, NEXT=9, LPAREN=10, RPAREN=11, DOUBLEIMPLY=12, IMPLY=13, AND=14, 
		OR=15, NOT=16, FORALL=17, EXISTS=18, EQUAL=19, VARIABLE=20, CONSTANT=21, 
		PREPOSITION=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"T__0", "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", 
		"WEAKNEXT", "NEXT", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", 
		"OR", "NOT", "FORALL", "EXISTS", "EQUAL", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"CHARACTER", "WS"
	};


	public FOLTLFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOLTLFormulaParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3B\n\3"+
		"\3\4\3\4\3\4\5\4G\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7P\n\7\3\b\3\b\3\b"+
		"\5\bU\n\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\5\17j\n\17\3\20\3\20\3\20\5\20o\n\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\5\25\u0085\n\25\3\25\7\25\u0088\n\25\f\25\16\25\u008b"+
		"\13\25\3\26\5\26\u008e\n\26\3\26\7\26\u0091\n\26\f\26\16\26\u0094\13\26"+
		"\3\27\3\27\7\27\u0098\n\27\f\27\16\27\u009b\13\27\3\30\3\30\3\31\6\31"+
		"\u00a0\n\31\r\31\16\31\u00a1\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\2\61\31\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00ae"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3\2"+
		"\2\2\3\63\3\2\2\2\5A\3\2\2\2\7F\3\2\2\2\tH\3\2\2\2\13J\3\2\2\2\rO\3\2"+
		"\2\2\17T\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31_\3"+
		"\2\2\2\33c\3\2\2\2\35i\3\2\2\2\37n\3\2\2\2!p\3\2\2\2#r\3\2\2\2%y\3\2\2"+
		"\2\'\u0080\3\2\2\2)\u0082\3\2\2\2+\u008d\3\2\2\2-\u0095\3\2\2\2/\u009c"+
		"\3\2\2\2\61\u009f\3\2\2\2\63\64\7.\2\2\64\4\3\2\2\2\65\66\7N\2\2\66\67"+
		"\7c\2\2\678\7u\2\28B\7v\2\29:\7N\2\2:;\7C\2\2;<\7U\2\2<B\7V\2\2=>\7n\2"+
		"\2>?\7c\2\2?@\7u\2\2@B\7v\2\2A\65\3\2\2\2A9\3\2\2\2A=\3\2\2\2B\6\3\2\2"+
		"\2CD\7Y\2\2DG\7W\2\2EG\7Y\2\2FC\3\2\2\2FE\3\2\2\2G\b\3\2\2\2HI\7W\2\2"+
		"I\n\3\2\2\2JK\7T\2\2K\f\3\2\2\2LM\7]\2\2MP\7_\2\2NP\7I\2\2OL\3\2\2\2O"+
		"N\3\2\2\2P\16\3\2\2\2QR\7>\2\2RU\7@\2\2SU\7H\2\2TQ\3\2\2\2TS\3\2\2\2U"+
		"\20\3\2\2\2VW\7Y\2\2WX\7Z\2\2X\22\3\2\2\2YZ\7Z\2\2Z\24\3\2\2\2[\\\7*\2"+
		"\2\\\26\3\2\2\2]^\7+\2\2^\30\3\2\2\2_`\7>\2\2`a\7/\2\2ab\7@\2\2b\32\3"+
		"\2\2\2cd\7/\2\2de\7@\2\2e\34\3\2\2\2fj\7(\2\2gh\7(\2\2hj\7(\2\2if\3\2"+
		"\2\2ig\3\2\2\2j\36\3\2\2\2ko\7~\2\2lm\7~\2\2mo\7~\2\2nk\3\2\2\2nl\3\2"+
		"\2\2o \3\2\2\2pq\7#\2\2q\"\3\2\2\2rs\7H\2\2st\7q\2\2tu\7t\2\2uv\7c\2\2"+
		"vw\7n\2\2wx\7n\2\2x$\3\2\2\2yz\7G\2\2z{\7z\2\2{|\7k\2\2|}\7u\2\2}~\7v"+
		"\2\2~\177\7u\2\2\177&\3\2\2\2\u0080\u0081\7?\2\2\u0081(\3\2\2\2\u0082"+
		"\u0084\7A\2\2\u0083\u0085\t\2\2\2\u0084\u0083\3\2\2\2\u0085\u0089\3\2"+
		"\2\2\u0086\u0088\5/\30\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a*\3\2\2\2\u008b\u0089\3\2\2\2"+
		"\u008c\u008e\t\2\2\2\u008d\u008c\3\2\2\2\u008e\u0092\3\2\2\2\u008f\u0091"+
		"\5/\30\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093,\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0099\4C\\\2\u0096"+
		"\u0098\5/\30\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a.\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d"+
		"\t\3\2\2\u009d\60\3\2\2\2\u009e\u00a0\t\4\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a4\b\31\2\2\u00a4\62\3\2\2\2\17\2AFOTin\u0084\u0089\u008d"+
		"\u0092\u0099\u00a1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}