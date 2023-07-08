package lang.semantics.environment;
import lang.helpers.FuncHelper;
import lang.parser.antlr.LunaLangParser;
import lang.semantics.types.SType;
import lang.semantics.types.STypeUndeclared;

import java.util.HashMap;

public class SEnvironment {
    private final HashMap<String, SScope> funcScope = new HashMap<>();
    private SScope current;

    public void attribute(String id, SType type){
        this.current.attribute(id, type);
    }

    public void attribute(STypeUndeclared untyped, SType type){
        this.current.attribute(untyped.getId(), type);
    }

    public SType get(String id){
        return this.current.get(id);
    }

    public void newScopeFunc(LunaLangParser.FuncContext ctx){
        var scope = new SScope(null, 0);
        this.funcScope.put(FuncHelper.getName(ctx), scope);
        this.current = scope;
    }
    public void popScopeFunc(){
        this.current = null;
    }
    public void increaseLevel(){
        this.current = this.current.newBlockScope();
    }
    public void popLevel(){
        this.current = this.current.popBlockScope();
    }
    public SScope getFuncScope(String name){
        return this.funcScope.get(name);
    }
}
