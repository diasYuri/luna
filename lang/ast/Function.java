package lang.ast;

import lang.ast.abstracts.Type;

import java.util.List;

public class Function extends Expr {
    private String id;
    private Params params;
    private List<Type> returnTypes;
    private List<Cmd> body;

    public Function(int l, int c, String id, Params params, List<Type> returnTypes, List<Cmd> body) {
        super(l, c);
        this.id = id;
        this.params = params;
        this.returnTypes = returnTypes;
        this.body = body;
    }



    public Function(int l, int c, String id, Params params, List<Cmd> body) {
        super(l, c);
        this.id = id;
        this.params = params;
        this.body = body;
    }


    public String getId() {
        return id;
    }

    public Params getParams() {
        return params;
    }

    public List<Type> getReturnTypes() {
        return returnTypes;
    }

    public List<Cmd> getBody() {
        return body;
    }
}