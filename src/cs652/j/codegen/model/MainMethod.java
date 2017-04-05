package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 31/03/17.
 */
public class MainMethod extends OutputModelObject {
    @ModelElement
    public List<OutputModelObject> locals = new ArrayList<>();
    @ModelElement
    public List<OutputModelObject> instrs = new ArrayList<>();
    @ModelElement
    public OutputModelObject whileStat;

    public void addLocals(OutputModelObject omo)
    {
        locals.add(omo);
    }
    public void addInstrs(OutputModelObject omo) { instrs.add(omo); }
}
