package lang.semantics;

import lang.semantics.helpers.Comparer;
import lang.semantics.types.SType;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionsMap {
    private HashMap<String, ArrayList<FunctionsDefinition>> map = new HashMap<>();

    public FunctionsDefinition get(String name, ArrayList<SType> params){
         var listFunc = map.get(name);
         if(listFunc == null || listFunc.size() == 0){
             return null;
         }
        for (var func: listFunc) {
            if(compareList(func.params(), params)) {
                return func;
            }
        }
        return null;
    }
    public boolean put(String name, ArrayList<SType> params, ArrayList<SType> returns){
        var funcDef = new FunctionsDefinition()
                .setName(name)
                .setParams(params)
                .setReturns(returns);

        var list = map.get(name);
        if(list == null){
            list = new ArrayList<>();
            map.put(name, list);
        }
        return put(funcDef, list);
    }

    private boolean put(FunctionsDefinition funDef, ArrayList<FunctionsDefinition> list){
        for (var def: list) {
            var sameName = funDef.name().equals(def.name());
            var sameParams = compareList(funDef.params(), def.params());
            if(sameParams && sameName) return false;
        }
        list.add(funDef);
        return true;
    }

    private boolean compareList(ArrayList a, ArrayList b){
        return Comparer.ListCompare(a, b);
    }
}

class FunctionsDefinition{
    private String name;

    private ArrayList<SType> params;
    private ArrayList<SType> returns;

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