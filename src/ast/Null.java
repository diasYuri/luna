package src.ast;


import src.ast.abstracts.Node;

public class Null extends Node {
    private String value = null;

    public Null(int l, int c){
        super(l,c);
    }


    public String getValue(){ return value;}

    @Override
    public String toString(){
        return "null";
    }

}

