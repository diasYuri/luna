package lang.ast;

import lang.ast.abstracts.Expr;

public class FieldAccess extends Expr {
    private Expr expr;
    private String identifier;

    public FieldAccess(int l, int c, Expr expr, String identifier) {
        super(l, c);
        this.expr = expr;
        this.identifier = identifier;
    }

    public Expr getExpr() {
        return expr;
    }

    public String getidentifier() {
        return identifier;
    }
}
