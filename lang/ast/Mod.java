package lang.ast;

import lang.ast.abstracts.BinOp;


public class Mod extends BinOp {
    public Mod(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
