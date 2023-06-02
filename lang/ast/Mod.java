package lang.ast;

import lang.ast.abstracts.BinOp;
import lang.ast.abstracts.Expr;


public class Mod extends BinOp {
    public Mod(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
