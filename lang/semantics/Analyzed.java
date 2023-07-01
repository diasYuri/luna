package lang.semantics;

import java.util.ArrayList;

public class Analyzed {
    private ArrayList<String> errors;

    public Analyzed(ArrayList<String> errors) {
        this.errors = errors;
    }

    public void showErrors(){
        for (var error: errors) {
            System.out.println(error);
        }
    };

    public boolean hasError(){return this.errors.size()>0;}
    public ArrayList<String> getErrors(){return this.errors;}
}
