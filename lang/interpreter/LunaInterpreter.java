package lang.interpreter;

import lang.ast.RootNode;
import lang.interpreter.exceptions.LunaRuntimeException;
import lang.interpreter.types.*;
import lang.interpreter.types.descriptors.DataTypeDescriptor;
import lang.interpreter.types.descriptors.PrimitiveTypeDescriptor;
import lang.interpreter.types.descriptors.TypeDescriptor;
import lang.interpreter.types.pointers.ArrayPointer;
import lang.interpreter.types.pointers.Pointer;
import lang.interpreter.types.pointers.RefPointer;
import lang.parser.antlr.LunaLangBaseVisitor;
import lang.parser.antlr.LunaLangParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class LunaInterpreter extends LunaLangBaseVisitor<Object> {
    private final HashMap<String, LunaLangParser.FuncContext> funcs = new HashMap<>();
    private final HashMap<String, HashMap<String, Class>> dataDefinitions = new HashMap<>();
    private final Stack<Object> operands = new Stack<>();
    private final Environment env = new Environment();
    private final ContextSignal returnContextSignal = new ContextSignal();

    public void interpreter(RootNode root){
        this.visit(root.Ctx());
    }

    @Override
    public Object visitProg(LunaLangParser.ProgContext ctx) {
        try {
            LunaLangParser.FuncContext main = null;
            for(var func : ctx.func()){
                String funcName = func.ID().getText();

                funcs.put(funcName, func);

                if(funcName.equals("main")){
                    main = func;
                }
            }
            for(var data : ctx.data()){
                dataDefinitions.put(data.ID_DATA().getText(), new HashMap<>());
            }
            for(var data : ctx.data()){
                data.accept(this);
            }
            if(main == null){
                throw new RuntimeException( "Não há uma função chamada inicio ! abortando ! ");
            }

            env.newScope();
            return main.accept(this);
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitData(LunaLangParser.DataContext ctx) {
        try {
            String dataName = ctx.ID_DATA().getText();
            HashMap<String, Class> dataDefinition = dataDefinitions.get(dataName);
            for(var decl: ctx.decl()){
                decl.type().accept(this);
                TypeDescriptor descriptor = (TypeDescriptor)operands.pop();
                String propName = decl.ID().getText();
                dataDefinition.put(propName, descriptor.getType());
            }
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitCall_attr(LunaLangParser.Call_attrContext ctx) {
        try {
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

            if(ctx.lvalue() != null && ctx.lvalue().size()>0){
                var response = (ArrayList)operands.pop();
                for (int i = 0; i < ctx.lvalue().size(); i++) {
                    ctx.lvalue(i).accept(this);
                    Pointer pointer = (Pointer)operands.pop();
                    pointer.setValue(response.get(i));
                }
            }
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitCallValue(LunaLangParser.CallValueContext ctx) {
        try {
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
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitFunc(LunaLangParser.FuncContext ctx) {
        try {
            if(ctx.params() != null){
                ctx.params().accept(this);
                var params = (ArrayList)operands.pop();
                for (int i = params.size()-1; i >= 0; i--) {
                    var varName = ((Parameter)params.get(i)).name();
                    var value = operands.pop();
                    env.attributeVar(varName, value);
                }
            }


            for(var cmd : ctx.cmd()){
                cmd.accept(this);
                if(returnContextSignal.listingSignal(true)) {
                    break;
                }
            }
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitParams(LunaLangParser.ParamsContext ctx) {
        try {
            var params = new ArrayList<Parameter>();
            for (int i = 0; i < ctx.ID().size(); i++) {
                params.add(new Parameter(ctx.ID(i).getText(), ctx.type(i).getText()));
            }
            operands.push(params);
            return params;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitReturn(LunaLangParser.ReturnContext ctx) {
        try {
            ctx.exps().accept(this);
            var value = operands.peek();
            returnContextSignal.emitSignal();
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitCmdscope(LunaLangParser.CmdscopeContext ctx) {
        try {
            env.newTemporaryScope();
            for(var cmd : ctx.cmd()){
                cmd.accept(this);
                if(returnContextSignal.listingSignal(false)) {
                    break;
                }
            }
            env.endCurrentScope();
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitIterate(LunaLangParser.IterateContext ctx) {
        try {
            ctx.exp().accept(this);
            var valueIterate = (LunaNumber)operands.pop();
            for (int i = 0; i < valueIterate.$int(); i++) {
                env.newTemporaryScope();
                ctx.cmd().accept(this);
                env.endCurrentScope();
            }
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitExps(LunaLangParser.ExpsContext ctx) {
        try {
            var exps = ctx.exp();
            var arrayList = new ArrayList<>();

            for (var exp: exps) {
                exp.accept(this);
                var result = operands.pop();
                arrayList.add(result);
            }

            operands.push(arrayList);
            return arrayList;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitIf(LunaLangParser.IfContext ctx) {
        try {
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
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitRead(LunaLangParser.ReadContext ctx) {
        try {
            ctx.lvalue().accept(this);
            Pointer pointer = (Pointer)operands.pop();
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            pointer.setValue(value);
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitPrint(LunaLangParser.PrintContext ctx) {
        try {
            ctx.exp().accept(this);
            var value = operands.pop();
            if(true) throw new RuntimeException("deu merda");
            System.out.println(value);
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitAdd(LunaLangParser.AddContext ctx) {
        try {
            ctx.left.accept(this);
            ctx.right.accept(this);
            var valueRight = (LunaNumber)operands.pop();
            var valueLeft = (LunaNumber)operands.pop();
            LunaNumber resultValue = valueLeft.add(valueRight);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitSub(LunaLangParser.SubContext ctx) {
        try {
            ctx.left.accept(this);
            ctx.right.accept(this);
            var valueRight = (LunaNumber)operands.pop();
            var valueLeft = (LunaNumber)operands.pop();
            LunaNumber resultValue = valueLeft.sub(valueRight);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitMult(LunaLangParser.MultContext ctx) {
        try {
            ctx.left.accept(this);
            ctx.right.accept(this);
            var valueRight = (LunaNumber)operands.pop();
            var valueLeft = (LunaNumber)operands.pop();
            LunaNumber resultValue = valueLeft.mult(valueRight);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitDiv(LunaLangParser.DivContext ctx) {
        try {
            ctx.left.accept(this);
            ctx.right.accept(this);
            var valueRight = (LunaNumber)operands.pop();
            var valueLeft = (LunaNumber)operands.pop();
            LunaNumber resultValue = valueLeft.div(valueRight);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitMod(LunaLangParser.ModContext ctx) {
        try {
            ctx.left.accept(this);
            ctx.right.accept(this);
            var valueRight = (LunaNumber)operands.pop();
            var valueLeft = (LunaNumber)operands.pop();
            LunaNumber resultValue = valueLeft.mod(valueRight);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitAttr(LunaLangParser.AttrContext ctx) {
        try {
            ctx.lvalue().accept(this);
            var objPointer = operands.pop();
            ctx.exp().accept(this);
            var value = operands.pop();

            if(objPointer instanceof Pointer pointer){
                pointer.setValue(value);
            }

            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitLvalueArr(LunaLangParser.LvalueArrContext ctx) {
        try {
            ctx.exp().accept(this);
            LunaNumber value = (LunaNumber)operands.pop();
            ctx.lvalue().accept(this);
            Pointer pointer = (Pointer)operands.pop();
            var arr = (Object[])pointer.getValue();
            ArrayPointer arrPointer = new ArrayPointer(arr, value.$int());
            operands.push(arrPointer);
            return arrPointer;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitLvalueId(LunaLangParser.LvalueIdContext ctx) {
        try {
            var name = ctx.ID().getText();
            var pointer = env.getPointer(name);
            operands.push(pointer);
            return pointer;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitLvalueAccess(LunaLangParser.LvalueAccessContext ctx) {
        try {
            ctx.lvalue().accept(this);
            Pointer pointer = (Pointer)operands.pop();
            LunaData data = (LunaData)pointer.getValue();
            String propName = ctx.ID().getText();
            RefPointer propPointer = data.getProperty(propName);
            LunaRuntimeException.ThrowIfNull(propPointer, ctx, String.format("The %s property has not been set", propName));
            operands.push(propPointer);
            return propPointer;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitPexpLvalue(LunaLangParser.PexpLvalueContext ctx) {
        try {
            ctx.lvalue().accept(this);
            var pointer = (Pointer)operands.pop();
            operands.push(pointer.getValue());
            return pointer.getValue();
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitEquals(LunaLangParser.EqualsContext ctx) {
        try {
            ctx.l.accept(this);
            var lvalue = (LunaComparable)operands.pop();
            ctx.right.accept(this);
            var rvalue = (LunaComparable)operands.pop();

            LunaBoolean resultValue = lvalue.equal(rvalue);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitLesser_than(LunaLangParser.Lesser_thanContext ctx) {
        try {
            ctx.left.accept(this);
            var lvalue = (LunaComparable)operands.pop();
            ctx.right.accept(this);
            var rvalue = (LunaComparable)operands.pop();

            LunaBoolean resultValue = lvalue.lt(rvalue);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitAndexp(LunaLangParser.AndexpContext ctx) {
        try {
            ctx.left.accept(this);
            var lvalue = (LunaBoolean)operands.pop();

            ctx.right.accept(this);
            var rvalue = (LunaBoolean)operands.pop();

            var resultValue = lvalue.and(rvalue);
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitMinusexp(LunaLangParser.MinusexpContext ctx) {
        try {
            ctx.sexp().accept(this);
            var value = (LunaNumber)operands.pop();
            LunaNumber resultValue = value.minus();
            operands.push(resultValue);
            return resultValue;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitNexp(LunaLangParser.NexpContext ctx) {
        try {
            ctx.sexp().accept(this);
            var value = ((LunaBoolean)operands.pop()).neg();
            operands.push(value);
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitInt(LunaLangParser.IntContext ctx) {
        try {
            String valueStr = ctx.INT().getText();
            Integer value = Integer.parseInt(valueStr);
            operands.push(new LunaInteger(value));
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitFloat(LunaLangParser.FloatContext ctx) {
        try {
            String valueStr = ctx.FLOAT().getText();
            Float value = Float.parseFloat(valueStr);
            operands.push(new LunaFloat(value));
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitTrue(LunaLangParser.TrueContext ctx) {
        try {
            LunaBoolean value = LunaBoolean.$true();
            operands.push(value);
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitFalse(LunaLangParser.FalseContext ctx) {
        try {
            LunaBoolean value = LunaBoolean.$false();
            operands.push(value);
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitChar(LunaLangParser.CharContext ctx) {
        try {
            LunaChar value = LunaChar.parse(ctx.CHAR().getText());
            operands.push(value);
            return value;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
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
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitArrayType(LunaLangParser.ArrayTypeContext ctx) {
        try {
            ctx.type().accept(this);
            ((TypeDescriptor)operands.peek()).convertInArrayType();
            return operands.peek();
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }


    @Override
    public Object visitBtype(LunaLangParser.BtypeContext ctx) {
        try{
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
            if(ctx.ID_DATA() != null){
                String id = ctx.ID_DATA().getText();
                var descriptor = dataDefinitions.get(id);
                if(descriptor == null){
                    throw new RuntimeException(String.format("the type %s has not been defined", id));
                }
                operands.push(new DataTypeDescriptor(id, descriptor));
            }
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitTuple(LunaLangParser.TupleContext ctx) {
        return super.visitTuple(ctx);
    }

    @Override
    public Object visitNull(LunaLangParser.NullContext ctx) {
        try{
            operands.push(null);
            return null;
        }catch(LunaRuntimeException e){
            throw e;
        }
        catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }
}
