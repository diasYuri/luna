package lang.helpers;

import lang.parser.antlr.LunaLangParser;
import lang.semantics.types.*;
import lang.sourcegen.Environment;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class TypeHelper {
    private final Environment env;

    public TypeHelper(Environment env) {
        this.env = env;
    }

    public ArrayList<SType> getParams(LunaLangParser.ParamsContext ctx) {
        var listTypes = new ArrayList<SType>();
        for (var type: ctx.type()) {
            listTypes.add(getType(type));
        }
        return listTypes;
    }

    public SType getType(ParserRuleContext ctx){
        if(ctx instanceof LunaLangParser.ArrayTypeContext arrCtx){
            return getType(arrCtx);
        }
        if(ctx instanceof LunaLangParser.BtypeContext bCtx){
            return getType(bCtx);
        }
        return null;
    }

    public SType getType(LunaLangParser.ArrayTypeContext ctx) {
        return new STypeArray(getType(ctx.type()));
    }

    public SType getType(LunaLangParser.BtypeContext ctx) {
        if(ctx.TYPE_INT() != null){
            return STypeInt.getInstance();
        }
        if(ctx.TYPE_FLOAT() != null){
            return STypeFloat.getInstance();
        }
        if(ctx.TYPE_BOOL() != null){
            return STypeBoolean.getInstance();
        }
        if(ctx.TYPE_CHAR() != null){
            return STypeChar.getInstance();
        }
        if(ctx.ID_DATA() != null){
            String id = ctx.ID_DATA().getText();
            return env.getData(id);
        }

        return STypeError.getInstance();
    }
}
