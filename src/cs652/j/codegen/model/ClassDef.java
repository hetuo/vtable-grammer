package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 31/03/17.
 */
public class ClassDef extends OutputModelObject{
    public String name;
    @ModelElement
    public List<OutputModelObject> fields = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> methods = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> vtable = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> sFields = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> sMethods = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> sVtable = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> methodsForSlot = new ArrayList<>();

    public ClassDef(String name)
    {
        this.name = name;
    }
    public void addFields(OutputModelObject omo)
    {
        fields.add(omo);
    }
    public void addVtable(OutputModelObject omo)
    {
        vtable.add(omo);
    }
    public void addMethods(OutputModelObject omo)
    {
        methods.add(omo);
    }
    public void addSFields(OutputModelObject omo)
    {
        sFields.add(omo);
    }
    public void addMethodsForSlot(OutputModelObject omo) {methodsForSlot.add(omo);}
    public void addSVtable(OutputModelObject omo)
    {
        sVtable.add(omo);
    }
    public void addSMethods(OutputModelObject omo)
    {
        sMethods.add(omo);
    }
}
