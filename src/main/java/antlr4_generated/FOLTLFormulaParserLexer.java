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
		PREPOSITION=22, FALSEATOM=23, TRUEATOM=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'"
	};
	public static final String[] ruleNames = {
		"T__0", "LAST", "WEAKUNTIL", "UNTIL", "RELEASE", "GLOBALLY", "EVENTUALLY", 
		"WEAKNEXT", "NEXT", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", 
		"OR", "NOT", "FORALL", "EXISTS", "EQUAL", "VARIABLE", "CONSTANT", "PREPOSITION", 
		"FALSEATOM", "TRUEATOM", "CHARACTER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00c8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\5\7T\n\7\3\b\3\b\3\b\5\bY\n\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\5\17n\n\17\3\20\3\20\3\20"+
		"\5\20s\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u0089\n\25\3\25\7\25\u008c"+
		"\n\25\f\25\16\25\u008f\13\25\3\26\5\26\u0092\n\26\3\26\7\26\u0095\n\26"+
		"\f\26\16\26\u0098\13\26\3\27\3\27\7\27\u009c\n\27\f\27\16\27\u009f\13"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u00b0\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u00be\n\31\3\32\3\32\3\33\6\33\u00c3\n\33\r\33\16"+
		"\33\u00c4\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\2\65\33\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00d5\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5E\3\2\2\2\7J\3\2\2\2\tL\3\2\2"+
		"\2\13N\3\2\2\2\rS\3\2\2\2\17X\3\2\2\2\21Z\3\2\2\2\23]\3\2\2\2\25_\3\2"+
		"\2\2\27a\3\2\2\2\31c\3\2\2\2\33g\3\2\2\2\35m\3\2\2\2\37r\3\2\2\2!t\3\2"+
		"\2\2#v\3\2\2\2%}\3\2\2\2\'\u0084\3\2\2\2)\u0086\3\2\2\2+\u0091\3\2\2\2"+
		"-\u0099\3\2\2\2/\u00af\3\2\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\u00c2"+
		"\3\2\2\2\678\7.\2\28\4\3\2\2\29:\7N\2\2:;\7c\2\2;<\7u\2\2<F\7v\2\2=>\7"+
		"N\2\2>?\7C\2\2?@\7U\2\2@F\7V\2\2AB\7n\2\2BC\7c\2\2CD\7u\2\2DF\7v\2\2E"+
		"9\3\2\2\2E=\3\2\2\2EA\3\2\2\2F\6\3\2\2\2GH\7Y\2\2HK\7W\2\2IK\7Y\2\2JG"+
		"\3\2\2\2JI\3\2\2\2K\b\3\2\2\2LM\7W\2\2M\n\3\2\2\2NO\7T\2\2O\f\3\2\2\2"+
		"PQ\7]\2\2QT\7_\2\2RT\7I\2\2SP\3\2\2\2SR\3\2\2\2T\16\3\2\2\2UV\7>\2\2V"+
		"Y\7@\2\2WY\7H\2\2XU\3\2\2\2XW\3\2\2\2Y\20\3\2\2\2Z[\7Y\2\2[\\\7Z\2\2\\"+
		"\22\3\2\2\2]^\7Z\2\2^\24\3\2\2\2_`\7*\2\2`\26\3\2\2\2ab\7+\2\2b\30\3\2"+
		"\2\2cd\7>\2\2de\7/\2\2ef\7@\2\2f\32\3\2\2\2gh\7/\2\2hi\7@\2\2i\34\3\2"+
		"\2\2jn\7(\2\2kl\7(\2\2ln\7(\2\2mj\3\2\2\2mk\3\2\2\2n\36\3\2\2\2os\7~\2"+
		"\2pq\7~\2\2qs\7~\2\2ro\3\2\2\2rp\3\2\2\2s \3\2\2\2tu\7#\2\2u\"\3\2\2\2"+
		"vw\7H\2\2wx\7q\2\2xy\7t\2\2yz\7c\2\2z{\7n\2\2{|\7n\2\2|$\3\2\2\2}~\7G"+
		"\2\2~\177\7z\2\2\177\u0080\7k\2\2\u0080\u0081\7u\2\2\u0081\u0082\7v\2"+
		"\2\u0082\u0083\7u\2\2\u0083&\3\2\2\2\u0084\u0085\7?\2\2\u0085(\3\2\2\2"+
		"\u0086\u0088\7A\2\2\u0087\u0089\t\2\2\2\u0088\u0087\3\2\2\2\u0089\u008d"+
		"\3\2\2\2\u008a\u008c\5\63\32\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e*\3\2\2\2\u008f\u008d\3"+
		"\2\2\2\u0090\u0092\t\2\2\2\u0091\u0090\3\2\2\2\u0092\u0096\3\2\2\2\u0093"+
		"\u0095\5\63\32\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097,\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009d"+
		"\4C\\\2\u009a\u009c\5\63\32\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e.\3\2\2\2\u009f\u009d\3"+
		"\2\2\2\u00a0\u00a1\7H\2\2\u00a1\u00a2\7C\2\2\u00a2\u00a3\7N\2\2\u00a3"+
		"\u00a4\7U\2\2\u00a4\u00b0\7G\2\2\u00a5\u00a6\7H\2\2\u00a6\u00a7\7c\2\2"+
		"\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00b0\7g\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae"+
		"\u00b0\7g\2\2\u00af\u00a0\3\2\2\2\u00af\u00a5\3\2\2\2\u00af\u00aa\3\2"+
		"\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7V\2\2\u00b2\u00b3\7T\2\2\u00b3\u00b4"+
		"\7W\2\2\u00b4\u00be\7G\2\2\u00b5\u00b6\7V\2\2\u00b6\u00b7\7t\2\2\u00b7"+
		"\u00b8\7w\2\2\u00b8\u00be\7g\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7t\2\2"+
		"\u00bb\u00bc\7w\2\2\u00bc\u00be\7g\2\2\u00bd\u00b1\3\2\2\2\u00bd\u00b5"+
		"\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\62\3\2\2\2\u00bf\u00c0\t\3\2\2\u00c0"+
		"\64\3\2\2\2\u00c1\u00c3\t\4\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2"+
		"\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\b\33\2\2\u00c7\66\3\2\2\2\21\2EJSXmr\u0088\u008d\u0091\u0096\u009d\u00af"+
		"\u00bd\u00c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}