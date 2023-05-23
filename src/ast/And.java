package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;

public class And extends BinOp {
    public And(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
