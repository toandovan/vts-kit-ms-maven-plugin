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
		RULE_relationsip_list = 7, RULE_relation_ele = 8, RULE_relation_ele_body = 9, 
		RULE_display_field = 10, RULE_dto_declaration = 11, RULE_dto_list = 12, 
		RULE_dto_field = 13, RULE_type = 14, RULE_relation_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "entity_declaration", "table_name", "entity_body", "entity_field", 
			"entity_validate", "relationship", "relationsip_list", "relation_ele", 
			"relation_ele_body", "display_field", "dto_declaration", "dto_list", 
			"dto_field", "type", "relation_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'to'", "'String'", "'Float'", "'Double'", "'Long'", "'OneToOne'", 
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENTITY) | (1L << DTO) | (1L << RELATIONSHIP))) != 0)) {
				{
				setState(35);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENTITY:
					{
					setState(32);
					entity_declaration();
					}
					break;
				case RELATIONSHIP:
					{
					setState(33);
					relationship();
					}
					break;
				case DTO:
					{
					setState(34);
					dto_declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
			setState(42);
			match(ENTITY);
			setState(43);
			match(ID);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSB) {
				{
				setState(44);
				table_name();
				}
			}

			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(47);
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
			setState(50);
			match(LSB);
			setState(51);
			match(ID);
			setState(52);
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
			setState(54);
			match(LP);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(55);
				entity_field();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(63);
			match(ID);
			setState(64);
			type();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==REQUIRE || _la==UNIQUE) {
				{
				{
				setState(65);
				entity_validate();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
			setState(73);
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
			setState(75);
			match(RELATIONSHIP);
			setState(76);
			relation_type();
			setState(77);
			match(LP);
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				relationsip_list();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(83);
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
			setState(85);
			relation_ele();
			setState(86);
			match(T__0);
			setState(87);
			relation_ele();
			setState(88);
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
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public Relation_ele_bodyContext relation_ele_body() {
			return getRuleContext(Relation_ele_bodyContext.class,0);
		}
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
			setState(90);
			match(ID);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(91);
				relation_ele_body();
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

	public static class Relation_ele_bodyContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(JDLParser.LP, 0); }
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public TerminalNode RP() { return getToken(JDLParser.RP, 0); }
		public Display_fieldContext display_field() {
			return getRuleContext(Display_fieldContext.class,0);
		}
		public TerminalNode REQUIRE() { return getToken(JDLParser.REQUIRE, 0); }
		public Relation_ele_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_ele_body; }
	}

	public final Relation_ele_bodyContext relation_ele_body() throws RecognitionException {
		Relation_ele_bodyContext _localctx = new Relation_ele_bodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relation_ele_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(LP);
			setState(95);
			match(ID);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(96);
				display_field();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REQUIRE) {
				{
				setState(99);
				match(REQUIRE);
				}
			}

			setState(102);
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

	public static class Display_fieldContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(JDLParser.LB, 0); }
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public TerminalNode RB() { return getToken(JDLParser.RB, 0); }
		public Display_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_display_field; }
	}

	public final Display_fieldContext display_field() throws RecognitionException {
		Display_fieldContext _localctx = new Display_fieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_display_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(LB);
			setState(105);
			match(ID);
			setState(106);
			match(RB);
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
		enterRule(_localctx, 22, RULE_dto_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(DTO);
			setState(109);
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
		enterRule(_localctx, 24, RULE_dto_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			setState(112);
			match(LSB);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(113);
				dto_field();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
		public TerminalNode ID() { return getToken(JDLParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 26, RULE_dto_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(ID);
			setState(122);
			type();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REQUIRE) {
				{
				setState(123);
				match(REQUIRE);
				}
			}

			setState(126);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JDLParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(JDLParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(JDLParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(JDLParser.LONG, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
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
		enterRule(_localctx, 30, RULE_relation_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u0087\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\5\3\60\n\3\3\3\5\3\63"+
		"\n\3\3\4\3\4\3\4\3\4\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3\6\3\6\3"+
		"\6\7\6E\n\6\f\6\16\6H\13\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\6\bR\n\b\r"+
		"\b\16\bS\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n_\n\n\3\13\3\13\3\13\5"+
		"\13d\n\13\3\13\5\13g\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\7\16u\n\16\f\16\16\16x\13\16\3\16\3\16\3\17\3\17\3\17\5\17\177"+
		"\n\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \2\5\3\2\20\21\3\2\4\7\3\2\b\13\2\u0083\2\'\3\2\2\2\4"+
		",\3\2\2\2\6\64\3\2\2\2\b8\3\2\2\2\nA\3\2\2\2\fK\3\2\2\2\16M\3\2\2\2\20"+
		"W\3\2\2\2\22\\\3\2\2\2\24`\3\2\2\2\26j\3\2\2\2\30n\3\2\2\2\32q\3\2\2\2"+
		"\34{\3\2\2\2\36\u0082\3\2\2\2 \u0084\3\2\2\2\"&\5\4\3\2#&\5\16\b\2$&\5"+
		"\30\r\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2"+
		"(*\3\2\2\2)\'\3\2\2\2*+\7\2\2\3+\3\3\2\2\2,-\7\f\2\2-/\7\34\2\2.\60\5"+
		"\6\4\2/.\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61\63\5\b\5\2\62\61\3\2\2\2"+
		"\62\63\3\2\2\2\63\5\3\2\2\2\64\65\7\31\2\2\65\66\7\34\2\2\66\67\7\32\2"+
		"\2\67\7\3\2\2\28<\7\26\2\29;\5\n\6\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3"+
		"\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\27\2\2@\t\3\2\2\2AB\7\34\2\2BF\5\36\20"+
		"\2CE\5\f\7\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2"+
		"\2IJ\7\30\2\2J\13\3\2\2\2KL\t\2\2\2L\r\3\2\2\2MN\7\17\2\2NO\5 \21\2OQ"+
		"\7\26\2\2PR\5\20\t\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2"+
		"UV\7\27\2\2V\17\3\2\2\2WX\5\22\n\2XY\7\3\2\2YZ\5\22\n\2Z[\7\30\2\2[\21"+
		"\3\2\2\2\\^\7\34\2\2]_\5\24\13\2^]\3\2\2\2^_\3\2\2\2_\23\3\2\2\2`a\7\26"+
		"\2\2ac\7\34\2\2bd\5\26\f\2cb\3\2\2\2cd\3\2\2\2df\3\2\2\2eg\7\20\2\2fe"+
		"\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\27\2\2i\25\3\2\2\2jk\7\24\2\2kl\7\34"+
		"\2\2lm\7\25\2\2m\27\3\2\2\2no\7\16\2\2op\5\32\16\2p\31\3\2\2\2qr\7\34"+
		"\2\2rv\7\31\2\2su\5\34\17\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy"+
		"\3\2\2\2xv\3\2\2\2yz\7\32\2\2z\33\3\2\2\2{|\7\34\2\2|~\5\36\20\2}\177"+
		"\7\20\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\30\2"+
		"\2\u0081\35\3\2\2\2\u0082\u0083\t\3\2\2\u0083\37\3\2\2\2\u0084\u0085\t"+
		"\4\2\2\u0085!\3\2\2\2\16%\'/\62<FS^cfv~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}