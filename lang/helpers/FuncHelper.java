package lang.helpers;

import lang.parser.antlr.LunaLangParser;

public class FuncHelper {
    public static String getName(LunaLangParser.FuncContext ctx){
        return ctx.ID().getText() + "(" + (ctx.params() == null ? "" : ctx.params().getText()) + ")";
    }
}
