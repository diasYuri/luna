package lang.sourcegen;

import lang.semantics.types.SType;
import lang.semantics.types.STypeData;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
    private final HashMap<String, STypeData> dataDeclarations;

    public Environment(HashMap<String, STypeData> dataDeclarations) {
        this.dataDeclarations = dataDeclarations;
    }


    public STypeData getData(String nameData){return dataDeclarations.get(nameData);}

    public FunctionDefinition getFunc(String funcName, ArrayList<SType> params) {
        return null;
    }
}

class FunctionDefinition{

}