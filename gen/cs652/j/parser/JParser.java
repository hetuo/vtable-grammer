// Generated from /home/tuo/cs652/project/vtable-grammar-hetuo/grammars/cs652/j/parser/J.g4 by ANTLR 4.6
package cs652.j.parser;

    import cs652.j.semantics.*;
    import org.antlr.symtab.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, StringLiteral=20, IntegerLiteral=21, FloatingPointLiteral=22, 
		Identifier=23, STRING=24, WS=25, LINE_COMMENT=26, COMMENT=27;
	public static final int
		RULE_file = 0, RULE_classDeclaration = 1, RULE_typeType = 2, RULE_classBody = 3, 
		RULE_classBodyDeclaration = 4, RULE_fieldDeclaration = 5, RULE_methodDeclaration = 6, 
		RULE_formalParameters = 7, RULE_formalParameterList = 8, RULE_formalParameter = 9, 
		RULE_methodBody = 10, RULE_block = 11, RULE_blockStatement = 12, RULE_localVariableDeclarationStatement = 13, 
		RULE_localVariableDeclaration = 14, RULE_statement = 15, RULE_parExpression = 16, 
		RULE_expressionList = 17, RULE_statementExpression = 18, RULE_expression = 19, 
		RULE_ind = 20, RULE_literal = 21, RULE_creator = 22, RULE_main = 23;
	public static final String[] ruleNames = {
		"file", "classDeclaration", "typeType", "classBody", "classBodyDeclaration", 
		"fieldDeclaration", "methodDeclaration", "formalParameters", "formalParameterList", 
		"formalParameter", "methodBody", "block", "blockStatement", "localVariableDeclarationStatement", 
		"localVariableDeclaration", "statement", "parExpression", "expressionList", 
		"statementExpression", "expression", "ind", "literal", "creator", "main"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'extends'", "'int'", "'fload'", "'void'", "'{'", "'}'", 
		"';'", "'('", "')'", "','", "'if'", "'else'", "'while'", "'return'", "'.'", 
		"'new'", "'='", "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "StringLiteral", "IntegerLiteral", 
		"FloatingPointLiteral", "Identifier", "STRING", "WS", "LINE_COMMENT", 
		"COMMENT"
	};
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
	public String getGrammarFileName() { return "J.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public GlobalScope scope;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(48);
				classDeclaration();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			main();
			setState(55);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__0);
			setState(58);
			match(Identifier);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(59);
				match(T__1);
				setState(60);
				typeType();
				}
			}

			setState(63);
			classBody();
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

	public static class TypeTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << Identifier))) != 0)) ) {
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__5);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << Identifier))) != 0)) {
				{
				{
				setState(68);
				classBodyDeclaration();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__6);
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

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBodyDeclaration);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				methodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				fieldDeclaration();
				}
				break;
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public Type type;
		public int flag;
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			typeType();
			setState(82);
			match(Identifier);
			setState(83);
			match(T__7);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public Scope scope;
		public Type tyep;
		public int flag;
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			typeType();
			setState(86);
			match(Identifier);
			setState(87);
			formalParameters();
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(88);
				methodBody();
				}
				break;
			case T__7:
				{
				setState(89);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__8);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << Identifier))) != 0)) {
				{
				setState(93);
				formalParameterList();
				}
			}

			setState(96);
			match(T__9);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			formalParameter();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(99);
				match(T__10);
				setState(100);
				formalParameter();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public Type type;
		public int flag;
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			typeType();
			setState(107);
			match(Identifier);
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public Scope scope;
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__5);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__18) | (1L << StringLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << Identifier))) != 0)) {
				{
				{
				setState(112);
				blockStatement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__6);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockStatement);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				statement();
				}
				break;
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

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			localVariableDeclaration();
			setState(125);
			match(T__7);
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

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public Type type;
		public int flag;
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			typeType();
			setState(128);
			match(Identifier);
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

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				block();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__11);
				setState(132);
				parExpression();
				setState(133);
				statement();
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(134);
					match(T__12);
					setState(135);
					statement();
					}
					break;
				}
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				match(T__13);
				setState(139);
				parExpression();
				setState(140);
				statement();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				match(T__14);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__18) | (1L << StringLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << Identifier))) != 0)) {
					{
					setState(143);
					expression(0);
					}
				}

				setState(146);
				match(T__7);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				match(T__7);
				}
				break;
			case T__16:
			case T__18:
			case StringLiteral:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				statementExpression();
				setState(149);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__8);
			setState(154);
			expression(0);
			setState(155);
			match(T__9);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionList);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__18:
			case StringLiteral:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				expression(0);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(158);
					match(T__10);
					setState(159);
					expression(0);
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Type type;
		public int flag;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.type = ctx.type;
			this.flag = ctx.flag;
		}
	}
	public static class DotRefContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DotRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterDotRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitDotRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitDotRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncRefContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FuncRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterFuncRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitFuncRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitFuncRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndRefContext extends ExpressionContext {
		public IndContext ind() {
			return getRuleContext(IndContext.class,0);
		}
		public IndRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterIndRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitIndRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitIndRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralRefContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterLiteralRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitLiteralRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitLiteralRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignRefContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterAssignRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitAssignRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitAssignRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatorRefContext extends ExpressionContext {
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public CreatorRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterCreatorRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitCreatorRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitCreatorRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				_localctx = new IndRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(171);
				ind();
				}
				break;
			case T__16:
				{
				_localctx = new CreatorRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(T__16);
				setState(173);
				creator();
				}
				break;
			case T__18:
			case StringLiteral:
			case IntegerLiteral:
			case FloatingPointLiteral:
				{
				_localctx = new LiteralRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new DotRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(178);
						match(T__15);
						setState(179);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new AssignRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(181);
						match(T__17);
						}
						setState(182);
						expression(2);
						}
						break;
					case 3:
						{
						_localctx = new FuncRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						match(T__8);
						setState(185);
						expressionList();
						setState(186);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IndContext extends ParserRuleContext {
		public int flag;
		public TerminalNode Identifier() { return getToken(JParser.Identifier, 0); }
		public IndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterInd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitInd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitInd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndContext ind() throws RecognitionException {
		IndContext _localctx = new IndContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(Identifier);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(JParser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(JParser.FloatingPointLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(JParser.StringLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << StringLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral))) != 0)) ) {
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

	public static class CreatorContext extends ParserRuleContext {
		public Type type;
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_creator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			typeType();
			setState(198);
			match(T__8);
			setState(199);
			match(T__9);
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

	public static class MainContext extends ParserRuleContext {
		public Scope scope;
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JListener ) ((JListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JVisitor ) return ((JVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__16) | (1L << T__18) | (1L << StringLiteral) | (1L << IntegerLiteral) | (1L << FloatingPointLiteral) | (1L << Identifier))) != 0)) {
				{
				{
				setState(201);
				blockStatement();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00d2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3@\n\3"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\6\3\6\3\6\5"+
		"\6R\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\5\ta\n\t"+
		"\3\t\3\t\3\n\3\n\3\n\7\nh\n\n\f\n\16\nk\13\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\7\rt\n\r\f\r\16\rw\13\r\3\r\3\r\3\16\3\16\5\16}\n\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u008b\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0093\n\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u009a\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00a3\n\23\f\23\16"+
		"\23\u00a6\13\23\3\23\5\23\u00a9\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00b2\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u00bf\n\25\f\25\16\25\u00c2\13\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\31\7\31\u00cd\n\31\f\31\16\31\u00d0\13\31\3\31\2\3(\32\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\4\4\2\5\7\31\31\3"+
		"\2\25\30\u00d2\2\65\3\2\2\2\4;\3\2\2\2\6C\3\2\2\2\bE\3\2\2\2\nQ\3\2\2"+
		"\2\fS\3\2\2\2\16W\3\2\2\2\20^\3\2\2\2\22d\3\2\2\2\24l\3\2\2\2\26o\3\2"+
		"\2\2\30q\3\2\2\2\32|\3\2\2\2\34~\3\2\2\2\36\u0081\3\2\2\2 \u0099\3\2\2"+
		"\2\"\u009b\3\2\2\2$\u00a8\3\2\2\2&\u00aa\3\2\2\2(\u00b1\3\2\2\2*\u00c3"+
		"\3\2\2\2,\u00c5\3\2\2\2.\u00c7\3\2\2\2\60\u00ce\3\2\2\2\62\64\5\4\3\2"+
		"\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67"+
		"\65\3\2\2\289\5\60\31\29:\7\2\2\3:\3\3\2\2\2;<\7\3\2\2<?\7\31\2\2=>\7"+
		"\4\2\2>@\5\6\4\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\b\5\2B\5\3\2\2\2CD"+
		"\t\2\2\2D\7\3\2\2\2EI\7\b\2\2FH\5\n\6\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\t\2\2M\t\3\2\2\2NR\7\n\2\2OR\5\16\b"+
		"\2PR\5\f\7\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\13\3\2\2\2ST\5\6\4\2TU\7\31"+
		"\2\2UV\7\n\2\2V\r\3\2\2\2WX\5\6\4\2XY\7\31\2\2Y\\\5\20\t\2Z]\5\26\f\2"+
		"[]\7\n\2\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2\2^`\7\13\2\2_a\5\22\n\2`_\3"+
		"\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\f\2\2c\21\3\2\2\2di\5\24\13\2ef\7\r\2\2"+
		"fh\5\24\13\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\23\3\2\2\2ki\3\2"+
		"\2\2lm\5\6\4\2mn\7\31\2\2n\25\3\2\2\2op\5\30\r\2p\27\3\2\2\2qu\7\b\2\2"+
		"rt\5\32\16\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2"+
		"\2xy\7\t\2\2y\31\3\2\2\2z}\5\34\17\2{}\5 \21\2|z\3\2\2\2|{\3\2\2\2}\33"+
		"\3\2\2\2~\177\5\36\20\2\177\u0080\7\n\2\2\u0080\35\3\2\2\2\u0081\u0082"+
		"\5\6\4\2\u0082\u0083\7\31\2\2\u0083\37\3\2\2\2\u0084\u009a\5\30\r\2\u0085"+
		"\u0086\7\16\2\2\u0086\u0087\5\"\22\2\u0087\u008a\5 \21\2\u0088\u0089\7"+
		"\17\2\2\u0089\u008b\5 \21\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u009a\3\2\2\2\u008c\u008d\7\20\2\2\u008d\u008e\5\"\22\2\u008e\u008f\5"+
		" \21\2\u008f\u009a\3\2\2\2\u0090\u0092\7\21\2\2\u0091\u0093\5(\25\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u009a\7\n"+
		"\2\2\u0095\u009a\7\n\2\2\u0096\u0097\5&\24\2\u0097\u0098\7\n\2\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0084\3\2\2\2\u0099\u0085\3\2\2\2\u0099\u008c\3\2"+
		"\2\2\u0099\u0090\3\2\2\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u009a"+
		"!\3\2\2\2\u009b\u009c\7\13\2\2\u009c\u009d\5(\25\2\u009d\u009e\7\f\2\2"+
		"\u009e#\3\2\2\2\u009f\u00a4\5(\25\2\u00a0\u00a1\7\r\2\2\u00a1\u00a3\5"+
		"(\25\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a9\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\3\2"+
		"\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9%\3\2\2\2\u00aa\u00ab"+
		"\5(\25\2\u00ab\'\3\2\2\2\u00ac\u00ad\b\25\1\2\u00ad\u00b2\5*\26\2\u00ae"+
		"\u00af\7\23\2\2\u00af\u00b2\5.\30\2\u00b0\u00b2\5,\27\2\u00b1\u00ac\3"+
		"\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00c0\3\2\2\2\u00b3"+
		"\u00b4\f\7\2\2\u00b4\u00b5\7\22\2\2\u00b5\u00bf\5(\25\b\u00b6\u00b7\f"+
		"\4\2\2\u00b7\u00b8\7\24\2\2\u00b8\u00bf\5(\25\4\u00b9\u00ba\f\5\2\2\u00ba"+
		"\u00bb\7\13\2\2\u00bb\u00bc\5$\23\2\u00bc\u00bd\7\f\2\2\u00bd\u00bf\3"+
		"\2\2\2\u00be\u00b3\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1)\3\2\2\2"+
		"\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7\31\2\2\u00c4+\3\2\2\2\u00c5\u00c6\t"+
		"\3\2\2\u00c6-\3\2\2\2\u00c7\u00c8\5\6\4\2\u00c8\u00c9\7\13\2\2\u00c9\u00ca"+
		"\7\f\2\2\u00ca/\3\2\2\2\u00cb\u00cd\5\32\16\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\61\3\2\2"+
		"\2\u00d0\u00ce\3\2\2\2\24\65?IQ\\`iu|\u008a\u0092\u0099\u00a4\u00a8\u00b1"+
		"\u00be\u00c0\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}