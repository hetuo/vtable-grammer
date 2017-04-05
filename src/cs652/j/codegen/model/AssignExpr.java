package cs652.j.codegen.model;

/**
 * Created by tuo on 02/04/17.
 */
public class AssignExpr extends Expr {

    @ModelElement
    public OutputModelObject left;
    @ModelElement
    public OutputModelObject right;
}
