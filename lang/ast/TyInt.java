package lang.ast;

import lang.ast.abstracts.Type;

public class TyInt extends Type {

    public TyInt(int l, int c){
        super(l,c);
    }
    
    public boolean match(Type t){
        return t instanceof TyInt; 
     }

    //@Override
    public String toString(){ return "Int"; }
}

