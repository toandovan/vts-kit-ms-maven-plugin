// Generated from E:/ToanDV19/VTS/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JDLParser}.
 */
public interface JDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JDLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JDLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JDLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void enterEntity_declaration(JDLParser.Entity_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void exitEntity_declaration(JDLParser.Entity_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(JDLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(JDLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#entity_body}.
	 * @param ctx the parse tree
	 */
	void enterEntity_body(JDLParser.Entity_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#entity_body}.
	 * @param ctx the parse tree
	 */
	void exitEntity_body(JDLParser.Entity_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#entity_field}.
	 * @param ctx the parse tree
	 */
	void enterEntity_field(JDLParser.Entity_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#entity_field}.
	 * @param ctx the parse tree
	 */
	void exitEntity_field(JDLParser.Entity_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 */
	void enterEntity_validate(JDLParser.Entity_validateContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 */
	void exitEntity_validate(JDLParser.Entity_validateContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#relationship}.
	 * @param ctx the parse tree
	 */
	void enterRelationship(JDLParser.RelationshipContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#relationship}.
	 * @param ctx the parse tree
	 */
	void exitRelationship(JDLParser.RelationshipContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 */
	void enterRelationsip_list(JDLParser.Relationsip_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 */
	void exitRelationsip_list(JDLParser.Relationsip_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 */
	void enterRelation_ele(JDLParser.Relation_eleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 */
	void exitRelation_ele(JDLParser.Relation_eleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 */
	void enterRelation_ele_body(JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 */
	void exitRelation_ele_body(JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#display_field}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_field(JDLParser.Display_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#display_field}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_field(JDLParser.Display_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDto_declaration(JDLParser.Dto_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDto_declaration(JDLParser.Dto_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#dto_list}.
	 * @param ctx the parse tree
	 */
	void enterDto_list(JDLParser.Dto_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#dto_list}.
	 * @param ctx the parse tree
	 */
	void exitDto_list(JDLParser.Dto_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#dto_field}.
	 * @param ctx the parse tree
	 */
	void enterDto_field(JDLParser.Dto_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#dto_field}.
	 * @param ctx the parse tree
	 */
	void exitDto_field(JDLParser.Dto_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JDLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JDLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JDLParser#relation_type}.
	 * @param ctx the parse tree
	 */
	void enterRelation_type(JDLParser.Relation_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JDLParser#relation_type}.
	 * @param ctx the parse tree
	 */
	void exitRelation_type(JDLParser.Relation_typeContext ctx);
}