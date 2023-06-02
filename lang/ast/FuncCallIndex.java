package lang.ast;


import lang.ast.abstracts.Expr;

import java.util.Collections;
import java.util.List;

public class FuncCallIndex extends Expr {
    private String id;
    private List<Expr> arguments;
    private Expr indexExpr;
    

    public FuncCallIndex(int l, int c,String id, List<Expr> arguments, Expr indexExpr){
        super(l,c);
        this.id = id;
        this.indexExpr = indexExpr;
        this.arguments = arguments;
    }
    
    
    public List<Expr> getArgs(){
        if (arguments == null) {
            return Collections.emptyList();
        }
        return arguments;
    }
    
    public Expr getIndexExpr(){
        if (indexExpr == null) {
            return null;
        }
        return indexExpr;
    }


    @Override
    public String toString() {
        String result = id + "(";
        if (arguments != null && !arguments.isEmpty()) {
            for (int i = 0; i < arguments.size(); i++) {
                result += arguments.get(i).toString();
                if (i < arguments.size() - 1) {
                    result += ", ";
                }
            }
        }
        result += ")";
        result += "[" + indexExpr.toString() + "]";
        return result;
    }

}
