package src.ast;


import src.ast.abstracts.Expr;


public class False extends Expr {

    public False(int l, int c){
        super(l,c);
    }

    public boolean getValue(){ return false;}

}

