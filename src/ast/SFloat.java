package src.ast;


import src.ast.abstracts.Node;

public class SFloat extends Node {
    private float valor;

    public SFloat(int l, int c, float valor){
        super(l,c);
        this.valor = valor;
    }

    public float getValue(){ return valor;}
}

