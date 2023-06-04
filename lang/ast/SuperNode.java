package lang.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class SuperNode {
   
   // The line and column of the node in the input text
   
    public abstract int getLine();
    public abstract int getColumn();
}

