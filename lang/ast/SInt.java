package lang.ast;


import lang.ast.abstracts.Node;

public class SInt extends Node {
    private int valor;

    public SInt(int l, int c, int valor){
        super(l,c);
        this.valor = valor;
    }

    public int getValue(){ return valor;}
}

