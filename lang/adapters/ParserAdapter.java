package lang.adapters;

import lang.ast.Data;
import lang.ast.Declaration;
import lang.ast.Param;
import lang.ast.Params;
import lang.ast.Return;
import lang.ast.Exps;
import lang.ast.If;
import lang.ast.IfElse;
import lang.ast.Iterate;
import lang.ast.abstracts.Node;
import lang.ast.abstracts.Type;
import lang.ast.Print;
import lang.ast.Read;
import lang.ast.Multi;
import lang.ast.Not;
import lang.ast.Div;
import lang.ast.Eq;
import lang.ast.Expr;

import java.util.List;

import lang.ast.Add;
import lang.ast.And;
import lang.ast.ArrayAccess;
import lang.ast.Attribution;
import lang.ast.CallAttr;
import lang.ast.CallOffSet;
import lang.ast.CmdList;
import lang.ast.LValue;

import lang.ast.Function;
import lang.ast.Program;
import lang.ast.Lt;
import lang.ast.Minus;
import lang.ast.Sub;
import lang.ast.Cmd;
import lang.ast.Mod;
import lang.ast.Null;
import lang.ast.Iterate;
import lang.ast.And;
import lang.parser.antlr.LunaLangParser;

public class ParserAdapter {
    
    public Program mapFrom(LunaLangParser.ProgContext ctx){
        List<Data> dataList = ctx.data().stream().map(this::mapFrom).toList();
        List<Function> functionList = ctx.func().stream().map(this::mapFrom).toList();
        return new Program(ctx.start.getLine(), ctx.start.getCharPositionInLine(), dataList, functionList);
    }

    public Data mapFrom(LunaLangParser.DataContext ctx){
        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();
        var declarations = ctx.decl().stream().map(this::mapFrom).toList();
        var id = ctx.ID_DATA().getText();
        return new Data(l, c, id, declarations);
    }

    public Declaration mapFrom(LunaLangParser.DeclContext ctx){
        var type = mapFrom(ctx.type());
        var id = ctx.ID().getText();
        return new Declaration(ctx.start.getLine(), ctx.start.getCharPositionInLine(), id, type);
    }

    public CallAttr mapFrom(LunaLangParser.Call_attrContext ctx){
        String funcName = ctx.ID().getText();
        var params = mapFrom(ctx.parameters);
        List<LValue> lValues = ctx.lvalue().stream().map(this::mapFrom).toList();
        return new CallAttr(ctx.start.getLine(),ctx.start.getCharPositionInLine(),funcName,params,lValues);
    }

    public LValue mapFrom(LunaLangParser.LvalueContext ctx){
        return new LValue(ctx.start.getLine(),ctx.start.getCharPositionInLine(),ctx.getText());

    }
    
