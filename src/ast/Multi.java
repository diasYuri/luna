package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;

public class Multi extends BinOp {
    public Multi(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
