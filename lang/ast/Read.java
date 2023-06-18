package lang.ast;

public class Read extends Cmd {
    private LValue variable;

    public Read(int l, int c, LValue variable) {
        super(l, c);
        this.variable = variable;
    }

    public LValue getVariableName() {
        return variable;
    }

    
}
