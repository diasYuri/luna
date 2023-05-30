package src.ast;

import src.ast.abstracts.Expr;
import src.ast.abstracts.Cmd;

public class Iterate extends Cmd {
    private Expr condition;
    private Cmd body;

    public Iterate(int l, int c, Expr condition, Cmd body) {
        super(l, c);
        this.condition = condition;
        this.body = body;
    }

    public Expr getCondition() {
        return condition;
    }

    public Cmd getBody() {
        return body;
    }
}