package src.ast;


import src.ast.abstracts.Expr;


public abstract class LValue extends Expr{
    // Função importante para os valores literais
    public abstract String getId();

    public LValue(int line, int column){
        super(line, column);
    }

}