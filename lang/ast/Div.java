package lang.ast;

import lang.ast.abstracts.BinOp;

public class Div extends BinOp {
    public Div(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
