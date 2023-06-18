package lang.ast;

import lang.ast.abstracts.BinOp;

public class Add extends BinOp {
    public Add(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

