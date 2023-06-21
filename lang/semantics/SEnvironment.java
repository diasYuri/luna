package lang.semantics;

import lang.semantics.types.SType;
import lang.semantics.types.STypeUndeclared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SEnvironment {
    private Stack<StackScope> stack = new Stack<>();

    public void attribute(String id, SType type){
        stack.peek().attribute(id, type);
    }

    public void attribute(STypeUndeclared untyped, SType type){
        stack.peek().attribute(untyped.getId(), type);
    }

    public SType get(String id){
        return stack.peek().get(id);
    }

    public void pushScope(){
        stack.push(new StackScope());
    }
    public void popScope(){
        stack.pop();
    }
    public void increaseLevel(){
        stack.peek().increaseLevel();
    }
    public void popLevel(){
        stack.peek().popLevel();
    }

    public void printEnv(){
        System.out.println(stack.toString());
    }
}


class StackScope{
    private int level = 0;
    private ArrayList<HashMap<String, SType>> stack = new ArrayList<>();

    public StackScope() {
        stack.add(new HashMap<>());
    }

    public SType get(String id){
        for(var i = level; i>=0; i--){
            var map = stack.get(i);
            var value = map.get(id);
            if(value != null) return value;
        }
        return null;
    }

    public void attribute(String id, SType type){
        stack.get(level).put(id, type);
    }

    public void attribute(STypeUndeclared untyped, SType type){
        stack.get(level).replace(untyped.getId(), type);
    }

    public void increaseLevel(){
        this.level++;
        this.stack.add(new HashMap<>());
    }

    public void popLevel(){
        this.stack.remove(this.level);
        this.level--;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
