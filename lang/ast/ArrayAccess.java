package lang.ast;

public class ArrayAccess extends Expr {
    private LValue lValue;
    private Expr expr;

    public ArrayAccess(int l, int c,LValue lValue, Expr expr) {
        super(l, c);
        this.lValue = lValue;
        this.expr = expr;
    }


    public LValue getLValue() {
        return lValue;
    }

    public Expr getExp() {
        return expr;
    }
   
}