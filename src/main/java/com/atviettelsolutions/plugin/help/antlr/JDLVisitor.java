// Generated from D:/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JDLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JDLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#entity_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_declaration(JDLParser.Entity_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(JDLParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#entity_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_body(JDLParser.Entity_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#entity_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_field(JDLParser.Entity_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#entity_validate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_validate(JDLParser.Entity_validateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#relationship}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationship(JDLParser.RelationshipContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#relationsip_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationsip_list(JDLParser.Relationsip_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#relation_ele}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_ele(JDLParser.Relation_eleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#relation_ele_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_ele_body(JDLParser.Relation_ele_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#display_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay_field(JDLParser.Display_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#dto_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_declaration(JDLParser.Dto_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#dto_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_list(JDLParser.Dto_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#dto_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto_field(JDLParser.Dto_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#entity_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_type(JDLParser.Entity_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JDLParser#relation_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation_type(JDLParser.Relation_typeContext ctx);
}