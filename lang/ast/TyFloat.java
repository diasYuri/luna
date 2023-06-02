package lang.ast;


import lang.ast.abstracts.Type;

public class TyFloat extends Type {

    public TyFloat(int l, int c){
        super(l,c);
    }
    
    public boolean match(Type t){
        return t instanceof TyFloat; 
     }

    //@Override
    public String toString(){ return "Float"; }
}

