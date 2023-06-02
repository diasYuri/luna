package lang.ast;

import lang.ast.abstracts.BinOp;
import lang.ast.abstracts.Expr;

public class Lt extends BinOp {
    public Lt(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }
}
