package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuo on 02/04/17.
 */
public class FuncExpr extends Function {

    public String className;
    public FuncExpr(String name, String typeName)
    {
        super(name, typeName);
    }
}
