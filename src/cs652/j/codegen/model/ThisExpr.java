package cs652.j.codegen.model;

/**
 * Created by tuo on 04/04/17.
 */
public class ThisExpr extends ValueExpr {

    @ModelElement
    public OutputModelObject omo;
    public String slotType;
    public ThisExpr(String name, String type)
    {
        super(name, type);
    }

}
