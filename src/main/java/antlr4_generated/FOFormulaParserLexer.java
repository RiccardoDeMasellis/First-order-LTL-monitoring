// Generated from FOFormulaParser.g4 by ANTLR 4.3

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
public class FOFormulaParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, DOUBLEIMPLY=4, IMPLY=5, AND=6, OR=7, NOT=8, 
		FORALL=9, EXISTS=10, EQUAL=11, FALSEATOM=12, TRUEATOM=13, VARIABLE=14, 
		CONSTANT=15, PREPOSITION=16, WS=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'"
	};
	public static final String[] ruleNames = {
		"T__0", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", "OR", "NOT", 
		"FORALL", "EXISTS", "EQUAL", "FALSEATOM", "TRUEATOM", "VARIABLE", "CONSTANT", 
		"PREPOSITION", "CHARACTER", "WS"
	};


	public FOFormulaParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOFormulaParser.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\5\78\n\7\3\b\3\b\3\b\5\b=\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r`\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16n\n\16\3\17\3\17\5\17r\n"+
		"\17\3\17\7\17u\n\17\f\17\16\17x\13\17\3\20\5\20{\n\20\3\20\7\20~\n\20"+
		"\f\20\16\20\u0081\13\20\3\21\3\21\7\21\u0085\n\21\f\21\16\21\u0088\13"+
		"\21\3\22\3\22\3\23\6\23\u008d\n\23\r\23\16\23\u008e\3\23\3\23\2\2\24\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\2%\23\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u009a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2"+
		"\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13\61\3\2\2\2\r\67\3"+
		"\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25G\3\2\2\2\27N\3\2\2\2\31"+
		"_\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37z\3\2\2\2!\u0082\3\2\2\2#\u0089\3"+
		"\2\2\2%\u008c\3\2\2\2\'(\7.\2\2(\4\3\2\2\2)*\7*\2\2*\6\3\2\2\2+,\7+\2"+
		"\2,\b\3\2\2\2-.\7>\2\2./\7/\2\2/\60\7@\2\2\60\n\3\2\2\2\61\62\7/\2\2\62"+
		"\63\7@\2\2\63\f\3\2\2\2\648\7(\2\2\65\66\7(\2\2\668\7(\2\2\67\64\3\2\2"+
		"\2\67\65\3\2\2\28\16\3\2\2\29=\7~\2\2:;\7~\2\2;=\7~\2\2<9\3\2\2\2<:\3"+
		"\2\2\2=\20\3\2\2\2>?\7#\2\2?\22\3\2\2\2@A\7H\2\2AB\7q\2\2BC\7t\2\2CD\7"+
		"c\2\2DE\7n\2\2EF\7n\2\2F\24\3\2\2\2GH\7G\2\2HI\7z\2\2IJ\7k\2\2JK\7u\2"+
		"\2KL\7v\2\2LM\7u\2\2M\26\3\2\2\2NO\7?\2\2O\30\3\2\2\2PQ\7H\2\2QR\7C\2"+
		"\2RS\7N\2\2ST\7U\2\2T`\7G\2\2UV\7H\2\2VW\7c\2\2WX\7n\2\2XY\7u\2\2Y`\7"+
		"g\2\2Z[\7h\2\2[\\\7c\2\2\\]\7n\2\2]^\7u\2\2^`\7g\2\2_P\3\2\2\2_U\3\2\2"+
		"\2_Z\3\2\2\2`\32\3\2\2\2ab\7V\2\2bc\7T\2\2cd\7W\2\2dn\7G\2\2ef\7V\2\2"+
		"fg\7t\2\2gh\7w\2\2hn\7g\2\2ij\7v\2\2jk\7t\2\2kl\7w\2\2ln\7g\2\2ma\3\2"+
		"\2\2me\3\2\2\2mi\3\2\2\2n\34\3\2\2\2oq\7A\2\2pr\t\2\2\2qp\3\2\2\2rv\3"+
		"\2\2\2su\5#\22\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\36\3\2\2\2x"+
		"v\3\2\2\2y{\t\2\2\2zy\3\2\2\2{\177\3\2\2\2|~\5#\22\2}|\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080 \3\2\2\2\u0081\177\3\2\2"+
		"\2\u0082\u0086\4C\\\2\u0083\u0085\5#\22\2\u0084\u0083\3\2\2\2\u0085\u0088"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\"\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008a\t\3\2\2\u008a$\3\2\2\2\u008b\u008d\t\4\2\2"+
		"\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\23\2\2\u0091&\3\2\2\2\r\2\67"+
		"<_mqvz\177\u0086\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}