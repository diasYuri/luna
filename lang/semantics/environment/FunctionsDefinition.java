package lang.semantics.environment;

import lang.semantics.types.SType;

import java.util.ArrayList;
import java.util.Map;

public class FunctionsDefinition {
    private String name;
    private ArrayList<SType> params;
    private ArrayList<SType> returns;
    private Map<String, SType> symbols;

    public String name() {
        return name;
    }

    public FunctionsDefinition setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<SType> params() {
        return params;
    }

    public FunctionsDefinition setParams(ArrayList<SType> params) {
        this.params = params;
        return this;
    }

    public ArrayList<SType> returns() {
        return returns;
    }

    public FunctionsDefinition setReturns(ArrayList<SType> returns) {
        this.returns = returns;
        return this;
    }
}
