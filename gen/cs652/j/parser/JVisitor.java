// Generated from /home/tuo/cs652/project/vtable-grammar-hetuo/grammars/cs652/j/parser/J.g4 by ANTLR 4.6
package cs652.j.parser;

    import cs652.j.semantics.*;
    import org.antlr.symtab.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(JParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(JParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(JParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(JParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(JParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(JParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(JParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(JParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(JParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(JParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotRef(JParser.DotRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRef(JParser.FuncRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndRef(JParser.IndRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralRef(JParser.LiteralRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignRef(JParser.AssignRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CreatorRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorRef(JParser.CreatorRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#ind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInd(JParser.IndContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(JParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(JParser.MainContext ctx);
}