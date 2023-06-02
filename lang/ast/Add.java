package lang.ast;

import lang.ast.abstracts.BinOp;
import lang.ast.abstracts.Expr;

public class Add extends BinOp {
    public Add(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

