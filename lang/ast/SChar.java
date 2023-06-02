package lang.ast;


import lang.ast.abstracts.Node;

public class SChar extends Node {
    private char valor;

    public SChar(int l, int c, char valor){
        super(l,c);
        this.valor= valor;
    }

    public char getValue(){ return valor;}
}

