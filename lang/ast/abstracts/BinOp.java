package lang.ast.abstracts;

import lang.ast.Expr;

public abstract class BinOp extends Expr {
    private Expr left;
    private Expr right;
    public BinOp(int l, int c, Expr left, Expr right) {
        super(l, c);
        this.left = left;
        this.right = right;
    }

    public BinOp setLeft(Expr n){
        left = n;
        return this;
    }
    public BinOp setRight(Expr n){
        right = n;
        return this;
    }

    public Expr getLeft(){ return left;}
    public Expr getRight(){ return right;}
}
