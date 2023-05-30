package src.ast;

import src.ast.abstracts.Expr;

import java.util.ArrayList;
import java.util.List;

public class Params extends Expr {
    private List<Param> params;

    public Params(int l, int c) {
        super(l, c);
        this.params = new ArrayList<>();
    }

    public void addParam(Param param) {
        params.add(param);
    }

    public List<Param> getParams() {
        return params;
    }
}