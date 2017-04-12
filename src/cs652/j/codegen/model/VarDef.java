package cs652.j.codegen.model;

/**
 * Created by tuo on 31/03/17.
 */
public class VarDef extends OutputModelObject {
    public String varName;
    @ModelElement
    public Type type;

    public VarDef(String varName)
    {
        this.varName = varName;
    }
}
