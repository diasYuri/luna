package src.ast;



import src.ast.abstracts.Expr;
import src.ast.abstracts.Type;

public class NewTypeInstance extends Expr {
    private Expr expr;
    private Type type;
    private String newType;


    public NewTypeInstance(int l, int c, Expr expr,Type type){
        super(l,c);
        this.type = type;
        this.expr = expr;
    }
    // Construção de vetor de DATA
    public NewTypeInstance(int l, int c, Expr expr,String newType){
        super(l,c);
        this.type = null;
        this.newType = newType;
        this.expr = expr;
    }
    
    public NewTypeInstance (int l, int c, Type type){
        super(l, c);
        this.expr = null;
        this.type = type;
    }

    // Construtor para um DATA
    public NewTypeInstance(int l, int c, String newType){
        super(l, c);
        this.expr = null;
        this.type = null;
        this.newType = newType;
    }


    @Override
    public String toString(){
        if(type != null){
            return " new " + type + (expr != null ? (" [ " + expr + " ] ") : " ");
        }
        else
            return " new " + newType + (expr != null ? (" [ " + expr + " ] ") : " ");
    } 





}
