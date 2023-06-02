package lang.interpreter.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class LunaRuntimeException extends RuntimeException{

    public LunaRuntimeException(ParserRuleContext ctx, String message) {
        super(String.format(" Linha: %s Coluna: %s - ", ctx.start.getLine(), ctx.start.getCharPositionInLine())+message);
    }

    public static void ThrowIfNull(Object value, ParserRuleContext ctx, String message){
        if(value == null){
            throw new LunaRuntimeException(ctx, message);
        }
    }
}
