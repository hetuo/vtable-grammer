package cs652.j.codegen.model;

/**
 * Created by tuo on 03/04/17.
 */
public class ParameterDef extends OutputModelObject {
    public String parameterName;
    @ModelElement
    public Type type;

    public ParameterDef(String varName)
    {
        this.parameterName = varName;
    }
}
