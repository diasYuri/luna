package lang.semantics.environment;

import lang.semantics.helpers.Comparer;
import lang.semantics.types.SType;
import java.util.ArrayList;
import java.util.Stack;

public class ReturnEnvironment {
    private Stack<ReturnContext> stack = new Stack<>();
    public void pushFunc(ArrayList<SType> types){
        stack.push(new ReturnContext(types));
    }
    public void popFunc(){
        stack.pop();
    }

    public boolean match(ArrayList<SType> types){
        return Comparer.ListCompare(types, stack.peek().types());
    }
    public void setReturned(boolean value){this.stack.peek().setReturned(value);}
    public boolean returned(){return this.stack.peek().returned();}
}

class ReturnContext {
    private ArrayList<SType> types;
    private boolean returned = false;

    public ReturnContext(ArrayList<SType> types) {
        this.types = types;
    }

    public ArrayList<SType> types() {
        return types;
    }

    public ReturnContext setTypes(ArrayList<SType> types) {
        this.types = types;
        return this;
    }

    public boolean returned() {
        return returned;
    }

    public ReturnContext setReturned(boolean returned) {
        this.returned = returned;
        return this;
    }
}

