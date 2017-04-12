// Generated from /home/tuo/cs652/project/vtable-grammar-hetuo/grammars/cs652/j/parser/J.g4 by ANTLR 4.6
package cs652.j.parser;

    import cs652.j.semantics.*;
    import org.antlr.symtab.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JParser}.
 */
public interface JListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(JParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(JParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(JParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(JParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(JParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(JParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(JParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(JParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(JParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(JParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(JParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(JParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(JParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(JParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(JParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(JParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(JParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(JParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(JParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(JParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDotRef(JParser.DotRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDotRef(JParser.DotRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncRef(JParser.FuncRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncRef(JParser.FuncRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndRef(JParser.IndRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndRef(JParser.IndRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralRef(JParser.LiteralRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralRef(JParser.LiteralRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignRef(JParser.AssignRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignRef(JParser.AssignRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CreatorRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCreatorRef(JParser.CreatorRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CreatorRef}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCreatorRef(JParser.CreatorRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#ind}.
	 * @param ctx the parse tree
	 */
	void enterInd(JParser.IndContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#ind}.
	 * @param ctx the parse tree
	 */
	void exitInd(JParser.IndContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(JParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(JParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(JParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(JParser.MainContext ctx);
}