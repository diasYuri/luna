package lang.ast;

public class Not extends Expr{
    private Expr expr;

    public Not(int l, int c, Expr expr){
        super(l,c);
        this.expr= expr;
    }

    @Override
    public String toString(){
        return " ! " + expr.toString();
    }

    
}

