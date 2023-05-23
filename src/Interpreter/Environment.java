package src.Interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Environment {
    private final Stack<Object> operands = new Stack<>();
    private final Stack<Scope> scopeStack = new Stack<>();
    private final TemporaryScope temporaryScope = new TemporaryScope();

    public Pointer getPointer(String name){
        return currentScope().GetPointer(name);
    }
    public void attributePointer(Pointer pointer){
        currentScope().attributePointer(pointer);
    }
    public void attributeVar(String name, Object value){
        var pointer = this.getPointer(name);
        pointer.setValue(value);
    }

    public void newScope(){
        scopeStack.push(new Scope());
    }

    public void newTemporaryScope(){
        scopeStack.push(temporaryScope.refresh(currentScope()));
    }

    public void endCurrentScope(){
        scopeStack.pop();
    }


    private Scope currentScope(){
        return scopeStack.peek();
    }
}

class TemporaryScope extends Scope {
    private Boolean clear;
    public TemporaryScope() {
        super();
        this.clear = true;
    }
    public TemporaryScope refresh(Scope currentScope){
        if(!this.clear){this.memory.clear();}
        this.memory.putAll(currentScope.memory);
        this.clear = false;
        return this;
    }
}

class Scope {
    protected HashMap<String, Pointer> memory;

    public Scope() {
        this.memory = new HashMap<>();
    }

    public Pointer GetPointer(String name){
        var pointer = memory.get(name);
        if(pointer == null){
            pointer = new Pointer(name);
            attributePointer(pointer);
        }
        return pointer;
    }

    public void attributePointer(Pointer pointer){
        memory.put(pointer.name(), pointer);
    }

    public void clear(){
        memory.clear();
    }
}
