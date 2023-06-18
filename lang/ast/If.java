package lang.ast;

public class If extends Cmd {
    private Expr condition;
    private Cmd body;

    public If(int l, int c, Expr condition, Cmd body) {
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