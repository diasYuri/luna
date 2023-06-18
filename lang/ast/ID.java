package lang.ast;

public class ID extends Expr {
    private final String name;

    public ID(int l, int c, String name){
        super(l,c);
        this.name= name;
    }

    public String getName(){ return name;}
}

