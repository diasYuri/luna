package lang.ast;


import lang.ast.abstracts.Node;

public class True extends Node {

    public True(int l, int c){
        super(l,c);
    }

    public boolean getValue(){ return true;}

}

