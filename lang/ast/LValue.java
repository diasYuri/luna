package lang.ast;

public class LValue extends Expr{
    // Função importante para os valores literais
    private String id;
    public String getId()
    {return id;}

    public LValue(int line, int column, String id){
        super(line, column);
        this.id = id;
    }

}