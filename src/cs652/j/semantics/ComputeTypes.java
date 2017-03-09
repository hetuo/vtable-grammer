package cs652.j.semantics;

import org.antlr.symtab.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ComputeTypes extends JBaseListener {
	protected StringBuilder buf = new StringBuilder();
	public Scope currentScope;
	private String strForstatement;
	private String tmpString;
	private int flag = 1;
	private String type = new String();
	public static final Type JINT_TYPE = new JPrimitiveType("int");
	public static final Type JFLOAT_TYPE = new JPrimitiveType("float");
	public static final Type JSTRING_TYPE = new JPrimitiveType("string");
	public static final Type JVOID_TYPE = new JPrimitiveType("void");

	public ComputeTypes(GlobalScope globals) {
		this.currentScope = globals;
		strForstatement = new String();
		tmpString = new String();
	}

	@Override
	public void enterClassDeclaration(JParser.ClassDeclarationContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void exitClassDeclaration(JParser.ClassDeclarationContext ctx)
	{
	}

	@Override
	public void enterMethodDeclaration(JParser.MethodDeclarationContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void enterFormalParameters(JParser.FormalParametersContext ctx)
	{
	}

	@Override
	public void exitMethodDeclaration(JParser.MethodDeclarationContext ctx)
	{
	}

	@Override
	public void enterFormalParameter(JParser.FormalParameterContext ctx)
	{
		/*String name = ctx.Identifier().getText();
		buf.append(name + " is " + ctx.type.getName() + "\n");*/
	}

	@Override
	public void enterBlock(JParser.BlockContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void exitBlock(JParser.BlockContext ctx)
	{
	}

	@Override
	public void enterLocalVariableDeclaration(JParser.LocalVariableDeclarationContext ctx)
	{
		/*String name = ctx.Identifier().getText();
		buf.append(name + " is " + ctx.type.getName()+"\n");*/
	}

	@Override
	public void enterFieldDeclaration(JParser.FieldDeclarationContext ctx)
	{
	}

	@Override
	public void enterMain(JParser.MainContext ctx)
	{
	    currentScope = ctx.scope;
	}

	@Override
	public void exitMain(JParser.MainContext ctx)
	{
	}

    @Override
    public void enterStatement(JParser.StatementContext ctx)
    {
        if (ctx.getChild(0).getText().equals("return"))
        {
            if (ctx.getChild(1) instanceof JParser.IndRefContext)
            {
                String name = ((JParser.IndRefContext)ctx.getChild(1)).Identifier().getText();
                VariableSymbol s = (VariableSymbol)currentScope.resolve(name);
                buf.append(name + " is " + s.getType().getName() + "\n");
            }
            else if (ctx.getChild(1) instanceof JParser.LiteralRefContext)
            {
                Type type;
                String nameAfterEqual = ctx.getChild(1).getChild(0).getText();
                if (((JParser.LiteralContext)ctx.getChild(1).getChild(0)).FloatingPointLiteral() != null)
                    type = JFLOAT_TYPE;
                else
                    type = JINT_TYPE;
                buf.append(nameAfterEqual + " is " + type.getName() + "\n");
            }
        }
        else if (ctx.getChild(0).getText().equals("while") || ctx.getChild(0).getText().equals("if"))
        {
            if (ctx.getChild(1).getChildCount() == 3)
            {
                String name = ((JParser.IndRefContext)ctx.getChild(1).getChild(1)).Identifier().getText();
                Symbol s = currentScope.resolve(name);
                if (s instanceof VariableSymbol)
                    buf.append(name + " is " + ((VariableSymbol)s).getType().getName() + "\n");
            }
        }
    }

    @Override
    public void enterExpressionList(JParser.ExpressionListContext ctx)
    {
        if (ctx.isEmpty())
            return;

        int sum = ctx.getChildCount();
        for (int i = 0; i < sum; i += 2)
        {
            if (ctx.getChild(i) instanceof JParser.IndRefContext)
            {
                String name = ctx.getChild(i).getChild(0).getText();
                System.out.println("hetuo" + name);
                Type type = ((VariableSymbol)currentScope.resolve(name)).getType();
                buf.append(name + " is " + type.getName() + "\n");
            }
            if (ctx.getChild(i) instanceof JParser.LiteralRefContext)
            {
                String name = ctx.getChild(i).getChild(0).getText();
                Type type;
                if (((JParser.LiteralContext)ctx.getChild(i).getChild(0)).FloatingPointLiteral() != null){
                    type = JFLOAT_TYPE;
                    buf.append(name + " is " + type.getName() + "\n");
                }
                else if (((JParser.LiteralContext)ctx.getChild(i).getChild(0)).IntegerLiteral() != null){
                    type = JINT_TYPE;
                    buf.append(name + " is " + type.getName() + "\n");
                }
            }
            else if (ctx.getChild(i) instanceof JParser.CreatorRefContext)
            {
                String name = ((JParser.CreatorContext)ctx.getChild(i).getChild(1)).typeType().getText();
                Type type = ((JParser.CreatorContext)ctx.getChild(i).getChild(1)).type;
                buf.append("new" + name + "()" + " is " + type.getName() + "\n");
            }
        }
    }

    @Override
    public void enterAssignRef(JParser.AssignRefContext ctx)
    {
        Type type;
        String namePreEqual;
        String nameAfterEqual;
        if (ctx.getChild(0).getChildCount() == 1)
        {
            namePreEqual = ((JParser.IndRefContext)ctx.getChild(0)).Identifier().getText();
            Symbol s = currentScope.resolve(namePreEqual);
            if (s instanceof JClass)
                type = (JClass)s;
            else if (s instanceof JMethod)
                type = ((JMethod) s).getType();
            else
                type = ((VariableSymbol)s).getType();
            buf.append(namePreEqual + " is " + type.getName() + "\n");
        }
        /*if (ctx.getChild(2).getChildCount() == 1)
        {
            if (ctx.getChild(2) instanceof JParser.IndRefContext) {
                nameAfterEqual = ((JParser.IndRefContext)ctx.getChild(2)).Identifier().getText();
                Symbol s = currentScope.resolve(nameAfterEqual);
                if (s instanceof JClass)
                    type = (JClass)s;
                else if (s instanceof JMethod)
                    type = ((JMethod) s).getType();
                else
                    type = ((VariableSymbol)s).getType();
                buf.append(nameAfterEqual + " is " + type.getName() + "\n");
            }
            else if (ctx.getChild(2) instanceof JParser.LiteralRefContext)
            {
                nameAfterEqual = ctx.getChild(2).getChild(0).getText();
                if (((JParser.LiteralContext)ctx.getChild(2).getChild(0)).FloatingPointLiteral() != null)
                    type = JFLOAT_TYPE;
                else
                    type = JINT_TYPE;
                buf.append(nameAfterEqual + " is " + type.getName() + "\n");
                //System.out.println("zyx11" + nameAfterEqual);
            }
            else
            {
                System.out.println("test" + ctx.getChild(2).getChild(0).getText());
            }

        }*/
    }
    @Override
    public void exitAssignRef(JParser.AssignRefContext ctx)
    {
        Type type;
        String namePreEqual;
        String nameAfterEqual;
        /*if (ctx.getChild(0).getChildCount() == 1)
        {
            namePreEqual = ((JParser.IndRefContext)ctx.getChild(0)).Identifier().getText();
            Symbol s = currentScope.resolve(namePreEqual);
            if (s instanceof JClass)
                type = (JClass)s;
            else if (s instanceof JMethod)
                type = ((JMethod) s).getType();
            else
                type = ((VariableSymbol)s).getType();
            buf.append(namePreEqual + " is " + type.getName() + "\n");
        }*/
        /*else
        {
            type = ((JParser.ExpressionContext)ctx.getChild(0)).type;
            if (tmpString.length() != 0){
                buf.append(tmpString);
                tmpString = new String();
            }
            else
                buf.append(ctx.getChild(0).getText());

            strForstatement = new String() ;

            buf.append(" is " + type.getName() + "\n");
        }*/

        if (ctx.getChild(2).getChildCount() == 1)
        {
            if (ctx.getChild(2) instanceof JParser.IndRefContext) {
                nameAfterEqual = ((JParser.IndRefContext)ctx.getChild(2)).Identifier().getText();
                Symbol s = currentScope.resolve(nameAfterEqual);
                if (s instanceof JClass)
                type = (JClass)s;
                else if (s instanceof JMethod)
                    type = ((JMethod) s).getType();
                else
                    type = ((VariableSymbol)s).getType();
                buf.append(nameAfterEqual + " is " + type.getName() + "\n");
            }
            else if (ctx.getChild(2) instanceof JParser.LiteralRefContext)
            {
                nameAfterEqual = ctx.getChild(2).getChild(0).getText();
                if (((JParser.LiteralContext)ctx.getChild(2).getChild(0)).FloatingPointLiteral() != null)
                    type = JFLOAT_TYPE;
                else
                    type = JINT_TYPE;
                buf.append(nameAfterEqual + " is " + type.getName() + "\n");
                //System.out.println("zyx11" + nameAfterEqual);
            }
            else
            {
                System.out.println("test" + ctx.getChild(2).getChild(0).getText());
            }

        }
        else if (ctx.getChild(2).getChildCount() == 2)
        {
            String name = ((JParser.CreatorContext)ctx.getChild(2).getChild(1)).typeType().getText();
            type = ((JParser.CreatorContext)ctx.getChild(2).getChild(1)).type;
            buf.append("new" + name + "()" + " is " + type.getName() + "\n");
        }
        /*else
        {

            type = ((JParser.ExpressionContext)ctx.getChild(2)).type;
            buf.append(ctx.getChild(2).getText());
            strForstatement = new String() ;
            buf.append(" is " + type.getName());
        }*/

    }

	@Override
	public void enterCreator(JParser.CreatorContext ctx)
	{

	}

	@Override
	public void exitLiteral(JParser.LiteralContext ctx)
	{
		/*if (ctx.IntegerLiteral() != null)
			buf.append(ctx.IntegerLiteral().getText() + " is int\n");
		else if (ctx.FloatingPointLiteral() != null)
			buf.append(ctx.FloatingPointLiteral().getText() + " is float\n");
		else
			return;*/
	}

    @Override
    public void exitIndRef(JParser.IndRefContext ctx)
    {
        if (ctx.Identifier().getText().equals("printf")){
            flag = 0;
            ctx.type = JVOID_TYPE;}
        else if (ctx.Identifier().getText().equals("this")){
            Scope s = currentScope;
            while (s != null && !(s instanceof JClass))
            {
                s = s.getEnclosingScope();
            }
            ctx.type = (JClass)s;
            //buf.append("this is " + s.getName() + "\n");
        }
        else {
            Symbol s = currentScope.resolve(ctx.Identifier().getText());
            if (s == null)
                ctx.type = JSTRING_TYPE;
            else if (s instanceof JClass) {
                ctx.type = (JClass) s;
                //buf.append(ctx.Identifier().getText() + " is " + ctx.type.getName());
            }
            else if (s instanceof JMethod)
                ctx.type = ((JMethod) s).getType();
            else
            {
                ctx.type = ((VariableSymbol)s).getType();
            }
        }
    }

	@Override
	public void exitFuncRef(JParser.FuncRefContext ctx)
	{
		if (ctx.getChild(0).getChildCount() == 1)
        {
            String name = ((JParser.IndRefContext)ctx.getChild(0)).Identifier().getText();
            if (name.equals("printf"))
                return;
            JMethod m = (JMethod)currentScope.resolve(name);
            Type type = m.getType();
            ctx.type = type;
            buf.append(name + '(');
            if (ctx.expressionList() != null)
            {
                JParser.ExpressionListContext list = ctx.expressionList();
                int sum = list.getChildCount();
                for (int i = 0; i < sum; i += 2)
                {
                    //JParser.LiteralRefContext literal = ((JParser.LiteralRefContext)list.getChild(i));
                    System.out.println("Class Type:" + list.getChild(i).getClass().getName());
                    if (list.getChild(i) instanceof JParser.CreatorRefContext)
                    {
                        System.out.println("xxxxxxxxxxx");
                        buf.append("new" + list.getChild(i).getText() + "()");
                    }
                    else
                        buf.append(list.getChild(i).getText());
                    //strForstatement += literal.getText();
                    if (i != sum - 1)
                        buf.append(",");
                }
            }
            buf.append(") is " + type.getName() + "\n");
        }
        else
        {
            Type type = ((JParser.ExpressionContext)ctx.getChild(0)).type;
            buf.append(ctx.getChild(0).getText());
            strForstatement = new String();
            buf.append("(");
            if (ctx.expressionList() != null)
            {
                JParser.ExpressionListContext list = ctx.expressionList();
                int sum = list.getChildCount();
                for (int i = 0; i < sum; i += 2)
                {
                    //JParser.LiteralRefContext literal = ((JParser.LiteralRefContext)list.getChild(i));
                    if (list.getChild(i) instanceof JParser.CreatorRefContext)
                    {
                        buf.append(list.getChild(i).getText());
                    }
                    else
                        buf.append(list.getChild(i).getText());
                    //strForstatement += literal.getText();
                    if (i != sum - 1)
                        buf.append(",");
                }
            }
            buf.append(") is " + type.getName() + "\n");
            ctx.type = type;
        }
	}

	@Override
	public void exitDotRef(JParser.DotRefContext ctx)
	{
	    if (ctx.getChild(0).getChildCount() == 1)
        {
            JClass c = (JClass)((JParser.ExpressionContext)ctx.getChild(0)).type;
            String namePreDot = ((JParser.IndRefContext)ctx.getChild(0)).Identifier().getText();
            buf.append(namePreDot + " is " + c.getName() + "\n");
            String nameAfterDot = ((JParser.IndRefContext)ctx.getChild(2)).Identifier().getText();
            Symbol s = c.resolve(nameAfterDot);
            if (s instanceof JClass)
            {
                ctx.type = (JClass)s;
            }
            else if (s instanceof JMethod)
            {
                ctx.type = ((JMethod)s).getType();
            }
            else
            {
                ctx.type = ((VariableSymbol)s).getType();
            }
            //buf.append(namePreDot + "." + nameAfterDot);
            if (!(s instanceof JMethod))
                buf.append(ctx.getText() + " is " + ctx.type.getName() + "\n");
            strForstatement += (namePreDot + "." + nameAfterDot);
        }
        else
        {
            JClass c = (JClass)((JParser.ExpressionContext)ctx.getChild(0)).type;
            String nameAfterDot = ((JParser.IndRefContext)ctx.getChild(2)).Identifier().getText();
            //buf.append(ctx.getChild(0).getText() + " is " + c.getName() + "\n");
            Symbol s = c.resolve(nameAfterDot);
            if (s instanceof JClass)
            {
                ctx.type = (JClass)s;
            }
            else if (s instanceof JMethod)
            {
                ctx.type = ((JMethod)s).getType();
            }
            else
            {
                ctx.type = ((VariableSymbol)s).getType();
            }
            //buf.append("." + nameAfterDot);
           // System.out.println(s.getName() + "@@@" + s.getClass().getName());
            if (!(s instanceof JMethod))
                buf.append(ctx.getText() + " is " + ctx.type.getName() + "\n");
            strForstatement += ("." + nameAfterDot);
        }

	}

    @Override
    public void exitStatementExpression(JParser.StatementExpressionContext ctx)
    {
    }

	public String getRefOutput() {
		return buf.toString();
	}
}

