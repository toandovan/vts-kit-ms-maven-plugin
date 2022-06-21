// Generated from D:/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JDLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STRING=2, FLOAT=3, DOUBLE=4, LONG=5, ONETOONE=6, ONETOMANY=7, 
		MANYTOONE=8, MANYTOMANY=9, ENTITY=10, API=11, DTO=12, RELATIONSHIP=13, 
		REQUIRE=14, UNIQUE=15, BLOCK_CMT=16, LINE_CMT=17, LB=18, RB=19, LP=20, 
		RP=21, SEMI=22, LSB=23, RSB=24, COMMA=25, ID=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "STRING", "FLOAT", "DOUBLE", "LONG", "ONETOONE", "ONETOMANY", 
			"MANYTOONE", "MANYTOMANY", "ENTITY", "API", "DTO", "RELATIONSHIP", "REQUIRE", 
			"UNIQUE", "BLOCK_CMT", "LINE_CMT", "LB", "RB", "LP", "RP", "SEMI", "LSB", 
			"RSB", "COMMA", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'to'", "'string'", "'float'", "'double'", "'long'", "'OneToOne'", 
			"'OneToMany'", "'ManyToOne'", "'ManyToMany'", "'ENTITY'", "'API'", "'DTO'", 
			"'RELATIONSHIP'", "'require'", "'unique'", null, null, "'('", "')'", 
			"'{'", "'}'", "';'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "STRING", "FLOAT", "DOUBLE", "LONG", "ONETOONE", "ONETOMANY", 
			"MANYTOONE", "MANYTOMANY", "ENTITY", "API", "DTO", "RELATIONSHIP", "REQUIRE", 
			"UNIQUE", "BLOCK_CMT", "LINE_CMT", "LB", "RB", "LP", "RP", "SEMI", "LSB", 
			"RSB", "COMMA", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public JDLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001b\u00dd\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ab"+
		"\b\u000f\n\u000f\f\u000f\u00ae\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00b9\b\u0010\n\u0010\f\u0010\u00bc\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u00d2\b\u0019\n\u0019\f\u0019\u00d5\t\u0019\u0001\u001a"+
		"\u0004\u001a\u00d8\b\u001a\u000b\u001a\f\u001a\u00d9\u0001\u001a\u0001"+
		"\u001a\u0001\u00ac\u0000\u001b\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b\u0001\u0000"+
		"\u0004\u0002\u0000\n\n\f\r\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\r\r  \u00e0\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0001"+
		"7\u0001\u0000\u0000\u0000\u0003:\u0001\u0000\u0000\u0000\u0005A\u0001"+
		"\u0000\u0000\u0000\u0007G\u0001\u0000\u0000\u0000\tN\u0001\u0000\u0000"+
		"\u0000\u000bS\u0001\u0000\u0000\u0000\r\\\u0001\u0000\u0000\u0000\u000f"+
		"f\u0001\u0000\u0000\u0000\u0011p\u0001\u0000\u0000\u0000\u0013{\u0001"+
		"\u0000\u0000\u0000\u0015\u0082\u0001\u0000\u0000\u0000\u0017\u0086\u0001"+
		"\u0000\u0000\u0000\u0019\u008a\u0001\u0000\u0000\u0000\u001b\u0097\u0001"+
		"\u0000\u0000\u0000\u001d\u009f\u0001\u0000\u0000\u0000\u001f\u00a6\u0001"+
		"\u0000\u0000\u0000!\u00b4\u0001\u0000\u0000\u0000#\u00bf\u0001\u0000\u0000"+
		"\u0000%\u00c1\u0001\u0000\u0000\u0000\'\u00c3\u0001\u0000\u0000\u0000"+
		")\u00c5\u0001\u0000\u0000\u0000+\u00c7\u0001\u0000\u0000\u0000-\u00c9"+
		"\u0001\u0000\u0000\u0000/\u00cb\u0001\u0000\u0000\u00001\u00cd\u0001\u0000"+
		"\u0000\u00003\u00cf\u0001\u0000\u0000\u00005\u00d7\u0001\u0000\u0000\u0000"+
		"78\u0005t\u0000\u000089\u0005o\u0000\u00009\u0002\u0001\u0000\u0000\u0000"+
		":;\u0005s\u0000\u0000;<\u0005t\u0000\u0000<=\u0005r\u0000\u0000=>\u0005"+
		"i\u0000\u0000>?\u0005n\u0000\u0000?@\u0005g\u0000\u0000@\u0004\u0001\u0000"+
		"\u0000\u0000AB\u0005f\u0000\u0000BC\u0005l\u0000\u0000CD\u0005o\u0000"+
		"\u0000DE\u0005a\u0000\u0000EF\u0005t\u0000\u0000F\u0006\u0001\u0000\u0000"+
		"\u0000GH\u0005d\u0000\u0000HI\u0005o\u0000\u0000IJ\u0005u\u0000\u0000"+
		"JK\u0005b\u0000\u0000KL\u0005l\u0000\u0000LM\u0005e\u0000\u0000M\b\u0001"+
		"\u0000\u0000\u0000NO\u0005l\u0000\u0000OP\u0005o\u0000\u0000PQ\u0005n"+
		"\u0000\u0000QR\u0005g\u0000\u0000R\n\u0001\u0000\u0000\u0000ST\u0005O"+
		"\u0000\u0000TU\u0005n\u0000\u0000UV\u0005e\u0000\u0000VW\u0005T\u0000"+
		"\u0000WX\u0005o\u0000\u0000XY\u0005O\u0000\u0000YZ\u0005n\u0000\u0000"+
		"Z[\u0005e\u0000\u0000[\f\u0001\u0000\u0000\u0000\\]\u0005O\u0000\u0000"+
		"]^\u0005n\u0000\u0000^_\u0005e\u0000\u0000_`\u0005T\u0000\u0000`a\u0005"+
		"o\u0000\u0000ab\u0005M\u0000\u0000bc\u0005a\u0000\u0000cd\u0005n\u0000"+
		"\u0000de\u0005y\u0000\u0000e\u000e\u0001\u0000\u0000\u0000fg\u0005M\u0000"+
		"\u0000gh\u0005a\u0000\u0000hi\u0005n\u0000\u0000ij\u0005y\u0000\u0000"+
		"jk\u0005T\u0000\u0000kl\u0005o\u0000\u0000lm\u0005O\u0000\u0000mn\u0005"+
		"n\u0000\u0000no\u0005e\u0000\u0000o\u0010\u0001\u0000\u0000\u0000pq\u0005"+
		"M\u0000\u0000qr\u0005a\u0000\u0000rs\u0005n\u0000\u0000st\u0005y\u0000"+
		"\u0000tu\u0005T\u0000\u0000uv\u0005o\u0000\u0000vw\u0005M\u0000\u0000"+
		"wx\u0005a\u0000\u0000xy\u0005n\u0000\u0000yz\u0005y\u0000\u0000z\u0012"+
		"\u0001\u0000\u0000\u0000{|\u0005E\u0000\u0000|}\u0005N\u0000\u0000}~\u0005"+
		"T\u0000\u0000~\u007f\u0005I\u0000\u0000\u007f\u0080\u0005T\u0000\u0000"+
		"\u0080\u0081\u0005Y\u0000\u0000\u0081\u0014\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005A\u0000\u0000\u0083\u0084\u0005P\u0000\u0000\u0084\u0085\u0005"+
		"I\u0000\u0000\u0085\u0016\u0001\u0000\u0000\u0000\u0086\u0087\u0005D\u0000"+
		"\u0000\u0087\u0088\u0005T\u0000\u0000\u0088\u0089\u0005O\u0000\u0000\u0089"+
		"\u0018\u0001\u0000\u0000\u0000\u008a\u008b\u0005R\u0000\u0000\u008b\u008c"+
		"\u0005E\u0000\u0000\u008c\u008d\u0005L\u0000\u0000\u008d\u008e\u0005A"+
		"\u0000\u0000\u008e\u008f\u0005T\u0000\u0000\u008f\u0090\u0005I\u0000\u0000"+
		"\u0090\u0091\u0005O\u0000\u0000\u0091\u0092\u0005N\u0000\u0000\u0092\u0093"+
		"\u0005S\u0000\u0000\u0093\u0094\u0005H\u0000\u0000\u0094\u0095\u0005I"+
		"\u0000\u0000\u0095\u0096\u0005P\u0000\u0000\u0096\u001a\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0005r\u0000\u0000\u0098\u0099\u0005e\u0000\u0000\u0099"+
		"\u009a\u0005q\u0000\u0000\u009a\u009b\u0005u\u0000\u0000\u009b\u009c\u0005"+
		"i\u0000\u0000\u009c\u009d\u0005r\u0000\u0000\u009d\u009e\u0005e\u0000"+
		"\u0000\u009e\u001c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005u\u0000\u0000"+
		"\u00a0\u00a1\u0005n\u0000\u0000\u00a1\u00a2\u0005i\u0000\u0000\u00a2\u00a3"+
		"\u0005q\u0000\u0000\u00a3\u00a4\u0005u\u0000\u0000\u00a4\u00a5\u0005e"+
		"\u0000\u0000\u00a5\u001e\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005/\u0000"+
		"\u0000\u00a7\u00a8\u0005*\u0000\u0000\u00a8\u00ac\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ab\t\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ae\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00af\u00b0\u0005*\u0000\u0000\u00b0\u00b1"+
		"\u0005/\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006"+
		"\u000f\u0000\u0000\u00b3 \u0001\u0000\u0000\u0000\u00b4\u00b5\u0005/\u0000"+
		"\u0000\u00b5\u00b6\u0005/\u0000\u0000\u00b6\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\b\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0006\u0010\u0000\u0000\u00be"+
		"\"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005(\u0000\u0000\u00c0$\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005)\u0000\u0000\u00c2&\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0005{\u0000\u0000\u00c4(\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005}\u0000\u0000\u00c6*\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005"+
		";\u0000\u0000\u00c8,\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005[\u0000"+
		"\u0000\u00ca.\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005]\u0000\u0000\u00cc"+
		"0\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005,\u0000\u0000\u00ce2\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d3\u0007\u0001\u0000\u0000\u00d0\u00d2\u0007"+
		"\u0002\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d44\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d8\u0007\u0003\u0000\u0000\u00d7\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0006\u001a\u0001\u0000\u00dc6\u0001\u0000\u0000"+
		"\u0000\u0005\u0000\u00ac\u00ba\u00d3\u00d9\u0002\u0006\u0000\u0000\u0000"+
		"\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}