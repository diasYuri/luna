package lang.ast;


import lang.ast.abstracts.Expr;


public class SMinus extends Expr{
    private Expr expr;

    public SMinus(int l, int c, Expr expr){
        super(l,c);
        this.expr= expr;
    }

    @Override
    public String toString(){
        return "- " + expr.toString();
    }

    
}
