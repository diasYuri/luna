package lang.ast;

import lang.ast.abstracts.BinOp;

public class Eq extends BinOp {

    public Eq(int l, int c, Expr left, Expr right) {
        super(l, c, left, right);
    }

    public String toString() {
        String s = getLeft().toString();
        String ss = getRight().toString();
        //if(getRight() instanceof Add){
        //    ss = "(" + ss + ")";
        //}
        return s + " = " + ss;
    }
}
