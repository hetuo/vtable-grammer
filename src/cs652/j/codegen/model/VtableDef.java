package cs652.j.codegen.model;

/**
 * Created by tuo on 03/04/17.
 */
public class VtableDef extends OutputModelObject {
    public String className;
    public String methodName;

    public VtableDef(String className, String methodName)
    {
        this.className = className;
        this.methodName = methodName;
    }
}
