package lang.semantics;

import lang.semantics.environment.SEnvironment;
import lang.semantics.types.SType;

import java.util.ArrayList;
import java.util.HashMap;

public record Analyzed(ArrayList<String> errors, SEnvironment environment, HashMap<String, SType> callFuncType) {
    public void showErrors(){
        for (var error: errors) {
            System.out.println(error);
        }
    };

    public boolean hasError(){return this.errors.size()>0;}
    public ArrayList<String> getErrors(){return this.errors;}
}
