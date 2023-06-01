package src.adapters;

import src.ast.Data;
import src.ast.Declaration;
import src.ast.abstracts.Node;
import src.ast.abstracts.Type;
import src.parser.antlr.LunaLangParser;

public class ParserAdapter {
    /*public Program mapFrom(LunaLangParser.ProgContext ctx){
        List<Data> dataList = ctx.data().stream().map(this::mapFrom).toList();
        List<Function> functionList = ctx.func().stream().map(this::mapFrom).toList();
        return new Program(ctx.start.getLine(), ctx.start.getCharPositionInLine(), dataList, functionList);
    }*/

    public Data mapFrom(LunaLangParser.DataContext ctx){
        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();
        var declarations = ctx.decl().stream().map(this::mapFrom).toList();
        var id = ctx.ID().getText();
        return new Data(l, c, id, declarations);
    }
    public Declaration mapFrom(LunaLangParser.DeclContext ctx){
        var type = mapFrom(ctx.type());
        var id = ctx.ID().getText();
        return new Declaration(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, type);
    }

    public Type mapFrom(LunaLangParser.TypeContext ctx){
        if(ctx instanceof LunaLangParser.ArrayTypeContext typedCtx){
            return mapFrom(typedCtx);
        }
        if(ctx instanceof LunaLangParser.TypeignoreContext typedCtx){
            return mapFrom(typedCtx);
        }
        throw new RuntimeException();
    }

    public Type mapFrom(LunaLangParser.TypeignoreContext ctx){
        if(ctx.children.get(0) instanceof LunaLangParser.BtypeContext btypeContext){
            return mapFrom(btypeContext);
        }
        throw new RuntimeException();
    }
    public New mapFrom(LunaLangParser.NewContext ctx){
        return new New(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    public ArrayType mapFrom(LunaLangParser.ArrayTypeContext ctx){
        return new ArrayType(ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    public BType mapFrom(LunaLangParser.BtypeContext ctx) {
        if(ctx.TYPE_INT() != null){
            return new BTypeInt(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        if(ctx.TYPE_FLOAT() != null){
            return new BTypeFloat(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        if(ctx.TYPE_BOOL() != null){
            return new BTypeBool(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        if(ctx.TYPE_CHAR() != null){
            return new BTypeChar(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        if(ctx.ID() != null){
            return new BTypeId(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID().getText());
        }
        throw new RuntimeException();
    }
}

class New extends Node {
    public New(int l, int c) {
        super(l, c);
    }
}


class ArrayType extends Type {
    public ArrayType(int l, int c) {
        super(l, c);
    }
}

abstract class BType extends Type {
    public BType(int l, int c) {
        super(l, c);
    }
}
class BTypeInt extends BType {
    public BTypeInt(int l, int c) {
        super(l, c);
    }
}

class BTypeFloat extends BType {
    public BTypeFloat(int l, int c) {
        super(l, c);
    }
}

class BTypeBool extends BType {
    public BTypeBool(int l, int c) {
        super(l, c);
    }
}

class BTypeChar extends BType {
    public BTypeChar(int l, int c) {
        super(l, c);
    }
}

class BTypeId extends BType {
    private String id;
    public BTypeId(int l, int c, String id) {
        super(l, c);
        this.id = id;
    }
}


interface ParserAdapterNode<TContext, TNode>{
    public TNode mapFrom(TContext context);
}