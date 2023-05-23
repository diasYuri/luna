package src.Interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Environment {
    private final Stack<Object> operands = new Stack<>();
    private final Stack<HashMap<String, Pointer>> scopeStack = new Stack<>();


    public void attributeVar(String name, Object value){
        var currentScope = this.currentScope();
        var pointer = currentScope.get(name);
        if(pointer == null){
            currentScope().put(name, new Pointer(name, value));
        }else{
            pointer.setValue(value);
        }
    }

    public void newScope(){
        scopeStack.push(new HashMap<>());
    }

    public void endCurrentScope(){
        scopeStack.pop();
    }

    private HashMap<String, Pointer> currentScope(){
        return scopeStack.peek();
    }
}
