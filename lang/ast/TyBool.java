package lang.ast;

import lang.ast.abstracts.Type;

public class TyBool extends Type {

    public TyBool(int l, int c){
        super(l,c);
    }

    public boolean match(Type t){
        return t instanceof TyBool; 
     }

    //@Override
    public String toString(){ return "Bool"; }
}

