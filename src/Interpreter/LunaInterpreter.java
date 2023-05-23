package src.Interpreter;

import src.parser.LunaLangBaseVisitor;
import src.parser.LunaLangParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LunaInterpreter extends LunaLangBaseVisitor<Object> {
    private final HashMap<String, LunaLangParser.FuncContext> funcs = new HashMap<>();
    private final Stack<Object> operands = new Stack<>();
    private final Environment env = new Environment();

    @Override
    public Object visitExp(LunaLangParser.ExpContext ctx) {
        return super.visitExp(ctx);
    }

    @Override
    public Object visitProg(LunaLangParser.ProgContext ctx) {
        LunaLangParser.FuncContext main = null;

        for(var func : ctx.func()){
            String funcName = func.ID().getText();

            funcs.put(funcName, func);

            if(funcName.equals("main")){
                main = func;
            }
        }
        if(main == null){
            throw new RuntimeException( "Não há uma função chamada inicio ! abortando ! ");
        }

        env.newScope();
        return main.accept(this);
    }

    @Override
    public Object visitCallValue(LunaLangParser.CallValueContext ctx) {
        String funcName = ctx.ID().getText();
        if(!funcs.containsKey(funcName)){
            throw new RuntimeException("A função "+funcName+" não foi declarada.");
        }

        ctx.offset.accept(this);
        var offset = (Integer)operands.pop();
        if(offset == null){
            throw new RuntimeException("Offset undefined");
        }

        if(ctx.parameters != null){
            ctx.parameters.accept(this);
            var params = (ArrayList)operands.pop();
            for(var param: params){
                operands.push(param);
            }
        }

        env.newScope();
        funcs.get(funcName).accept(this);
        env.endCurrentScope();

        var response = (ArrayList)operands.pop();
        if(response == null){
            throw new RuntimeException("Response undefined");
        }

        var value = response.get(offset);
        operands.push(value);
        return value;
    }

    @Override
    public Object visitFunc(LunaLangParser.FuncContext ctx) {
        if(ctx.params() != null){
            ctx.params().accept(this);
            var params = (ArrayList)operands.pop();
            for (int i = params.size()-1; i >= 0; i--) {
                var varName = ((Parameter)params.get(i)).name();
                var value = operands.pop();
                env.attributeVar(varName, value);
            }
        }

        return super.visitFunc(ctx);
    }

    @Override
    public Object visitParams(LunaLangParser.ParamsContext ctx) {
        var params = new ArrayList<Parameter>();
        for (int i = 0; i < ctx.ID().size(); i++) {
            params.add(new Parameter(ctx.ID(i).getText(), ctx.type(i).getText()));
        }
        operands.push(params);
        return params;
    }

    @Override
    public Object visitReturn(LunaLangParser.ReturnContext ctx) {
        ctx.exps().accept(this);
        var value = operands.peek();
        return value;
    }

    @Override
    public Object visitIterate(LunaLangParser.IterateContext ctx) {
        ctx.exp().accept(this);
        var valueIterate = (Integer)operands.pop();
        for (int i = 0; i < valueIterate; i++) {
            env.newTemporaryScope();
            ctx.cmd().accept(this);
            env.endCurrentScope();
        }
        return null;
    }

    @Override
    public Object visitExps(LunaLangParser.ExpsContext ctx) {
        var exps = ctx.exp();
        var arrayList = new ArrayList<>();

        for (var exp: exps) {
            exp.accept(this);
            var result = operands.pop();
            arrayList.add(result);
        }

        operands.push(arrayList);
        return arrayList;
    }

    @Override
    public Object visitPrint(LunaLangParser.PrintContext ctx) {
        ctx.exp().accept(this);
        var value = operands.pop();
        System.out.println(value);
        return null;
    }

    @Override
    public Object visitAdd(LunaLangParser.AddContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);

        var valueRight = (Number)operands.pop();
        var valueLeft = (Number)operands.pop();

        if(valueRight instanceof Float || valueLeft instanceof Float){
            Float resultValue = valueLeft.floatValue() + valueRight.floatValue();
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = valueLeft.intValue() + valueRight.intValue();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitSub(LunaLangParser.SubContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);

        var valueRight = (Number)operands.pop();
        var valueLeft = (Number)operands.pop();

        if(valueRight instanceof Float || valueLeft instanceof Float){
            Float resultValue = valueLeft.floatValue() - valueRight.floatValue();
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = valueLeft.intValue() - valueRight.intValue();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitMult(LunaLangParser.MultContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);

        var valueRight = (Number)operands.pop();
        var valueLeft = (Number)operands.pop();

        if(valueRight instanceof Float || valueLeft instanceof Float){
            Float resultValue = valueLeft.floatValue() * valueRight.floatValue();
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = valueLeft.intValue() * valueRight.intValue();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitDiv(LunaLangParser.DivContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);

        var valueRight = (Number)operands.pop();
        var valueLeft = (Number)operands.pop();

        if(valueRight instanceof Float || valueLeft instanceof Float){
            Float resultValue = valueLeft.floatValue() / valueRight.floatValue();
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = valueLeft.intValue() / valueRight.intValue();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitMod(LunaLangParser.ModContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);

        var valueRight = (Number)operands.pop();
        var valueLeft = (Number)operands.pop();

        if(valueRight instanceof Float || valueLeft instanceof Float){
            Float resultValue = valueLeft.floatValue() % valueRight.floatValue();
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = valueLeft.intValue() % valueRight.intValue();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitAttr(LunaLangParser.AttrContext ctx) {
        ctx.lvalue().accept(this);
        var objPointer = operands.pop();

        ctx.exp().accept(this);
        var value = operands.pop();

        if(objPointer instanceof Pointer pointer){
            pointer.setValue(value);
            env.attributePointer(pointer);
        }

        return value;
    }

    @Override
    public Object visitLvalue_id(LunaLangParser.Lvalue_idContext ctx) {
        var name = ctx.ID().getText();
        var pointer = env.getPointer(name);
        operands.push(pointer);
        return pointer;

    }

    @Override
    public Object visitPexp_lvalue(LunaLangParser.Pexp_lvalueContext ctx) {
        ctx.lvalue().accept(this);
        var pointer = (Pointer)operands.pop();
        operands.push(pointer.value());
        return pointer.value();
    }

    @Override
    public Object visitMinusexp(LunaLangParser.MinusexpContext ctx) {
        ctx.sexp().accept(this);
        var value = (Number)operands.pop();

        if(value instanceof Float valuef){
            Float resultValue = valuef * -1;
            operands.push(resultValue);
            return resultValue;
        }

        Integer resultValue = value.intValue() * -1;
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitNexp(LunaLangParser.NexpContext ctx) {
        ctx.sexp().accept(this);
        var value = !(Boolean)operands.pop();
        operands.push(value);
        return value;
    }

    @Override
    public Object visitInt(LunaLangParser.IntContext ctx) {
        String valueStr = ctx.INT().getText();
        Integer value = Integer.parseInt(valueStr);
        operands.push(value);
        return value;
    }

    @Override
    public Object visitFloat(LunaLangParser.FloatContext ctx) {
        String valueStr = ctx.FLOAT().getText();
        Float value = Float.parseFloat(valueStr);
        operands.push(value);
        return value;
    }

    @Override
    public Object visitTrue(LunaLangParser.TrueContext ctx) {
        Boolean value = true;
        operands.push(value);
        return value;
    }

    @Override
    public Object visitFalse(LunaLangParser.FalseContext ctx) {
        Boolean value = false;
        operands.push(value);
        return value;
    }
}
