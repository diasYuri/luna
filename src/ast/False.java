package src.ast;


import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;
import src.ast.abstracts.Node;

public class False extends Node {

    public False(int l, int c){
        super(l,c);
    }

    public boolean getValue(){ return false;}

}

