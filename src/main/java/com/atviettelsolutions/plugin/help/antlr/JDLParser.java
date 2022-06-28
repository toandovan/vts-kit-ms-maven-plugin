// Generated from E:/ToanDV19/VTS/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import com.atviettelsolutions.plugin.help.antlr.JDLListener;
import com.atviettelsolutions.plugin.help.antlr.JDLVisitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STRING=2, FLOAT=3, DOUBLE=4, LONG=5, INTERGER=6, ONETOONE=7, ONETOMANY=8, 
		MANYTOONE=9, MANYTOMANY=10, ENTITY=11, API=12, DTO=13, RELATIONSHIP=14, 
		REQUIRE=15, UNIQUE=16, BLOCK_CMT=17, LINE_CMT=18, LB=19, RB=20, LP=21, 
		RP=22, SEMI=23, LSB=24, RSB=25, COMMA=26, ID=27, WS=28;
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
			null, "'to'", "'String'", "'Float'", "'Double'", "'Long'", "'Interger'", 
			"'OneToOne'", "'OneToMany'", "'ManyToOne'", "'ManyToMany'", "'ENTITY'", 
			"'API'", "'DTO'", "'RELATIONSHIP'", "'require'", "'unique'", null, null, 
			"'('", "')'", "'{'", "'}'", "';'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "STRING", "FLOAT", "DOUBLE", "LONG", "INTERGER", "ONETOONE", 
			"ONETOMANY", "MANYTOONE", "MANYTOMANY", "ENTITY", "API", "DTO", "RELATIONSHIP", 
			"REQUIRE", "UNIQUE", "BLOCK_CMT", "LINE_CMT", "LB", "RB", "LP", "RP", 
			"SEMI", "LSB", "RSB", "COMMA", "ID", "WS"
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener) ((JDLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor) return ((JDLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterEntity_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitEntity_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitEntity_declaration(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterEntity_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitEntity_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitEntity_body(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterEntity_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitEntity_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitEntity_field(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterEntity_validate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitEntity_validate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitEntity_validate(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterRelationship(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitRelationship(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitRelationship(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterRelationsip_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitRelationsip_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitRelationsip_list(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterRelation_ele(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitRelation_ele(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitRelation_ele(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterRelation_ele_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitRelation_ele_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitRelation_ele_body(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterDisplay_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitDisplay_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitDisplay_field(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterDto_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitDto_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitDto_declaration(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterDto_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitDto_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitDto_list(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterDto_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitDto_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitDto_field(this);
			else return visitor.visitChildren(this);
		}
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
		public TerminalNode INTERGER() { return getToken(JDLParser.INTERGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << FLOAT) | (1L << DOUBLE) | (1L << LONG) | (1L << INTERGER))) != 0)) ) {
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).enterRelation_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JDLListener ) ((JDLListener)listener).exitRelation_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JDLVisitor ) return ((JDLVisitor<? extends T>)visitor).visitRelation_type(this);
			else return visitor.visitChildren(this);
		}
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
		"\u0004\u0001\u001c\u0085\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000\n\u0000"+
		"\f\u0000\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001.\b\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003"+
		"9\b\u0003\n\u0003\f\u0003<\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004C\b\u0004\n\u0004\f\u0004F\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006P\b\u0006\u000b\u0006\f\u0006Q\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0003\b]\b\b\u0001\t\u0001\t\u0001\t\u0003\tb\b"+
		"\t\u0001\t\u0003\te\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f"+
		"s\b\f\n\f\f\fv\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\r}\b"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0003\u0001\u0000\u000f\u0010"+
		"\u0001\u0000\u0002\u0006\u0001\u0000\u0007\n\u0081\u0000%\u0001\u0000"+
		"\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000"+
		"\u00066\u0001\u0000\u0000\u0000\b?\u0001\u0000\u0000\u0000\nI\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eU\u0001\u0000\u0000\u0000"+
		"\u0010Z\u0001\u0000\u0000\u0000\u0012^\u0001\u0000\u0000\u0000\u0014h"+
		"\u0001\u0000\u0000\u0000\u0016l\u0001\u0000\u0000\u0000\u0018o\u0001\u0000"+
		"\u0000\u0000\u001ay\u0001\u0000\u0000\u0000\u001c\u0080\u0001\u0000\u0000"+
		"\u0000\u001e\u0082\u0001\u0000\u0000\u0000 $\u0003\u0002\u0001\u0000!"+
		"$\u0003\f\u0006\u0000\"$\u0003\u0016\u000b\u0000# \u0001\u0000\u0000\u0000"+
		"#!\u0001\u0000\u0000\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000"+
		"\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0000\u0000\u0001)\u0001"+
		"\u0001\u0000\u0000\u0000*+\u0005\u000b\u0000\u0000+-\u0005\u001b\u0000"+
		"\u0000,.\u0003\u0004\u0002\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.0\u0001\u0000\u0000\u0000/1\u0003\u0006\u0003\u00000/\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000"+
		"\u000023\u0005\u0018\u0000\u000034\u0005\u001b\u0000\u000045\u0005\u0019"+
		"\u0000\u00005\u0005\u0001\u0000\u0000\u00006:\u0005\u0015\u0000\u0000"+
		"79\u0003\b\u0004\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0016\u0000\u0000>\u0007\u0001"+
		"\u0000\u0000\u0000?@\u0005\u001b\u0000\u0000@D\u0003\u001c\u000e\u0000"+
		"AC\u0003\n\u0005\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000GH\u0005\u0017\u0000\u0000H\t\u0001\u0000"+
		"\u0000\u0000IJ\u0007\u0000\u0000\u0000J\u000b\u0001\u0000\u0000\u0000"+
		"KL\u0005\u000e\u0000\u0000LM\u0003\u001e\u000f\u0000MO\u0005\u0015\u0000"+
		"\u0000NP\u0003\u000e\u0007\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001"+
		"\u0000\u0000\u0000ST\u0005\u0016\u0000\u0000T\r\u0001\u0000\u0000\u0000"+
		"UV\u0003\u0010\b\u0000VW\u0005\u0001\u0000\u0000WX\u0003\u0010\b\u0000"+
		"XY\u0005\u0017\u0000\u0000Y\u000f\u0001\u0000\u0000\u0000Z\\\u0005\u001b"+
		"\u0000\u0000[]\u0003\u0012\t\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]\u0011\u0001\u0000\u0000\u0000^_\u0005\u0015\u0000"+
		"\u0000_a\u0005\u001b\u0000\u0000`b\u0003\u0014\n\u0000a`\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ce\u0005\u000f"+
		"\u0000\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fg\u0005\u0016\u0000\u0000g\u0013\u0001\u0000\u0000"+
		"\u0000hi\u0005\u0013\u0000\u0000ij\u0005\u001b\u0000\u0000jk\u0005\u0014"+
		"\u0000\u0000k\u0015\u0001\u0000\u0000\u0000lm\u0005\r\u0000\u0000mn\u0003"+
		"\u0018\f\u0000n\u0017\u0001\u0000\u0000\u0000op\u0005\u001b\u0000\u0000"+
		"pt\u0005\u0018\u0000\u0000qs\u0003\u001a\r\u0000rq\u0001\u0000\u0000\u0000"+
		"sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wx\u0005\u0019"+
		"\u0000\u0000x\u0019\u0001\u0000\u0000\u0000yz\u0005\u001b\u0000\u0000"+
		"z|\u0003\u001c\u000e\u0000{}\u0005\u000f\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0017\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000\u0080\u0081\u0007"+
		"\u0001\u0000\u0000\u0081\u001d\u0001\u0000\u0000\u0000\u0082\u0083\u0007"+
		"\u0002\u0000\u0000\u0083\u001f\u0001\u0000\u0000\u0000\f#%-0:DQ\\adt|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}