package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;

public class Add extends BinOp {
    public Add(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

