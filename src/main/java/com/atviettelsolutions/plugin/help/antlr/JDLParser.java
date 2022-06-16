package com.atviettelsolutions.plugin.help.antlr;// Generated from e:\ToanDV19\VTS\vts-kit-ms-maven-plugin\src\main\java\com\atviettelsolutions\plugin\help\JDL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STRING=2, FLOAT=3, DOUBLE=4, LONG=5, ONETOONE=6, ONETOMANY=7, 
		MANYTOONE=8, MANYTOMANY=9, ENTITY=10, API=11, DTO=12, RELATIONSHIP=13, 
		REQUIRE=14, UNIQUE=15, BLOCK_CMT=16, LINE_CMT=17, LB=18, RB=19, LP=20, 
		RP=21, SEMI=22, LSB=23, RSB=24, COMMA=25, ID=26, WS=27;
	public static final int
		RULE_program = 0, RULE_entity_declaration = 1, RULE_table_name = 2, RULE_entity_body = 3, 
		RULE_entity_field = 4, RULE_entity_validate = 5, RULE_relationship = 6, 
		RULE_relationsip_list = 7, RULE_relation_ele = 8, RULE_dto_declaration = 9, 
		RULE_dto_list = 10, RULE_dto_field = 11, RULE_entity_type = 12, RULE_relation_type = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "entity_declaration", "table_name", "entity_body", "entity_field", 
			"entity_validate", "relationship", "relationsip_list", "relation_ele", 
			"dto_declaration", "dto_list", "dto_field", "entity_type", "relation_type"
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

	@Override
	public String getGrammarFileName() { return "JDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JDLParser.EOF, 0); }
		public List<Entity_declarationContext> entity_declaration() {
			return getRuleContexts(Entity_declarationContext.class);
		}
		public Entity_declarationContext entity_declaration(int i) {
			return getRuleContext(Entity_declarationContext.class,i);
		}
		public List<RelationshipContext> relationship() {
			return getRuleContexts(RelationshipContext.class);
		}
		public RelationshipContext relationship(int i) {
			return getRuleContext(RelationshipContext.class,i);
		}
		public List<Dto_declarationContext> dto_declaration() {
			return getRuleContexts(Dto_declarationContext.class);
		}
		public Dto_declarationContext dto_declaration(int i) {
			return getRuleContext(Dto_declarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENTITY) | (1L << DTO) | (1L << RELATIONSHIP))) != 0)) {
				{
				setState(31);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENTITY:
					{
					setState(28);
					entity_declaration();
					}
					break;
				case RELATIONSHIP:
					{
					setState(29);
					relationship();
					}
					break;
				case DTO:
					{
					setState(30);
					dto_declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
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

	public static class Entity_declarationContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(JDLParser.ENTITY, 0); }
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Entity_bodyContext entity_body() {
			return getRuleContext(Entity_bodyContext.class,0);
		}
		public Entity_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_declaration; }
	}

	public final Entity_declarationContext entity_declaration() throws RecognitionException {
		Entity_declarationContext _localctx = new Entity_declarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entity_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(ENTITY);
			setState(39);
			match(ID);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(40);
				table_name();
				}
			}

			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(43);
				entity_body();
				}
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

	public static class Table_nameContext extends ParserRuleContext {
		public TerminalNode LSB() { return getToken(JDLParser.LSB, 0); }
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public TerminalNode RSB() { return getToken(JDLParser.RSB, 0); }
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(LSB);
			setState(47);
			match(ID);
			setState(48);
			match(RSB);
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

	public static class Entity_bodyContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(JDLParser.LP, 0); }
		public TerminalNode RP() { return getToken(JDLParser.RP, 0); }
		public List<Entity_fieldContext> entity_field() {
			return getRuleContexts(Entity_fieldContext.class);
		}
		public Entity_fieldContext entity_field(int i) {
			return getRuleContext(Entity_fieldContext.class,i);
		}
		public Entity_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_body; }
	}

	public final Entity_bodyContext entity_body() throws RecognitionException {
		Entity_bodyContext _localctx = new Entity_bodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_entity_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(LP);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(51);
				entity_field();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(RP);
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

	public static class Entity_fieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public Entity_typeContext entity_type() {
			return getRuleContext(Entity_typeContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JDLParser.SEMI, 0); }
		public List<Entity_validateContext> entity_validate() {
			return getRuleContexts(Entity_validateContext.class);
		}
		public Entity_validateContext entity_validate(int i) {
			return getRuleContext(Entity_validateContext.class,i);
		}
		public Entity_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_field; }
	}

	public final Entity_fieldContext entity_field() throws RecognitionException {
		Entity_fieldContext _localctx = new Entity_fieldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entity_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);
			setState(60);
			entity_type();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==REQUIRE || _la==UNIQUE) {
				{
				{
				setState(61);
				entity_validate();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(SEMI);
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

	public static class Entity_validateContext extends ParserRuleContext {
		public TerminalNode REQUIRE() { return getToken(JDLParser.REQUIRE, 0); }
		public TerminalNode UNIQUE() { return getToken(JDLParser.UNIQUE, 0); }
		public Entity_validateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_validate; }
	}

	public final Entity_validateContext entity_validate() throws RecognitionException {
		Entity_validateContext _localctx = new Entity_validateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_entity_validate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==REQUIRE || _la==UNIQUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class RelationshipContext extends ParserRuleContext {
		public TerminalNode RELATIONSHIP() { return getToken(JDLParser.RELATIONSHIP, 0); }
		public Relation_typeContext relation_type() {
			return getRuleContext(Relation_typeContext.class,0);
		}
		public TerminalNode LP() { return getToken(JDLParser.LP, 0); }
		public TerminalNode RP() { return getToken(JDLParser.RP, 0); }
		public List<Relationsip_listContext> relationsip_list() {
			return getRuleContexts(Relationsip_listContext.class);
		}
		public Relationsip_listContext relationsip_list(int i) {
			return getRuleContext(Relationsip_listContext.class,i);
		}
		public RelationshipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationship; }
	}

	public final RelationshipContext relationship() throws RecognitionException {
		RelationshipContext _localctx = new RelationshipContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relationship);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(RELATIONSHIP);
			setState(72);
			relation_type();
			setState(73);
			match(LP);
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				relationsip_list();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(79);
			match(RP);
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

	public static class Relationsip_listContext extends ParserRuleContext {
		public List<Relation_eleContext> relation_ele() {
			return getRuleContexts(Relation_eleContext.class);
		}
		public Relation_eleContext relation_ele(int i) {
			return getRuleContext(Relation_eleContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JDLParser.SEMI, 0); }
		public Relationsip_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationsip_list; }
	}

	public final Relationsip_listContext relationsip_list() throws RecognitionException {
		Relationsip_listContext _localctx = new Relationsip_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_relationsip_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			relation_ele();
			setState(82);
			match(T__0);
			setState(83);
			relation_ele();
			setState(84);
			match(SEMI);
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

	public static class Relation_eleContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JDLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JDLParser.ID, i);
		}
		public TerminalNode LP() { return getToken(JDLParser.LP, 0); }
		public TerminalNode RP() { return getToken(JDLParser.RP, 0); }
		public TerminalNode LB() { return getToken(JDLParser.LB, 0); }
		public TerminalNode RB() { return getToken(JDLParser.RB, 0); }
		public TerminalNode REQUIRE() { return getToken(JDLParser.REQUIRE, 0); }
		public Relation_eleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_ele; }
	}

	public final Relation_eleContext relation_ele() throws RecognitionException {
		Relation_eleContext _localctx = new Relation_eleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relation_ele);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(87);
				match(LP);
				setState(88);
				match(ID);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LB) {
					{
					setState(89);
					match(LB);
					setState(90);
					match(ID);
					setState(91);
					match(RB);
					}
				}

				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==REQUIRE) {
					{
					setState(94);
					match(REQUIRE);
					}
				}

				setState(97);
				match(RP);
				}
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

	public static class Dto_declarationContext extends ParserRuleContext {
		public TerminalNode DTO() { return getToken(JDLParser.DTO, 0); }
		public Dto_listContext dto_list() {
			return getRuleContext(Dto_listContext.class,0);
		}
		public Dto_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dto_declaration; }
	}

	public final Dto_declarationContext dto_declaration() throws RecognitionException {
		Dto_declarationContext _localctx = new Dto_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dto_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(DTO);
			setState(101);
			dto_list();
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

	public static class Dto_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public TerminalNode LSB() { return getToken(JDLParser.LSB, 0); }
		public TerminalNode RSB() { return getToken(JDLParser.RSB, 0); }
		public List<Dto_fieldContext> dto_field() {
			return getRuleContexts(Dto_fieldContext.class);
		}
		public Dto_fieldContext dto_field(int i) {
			return getRuleContext(Dto_fieldContext.class,i);
		}
		public Dto_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dto_list; }
	}

	public final Dto_listContext dto_list() throws RecognitionException {
		Dto_listContext _localctx = new Dto_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dto_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			setState(104);
			match(LSB);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(105);
				dto_field();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(RSB);
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

	public static class Dto_fieldContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(JDLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JDLParser.ID, i);
		}
		public TerminalNode SEMI() { return getToken(JDLParser.SEMI, 0); }
		public TerminalNode REQUIRE() { return getToken(JDLParser.REQUIRE, 0); }
		public Dto_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dto_field; }
	}

	public final Dto_fieldContext dto_field() throws RecognitionException {
		Dto_fieldContext _localctx = new Dto_fieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dto_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(114);
			match(ID);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REQUIRE) {
				{
				setState(115);
				match(REQUIRE);
				}
			}

			setState(118);
			match(SEMI);
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

	public static class Entity_typeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JDLParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(JDLParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(JDLParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(JDLParser.LONG, 0); }
		public Entity_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type; }
	}

	public final Entity_typeContext entity_type() throws RecognitionException {
		Entity_typeContext _localctx = new Entity_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_entity_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Relation_typeContext extends ParserRuleContext {
		public TerminalNode ONETOMANY() { return getToken(JDLParser.ONETOMANY, 0); }
		public TerminalNode ONETOONE() { return getToken(JDLParser.ONETOONE, 0); }
		public TerminalNode MANYTOMANY() { return getToken(JDLParser.MANYTOMANY, 0); }
		public TerminalNode MANYTOONE() { return getToken(JDLParser.MANYTOONE, 0); }
		public Relation_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_type; }
	}

	public final Relation_typeContext relation_type() throws RecognitionException {
		Relation_typeContext _localctx = new Relation_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relation_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ONETOONE) | (1L << ONETOMANY) | (1L << MANYTOONE) | (1L << MANYTOMANY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2"+
		"%\13\2\3\2\3\2\3\3\3\3\3\3\5\3,\n\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\7\5\67\n\5\f\5\16\5:\13\5\3\5\3\5\3\6\3\6\3\6\7\6A\n\6\f\6\16\6D\13"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\6\bN\n\b\r\b\16\bO\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\n\5\nb\n\n\3\n\5\ne\n"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\7\fm\n\f\f\f\16\fp\13\f\3\f\3\f\3\r\3\r"+
		"\3\r\5\rw\n\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\5\3\2\20\21\3\2\4\7\3\2\b\13\2}\2#\3\2\2\2\4(\3\2"+
		"\2\2\6\60\3\2\2\2\b\64\3\2\2\2\n=\3\2\2\2\fG\3\2\2\2\16I\3\2\2\2\20S\3"+
		"\2\2\2\22X\3\2\2\2\24f\3\2\2\2\26i\3\2\2\2\30s\3\2\2\2\32z\3\2\2\2\34"+
		"|\3\2\2\2\36\"\5\4\3\2\37\"\5\16\b\2 \"\5\24\13\2!\36\3\2\2\2!\37\3\2"+
		"\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7"+
		"\2\2\3\'\3\3\2\2\2()\7\f\2\2)+\7\34\2\2*,\5\6\4\2+*\3\2\2\2+,\3\2\2\2"+
		",.\3\2\2\2-/\5\b\5\2.-\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60\61\7\31\2\2\61"+
		"\62\7\34\2\2\62\63\7\32\2\2\63\7\3\2\2\2\648\7\26\2\2\65\67\5\n\6\2\66"+
		"\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7"+
		"\27\2\2<\t\3\2\2\2=>\7\34\2\2>B\5\32\16\2?A\5\f\7\2@?\3\2\2\2AD\3\2\2"+
		"\2B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7\30\2\2F\13\3\2\2\2GH\t"+
		"\2\2\2H\r\3\2\2\2IJ\7\17\2\2JK\5\34\17\2KM\7\26\2\2LN\5\20\t\2ML\3\2\2"+
		"\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\27\2\2R\17\3\2\2\2ST\5"+
		"\22\n\2TU\7\3\2\2UV\5\22\n\2VW\7\30\2\2W\21\3\2\2\2Xd\7\34\2\2YZ\7\26"+
		"\2\2Z^\7\34\2\2[\\\7\24\2\2\\]\7\34\2\2]_\7\25\2\2^[\3\2\2\2^_\3\2\2\2"+
		"_a\3\2\2\2`b\7\20\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2ce\7\27\2\2dY\3\2\2"+
		"\2de\3\2\2\2e\23\3\2\2\2fg\7\16\2\2gh\5\26\f\2h\25\3\2\2\2ij\7\34\2\2"+
		"jn\7\31\2\2km\5\30\r\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2"+
		"\2pn\3\2\2\2qr\7\32\2\2r\27\3\2\2\2st\7\34\2\2tv\7\34\2\2uw\7\20\2\2v"+
		"u\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\30\2\2y\31\3\2\2\2z{\t\3\2\2{\33\3\2"+
		"\2\2|}\t\4\2\2}\35\3\2\2\2\16!#+.8BO^adnv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}