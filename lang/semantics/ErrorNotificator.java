package lang.semantics;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class ErrorNotificator {
    private ArrayList<String> errors = new ArrayList<>();

    public void addError(String error, ParserRuleContext ctx){
        errors.add(String.format(
                        "(linha: %d, coluna: %d) %s",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine(),
                        error));
    }

    public void clear(){
        errors.clear();
    }

    public ArrayList<String> errors() {
        return errors;
    }
}
