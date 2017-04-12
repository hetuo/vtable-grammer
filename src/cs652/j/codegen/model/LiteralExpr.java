package cs652.j.codegen.model;

/**
 * Created by tuo on 02/04/17.
 */
public class LiteralExpr extends Expr{

    public Object value;
    public String type;
    public LiteralExpr(Object value)
    {
        this.value = value;
    }
}
