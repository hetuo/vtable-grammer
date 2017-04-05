package cs652.j.codegen.model;

/**
 * Created by tuo on 05/04/17.
 */
public class IfStat extends OutputModelObject {
    @ModelElement
    public OutputModelObject condition;
    @ModelElement
    public OutputModelObject stat;
}
