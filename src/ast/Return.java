package src.ast;

import java.util.ArrayList;
import java.util.List;

import src.ast.abstracts.Cmd;

import src.ast.abstracts.Expr;

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