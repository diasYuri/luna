package src.Interpreter;

import src.types.pointers.RefPointer;

import java.util.HashMap;
import java.util.Stack;

public class Environment {
    private final Stack<Object> operands = new Stack<>();
    private final Stack<Scope> scopeStack = new Stack<>();

    public RefPointer getPointer(String name){
        return currentScope().GetPointer(name);
    }
    public void attributeVar(String name, Object value){
        var pointer = this.getPointer(name);
        pointer.setValue(value);
    }

    public void newScope(){
        scopeStack.push(new Scope());
    }

    public void newTemporaryScope(){
        scopeStack.push(TemporaryScope.create(currentScope()));
    }

    public void endCurrentScope(){
        scopeStack.pop();
    }


    private Scope currentScope(){
        return scopeStack.peek();
    }
}

class TemporaryScope extends Scope {
    public TemporaryScope() {
        super();
    }
    public TemporaryScope setContext(Scope currentScope){
        this.memory.clear();
        this.memory.putAll(currentScope.memory);
        return this;
    }

    public static TemporaryScope create(Scope currentScope){
        return new TemporaryScope().setContext(currentScope);
    }
}

class Scope {
    protected HashMap<String, RefPointer> memory;

    public Scope() {
        this.memory = new HashMap<>();
    }

    public RefPointer GetPointer(String name){
        var pointer = memory.get(name);
        if(pointer == null){
            pointer = new RefPointer(name);
            attributePointer(name, pointer);
        }
        return pointer;
    }

    public void attributePointer(String name, RefPointer pointer){
        memory.put(name, pointer);
    }

    public void clear(){
        memory.clear();
    }
}
