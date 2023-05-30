package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;


public class Minus extends BinOp {
    public Minus(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

