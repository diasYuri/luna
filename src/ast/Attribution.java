package src.ast;

import src.ast.abstracts.Expr;
import src.ast.abstracts.Cmd;

public class Attribution extends Cmd {
    private String variableName;
    private Expr expression;

    public Attribution(int l, int c, String variableName, Expr expression) {
        super(l, c);
        this.variableName = variableName;
        this.expression = expression;
    }

    public String getVariableName() {
        return variableName;
    }

    public Expr getExpression() {
        return expression;
    }
}
