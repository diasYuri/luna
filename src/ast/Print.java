package src.ast;

import src.ast.abstracts.Expr;
import src.ast.abstracts.Cmd;

public class Print extends Cmd {
    private Expr expression;

    public Print(int l, int c, Expr expression) {
        super(l, c);
        this.expression = expression;
    }

    public Expr getExpression() {
        return expression;
    }


}
