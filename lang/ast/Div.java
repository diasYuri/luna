package lang.ast;

import lang.ast.abstracts.BinOp;
import lang.ast.abstracts.Expr;

public class Div extends BinOp {
    public Div(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
