package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 03/04/17.
 */
public class Function extends OutputModelObject {
    public String name;
    public String typeName;
    public String className;
    public ThisExpr t;
    @ModelElement
    public List<OutputModelObject> args = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> types = new ArrayList<>();
    @ModelElement
    public OutputModelObject d;
    @ModelElement
    public OutputModelObject returnType;
    public Function(String name, String typeName)
    {
        this.name = name;
        this.typeName = typeName;
    }

    public void addFunc(OutputModelObject omo)
    {
        args.add(omo);
    }
    public void addTypes(OutputModelObject omo)
    {
        types.add(omo);
    }
}