    public CallOffSet mapFrom(LunaLangParser.CallValueContext ctx){
        String funcName = ctx.ID().getText();
        Expr expr = mapFrom(ctx.offset);
        var params = mapFrom(ctx.parameters);
        return new CallOffSet(ctx.start.getLine(),ctx.start.getCharPositionInLine(),funcName,params,expr);

    }
    
    
    public Function mapFrom(LunaLangParser.FuncContext ctx){
        var params = mapFrom(ctx.params());
        List<Cmd> commands = ctx.cmd().stream().map(this::mapFrom).toList();
        return new Function(ctx.start.getLine(),ctx.start.getCharPositionInLine(),ctx.getText(),params,commands);
    }

    
    public Params mapFrom(LunaLangParser.ParamsContext ctx){
        var params = new Params(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for (int i = 0; i < ctx.ID().size(); i++) {
            var l = ctx.ID(i).getSymbol().getLine();
            var c = ctx.ID(i).getSymbol().getCharPositionInLine();
            var id = ctx.ID(i).getText();
            var type = ctx.type(i).getText();
            params.addParam(new Param(l, c, id, type));
        }
        return params;
    }
    
    public Expr mapFrom(LunaLangParser.ExpContext ctx){
        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine(); 
        return new Expr(l,c);
    }

        
    public Return mapFrom(LunaLangParser.ReturnContext ctx){
        var exps = mapFrom(ctx.exps());
        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine(); 
        return new Return(l,c,exps);
    }

    public Cmd mapFrom (LunaLangParser.CmdContext ctx){
        var cmd = new Cmd(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        return cmd;
     }


    public CmdList mapfrom(LunaLangParser.CmdscopeContext ctx){
        var cmdList = new CmdList(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for(int i = 0; i < ctx.cmd().size(); i ++){
            var cmd  = new Cmd(ctx.cmd(i).start.getLine(),ctx.start.getCharPositionInLine());
            cmdList.addCmd(cmd);
        }
        return cmdList;
    }
    
    public Iterate mapFrom(LunaLangParser.IterateContext ctx){
        Expr expr = new Expr(ctx.exp().start.getLine(),ctx.exp().start.getCharPositionInLine());
        Cmd cmd = new Cmd(ctx.cmd().start.getLine(),ctx.cmd().start.getCharPositionInLine());
        return new Iterate(ctx.start.getLine(),ctx.start.getCharPositionInLine(),expr,cmd);
    }

    public Exps mapFrom(LunaLangParser.ExpsContext ctx){
        var exps = new Exps(ctx.start.getLine(), ctx.start.getCharPositionInLine());
        for(int i = 0; i < ctx.exp().size(); i ++){
            var l = ctx.exp(i).start.getLine();
            var c = ctx.exp(i).start.getCharPositionInLine();;
            var expr = new Expr(l,c);
            exps.addExpression(expr);
        }
        return exps;
    }

    public IfElse mapFrom(LunaLangParser.IfContext ctx) {
        Expr expr = new Expr(ctx.exp().start.getLine(),ctx.exp().start.getCharPositionInLine());
        Cmd ifBody = new Cmd(ctx.cmd_if.start.getLine(),ctx.cmd_if.start.getCharPositionInLine());
        Cmd elseBody = new Cmd(ctx.cmd_else.start.getLine(),ctx.cmd_else.start.getCharPositionInLine());
        return new IfElse(ctx.start.getLine(), ctx.start.getCharPositionInLine(), expr, ifBody, elseBody);
    }

    public Read mapFrom(LunaLangParser.ReadContext ctx){
        LValue lValue = new LValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.getText());
        Read read = new Read(ctx.start.getLine(),ctx.start.getCharPositionInLine(),lValue);
        return read;
    }


    public Print mapFrom(LunaLangParser.PrintContext ctx){
        var expr = mapFrom(ctx.exp());
        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine(); 
        return new Print(l,c,expr);
    }

    public Add mapFrom(LunaLangParser.AddContext ctx){
        var lf = ctx.left.start.getLine();
        var cf = ctx.left.start.getCharPositionInLine();

        var lr = ctx.right.start.getLine();
        var cr = ctx.right.start.getCharPositionInLine();

        var leftExpr = new Expr(lf,cf);
        var rightExpr = new Expr(lr,cr);

        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();

        return new Add(l,c,leftExpr,rightExpr);

    }

    public Sub mapFrom(LunaLangParser.SubContext ctx){
        var lf = ctx.left.start.getLine();
        var cf = ctx.left.start.getCharPositionInLine();

        var lr = ctx.right.start.getLine();
        var cr = ctx.right.start.getCharPositionInLine();

        var leftExpr = new Expr(lf,cf);
        var rightExpr = new Expr(lr,cr);

        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();

        return new Sub(l,c,leftExpr,rightExpr);

     }

    public Multi mapFrom(LunaLangParser.MultContext ctx){
        var lf = ctx.left.start.getLine();
        var cf = ctx.left.start.getCharPositionInLine();

        var lr = ctx.right.start.getLine();
        var cr = ctx.right.start.getCharPositionInLine();

        var leftExpr = new Expr(lf,cf);
        var rightExpr = new Expr(lr,cr);

        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();

        return new Multi(l,c,leftExpr,rightExpr);

    }
    
    public Div mapFrom(LunaLangParser.DivContext ctx){
        var lf = ctx.left.start.getLine();
        var cf = ctx.left.start.getCharPositionInLine();

        var lr = ctx.right.start.getLine();
        var cr = ctx.right.start.getCharPositionInLine();

        var leftExpr = new Expr(lf,cf);
        var rightExpr = new Expr(lr,cr);

        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();

        return new Div(l,c,leftExpr,rightExpr);

    }


    public Mod mapFrom(LunaLangParser.ModContext ctx){
        var lf = ctx.left.start.getLine();
        var cf = ctx.left.start.getCharPositionInLine();

        var lr = ctx.right.start.getLine();
        var cr = ctx.right.start.getCharPositionInLine();

        var leftExpr = new Expr(lf,cf);
        var rightExpr = new Expr(lr,cr);

        var l = ctx.start.getLine();
        var c = ctx.start.getCharPositionInLine();

        return new Mod(l,c,leftExpr,rightExpr);

    }
    
    public Attribution mapFrom(LunaLangParser.AttrContext ctx){
        LValue lValue = new LValue(ctx.lvalue().start.getLine(),ctx.lvalue().start.getCharPositionInLine(),ctx.lvalue().getText());
        Expr exp = new Expr(ctx.exp().start.getLine(),ctx.exp().start.getCharPositionInLine());
        Attribution attribution = new Attribution(ctx.start.getLine(),ctx.start.getCharPositionInLine(),lValue,exp);
        return attribution;
    }

    public ArrayAccess mapFrom(LunaLangParser.LvalueArrContext ctx){
        Expr expr = new Expr(ctx.exp().start.getLine(),ctx.exp().start.getCharPositionInLine());
        LValue lValue = new LValue(ctx.lvalue().start.getLine(), ctx.lvalue().start.getCharPositionInLine(), ctx.lvalue().getText());
        return new ArrayAccess(ctx.start.getLine(), ctx.start.getCharPositionInLine(), lValue, expr);
    }

    public LValue mapFrom(LunaLangParser.LvalueIdContext ctx){
        LValue lValue = new LValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(),ctx.getText());
        return lValue;
    }

    public LValue mapFrom(LunaLangParser.LvalueAccessContext ctx){
        LValue lValue = new LValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(),ctx.getText());
        return lValue;
    }

