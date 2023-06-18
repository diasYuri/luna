package lang.ast;

import lang.ast.abstracts.BinOp;

public class And extends BinOp {
    public And(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
