package lang.ast;

public class Param extends Expr {
    private String id;
    private String type;

    public Param(int l, int c, String id, String type) {
        super(l, c);
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
