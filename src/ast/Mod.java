package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;


public class Mod extends BinOp {
    public Mod(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
