package cs652.j.semantics;

import org.antlr.symtab.VariableSymbol;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by tuo on 01/03/17.
 */
public class JArg extends VariableSymbol {

    public JArg(String name, ParserRuleContext tree)
    {
        super(name);
        setDefNode(tree);
    }
}
