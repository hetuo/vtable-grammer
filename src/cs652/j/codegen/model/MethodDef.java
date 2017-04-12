package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 02/04/17.
 */
public class MethodDef extends OutputModelObject{
    public String name;
    public String scope;
    public int slot;
    @ModelElement
    public Type returnType;
    @ModelElement
    public List<OutputModelObject> args = new ArrayList<>();
    @ModelElement
    public Block block;

    public MethodDef(String name, String scope)
    {
        this.name = name;
        this.scope = scope;
    }
}
