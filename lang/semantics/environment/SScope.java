package lang.semantics.environment;

import lang.semantics.types.SType;
import lang.semantics.types.STypeUndeclared;

import java.util.ArrayList;
import java.util.HashMap;

public class SScope {
    private final SScope parent;
    private final HashMap<String, SType> scope;
    private final ArrayList<SScope> children;
    private int countChildren;
    private final int level;
    public SScope(SScope parent, int level) {
        this.parent = parent;
        this.scope = new HashMap<>();
        this.children = new ArrayList<>();
        this.countChildren = 0;
        this.level = level;
    }
    public SScope newBlockScope(){
        this.countChildren++;
        var scope = new SScope(this, this.level+1);
        this.children.add(scope);
        return scope;
    }

    public SScope popBlockScope(){
        return this.parent;
    }

    public SType get(String name){
        if(this.scope.containsKey(name)){
            return this.scope.get(name);
        }
        if(this.parent != null){
            return this.parent.get(name);
        }
        return null;
    }

    public void attribute(String id, SType type){
        this.scope.put(id, type);
    }

    public void attribute(STypeUndeclared untyped, SType type){
        this.scope.replace(untyped.getId(), type);
    }

    public SScope getScopeBlockBy(int i){
        if(i<=this.countChildren){
            return this.children.get(i);
        }
        return null;
    }

    public SScope getParent(){return this.parent;}
}
