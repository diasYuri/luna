package lang.ast;

import lang.ast.abstracts.Expr;

public class ArrayAccess extends Expr {
    private Expr array;
    private Expr index;

    public ArrayAccess(int l, int c, Expr array, Expr index) {
        super(l, c);
        this.array = array;
        this.index = index;
    }

    public Expr getArray() {
        return array;
    }

    public Expr getIndex() {
        return index;
    }
}