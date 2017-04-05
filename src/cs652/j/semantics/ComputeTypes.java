package cs652.j.semantics;

import cs652.j.parser.*;
import org.antlr.symtab.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ComputeTypes extends JBaseListener {
	protected StringBuilder buf = new StringBuilder();
	public Scope currentScope;
	public static final Type JINT_TYPE = new JPrimitiveType("int");
	public static final Type JFLOAT_TYPE = new JPrimitiveType("float");
	public static final Type JSTRING_TYPE = new JPrimitiveType("string");
	public static final Type JVOID_TYPE = new JPrimitiveType("void");

	public ComputeTypes(GlobalScope globals) {
		this.currentScope = globals;
	}

	@Override
	public void enterClassDeclaration(JParser.ClassDeclarationContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void enterMethodDeclaration(JParser.MethodDeclarationContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void enterBlock(JParser.BlockContext ctx)
	{
	    currentScope = ctx.scope;
	}

    @Override
    public void enterMain(JParser.MainContext ctx)
    {
        currentScope = ctx.scope;
    }

    private Type setType(Scope scope, String name)
    {
        Symbol s = scope.resolve(name);
        if (s == null)
            return JSTRING_TYPE;
        else if (s instanceof JClass) {
            return (JClass) s;
        }
        else if (s instanceof JMethod)
            return ((JMethod) s).getType();
        else
        {
            return ((VariableSymbol)s).getType();
        }
    }

    /*@Override
    public void exitLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx)
    {
        String name = ctx.typeType().getText();
        if (name.equals("int")){
            ctx.type = JINT_TYPE;
            ctx.flag = 0;
        }
        else if (name.equals("float")){
            ctx.type = JFLOAT_TYPE;
            ctx.flag = 0;
        }
        else if (name.equals("void")){
            ctx.type = JVOID_TYPE;
            ctx.flag = 0;
        }
        else{
            ctx.type = (JClass)currentScope.resolve(ctx.typeType().Identifier().getText());
            ctx.flag = 1;
        }
    }

    @Override
    public void exitFieldDeclaration(JParser.FieldDeclarationContext ctx)
    {
        String name = ctx.typeType().getText();
    }*/

    @Override
    public void exitIndRef(JParser.IndRefContext ctx) {
        JParser.IndContext ctxInd = (JParser.IndContext)ctx.getChild(0);
        String name = ctxInd.getText();
        ctx.type = setType(currentScope, name);
        if (name.equals("printf"))
            return;
        if (ctxInd.flag == 1)
            buf.append(name + " is " + ctx.type.getName() + "\n");
    }

    @Override
    public void exitDotRef(JParser.DotRefContext ctx) {
        JParser.IndContext ctxInd = (JParser.IndContext)ctx.getChild(2).getChild(0);
        String name = ctxInd.getText();
        JClass c = (JClass) ((JParser.ExpressionContext)ctx.getChild(0)).type;
        ctx.type = setType(c, name);
        if (ctx.flag == 1)
            buf.append(ctx.getText() + " is " + ctx.type.getName() + "\n");
    }

    public void exitFuncRef(JParser.FuncRefContext ctx) {
        String name = ctx.getChild(0).getText();
        if (name.equals("printf")) {
            ctx.type = JVOID_TYPE;
            return;
        }
        Type type = ((JParser.ExpressionContext)ctx.getChild(0)).type;
        ctx.type = type;
        buf.append(ctx.getText() + " is " + type.getName() + "\n");
    }

    @Override
    public void exitLiteralRef(JParser.LiteralRefContext ctx) {
        if (ctx.literal().FloatingPointLiteral() != null)
        {
            ctx.type = JFLOAT_TYPE;
            buf.append(ctx.getText() + " is " + JFLOAT_TYPE.getName() + "\n");
        }
        else if (ctx.literal().IntegerLiteral() != null)
        {
            ctx.type = JINT_TYPE;
            buf.append(ctx.getText() + " is " + JINT_TYPE.getName() + "\n");
        }
        else
            ctx.type = JVOID_TYPE;
    }

    @Override
    public void exitCreator(JParser.CreatorContext ctx) {
        ctx.type = (JClass)currentScope.resolve(ctx.typeType().Identifier().getText());
        buf.append("new" + ctx.getText() + " is " + ctx.type.getName() + "\n");
    }

	public String getRefOutput() {
		return buf.toString();
	}
}

