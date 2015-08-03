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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3E\n\3\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\5\7W\n\7\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\5\20v\n\20\3\21\3\21\3\21\5\21{\n\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\5\26\u0091\n\26\3\26\7\26\u0094\n\26\f\26\16\26\u0097\13\26\3\27"+
		"\5\27\u009a\n\27\3\27\7\27\u009d\n\27\f\27\16\27\u00a0\13\27\3\30\3\30"+
		"\7\30\u00a4\n\30\f\30\16\30\u00a7\13\30\3\31\3\31\3\32\6\32\u00ac\n\32"+
		"\r\32\16\32\u00ad\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\2\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/"+
		"\30\61\2\63\31\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00b9"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2"+
		"\2\3\65\3\2\2\2\5\67\3\2\2\2\7F\3\2\2\2\tL\3\2\2\2\13O\3\2\2\2\rR\3\2"+
		"\2\2\17X\3\2\2\2\21^\3\2\2\2\23b\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2\31i\3"+
		"\2\2\2\33k\3\2\2\2\35o\3\2\2\2\37u\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3\2\2"+
		"\2\'\u0085\3\2\2\2)\u008c\3\2\2\2+\u008e\3\2\2\2-\u0099\3\2\2\2/\u00a1"+
		"\3\2\2\2\61\u00a8\3\2\2\2\63\u00ab\3\2\2\2\65\66\7.\2\2\66\4\3\2\2\2\67"+
		"D\5\25\13\289\7N\2\29:\7c\2\2:;\7u\2\2;E\7v\2\2<=\7N\2\2=>\7C\2\2>?\7"+
		"U\2\2?E\7V\2\2@A\7n\2\2AB\7c\2\2BC\7u\2\2CE\7v\2\2D8\3\2\2\2D<\3\2\2\2"+
		"D@\3\2\2\2E\6\3\2\2\2FJ\5\25\13\2GH\7Y\2\2HK\7W\2\2IK\7Y\2\2JG\3\2\2\2"+
		"JI\3\2\2\2K\b\3\2\2\2LM\5\25\13\2MN\7W\2\2N\n\3\2\2\2OP\5\25\13\2PQ\7"+
		"T\2\2Q\f\3\2\2\2RV\5\25\13\2ST\7]\2\2TW\7_\2\2UW\7I\2\2VS\3\2\2\2VU\3"+
		"\2\2\2W\16\3\2\2\2X\\\5\25\13\2YZ\7>\2\2Z]\7@\2\2[]\7H\2\2\\Y\3\2\2\2"+
		"\\[\3\2\2\2]\20\3\2\2\2^_\5\25\13\2_`\7Y\2\2`a\7Z\2\2a\22\3\2\2\2bc\5"+
		"\25\13\2cd\7Z\2\2d\24\3\2\2\2ef\7\u00b2\2\2f\26\3\2\2\2gh\7*\2\2h\30\3"+
		"\2\2\2ij\7+\2\2j\32\3\2\2\2kl\7>\2\2lm\7/\2\2mn\7@\2\2n\34\3\2\2\2op\7"+
		"/\2\2pq\7@\2\2q\36\3\2\2\2rv\7(\2\2st\7(\2\2tv\7(\2\2ur\3\2\2\2us\3\2"+
		"\2\2v \3\2\2\2w{\7~\2\2xy\7~\2\2y{\7~\2\2zw\3\2\2\2zx\3\2\2\2{\"\3\2\2"+
		"\2|}\7#\2\2}$\3\2\2\2~\177\7H\2\2\177\u0080\7q\2\2\u0080\u0081\7t\2\2"+
		"\u0081\u0082\7c\2\2\u0082\u0083\7n\2\2\u0083\u0084\7n\2\2\u0084&\3\2\2"+
		"\2\u0085\u0086\7G\2\2\u0086\u0087\7z\2\2\u0087\u0088\7k\2\2\u0088\u0089"+
		"\7u\2\2\u0089\u008a\7v\2\2\u008a\u008b\7u\2\2\u008b(\3\2\2\2\u008c\u008d"+
		"\7?\2\2\u008d*\3\2\2\2\u008e\u0090\7A\2\2\u008f\u0091\t\2\2\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0095\3\2\2\2\u0092\u0094\5\61\31\2\u0093\u0092\3\2\2\2"+
		"\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096,\3"+
		"\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\t\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009e\3\2\2\2\u009b\u009d\5\61\31\2\u009c\u009b\3\2\2\2\u009d\u00a0\3"+
		"\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f.\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a5\4C\\\2\u00a2\u00a4\5\61\31\2\u00a3\u00a2\3\2\2\2"+
		"\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\60"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\t\3\2\2\u00a9\62\3\2\2\2\u00aa"+
		"\u00ac\t\4\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\32\2\2\u00b0"+
		"\64\3\2\2\2\17\2DJV\\uz\u0090\u0095\u0099\u009e\u00a5\u00ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}