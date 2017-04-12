package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 04/04/17.
 */
public class DotExpr extends OutputModelObject{
    @ModelElement
    public List<OutputModelObject> nodes = new ArrayList<>();
}
