package src.ast;

import src.ast.abstracts.BinOp;
import src.ast.abstracts.Expr;
import src.ast.abstracts.Node;

public class ID extends Node {
    private final String name;

    public ID(int l, int c, String name){
        super(l,c);
        this.name= name;
    }

    public String getName(){ return name;}
}

