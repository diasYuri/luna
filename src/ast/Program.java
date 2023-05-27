package src.ast;

import src.ast.abstracts.Node;
import java.util.List;

public class Program extends Node {
    private List<Data> dataDefinitions;
    private List<Function> functionDefinitions;

    public Program(int l, int c, List<Data> dataDefinitions, List<Function> functionDefinitions) {
        super(l, c);
        this.dataDefinitions = dataDefinitions;
        this.functionDefinitions = functionDefinitions;
    }

    public List<Data> getDataDefinitions() {
        return dataDefinitions;
    }

    public List<Function> getFunctionDefinitions() {
        return functionDefinitions;
    }
}
