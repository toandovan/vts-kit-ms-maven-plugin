// Generated from E:/ToanDV19/VTS/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import com.atviettelsolutions.plugin.help.antlr.JDLParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link com.atviettelsolutions.plugin.help.antlr.JDLParser}.
 */
public interface JDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(com.atviettelsolutions.plugin.help.antlr.JDLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(com.atviettelsolutions.plugin.help.antlr.JDLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void enterEntity_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 */
	void exitEntity_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(com.atviettelsolutions.plugin.help.antlr.JDLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(com.atviettelsolutions.plugin.help.antlr.JDLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_body}.
	 * @param ctx the parse tree
	 */
	void enterEntity_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_body}.
	 * @param ctx the parse tree
	 */
	void exitEntity_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_field}.
	 * @param ctx the parse tree
	 */
	void enterEntity_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_field}.
	 * @param ctx the parse tree
	 */
	void exitEntity_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 */
	void enterEntity_validate(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_validateContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 */
	void exitEntity_validate(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_validateContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationship}.
	 * @param ctx the parse tree
	 */
	void enterRelationship(com.atviettelsolutions.plugin.help.antlr.JDLParser.RelationshipContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationship}.
	 * @param ctx the parse tree
	 */
	void exitRelationship(com.atviettelsolutions.plugin.help.antlr.JDLParser.RelationshipContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 */
	void enterRelationsip_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relationsip_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 */
	void exitRelationsip_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relationsip_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 */
	void enterRelation_ele(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_eleContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 */
	void exitRelation_ele(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_eleContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 */
	void enterRelation_ele_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 */
	void exitRelation_ele_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#display_field}.
	 * @param ctx the parse tree
	 */
	void enterDisplay_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Display_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#display_field}.
	 * @param ctx the parse tree
	 */
	void exitDisplay_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Display_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDto_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDto_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_list}.
	 * @param ctx the parse tree
	 */
	void enterDto_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_list}.
	 * @param ctx the parse tree
	 */
	void exitDto_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_field}.
	 * @param ctx the parse tree
	 */
	void enterDto_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_field}.
	 * @param ctx the parse tree
	 */
	void exitDto_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(com.atviettelsolutions.plugin.help.antlr.JDLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(com.atviettelsolutions.plugin.help.antlr.JDLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_type}.
	 * @param ctx the parse tree
	 */
	void enterRelation_type(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_type}.
	 * @param ctx the parse tree
	 */
	void exitRelation_type(JDLParser.Relation_typeContext ctx);
}