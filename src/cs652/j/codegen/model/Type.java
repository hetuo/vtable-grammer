package cs652.j.codegen.model;

/**
 * Created by tuo on 01/04/17.
 */
public abstract class Type extends OutputModelObject{

    public String name;

    public Type(String name)
    {
        this.name = name;
    }
}
