package cs652.j.codegen;

//import cs652.j.codegen.model.AssignStat;
//import cs652.j.codegen.model.Block;
import cs652.j.codegen.model.*;
/*import cs652.j.codegen.model.CallStat;
import cs652.j.codegen.model.ClassDef;
import cs652.j.codegen.model.CtorCall;
import cs652.j.codegen.model.Expr;
import cs652.j.codegen.model.FieldRef;
import cs652.j.codegen.model.FuncName;
import cs652.j.codegen.model.IfElseStat;
import cs652.j.codegen.model.IfStat;
import cs652.j.codegen.model.LiteralRef;
import cs652.j.codegen.model.MainMethod;
import cs652.j.codegen.model.MethodCall;
import cs652.j.codegen.model.MethodDef;
import cs652.j.codegen.model.NullRef;
import cs652.j.codegen.model.ObjectTypeSpec;*/
/*import cs652.j.codegen.model.PrimitiveTypeSpec;
import cs652.j.codegen.model.PrintStat;
import cs652.j.codegen.model.PrintStringStat;
import cs652.j.codegen.model.ReturnStat;
import cs652.j.codegen.model.Stat;
import cs652.j.codegen.model.ThisRef;
import cs652.j.codegen.model.TypeCast;
import cs652.j.codegen.model.TypeSpec;
import cs652.j.codegen.model.VarDef;
import cs652.j.codegen.model.VarRef;
import cs652.j.codegen.model.WhileStat;
import cs652.j.codegen.model.OutputModelObject;*/
import cs652.j.codegen.model.PrimitiveType;
import cs652.j.codegen.model.Type;
import cs652.j.parser.JBaseVisitor;
//import cs652.j.parser.JParser;
import cs652.j.parser.JParser;
import cs652.j.semantics.JClass;
//import cs652.j.semantics.JField;
//import cs652.j.semantics.JMethod;
import cs652.j.semantics.JMethod;
import org.antlr.symtab.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator extends JBaseVisitor<OutputModelObject> {
	public STGroup templates;
	public String fileName;

	public Scope currentScope;
	public ClassDef currentClass = null;

	public CodeGenerator(String fileName) {
		this.fileName = fileName;
		templates = new STGroupFile("cs652/j/templates/C.stg");
	}

	public CFile generate(ParserRuleContext tree) {
		CFile file = (CFile)visit(tree);
		return file;
	}

	@Override
	public CFile visitFile(JParser.FileContext ctx)
    {
        CFile file = new CFile(fileName);
        file.main = (MainMethod) visit(ctx.main());
// whoa. what is all this nested looping. this is completely bizarre
// are you trying to look things up superclass chain? Symbol table already does that. Destroy this method and start again
        for (JParser.ClassDeclarationContext c : ctx.classDeclaration())
        {
            ClassDef cd = new ClassDef(c.Identifier().getText());
            currentScope = c.scope;
            if (c.getChildCount() == 5)
            {
                String superClassName = ((JParser.TypeTypeContext)c.getChild(3)).Identifier().getText();
                for (OutputModelObject s : file.classes)
                {
                    if (((ClassDef)s).name.equals(superClassName))
                    {
                        for (OutputModelObject f : ((ClassDef)s).sFields)
                        {
                            cd.addSFields((FieldDef)f);
                        }
                        for (OutputModelObject m : ((ClassDef)s).sMethods)
                        {
                            cd.addSMethods((MethodDef)m);
                        }
                        /*for (OutputModelObject v : ((ClassDef)s).sVtable)
                        {
                            cd.addSVtable((VtableDef)v);
                        }*/
                        for (OutputModelObject f : ((ClassDef)s).fields)
                        {
                            cd.addSFields((FieldDef)f);
                        }
                        for (OutputModelObject m : ((ClassDef)s).methods)
                        {
                            cd.addSMethods((MethodDef)m);
                        }
                        for (OutputModelObject v : ((ClassDef)s).vtable)
                        {
                            cd.addVtable(new VtableDef(((VtableDef)v).className, ((VtableDef)v).methodName));
                        }
                    }
                }
            }
            for (JParser.ClassBodyDeclarationContext b : c.classBody().classBodyDeclaration())
            {
                if (b.getChild(0) instanceof JParser.FieldDeclarationContext)
                {
                    cd.addFields(visit(b.getChild(0)));
                }
                else if (b.getChild(0) instanceof JParser.MethodDeclarationContext)
                {
                    currentClass = cd;
                    int size = cd.methods.size();
                    MethodDef omo = (MethodDef) visit(b.getChild(0));
                    omo.slot = size + cd.sMethods.size();
                    VtableDef v = new VtableDef(cd.name, omo.name);
                    int i = 0;
                    for (; i < cd.vtable.size(); i++)
                    {
                        if (((VtableDef)cd.vtable.get(i)).methodName.equals(omo.name))
                        {
                            //cd.vtable.remove(i);
                            //i--;
                            ((VtableDef)cd.vtable.get(i)).className = cd.name;
                            break;
                        }
                    }
                    if (i == cd.vtable.size())
                        cd.addVtable(v);
                    cd.addMethods(omo);
                }
            }
            for (int i = 0; i < cd.methods.size();i++)
            {
                cd.addMethodsForSlot(cd.methods.get(i));
            }
            for (int i =0; i < cd.sMethods.size(); i++)
            {
                for (int j =0; j < cd.methods.size(); j++)
                {
                    //System.out.println(i+"sMethods"+((MethodDef)cd.sMethods.get(i)).name);
                    //System.out.println(j+"methods"+((MethodDef)cd.methods.get(j)).name);
                    MethodDef sm = ((MethodDef)cd.sMethods.get(i));
                    MethodDef m = ((MethodDef)cd.methods.get(j));

                    /*if (sm.name.equals(m.name))
                    {
                        System.out.println("HAHHAHAHHAHHAHAH");
                        cd.methods.remove(j);
                        j--;
                        break;
                    }*/
                    if (((MethodDef)cd.sMethods.get(i)).name.equals(((MethodDef)cd.methods.get(j)).name))
                    {
                        //cd.sMethods.remove(sm);
                        //cd.sMethods.remove(i);
                        cd.sMethods.set(i, (MethodDef)cd.methods.get(j));
                        //i--;
                        //((MethodDef)cd.methods.get(j)).slot--;
                        cd.methods.remove(j);
                        j--;
                        break;
                    }
                }
            }
            int i = 0;
            for (; i < cd.sMethods.size(); i++)
            {
                ((MethodDef)cd.sMethods.get(i)).slot = i;
            }
            for (int j = 0; j < cd.methods.size(); j++)
            {
                ((MethodDef)cd.methods.get(j)).slot = i + j;
            }
            //for ()
            file.addClasses(cd);
            currentClass = null;
        }
        return file;
    }

    @Override
    public OutputModelObject visitMethodDeclaration(JParser.MethodDeclarationContext ctx)
    {
        currentScope = ctx.scope;
        String name = ctx.Identifier().getText();
        String scope = ctx.scope.getEnclosingScope().getName();
        MethodDef m = new MethodDef(name, scope);
// what is "flag"? Use a real name. Then get rid of it. you can't possibly be using it for anything proper
        if (ctx.flag == 0)
        {
            m.returnType = new PrimitiveType(ctx.tyep.getName()); // somehow you have renamed type to tyep
        }
        else
            m.returnType = new ObjectType(ctx.tyep.getName());

        ParameterDef pd = new ParameterDef("this");
        pd.type = new ObjectType(scope);
        m.args.add(pd);
        if (ctx.formalParameters().formalParameterList() != null)
        {
            for (JParser.FormalParameterContext p : ctx.formalParameters().formalParameterList().formalParameter())
            {
                m.args.add(visit(p));
            }
        }
        if (ctx.methodBody() != null)
        {
            Block b = (Block)visit(ctx.methodBody().block());
            m.block = b;
        }
        return m;
    }

    @Override
    public OutputModelObject visitBlock(JParser.BlockContext ctx)
    {
        Block b = new Block();
        currentScope = ctx.scope;
// you should have one single loop around the list of statements and I see a nested loop. that is incorrect
        for (JParser.BlockStatementContext state : ctx.blockStatement())
        {
            if (state.getChild(0) instanceof JParser.LocalVariableDeclarationStatementContext)
            {
                OutputModelObject omo = visit(state.getChild(0));
                b.addLocals(omo);
            }
// why are you re-parsing and trying to figure out if this is a statement?
            if (state.getChild(0) instanceof JParser.StatementContext)
            {
                //System.out.println("HHHH" + state.getChild(0).getText());
                if (state.getChild(0).getChild(0).getText().equals("return"))
                {
                    ReturnStat r = new ReturnStat();
                    r.omo = visit(state.getChild(0).getChild(1));
                    if (state.getChild(0).getChild(1) instanceof JParser.IndRefContext)
                    {
                        String name = ((IndExpr)r.omo).name;
                        if (currentClass != null) {
                            for (OutputModelObject fd : currentClass.fields) {
                                if (((FieldDef) fd).fieldName.equals(name)) {
                                    DotExpr d = new DotExpr();
                                    d.nodes.add(new PrimitiveType("this"));
                                    d.nodes.add(r.omo);
                                    r.omo = d;
                                    //flag = 1;
                                    break;
                                }
                            }
                        }
                    }
                    b.addInstrs(r);
                }
// never test for a string when you can use a test of types
                else if (state.getChild(0).getChild(0).getText().equals("if"))
                {
                    System.out.println("HHHHHHHHHHHH"); // Get rid of these debugging calls
                    if (state.getChild(0).getChildCount() == 3)
                    {
                        System.out.println("TYTTTTTTTTT");
                        IfStat i = new IfStat();
// use constructor arguments instead of setting fields
                        i.condition = visit(state.getChild(0).getChild(1).getChild(1));
                        i.stat = visit(state.getChild(0).getChild(2));
                        b.addInstrs(i);
                    }
                }
                else {
                    OutputModelObject omo = visit(state.getChild(0));
                    b.addInstrs(omo);
                }
            }
        }
        return b;
    }

    @Override
    public OutputModelObject visitFormalParameter(JParser.FormalParameterContext ctx)
    {
        String name = ctx.Identifier().getText();
        ParameterDef p = new ParameterDef(name);
        if (ctx.flag == 0)
        {
            p.type = new PrimitiveType(ctx.type.getName());
        }
        else
            p.type = new ObjectType(ctx.type.getName());
        return p;
    }

    @Override
    public MainMethod visitMain(JParser.MainContext ctx)
    {
        MainMethod main = new MainMethod();
        currentScope = ctx.scope;
        for (JParser.BlockStatementContext state : ctx.blockStatement())
        {
            if (state.getChild(0) instanceof JParser.LocalVariableDeclarationStatementContext)
            {
                OutputModelObject omo = visit(state.getChild(0));
                main.addLocals(omo);
            }
            if (state.getChild(0) instanceof JParser.StatementContext)
            {
// you should not be parsing again here. I don't understand why you simply don't ask the visitor to give you the code necessary for each statement
                if (state.getChild(0).getChild(0).getText().equals("if"))
                {
                    if (state.getChild(0).getChildCount() == 3)
                    {
                        IfStat i = new IfStat();
                        i.condition = visit(state.getChild(0).getChild(1).getChild(1));
                        i.stat = visit(state.getChild(0).getChild(2));
                        main.addInstrs(i);
                    }
                    else if (state.getChild(0).getChildCount() == 5)
                    {
                        IfElseStat i = new IfElseStat();
                        i.condition = visit(state.getChild(0).getChild(1).getChild(1));
                        i.stat = visit(state.getChild(0).getChild(2));
                        i.elseStat = visit(state.getChild(0).getChild(4));
                        main.addInstrs(i);
                    }
                }
                else if (state.getChild(0).getChild(0).getText().equals("while"))
                {
                    WhileStat w = new WhileStat();
                    w.condition = visit(state.getChild(0).getChild(1).getChild(1));
                    w.stat = visit(state.getChild(0).getChild(2).getChild(0));
                    main.whileStat = w;
                }
                else
                {
                    OutputModelObject omo = visit(state.getChild(0));
                    main.addInstrs(omo);
                }
            }
        }
        return main;
    }

    @Override
    public OutputModelObject visitFieldDeclaration(JParser.FieldDeclarationContext ctx)
    {
        String name = ctx.Identifier().getText();
        FieldDef f = new FieldDef(name);
        if (ctx.flag == 0)
        {
            f.type = new PrimitiveType(ctx.type.getName());
        }
        else
            f.type = new ObjectType(ctx.type.getName());
        return f;
    }

    @Override
    public VarDef visitLocalVariableDeclarationStatement(JParser.LocalVariableDeclarationStatementContext ctx)
    {
        String name = ctx.localVariableDeclaration().Identifier().getText();
        VarDef var = new VarDef(name);
        if (ctx.localVariableDeclaration().flag == 0)
        {
            var.type = new PrimitiveType(ctx.localVariableDeclaration().type.getName());
        }
        else
            var.type = new ObjectType(ctx.localVariableDeclaration().type.getName());
        return var;
    }

    @Override
    public OutputModelObject visitStatement(JParser.StatementContext ctx)
    {
        if (ctx.getChild(0) instanceof JParser.StatementExpressionContext)
        {
            return visit(ctx.getChild(0));
        }

        return null;
    }

    @Override
    public OutputModelObject visitAssignRef(JParser.AssignRefContext ctx)
    {
        AssignExpr assign = new AssignExpr();
        assign.left = visit(ctx.getChild(0));
        if (ctx.getChild(0) instanceof JParser.IndRefContext)
        {
            Scope scope = currentScope;
// why do you need to know if the scope is the main?
            while (!scope.getName().equals("main") && !(scope instanceof JClass))
            {
                scope = scope.getEnclosingScope();
            }

            if (!scope.getName().equals("main")){
// why are you looping across fields?
            for (FieldSymbol f : ((JClass)scope).getDefinedFields())
            {
                if (f.getName().equals(((IndExpr)assign.left).name))
                {
// you cannot use C strings in the model
                    ((IndExpr)assign.left).name = "this->" + ((IndExpr)assign.left).name;
                    break;
                }
            }}
        }
        assign.right = visit(ctx.getChild(2));
        if (ctx.expression(0).type instanceof JClass && ctx.getChild(2) instanceof JParser.IndRefContext)
        {
            //System.out.println("HAHHAHAHHAHAH" + ctx.expression(0).type.getName());
            ((IndExpr)assign.right).name = "((" + ctx.expression(0).type.getName() + " *)" + ((IndExpr)assign.right).name + ")";
        }
        return assign;
    }

    @Override
    public OutputModelObject visitDotRef(JParser.DotRefContext ctx)
    {
        DotExpr d = new DotExpr();
        d.nodes.add(visit(ctx.getChild(0)));
        d.nodes.add(visit(ctx.getChild(2)));
        return d;
    }

    @Override
    public OutputModelObject visitCreatorRef(JParser.CreatorRefContext ctx)
    {
        String name = ctx.creator().type.getName();
        return new CreatorExpr(name);
    }

    @Override
    public OutputModelObject visitIndRef(JParser.IndRefContext ctx)
    {
        String name = ctx.ind().Identifier().getText();
        String typeName = ctx.type.getName();
        IndExpr ind = new IndExpr(name, typeName);
        return ind;
    }

    @Override
    public LiteralExpr visitLiteralRef(JParser.LiteralRefContext ctx)
    {
        LiteralExpr l = new LiteralExpr((Object) ctx.getText());
        l.type = ctx.type.getName();
        return l;
    }

// at this point I'm going to stop doing a review because the code is so bad; sorry to be harsh but this next method is truly impressive in its size and complexity. You can try to rebuild this project if you like but it seems like you have difficulty understanding how all of the pieces fit together. I'm happy to review another attempt if you'd like to do that
    @Override
    public OutputModelObject visitFuncRef(JParser.FuncRefContext ctx)
    {
        String name;
        if (ctx.getChild(0).getChildCount() == 1)
            name = ctx.getChild(0).getText();
        else
            name = ctx.getChild(0).getChild(2).getText();
        String typeName = ctx.type.getName();
        Function f;
        if (name.equals("printf"))
            f = new PrintExpr(name, typeName);
        else
        {
            f= new FuncExpr(name, typeName);
        }
        if (name.equals("printf")) {
            for (JParser.ExpressionContext expr : ctx.expressionList().expression()) {
                OutputModelObject omo = (OutputModelObject) visit(expr);
                DotExpr d = new DotExpr();
                //System.out.println("&&&&&&" + currentScope.getEnclosingScope().getName());
                if (omo instanceof IndExpr)
                {
                    int flag = 0;
                    Scope scope = currentScope;
                    while (scope.getName().equals("local") || !(scope instanceof JMethod))
                    {
                        scope = scope.getEnclosingScope();
                    }
                    System.out.println(scope.getName());
                    System.out.println(((JMethod)scope).getSymbolNames());
                    if (((JMethod)scope).getSymbol(((IndExpr) omo).name) != null)
                    {
                        System.out.println("YEEEEEEEEEEEEEEEES");
                        f.addFunc(omo);
                    }
                    else {
                        if (currentClass != null) {
                            for (OutputModelObject fd : currentClass.fields) {
                                if (((FieldDef) fd).fieldName.equals(((IndExpr) omo).name)) {
                                    d.nodes.add(new PrimitiveType("this"));
                                    d.nodes.add(omo);
                                    f.addFunc(d);
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 0) {
                                for (OutputModelObject fd : currentClass.sFields) {
                                    if (((FieldDef) fd).fieldName.equals(((IndExpr) omo).name)) {
                                        d.nodes.add(new PrimitiveType("this"));
                                        d.nodes.add(omo);
                                        f.addFunc(d);
                                        flag = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (flag == 0)
                            f.addFunc(omo);
                    }
                }
                else
                    f.addFunc(omo);
            }
            return f;
        }
        if (typeName.equals("int") || typeName.equals("float") || typeName.equals("void"))
        {
            f.returnType = new PrimitiveType(typeName);
        }
        else
            f.returnType = new ObjectType(typeName);
        if (ctx.getChild(0) instanceof JParser.DotRefContext)
        {
            JClass scope;
            if (ctx.getChild(0).getChild(0) instanceof JParser.IndRefContext) {
                f.className = ((JParser.IndRefContext) ((ctx.getChild(0)).getChild(0))).type.getName();
                scope = (JClass)((JParser.IndRefContext) ((ctx.getChild(0)).getChild(0))).type;
            }
            else {
                f.className = ((JParser.DotRefContext) ((ctx.getChild(0)).getChild(0))).type.getName();
                scope = (JClass)((JParser.DotRefContext) ((ctx.getChild(0)).getChild(0))).type;
            }
            String tmp = f.className;
            String vName = ((JParser.DotRefContext)ctx.getChild(0)).getChild(0).getText();
            OutputModelObject d = visit(ctx.getChild(0).getChild(0));
            //System.out.println(f.name + "###########" + scope);
            int flag = 0;
            for (MethodSymbol m : scope.getDefinedMethods())
            {
                if (((JMethod)m).getName().equals(f.name))
                {
                    flag = 1;
                    break;
                }
            }
            //f.className = scope.getName();
            //if (scope.resolve(f.name) == null){
            while (flag == 0 && scope.getSuperClassScope() != null)
            {
               // System.out.println("##################" + scope.getSuperClassName());
                scope = (JClass) scope.getSuperClassScope();
                for (MethodSymbol m : ((JClass)scope).getDefinedMethods())
                {
                    if (((JMethod)m).getName().equals(f.name))
                    {
                        //flag = 1;
                        f.className = scope.getName();
                        break;
                    }
                }
               /* if (scope.resolve(f.name) != null)
                {
                    f.className = scope.getName();
                    break;
                }*/
               // System.out.println("Class Name: " + f.className);
            }
            //}
            ThisExpr t = new ThisExpr(vName, f.className);
            t.slotType = tmp;
            f.d = d;
            f.t = t;
            t.omo = d;
        }
        if (ctx.getChild(0) instanceof JParser.IndRefContext)
        {
            Scope scope= currentScope;
            while (!(scope instanceof JClass))
            {
                scope = scope.getEnclosingScope();
            }
            String scopeName = scope.getName();
           /* System.out.println("XXXXXXXXXXX" + scope.getName());
            f.className = ((JParser.IndRefContext)ctx.getChild(0)).type.getName();
            System.out.println(f.className);
            scope = (JClass) ((JParser.IndRefContext)ctx.getChild(0)).type;
            String tmp = f.className;
            String vName = ctx.getChild(0).getText();
            OutputModelObject d = visit(ctx.getChild(0));
            System.out.println(f.name + "###########" + scope);*/
            //OutputModelObject d = visit(ctx.getChild(0).getChild(0));
            OutputModelObject d = new IndExpr("this", null);
            int flag = 0;
            for (MethodSymbol m : ((JClass)scope).getDefinedMethods())
            {
                if (((JMethod)m).getName().equals(f.name))
                {
                    flag = 1;
                    f.className = scope.getName();
                    break;
                }
            }
            //f.className = scope.getName();
            //if (scope.resolve(f.name) == null){
            while (flag == 0 && ((JClass)scope).getSuperClassScope() != null)
            {
                // System.out.println("##################" + scope.getSuperClassName());
                scope = (JClass) ((JClass)scope).getSuperClassScope();
                for (MethodSymbol m : ((JClass)scope).getDefinedMethods())
                {
                    if (((JMethod)m).getName().equals(f.name))
                    {
                        //flag = 1;
                        f.className = scope.getName();
                        break;
                    }
                }
               /* if (scope.resolve(f.name) != null)
                {
                    f.className = scope.getName();
                    break;
                }*/
                // System.out.println("Class Name: " + f.className);
            }
            //}
            ThisExpr t = new ThisExpr("this", f.className);
            t.slotType = scopeName;
            f.d = d;
            f.t = t;
            t.omo = d;
        }
        f.addFunc(f.t);
        for (JParser.ExpressionContext expr : ctx.expressionList().expression()) {
            OutputModelObject omo = (OutputModelObject) visit(expr);
            if (omo instanceof IndExpr)
            {
                ((IndExpr)omo).name = "(("+((IndExpr)omo).type+" *)" +((IndExpr)omo).name + ")";
            }
            f.addFunc(omo);
        }
        for (OutputModelObject omo : f.args)
        {

            if (omo instanceof LiteralExpr){
            //if (tn.equals("int") || tn.equals("float") || tn.equals("void"))
                String tn = (String)((LiteralExpr)omo).type;
                f.addTypes(new PrimitiveType(tn));
            }
            else if (omo instanceof CreatorExpr)
            {
                String tn = ((CreatorExpr)omo).name;
                f.addTypes(new ObjectType(tn));
            }
            else{
                String tn = ((ValueExpr)omo).type;
                f.addTypes(new ObjectType(tn));}
        }
        return f;
    }
}
