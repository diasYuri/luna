package lang.ast;

import lang.ast.abstracts.Expr;

public class ID extends Expr {
    private final String name;

    public ID(int l, int c, String name){
        super(l,c);
        this.name= name;
    }

    public String getName(){ return name;}
}

