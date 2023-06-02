package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.ast.abstracts.Cmd;

import lang.ast.abstracts.Expr;

public class Return extends Cmd {
    private List<Expr> expressions;

    public Return(int l, int c) {
        super(l, c);
        this.expressions = new ArrayList<>();
    }

    public void addExpression(Expr expression) {
        expressions.add(expression);
    }

    public List<Expr> getExpressions() {
        return expressions;
    }

    
}