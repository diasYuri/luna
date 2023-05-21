package src.Interpreter;

import src.parser.LunaLangBaseVisitor;
import src.parser.LunaLangParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class LunaInterpreter extends LunaLangBaseVisitor<Object> {
    private final HashMap<String, LunaLangParser.FuncContext> funcs = new HashMap<>();
    private final Stack<Object> operands = new Stack<>();


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
        return main.accept(this);
        //return super.visitProg(ctx);
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

        funcs.get(funcName).accept(this);
        var response = (ArrayList)operands.pop();
        if(response == null){
            throw new RuntimeException("Response undefined");
        }

        var value = response.get(offset);
        operands.push(value);
        return value;
    }

    @Override
    public Object visitReturn(LunaLangParser.ReturnContext ctx) {
        ctx.exps().accept(this);
        var value = operands.peek();
        return value;
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
}
