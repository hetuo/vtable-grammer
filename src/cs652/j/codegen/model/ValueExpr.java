package cs652.j.codegen.model;

/**
 * Created by tuo on 04/04/17.
 */
public class ValueExpr extends Expr {
    public String name;
    public String type;

    public ValueExpr(String name, String type)
    {
        this.name = name;
        this.type = type;
    }
}
