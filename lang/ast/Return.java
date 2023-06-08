package lang.ast;

import java.util.ArrayList;
import java.util.List;

import lang.ast.abstracts.Cmd;

import lang.ast.abstracts.Expr;

public class Return extends Cmd {
    private Exps expressions;

    public Return(int l, int c, Exps expressions) {
        super(l, c);
        this.expressions = expressions;
    }

    public Exps getExpressions() {
        return expressions;
    }

    
}