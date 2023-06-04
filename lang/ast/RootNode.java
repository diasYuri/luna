package lang.ast;

import org.antlr.v4.runtime.ParserRuleContext;

public class RootNode extends SuperNode {
    private ParserRuleContext ctx;

    public RootNode(ParserRuleContext ctx) {
        this.ctx = ctx;
    }

    public ParserRuleContext Ctx(){return this.ctx;}
    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
