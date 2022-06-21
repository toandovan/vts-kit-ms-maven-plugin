// Generated from E:/ToanDV19/VTS/vts-kit-ms-maven-plugin/src/main/java/com/atviettelsolutions/plugin/help\JDL.g4 by ANTLR 4.10.1
package com.atviettelsolutions.plugin.help.antlr;
import com.atviettelsolutions.plugin.help.antlr.JDLParser;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link JDLVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class JDLBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements JDLVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProgram(com.atviettelsolutions.plugin.help.antlr.JDLParser.ProgramContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEntity_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_declarationContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTable_name(com.atviettelsolutions.plugin.help.antlr.JDLParser.Table_nameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEntity_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_bodyContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEntity_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_fieldContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEntity_validate(com.atviettelsolutions.plugin.help.antlr.JDLParser.Entity_validateContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelationship(com.atviettelsolutions.plugin.help.antlr.JDLParser.RelationshipContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelationsip_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relationsip_listContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelation_ele(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_eleContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelation_ele_body(com.atviettelsolutions.plugin.help.antlr.JDLParser.Relation_ele_bodyContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDisplay_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Display_fieldContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDto_declaration(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_declarationContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDto_list(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_listContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDto_field(com.atviettelsolutions.plugin.help.antlr.JDLParser.Dto_fieldContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitType(com.atviettelsolutions.plugin.help.antlr.JDLParser.TypeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitRelation_type(JDLParser.Relation_typeContext ctx) { return visitChildren(ctx); }
}