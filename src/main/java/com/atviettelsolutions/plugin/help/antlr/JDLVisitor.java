// Generated from E:/ToanDV19/VTS/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import com.atviettelsolutions.plugin.help.antlr.JDLParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(com.atviettelsolutions.plugin.help.antlr.JDLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(com.atviettelsolutions.plugin.help.antlr.JDLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_validate(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_validateContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationship}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationship(com.atviettelsolutions.plugin.help.antlr.JDLParser.RelationshipContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationsip_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relationsip_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_ele(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_eleContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_ele_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#display_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Display_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#dto_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(com.atviettelsolutions.plugin.help.antlr.JDLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link com.atviettelsolutions.plugin.help.antlr.JDLParser#relation_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_type(JDLParser.Relation_typeContext ctx);
}