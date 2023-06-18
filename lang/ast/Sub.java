package lang.ast;

import lang.ast.abstracts.BinOp;


public class Sub extends BinOp {
    public Sub(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}

