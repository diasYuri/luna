package lang.ast;

import lang.ast.abstracts.BinOp;

public class Lt extends BinOp {
    public Lt(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
