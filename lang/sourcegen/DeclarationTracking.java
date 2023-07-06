package lang.sourcegen;

import lang.semantics.types.SType;
import lang.semantics.types.STypeInt;

import java.util.HashMap;
import java.util.Stack;

public class DeclarationTracking {
    private final Stack<HashMap<String, Boolean>> declarationScope = new Stack<>();

    public void newScope(boolean copyCurrent){
        var scope = new HashMap<String, Boolean>();
        if (copyCurrent) scope.putAll(declarationScope.peek());
        declarationScope.push(scope);
    }

    public void popScope(){
        declarationScope.pop();
    }

    public Pair<Boolean, SType> getDeclarationInfo(String name){
        var value = declarationScope.peek().get(name);
        if(value == null) value = false;
        if(!value) declarationScope.peek().put(name, true);
        return new Pair<>(value, STypeInt.getInstance());
    }



}

record Pair<a, b>(a aValue, b bValue){}
