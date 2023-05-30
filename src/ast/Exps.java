package src.ast;

import java.util.ArrayList;
import java.util.List;
import src.ast.abstracts.Expr;



public class Exps extends Expr {
    private List<Expr> exps;

    public Exps(int l, int c) {
        super(l, c);
        this.exps = new ArrayList<>();
    }

    public void addExpression(Expr expression) {
     exps.add(expression);
    }

    public List<Expr> getExps() {
        return exps;
    }
}