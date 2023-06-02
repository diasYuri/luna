package lang.ast;

import lang.ast.abstracts.Expr;
import lang.ast.abstracts.Type;

public class Param extends Expr {
    private String id;
    private Type type;

    public Param(int l, int c, String id, Type type) {
        super(l, c);
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}
