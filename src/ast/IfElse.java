package src.ast;

import src.ast.abstracts.Expr;
import src.ast.abstracts.Cmd;

public class IfElse extends Cmd {
    private Expr condition;
    private Cmd ifBody;
    private Cmd elseBody;

    public IfElse(int l, int c, Expr condition, Cmd ifBody, Cmd elseBody) {
        super(l, c);
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expr getCondition() {
        return condition;
    }

    public Cmd getIfBody() {
        return ifBody;
    }

    public Cmd getElseBody() {
        return elseBody;
    }
}