package lang.ast;

import lang.ast.Expr;


public class Minus extends Expr {
    
    private Expr exp;

    public Minus(int line, int column, Expr exp) {
        super(line, column);
        this.exp = exp;
    }

    // @Override
    // public String toString(){
    //     return " - " + exp.toString();
    // }

    // @Override
    // public void accept(Visitor v) {
    //     v.visit(this);
    // }


}