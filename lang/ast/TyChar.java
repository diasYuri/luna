package lang.ast;


import lang.ast.abstracts.Type;

public class TyChar extends Type {

    public TyChar(int l, int c){
        super(l,c);
    }
    
    public boolean match(Type t){
        return t instanceof TyChar; 
     }

    //@Override
    public String toString(){ return "Char"; }
}

