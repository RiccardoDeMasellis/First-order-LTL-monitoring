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
		"WEAKNEXT", "NEXT", "TEMPOP", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", 
		"AND", "OR", "NOT", "FORALL", "EXISTS", "EQUAL", "VARIABLE", "CONSTANT", 
		"PREPOSITION", "CHARACTER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3D\n\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\5\7V\n\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\5\b`\n\b\3\b\3\b\5\b"+
		"d\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\5\20}\n\20\3\21\3\21\3\21\5\21"+
		"\u0082\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\5\26\u0098\n\26\3\26\7\26\u009b"+
		"\n\26\f\26\16\26\u009e\13\26\3\27\5\27\u00a1\n\27\3\27\7\27\u00a4\n\27"+
		"\f\27\16\27\u00a7\13\27\3\30\3\30\7\30\u00ab\n\30\f\30\16\30\u00ae\13"+
		"\30\3\31\3\31\3\32\6\32\u00b3\n\32\r\32\16\32\u00b4\3\32\3\32\2\2\33\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\2\27\f\31\r\33\16\35\17\37"+
		"\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\2\63\31\3\2\5\4\2\62;c|\6\2\62"+
		";C\\aac|\5\2\13\f\17\17\"\"\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2"+
		"\tK\3\2\2\2\13N\3\2\2\2\rY\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23i\3\2\2\2"+
		"\25l\3\2\2\2\27n\3\2\2\2\31p\3\2\2\2\33r\3\2\2\2\35v\3\2\2\2\37|\3\2\2"+
		"\2!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u008c\3\2\2\2)\u0093"+
		"\3\2\2\2+\u0095\3\2\2\2-\u00a0\3\2\2\2/\u00a8\3\2\2\2\61\u00af\3\2\2\2"+
		"\63\u00b2\3\2\2\2\65\66\7.\2\2\66\4\3\2\2\2\678\7N\2\289\7c\2\29:\7u\2"+
		"\2:D\7v\2\2;<\7N\2\2<=\7C\2\2=>\7U\2\2>D\7V\2\2?@\7n\2\2@A\7c\2\2AB\7"+
		"u\2\2BD\7v\2\2C\67\3\2\2\2C;\3\2\2\2C?\3\2\2\2D\6\3\2\2\2EI\5\25\13\2"+
		"FG\7Y\2\2GJ\7W\2\2HJ\7Y\2\2IF\3\2\2\2IH\3\2\2\2J\b\3\2\2\2KL\5\25\13\2"+
		"LM\7W\2\2M\n\3\2\2\2NO\5\25\13\2OP\7T\2\2P\f\3\2\2\2QU\5\25\13\2RS\7]"+
		"\2\2SV\7_\2\2TV\7I\2\2UR\3\2\2\2UT\3\2\2\2VZ\3\2\2\2WX\7]\2\2XZ\7_\2\2"+
		"YQ\3\2\2\2YW\3\2\2\2Z\16\3\2\2\2[_\5\25\13\2\\]\7>\2\2]`\7@\2\2^`\7H\2"+
		"\2_\\\3\2\2\2_^\3\2\2\2`d\3\2\2\2ab\7>\2\2bd\7@\2\2c[\3\2\2\2ca\3\2\2"+
		"\2d\20\3\2\2\2ef\5\25\13\2fg\7Y\2\2gh\7Z\2\2h\22\3\2\2\2ij\5\25\13\2j"+
		"k\7Z\2\2k\24\3\2\2\2lm\7\u00b2\2\2m\26\3\2\2\2no\7*\2\2o\30\3\2\2\2pq"+
		"\7+\2\2q\32\3\2\2\2rs\7>\2\2st\7/\2\2tu\7@\2\2u\34\3\2\2\2vw\7/\2\2wx"+
		"\7@\2\2x\36\3\2\2\2y}\7(\2\2z{\7(\2\2{}\7(\2\2|y\3\2\2\2|z\3\2\2\2} \3"+
		"\2\2\2~\u0082\7~\2\2\177\u0080\7~\2\2\u0080\u0082\7~\2\2\u0081~\3\2\2"+
		"\2\u0081\177\3\2\2\2\u0082\"\3\2\2\2\u0083\u0084\7#\2\2\u0084$\3\2\2\2"+
		"\u0085\u0086\7H\2\2\u0086\u0087\7q\2\2\u0087\u0088\7t\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7n\2\2\u008b&\3\2\2\2\u008c\u008d"+
		"\7G\2\2\u008d\u008e\7z\2\2\u008e\u008f\7k\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7v\2\2\u0091\u0092\7u\2\2\u0092(\3\2\2\2\u0093\u0094\7?\2\2\u0094"+
		"*\3\2\2\2\u0095\u0097\7A\2\2\u0096\u0098\t\2\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\u009c\3\2\2\2\u0099\u009b\5\61\31\2\u009a\u0099\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d,\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a5\3\2\2\2\u00a2"+
		"\u00a4\5\61\31\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6.\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00ac"+
		"\4C\\\2\u00a9\u00ab\5\61\31\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\60\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b0\t\3\2\2\u00b0\62\3\2\2\2\u00b1\u00b3\t\4\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\32\2\2\u00b7\64\3\2\2\2\21\2CI"+
		"UY_c|\u0081\u0097\u009c\u00a0\u00a5\u00ac\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}