package cs652.j.semantics;

import org.antlr.symtab.*;

public class DefineScopesAndSymbols extends JBaseListener {
	public Scope currentScope;
    public static final Type JINT_TYPE = new JPrimitiveType("int");
    public static final Type JFLOAT_TYPE = new JPrimitiveType("float");
    public static final Type JSTRING_TYPE = new JPrimitiveType("string");
    public static final Type JVOID_TYPE = new JPrimitiveType("void");

	public DefineScopesAndSymbols(GlobalScope globals) {
		currentScope = globals;
        currentScope.define(new JPrimitiveType("int"));
        currentScope.define(new JPrimitiveType("float"));
        currentScope.define(new JPrimitiveType("string"));
        currentScope.define(new JPrimitiveType("void"));
	}

    @Override
    public void enterClassDeclaration(JParser.ClassDeclarationContext ctx)
    {
        JClass c = new JClass(ctx.Identifier().getText(), ctx);
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
        m.setType((Type)currentScope.resolve(ctx.typeType().getText()));
        currentScope.define(m);
        m.setEnclosingScope(currentScope);
        currentScope = m;
        ctx.scope = m;
    }

    @Override
    public void enterFormalParameters(JParser.FormalParametersContext ctx)
    {
        VariableSymbol v = new VariableSymbol("this");
        v.setType((Type)currentScope.getEnclosingScope());
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
        a.setType((Type)currentScope.resolve(ctx.typeType().getText()));
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
        v.setType((Type)currentScope.resolve(ctx.typeType().getText()));
        currentScope.define(v);
    }

    @Override
    public void enterFieldDeclaration(JParser.FieldDeclarationContext ctx)
    {
        FieldSymbol f = new FieldSymbol(ctx.Identifier().getText());
        f.setType((Type)currentScope.resolve(ctx.typeType().getText()));
        currentScope.define(f);
    }

    @Override
    public void enterMain(JParser.MainContext ctx)
    {
        JMethod m = new JMethod("main", ctx);
        m.setType(JVOID_TYPE);
        currentScope.define(m);
        m.setEnclosingScope(currentScope);
        currentScope = m;

        JMethod l = new JMethod("local", ctx);
        currentScope.define(l);
        l.setEnclosingScope(currentScope);
        currentScope = l;
       // ctx.scope = m;
    }

    @Override
    public void exitMain(JParser.MainContext ctx)
    {
        currentScope = currentScope.getEnclosingScope().getEnclosingScope();
    }
}
