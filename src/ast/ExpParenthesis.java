package src.ast;



import src.ast.abstracts.Expr;

public class ExpParenthesis extends Expr {
    private Expr expr;

    public ExpParenthesis(int l, int c, Expr expr){
        super(l,c);
        this.expr = expr;
    }
    
    @Override
    public String toString(){
        return " ( " + expr.toString() + " ) ";
    }
}
