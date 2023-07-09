package lang.sourcegen;

import lang.helpers.FuncHelper;
import lang.parser.antlr.LunaLangParser;
import lang.semantics.environment.SEnvironment;
import lang.semantics.environment.SScope;
import lang.semantics.types.SType;

import java.util.HashMap;
import java.util.Stack;

public class DeclarationTracking {
    private final Stack<HashMap<String, Boolean>> declarationScope = new Stack<>();
    private final SEnvironment env;
    private SScope currentScope;
    private Stack<Integer> currentCountBlockScope = new Stack<>();

    public DeclarationTracking(SEnvironment env) {
        this.env = env;
    }

    public void entryFuncScope(LunaLangParser.FuncContext ctx){
        var funcName = FuncHelper.getName(ctx);
        this.currentScope = this.env.getFuncScope(funcName);
        this.currentCountBlockScope.clear();
        this.currentCountBlockScope.push(0);
        declarationScope.clear();
        declarationScope.push(new HashMap<>());
    }

    public void newBlockScope(){
        var scope = new HashMap<>(declarationScope.peek());
        declarationScope.push(scope);

        var currentBlock = this.currentCountBlockScope.pop();
        this.currentScope = this.currentScope.getScopeBlockBy(currentBlock);
        this.currentCountBlockScope.push(currentBlock+1);
        this.currentCountBlockScope.push(0);
    }

    public void popBlockScope(){
        this.declarationScope.pop();
        this.currentCountBlockScope.pop();
        this.currentScope = this.currentScope.getParent();
    }

    public Pair<Boolean, SType> getDeclarationInfo(String name){
        var value = declarationScope.peek().get(name);
        if(value == null) value = false;
        if(!value) declarationScope.peek().put(name, true);
        var type = this.currentScope.get(name);
        return new Pair<>(value, type);
    }
}
