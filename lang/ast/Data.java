package lang.ast;

import java.util.List;

public class Data extends Expr {
    private String id;
    private List<Declaration> declarations;

    public Data(int l, int c, String id, List<Declaration> declarations) {
        super(l, c);
        this.id = id;
        this.declarations = declarations;
    }

    public String getId() {
        return id;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }
}