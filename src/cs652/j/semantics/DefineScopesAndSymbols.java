package cs652.j.semantics;

import cs652.j.parser.*;
import org.antlr.symtab.*;

public class DefineScopesAndSymbols extends JBaseListener {
	public Scope currentScope;
    public static final JPrimitiveType JINT_TYPE = new JPrimitiveType("int");
    public static final JPrimitiveType JFLOAT_TYPE = new JPrimitiveType("float");
    public static final JPrimitiveType JSTRING_TYPE = new JPrimitiveType("string");
    public static final JPrimitiveType JVOID_TYPE = new JPrimitiveType("void");

	public DefineScopesAndSymbols(GlobalScope globals) {
		currentScope = globals;
        currentScope.define(JINT_TYPE);
        currentScope.define(JFLOAT_TYPE);
        currentScope.define(JSTRING_TYPE);
        currentScope.define(JVOID_TYPE);
	}

    @Override
    public void enterClassDeclaration(JParser.ClassDeclarationContext ctx)
    {
        JClass c = new JClass(ctx.Identifier().getText(), ctx);
        if (ctx.getChildCount() == 5){
            String superClass = ctx.typeType().Identifier().getText();
            c.setSuperClass(superClass);
        }

        currentScope.define(c);
        c.setEnclosingScope(currentScope);
        currentScope = c;
        ctx.scope = c;
    }

    @Override
    public void exitClassDeclaration(JParser.ClassDeclarationContext ctx)
    {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterMethodDeclaration(JParser.MethodDeclarationContext ctx)
    {
        JMethod m = new JMethod(ctx.Identifier().getText(), ctx);
        Type type = (Type)currentScope.resolve(ctx.typeType().getText());
        String typeName = type.getName();
        if (typeName.equals("int") || typeName.equals("float") || typeName.equals("void"))
            ctx.flag = 0;
        else
            ctx.flag = 1;
        m.setType(type);
        currentScope.define(m);
        m.setEnclosingScope(currentScope);
        currentScope = m;
        ctx.scope = m;
        ctx.tyep = type;
    }

    @Override
    public void enterFormalParameters(JParser.FormalParametersContext ctx)
    {
        VariableSymbol v = new VariableSymbol("this");
        Type type = (Type)currentScope.getEnclosingScope();
        v.setType(type);
        currentScope.define(v);
    }

    @Override
    public void exitMethodDeclaration(JParser.MethodDeclarationContext ctx)
    {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterFormalParameter(JParser.FormalParameterContext ctx)
    {
        JArg a = new JArg(ctx.Identifier().getText(), ctx);
        Type type = (Type)currentScope.resolve(ctx.typeType().getText());
        String typeName = type.getName();
        if (typeName.equals("int") || typeName.equals("float") || typeName.equals("void"))
            ctx.flag = 0;
        else
            ctx.flag = 1;
        a.setType(type);
        ctx.type = type;
        currentScope.define(a);
    }

    @Override
    public void enterBlock(JParser.BlockContext ctx)
    {
        JMethod l = new JMethod("local", ctx);
        currentScope.define(l);
        l.setEnclosingScope(currentScope);
        currentScope = l;
        ctx.scope = l;
    }

    @Override
    public void exitBlock(JParser.BlockContext ctx)
    {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx)
    {
        JVar v = new JVar(ctx.Identifier().getText(), ctx);
        Type type = (Type)currentScope.resolve(ctx.typeType().getText());
        String typeName = type.getName();
        if (typeName.equals("int") || typeName.equals("float") || typeName.equals("void"))
            ctx.flag = 0;
        else
            ctx.flag = 1;
        v.setType(type);
        currentScope.define(v);
        ctx.type = type;
    }

    @Override
    public void enterFieldDeclaration(JParser.FieldDeclarationContext ctx)
    {
        FieldSymbol f = new FieldSymbol(ctx.Identifier().getText());
        Type type = (Type)currentScope.resolve(ctx.typeType().getText());
        String typeName = type.getName();
        if (typeName.equals("int") || typeName.equals("float") || typeName.equals("void"))
            ctx.flag = 0;
        else
            ctx.flag = 1;
        f.setType(type);
        currentScope.define(f);
        ctx.type = type;
    }

    @Override
    public void enterMain(JParser.MainContext ctx)
    {
        JMethod m = new JMethod("main", ctx);
        m.setType(JVOID_TYPE);
        currentScope.define(m);
        m.setEnclosingScope(currentScope);
        currentScope = m;
        ctx.scope = m;
        JMethod l = new JMethod("local", ctx);
        currentScope.define(l);
        l.setEnclosingScope(currentScope);
        currentScope = l;
        ctx.scope = l;
       // ctx.scope = m;
    }

    @Override
    public void enterCreator(JParser.CreatorContext ctx)
    {
        Type type = (Type)currentScope.resolve(ctx.typeType().getText());
        ctx.type = type;
    }

    @Override
    public void exitMain(JParser.MainContext ctx)
    {
        currentScope = currentScope.getEnclosingScope().getEnclosingScope();
    }

    @Override
    public void enterInd(JParser.IndContext ctx) {
        ctx.flag = 1;
    }

    @Override
    public void exitDotRef(JParser.DotRefContext ctx) {
        ((JParser.IndContext)((JParser.IndRefContext)ctx.getChild(2)).getChild(0)).flag = 0;
    }

    @Override
    public void enterDotRef(JParser.DotRefContext ctx) {
        ctx.flag = 1;
    }

    @Override
    public void exitFuncRef(JParser.FuncRefContext ctx) {
        if (ctx.getChild(0) instanceof  JParser.DotRefContext)
        {
            ((JParser.DotRefContext)ctx.getChild(0)).flag = 0;
        }
        if (ctx.getChild(0) instanceof JParser.IndRefContext)
        {
            ((JParser.IndContext)((JParser.IndRefContext)ctx.getChild(0)).getChild(0)).flag = 0;
        }
    }
}
