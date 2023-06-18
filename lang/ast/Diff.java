package lang.ast;

import lang.ast.abstracts.BinOp;

public class Diff extends BinOp {
    public Diff(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
