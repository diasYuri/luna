package src.Interpreter;

import src.parser.LunaLangBaseVisitor;
import src.parser.LunaLangParser;

public class LunaInterpreter extends LunaLangBaseVisitor<Object> {
    @Override
    public Object visitExp(LunaLangParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Object visitProg(LunaLangParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }
}
