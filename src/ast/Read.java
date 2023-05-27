package src.ast;

import src.ast.abstracts.Cmd;

public class Read extends Cmd {
    private String variableName;

    public Read(int l, int c, String variableName) {
        super(l, c);
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    
}
