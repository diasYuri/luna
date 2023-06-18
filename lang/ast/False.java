package lang.ast;

public class False extends Expr {

    public False(int l, int c){
        super(l,c);
    }

    public boolean getValue(){ return false;}

}

