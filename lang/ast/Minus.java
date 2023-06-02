package lang.ast;

import lang.ast.abstracts.BinOp;
import lang.ast.abstracts.Expr;


public class Minus extends BinOp {
    public Minus(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

