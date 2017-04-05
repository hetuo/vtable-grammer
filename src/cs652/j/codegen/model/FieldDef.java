package cs652.j.codegen.model;

/**
 * Created by tuo on 03/04/17.
 */
public class FieldDef extends OutputModelObject {
    public String fieldName;
    @ModelElement
    public Type type;

    public FieldDef(String varName)
    {
        this.fieldName = varName;
    }
}
