package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 31/03/17.
 */
public class Body extends OutputModelObject {

    @ModelElement
    public List<OutputModelObject> locals = new ArrayList<>();

    public void addLocals(OutputModelObject omo)
    {
        locals.add(omo);
    }
}
