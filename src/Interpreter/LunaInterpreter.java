package src.Interpreter;

import src.exceptions.LunaRuntimeException;
import src.parser.LunaLangBaseVisitor;
import src.parser.LunaLangParser;
import src.types.*;
import src.types.descriptor.DataTypeDescriptor;
import src.types.descriptor.PrimitiveTypeDescriptor;
import src.types.descriptor.TypeDescriptor;
import src.types.pointers.ArrayPointer;
import src.types.pointers.Pointer;
import src.types.pointers.RefPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class LunaInterpreter extends LunaLangBaseVisitor<Object> {
    private final HashMap<String, LunaLangParser.FuncContext> funcs = new HashMap<>();
    private final HashMap<String, HashMap<String, Class>> dataDefinitions = new HashMap<>();
    private final Stack<Object> operands = new Stack<>();
    private final Environment env = new Environment();

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
        for(var data : ctx.data()){
            dataDefinitions.put(data.ID().getText(), new HashMap<>());
        }
        for(var data : ctx.data()){
            data.accept(this);
        }
        if(main == null){
            throw new RuntimeException( "Não há uma função chamada inicio ! abortando ! ");
        }

        env.newScope();
        return main.accept(this);
    }

    @Override
    public Object visitData(LunaLangParser.DataContext ctx) {
        String dataName = ctx.ID().getText();
        HashMap<String, Class> dataDefinition = dataDefinitions.get(dataName);
        for(var decl: ctx.decl()){
            decl.type().accept(this);
            TypeDescriptor descriptor = (TypeDescriptor)operands.pop();
            String propName = decl.ID().getText();
            dataDefinition.put(propName, descriptor.getType());
        }
        return null;
    }

    @Override
    public Object visitCall_attr(LunaLangParser.Call_attrContext ctx) {
        String funcName = ctx.ID().getText();
        if(!funcs.containsKey(funcName)){
            throw new RuntimeException("A função "+funcName+" não foi declarada.");
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

        if(ctx.lvalue() != null){
            var response = (ArrayList)operands.pop();
            for (int i = 0; i < ctx.lvalue().size(); i++) {
                ctx.lvalue(i).accept(this);
                Pointer pointer = (Pointer)operands.pop();
                pointer.setValue(response.get(i));
            }
        }
        return null;
    }

    @Override
    public Object visitCallValue(LunaLangParser.CallValueContext ctx) {
        String funcName = ctx.ID().getText();
        if(!funcs.containsKey(funcName)){
            throw new RuntimeException("A função "+funcName+" não foi declarada.");
        }

        ctx.offset.accept(this);
        var offset = (LunaNumber)operands.pop();
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

        var value = response.get(offset.$int());
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
    public Object visitCmdscope(LunaLangParser.CmdscopeContext ctx) {
        env.newTemporaryScope();
        var result = super.visitCmdscope(ctx);
        env.endCurrentScope();
        return result;
    }

    @Override
    public Object visitIterate(LunaLangParser.IterateContext ctx) {
        ctx.exp().accept(this);
        var valueIterate = (LunaNumber)operands.pop();
        for (int i = 0; i < valueIterate.$int(); i++) {
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
    public Object visitIf(LunaLangParser.IfContext ctx) {
        ctx.exp().accept(this);
        LunaBoolean exp = (LunaBoolean)operands.pop();
        if(exp.value()){
            ctx.cmd_if.accept(this);
        }else{
            if(ctx.cmd_else != null){
                ctx.cmd_else.accept(this);
            }
        }
        return null;
    }

    @Override
    public Object visitRead(LunaLangParser.ReadContext ctx) {
        ctx.lvalue().accept(this);
        Pointer pointer = (Pointer)operands.pop();
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        pointer.setValue(value);
        return null;
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
        var valueRight = (LunaNumber)operands.pop();
        var valueLeft = (LunaNumber)operands.pop();
        LunaNumber resultValue = valueLeft.add(valueRight);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitSub(LunaLangParser.SubContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);
        var valueRight = (LunaNumber)operands.pop();
        var valueLeft = (LunaNumber)operands.pop();
        LunaNumber resultValue = valueLeft.sub(valueRight);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitMult(LunaLangParser.MultContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);
        var valueRight = (LunaNumber)operands.pop();
        var valueLeft = (LunaNumber)operands.pop();
        LunaNumber resultValue = valueLeft.mult(valueRight);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitDiv(LunaLangParser.DivContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);
        var valueRight = (LunaNumber)operands.pop();
        var valueLeft = (LunaNumber)operands.pop();
        LunaNumber resultValue = valueLeft.div(valueRight);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitMod(LunaLangParser.ModContext ctx) {
        ctx.left.accept(this);
        ctx.right.accept(this);
        var valueRight = (LunaNumber)operands.pop();
        var valueLeft = (LunaNumber)operands.pop();
        LunaNumber resultValue = valueLeft.mod(valueRight);
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
        }

        return value;
    }

    @Override
    public Object visitLvalueArr(LunaLangParser.LvalueArrContext ctx) {
        ctx.exp().accept(this);
        LunaNumber value = (LunaNumber)operands.pop();
        ctx.lvalue().accept(this);
        Pointer pointer = (Pointer)operands.pop();
        var arr = (Object[])pointer.getValue();
        ArrayPointer arrPointer = new ArrayPointer(arr, value.$int());
        operands.push(arrPointer);
        return arrPointer;
    }

    @Override
    public Object visitLvalueId(LunaLangParser.LvalueIdContext ctx) {
        var name = ctx.ID().getText();
        var pointer = env.getPointer(name);
        operands.push(pointer);
        return pointer;
    }

    @Override
    public Object visitLvalueAccess(LunaLangParser.LvalueAccessContext ctx) {
        ctx.lvalue().accept(this);
        Pointer pointer = (Pointer)operands.pop();
        LunaData data = (LunaData)pointer.getValue();
        String propName = ctx.ID().getText();
        RefPointer propPointer = data.getProperty(propName);
        LunaRuntimeException.ThrowIfNull(propPointer, String.format("The %s property has not been set", propName));
        operands.push(propPointer);
        return propPointer;
    }

    @Override
    public Object visitPexpLvalue(LunaLangParser.PexpLvalueContext ctx) {
        ctx.lvalue().accept(this);
        var pointer = (Pointer)operands.pop();
        operands.push(pointer.getValue());
        return pointer.getValue();
    }

    @Override
    public Object visitEquals(LunaLangParser.EqualsContext ctx) {
        return super.visitEquals(ctx);
    }

    @Override
    public Object visitLesser_than(LunaLangParser.Lesser_thanContext ctx) {
        ctx.left.accept(this);
        var lvalue = (LunaComparable)operands.pop();
        ctx.right.accept(this);
        var rvalue = (LunaComparable)operands.pop();

        LunaBoolean resultValue = lvalue.lt(rvalue);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitAndexp(LunaLangParser.AndexpContext ctx) {
        ctx.left.accept(this);
        var lvalue = (LunaBoolean)operands.pop();

        ctx.right.accept(this);
        var rvalue = (LunaBoolean)operands.pop();

        var resultValue = lvalue.and(rvalue);
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitMinusexp(LunaLangParser.MinusexpContext ctx) {
        ctx.sexp().accept(this);
        var value = (LunaNumber)operands.pop();
        LunaNumber resultValue = value.minus();
        operands.push(resultValue);
        return resultValue;
    }

    @Override
    public Object visitNexp(LunaLangParser.NexpContext ctx) {
        ctx.sexp().accept(this);
        var value = ((LunaBoolean)operands.pop()).neg();
        operands.push(value);
        return value;
    }

    @Override
    public Object visitInt(LunaLangParser.IntContext ctx) {
        String valueStr = ctx.INT().getText();
        Integer value = Integer.parseInt(valueStr);
        operands.push(new LunaInteger(value));
        return value;
    }

    @Override
    public Object visitFloat(LunaLangParser.FloatContext ctx) {
        String valueStr = ctx.FLOAT().getText();
        Float value = Float.parseFloat(valueStr);
        operands.push(new LunaFloat(value));
        return value;
    }

    @Override
    public Object visitTrue(LunaLangParser.TrueContext ctx) {
        LunaBoolean value = LunaBoolean.$true();
        operands.push(value);
        return value;
    }

    @Override
    public Object visitFalse(LunaLangParser.FalseContext ctx) {
        LunaBoolean value = LunaBoolean.$false();
        operands.push(value);
        return value;
    }

    @Override
    public Object visitChar(LunaLangParser.CharContext ctx) {
        LunaChar value = LunaChar.parse(ctx.CHAR().getText());
        operands.push(value);
        return value;
    }

    @Override
    public Object visitNew(LunaLangParser.NewContext ctx)  {
        try{
            ctx.type().accept(this);
            TypeDescriptor type = (TypeDescriptor)operands.pop();
            Object instance;
            if(ctx.exp() != null){
                ctx.exp().accept(this);
                LunaNumber size = (LunaNumber)operands.pop();
                instance = type.newArrInstance(size.$int());
            }
            else {
               instance = type.newInstance();
            }
            operands.push(instance);
            return instance;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Object visitArrayType(LunaLangParser.ArrayTypeContext ctx) {
        ctx.type().accept(this);
        ((TypeDescriptor)operands.peek()).convertInArrayType();
        return operands.peek();
    }

    @Override
    public Object visitBtype(LunaLangParser.BtypeContext ctx) {
        if(ctx.TYPE_INT() != null){
            operands.push(new PrimitiveTypeDescriptor(LunaInteger.class));
        }
        if(ctx.TYPE_FLOAT() != null){
            operands.push(new PrimitiveTypeDescriptor(LunaFloat.class));
        }
        if(ctx.TYPE_BOOL() != null){
            operands.push(new PrimitiveTypeDescriptor(LunaBoolean.class));
        }
        if(ctx.TYPE_CHAR() != null){
            operands.push(new PrimitiveTypeDescriptor(LunaChar.class));
        }
        if(ctx.ID() != null){
            String id = ctx.ID().getText();
            var descriptor = dataDefinitions.get(id);
            if(descriptor == null){
                throw new RuntimeException(String.format("the type %s has not been defined", id));
            }
            operands.push(new DataTypeDescriptor(id, descriptor));
        }
        return null;
    }
}
