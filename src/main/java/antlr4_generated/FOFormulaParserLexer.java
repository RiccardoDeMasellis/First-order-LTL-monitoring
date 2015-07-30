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
		FORALL=9, EXISTS=10, EQUAL=11, VARIABLE=12, CONSTANT=13, PREPOSITION=14, 
		WS=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"T__0", "LPAREN", "RPAREN", "DOUBLEIMPLY", "IMPLY", "AND", "OR", "NOT", 
		"FORALL", "EXISTS", "EQUAL", "VARIABLE", "CONSTANT", "PREPOSITION", "CHARACTER", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7\64\n\7\3\b"+
		"\3\b\3\b\5\b9\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\5\rO\n\r\3\r\7\rR\n\r\f\r\16\rU\13"+
		"\r\3\16\5\16X\n\16\3\16\7\16[\n\16\f\16\16\16^\13\16\3\17\3\17\7\17b\n"+
		"\17\f\17\16\17e\13\17\3\20\3\20\3\21\6\21j\n\21\r\21\16\21k\3\21\3\21"+
		"\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\2!\21\3\2\5\4\2\62;c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"s\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7"+
		"\'\3\2\2\2\t)\3\2\2\2\13-\3\2\2\2\r\63\3\2\2\2\178\3\2\2\2\21:\3\2\2\2"+
		"\23<\3\2\2\2\25C\3\2\2\2\27J\3\2\2\2\31L\3\2\2\2\33W\3\2\2\2\35_\3\2\2"+
		"\2\37f\3\2\2\2!i\3\2\2\2#$\7.\2\2$\4\3\2\2\2%&\7*\2\2&\6\3\2\2\2\'(\7"+
		"+\2\2(\b\3\2\2\2)*\7>\2\2*+\7/\2\2+,\7@\2\2,\n\3\2\2\2-.\7/\2\2./\7@\2"+
		"\2/\f\3\2\2\2\60\64\7(\2\2\61\62\7(\2\2\62\64\7(\2\2\63\60\3\2\2\2\63"+
		"\61\3\2\2\2\64\16\3\2\2\2\659\7~\2\2\66\67\7~\2\2\679\7~\2\28\65\3\2\2"+
		"\28\66\3\2\2\29\20\3\2\2\2:;\7#\2\2;\22\3\2\2\2<=\7H\2\2=>\7q\2\2>?\7"+
		"t\2\2?@\7c\2\2@A\7n\2\2AB\7n\2\2B\24\3\2\2\2CD\7G\2\2DE\7z\2\2EF\7k\2"+
		"\2FG\7u\2\2GH\7v\2\2HI\7u\2\2I\26\3\2\2\2JK\7?\2\2K\30\3\2\2\2LN\7A\2"+
		"\2MO\t\2\2\2NM\3\2\2\2OS\3\2\2\2PR\5\37\20\2QP\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2T\32\3\2\2\2US\3\2\2\2VX\t\2\2\2WV\3\2\2\2X\\\3\2\2\2Y["+
		"\5\37\20\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\34\3\2\2\2^\\\3"+
		"\2\2\2_c\4C\\\2`b\5\37\20\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\36"+
		"\3\2\2\2ec\3\2\2\2fg\t\3\2\2g \3\2\2\2hj\t\4\2\2ih\3\2\2\2jk\3\2\2\2k"+
		"i\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\b\21\2\2n\"\3\2\2\2\13\2\638NSW\\ck\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}