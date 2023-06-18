package lang.ast;

public class Attribution extends Cmd {
    private LValue variable;
    private Expr expression;

    public Attribution(int l, int c, LValue variable, Expr expression) {
        super(l, c);
        this.variable = variable;
        this.expression = expression;
    }

    public LValue getVariable() {
        return variable;
    }

    public Expr getExpression() {
        return expression;
    }
}
