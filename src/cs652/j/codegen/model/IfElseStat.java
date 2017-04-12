package cs652.j.codegen.model;

/**
 * Created by tuo on 05/04/17.
 */
public class IfElseStat extends OutputModelObject {
    @ModelElement
    public OutputModelObject condition;
    @ModelElement
    public OutputModelObject stat;
    @ModelElement
    public OutputModelObject elseStat;
}