    public LValue mapFrom(LunaLangParser.PexpLvalueContext ctx){
        LValue lValue = new LValue(ctx.start.getLine(), ctx.start.getCharPositionInLine(),ctx.getText());
        return lValue;
    }


    public Eq mapFrom(LunaLangParser.EqualsContext ctx){
        Expr left = mapFrom(ctx.l);
        Expr right = mapFrom(ctx.right);
        return new Eq(ctx.start.getLine(),ctx.start.getCharPositionInLine(),left,right);
    }
    

    public Lt mapFrom(LunaLangParser.Lesser_thanContext ctx){
        Expr lExp = new Expr(ctx.left.start.getLine(),ctx.left.start.getCharPositionInLine());
        Expr rExp = new Expr(ctx.right.start.getLine(),ctx.right.start.getCharPositionInLine());
        Lt lt = new Lt(ctx.start.getLine(),ctx.start.getCharPositionInLine(),lExp,rExp);
        return lt;
    }

    public Expr mapFrom(LunaLangParser.RexpContext ctx){
        return new Expr(ctx.start.getLine(),ctx.start.getCharPositionInLine());
    }

    public Expr mapFrom(LunaLangParser.AexpContext ctx){
        return new Expr(ctx.start.getLine(),ctx.start.getCharPositionInLine());
    }

    public And mapFrom(LunaLangParser.AndexpContext ctx){
        Expr lExp = new Expr(ctx.left.start.getLine(),ctx.left.start.getCharPositionInLine());
        Expr rExp = new Expr(ctx.right.start.getLine(),ctx.right.start.getCharPositionInLine());
        And and = new And(ctx.start.getLine(),ctx.start.getCharPositionInLine(),lExp,rExp);
        return and;
    }

    public Minus mapFrom(LunaLangParser.MinusexpContext ctx){
        Expr exp = new Expr(ctx.sexp().start.getLine(),ctx.sexp().start.getCharPositionInLine());
        return new Minus(ctx.start.getLine(),ctx.start.getCharPositionInLine(),exp);
    }


    public Not mapFrom(LunaLangParser.NexpContext ctx){
        Expr exp = new Expr(ctx.sexp().start.getLine(),ctx.sexp().start.getCharPositionInLine());
        return new Not(ctx.start.getLine(),ctx.start.getCharPositionInLine(),exp);
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

    public Null mapFrom(LunaLangParser.NullContext ctx){
        return new Null(ctx.start.getLine(),ctx.start.getCharPositionInLine());
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
        if(ctx.ID_DATA() != null){
            return new BTypeId(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.ID_DATA().getText());
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