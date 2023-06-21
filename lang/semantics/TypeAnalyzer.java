package lang.semantics;

import lang.interpreter.exceptions.LunaRuntimeException;
import lang.parser.antlr.LunaLangBaseVisitor;
import lang.parser.antlr.LunaLangParser;
import lang.semantics.types.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TypeAnalyzer extends LunaLangBaseVisitor<Object> implements Analyzed {
    private final ErrorNotificator notificator = new ErrorNotificator();
    private final HashMap<String, STypeData> dataDeclarations = new HashMap<>();
    private final FunctionsMap functionsMap = new FunctionsMap();
    private final SEnvironment env = new SEnvironment();
    private final ReturnEnvironment rEnv = new ReturnEnvironment();

    public Analyzed Analyzer(ParserRuleContext root){
        notificator.clear();
        root.accept(this);
        return this;
    }
    public void showErrors(){
        notificator.displayError();
    }

    @Override
    public void showEnvType() {
        env.printEnv();
    }

    public ArrayList<String> getErrors(){
        return notificator.errors();
    }

    @Override
    public Object visitProg(LunaLangParser.ProgContext ctx) {
        for (var data: ctx.data()) {
            declareData(data);
        }
        for (var data: ctx.data()) {
            data.accept(this);
        }
        for (var func: ctx.func()) {
            declareFunc(func);
        }

        if(functionsMap.get("main", null) == null){
            notificator.addError("A função main() não foi definida", ctx);
        }

        for (var func: ctx.func()) {
            func.accept(this);
        }

        return null;
    }

    @Override
    public Object visitFunc(LunaLangParser.FuncContext ctx) {
        env.pushScope();

        var returns = new ArrayList<SType>();
        for (var type : ctx.type()) returns.add((SType) type.accept(this));
        rEnv.pushFunc(returns);

        if(ctx.params() != null){
            for (int i = 0; i < ctx.params().type().size(); i++) {
                var type = (SType)ctx.params().type(i).accept(this);
                var name = ctx.params().ID(i).getText();
                env.attribute(name, type);
            }
        }

        visitCmds(ctx.cmd());

        if(returns.size() > 0 && !rEnv.returned()){
            notificator.addError("A declaração de retorno não foi encontrada", ctx);
        }

        rEnv.popFunc();
        env.popScope();
        return null;
    }

    public void visitCmds(List<LunaLangParser.CmdContext> cmds){
        for(var cmd : cmds){

            cmd.accept(this);

        }
    }

    public void declareFunc(LunaLangParser.FuncContext ctx){
        var name = ctx.ID().getText();
        var params = ctx.params() != null
                ? (ArrayList)ctx.params().accept(this)
                : null;
        var returns = new ArrayList<SType>();
        for (var type : ctx.type()) {
            returns.add((SType) type.accept(this));
        }
        var success = functionsMap.put(name, params, returns);
        if(!success){
            notificator.addError(String.format("A função %s já foi definida", name), ctx);
        }
    }

    @Override
    public Object visitCmdscope(LunaLangParser.CmdscopeContext ctx) {
        env.increaseLevel();
        visitCmds(ctx.cmd());
        env.popLevel();
        return null;
    }

    @Override
    public Object visitCallValue(LunaLangParser.CallValueContext ctx) {
        //valida offset
        var offsetType = (SType)ctx.offset.accept(this);
        if(!(offsetType instanceof STypeInt)){
            notificator.addError("O offset da chamada deve ser do tipo Int", ctx.offset);
        }

        var funcName = ctx.ID().getText();
        var params = ctx.parameters != null
                        ? ctx.parameters.accept(this)
                        : null;
        var func = functionsMap.get(funcName, (ArrayList)params);
        if(func == null){
            notificator.addError(String.format("A função %s(%s) não foi definida", funcName, params), ctx);
        }

        return STypeDynamic.instance();
    }

    @Override
    public Object visitReturn(LunaLangParser.ReturnContext ctx) {
        var types = ctx.exps().accept(this);
        this.rEnv.setReturned(true);
        if(!rEnv.match((ArrayList<SType>) types)){
            notificator.addError(
                    String.format(
                            "O tipo do retorno não bate com o tipo de retorno esperado pela função."),
                    ctx);
        }

        return types;
    }

    @Override
    public Object visitIterate(LunaLangParser.IterateContext ctx) {
        var typeExp = ctx.exp().accept(this);
        if(!(typeExp instanceof STypeInt)){
            notificator.addError("A expressão condicional do iterate deve ser do tipo Int",ctx);
        }
        ctx.cmd().accept(this);
        return null;
    }

    @Override
    public Object visitIf(LunaLangParser.IfContext ctx) {
        var typeExp = (SType) ctx.exp().accept(this);
        if(!(STypeBoolean.getInstance().match(typeExp))){
            notificator.addError("A expressão condicional do if deve ser do tipo Boolean",ctx);
        }

        if(ctx.cmd_if != null){
            ctx.cmd_if.accept(this);
        }

        var returnedStateIf = this.rEnv.returned();
        this.rEnv.setReturned(false);

        if(ctx.cmd_else != null){
            ctx.cmd_else.accept(this);
        }

        this.rEnv.setReturned(returnedStateIf && this.rEnv.returned());

        return null;
    }

    @Override
    public Object visitCall_attr(LunaLangParser.Call_attrContext ctx) {
        var funcName = ctx.ID().getText();
        var params = ctx.parameters != null
                ? ctx.parameters.accept(this)
                : null;
        var func = functionsMap.get(funcName, (ArrayList)params);
        if(func == null){
            notificator.addError(String.format("A função %s(%s) não foi definida", funcName, params), ctx);
            return STypeError.getInstance();
        }

        if(ctx.lvalue() == null) return null;
        var types = new ArrayList<SType>();
        if(func.returns().size() < ctx.lvalue().size()){
            notificator.addError(
                    String.format("A função %s retorna %d valores, impossivel fazer o bind para %d variaveis",
                            funcName, func.returns().size(), ctx.lvalue().size()),
                    ctx);
        }else{
            for(var i=0; i<ctx.lvalue().size(); i++){
                var typePointer = (SType)getLvalue(ctx.lvalue(i));
                var value = func.returns().get(i);
                var type = attribute(typePointer, value, ctx);
                types.add(type);
            }
        }

        return types;
    }

    @Override
    public Object visitExps(LunaLangParser.ExpsContext ctx) {
        var types = new ArrayList<SType>();
        for(var exp: ctx.exp()){
            types.add((SType)exp.accept(this));
        }
        return types;
    }

    public void declareData(LunaLangParser.DataContext ctx){
        final Set<String> reservedTypes = Set.of("Int", "Float", "Char", "Boolean");
        var nameData = ctx.ID_DATA().getText();
        if(reservedTypes.contains(nameData)){
            notificator.addError(String.format("O tipo %s já é um tipo reservado da linguagem", nameData), ctx);
        }
        dataDeclarations.put(nameData, STypeData.Declare(nameData));
    }
    @Override
    public Object visitData(LunaLangParser.DataContext ctx) {
        var nameData = ctx.ID_DATA().getText();
        var dataDeclared = dataDeclarations.get(nameData);

        HashMap<String, SType> dataDescriptor = new HashMap<>();
        for (var decl : ctx.decl()) {
            SType type = (SType)decl.type().accept(this);
            String name = decl.ID().getText();
            dataDescriptor.put(name, type);
        }

        return dataDeclared.AddDataDescriptor(dataDescriptor);
    }

    @Override
    public Object visitDecl(LunaLangParser.DeclContext ctx) {
        SType type = (SType)ctx.type().accept(this);
        env.attribute(ctx.ID().getText(), type);
        return type;
    }

    @Override
    public Object visitAttr(LunaLangParser.AttrContext ctx) {
        var value = (SType)ctx.exp().accept(this);

        var typePointer = (SType)getLvalue(ctx.lvalue());

        return attribute(typePointer, value, ctx);
    }

    public Object getLvalue(LunaLangParser.LvalueContext ctx){
        if(ctx instanceof LunaLangParser.LvalueAccessContext aCtx){
            return aCtx.accept(this);
        }
        if(ctx instanceof LunaLangParser.LvalueArrContext arCtx){
            return arCtx.accept(this);
        }
        if(ctx instanceof LunaLangParser.LvalueIdContext idCtx){
            var id = idCtx.ID().getText();
            var type = env.get(id);
            if(type == null){
                var typeEmpty = new STypeUndeclared(id);
                env.attribute(id, typeEmpty);
                return typeEmpty;
            }
            return type;
        }
        throw new LunaRuntimeException(ctx, "Error");
    }

    public SType attribute(SType typePointer, SType value, ParserRuleContext ctx){
        if(typePointer == null){
            notificator.addError("variável não definida.",ctx);
        }
        else if(value instanceof STypeUndeclared || value == null){
            notificator.addError("erro de atribuição, não é possivel atribuir um valor inválido em uma variável",ctx);
        }
        else if(typePointer instanceof STypeUndeclared untyped){
            env.attribute(untyped, value);
        }
        else if(!value.match(typePointer)){
            notificator.addError(String.format(
                            "Atribuição inválida, não é possivel atribuir o tipo %s em uma variável de tipo %s",
                            value.TypeName(),
                            typePointer.TypeName()), ctx);
            return STypeError.getInstance();
        }

        return value;
    }

    @Override
    public Object visitLvalueId(LunaLangParser.LvalueIdContext ctx) {
        var id = ctx.ID().getText();
        var type = env.get(id);
        if(type == null || type instanceof STypeUndeclared){
            notificator.addError(String.format("A variável %s não foi declarada", id), ctx);
            return STypeError.getInstance();
        }
        return type;
    }

    @Override
    public Object visitLvalueArr(LunaLangParser.LvalueArrContext ctx) {
        var value = ctx.lvalue().accept(this);
        if(value instanceof STypeEmpty empty){
            notificator.addError(String.format("O tipo de %s não foi definido.", empty.name()), ctx);
            return STypeError.getInstance();
        }
        if(!(value instanceof STypeArray sTypeArray)){
            notificator.addError("O tipo não está definido como array, acesso inválido.", ctx);
            return STypeError.getInstance();
        }
        return sTypeArray.type();
    }

    @Override
    public Object visitLvalueAccess(LunaLangParser.LvalueAccessContext ctx) {
        var value = ctx.lvalue().accept(this);
        var id = ctx.ID().getText();

        if(!(value instanceof STypeData data)){
            notificator.addError("O tipo não está definido como Data Type, acesso inválido.", ctx);
            return STypeError.getInstance();
        }

        var memberType = data.getMemberType(id);
        if(memberType == null){
            notificator.addError(String.format("Não existe o membro %s no tipo %s", id, data.TypeName()), ctx);
            return STypeError.getInstance();
        }
        return memberType;
    }

    @Override
    public Object visitNexp(LunaLangParser.NexpContext ctx) {
        var value = (SType)ctx.right.accept(this);
        if(!(value instanceof STypeBoolean)){
            notificator.addError("Operação inválido, o operador (!) só se aplica a tipos booleanos", ctx);
            return STypeError.getInstance();
        }
        return value;
    }

    @Override
    public Object visitMinusexp(LunaLangParser.MinusexpContext ctx) {
        var value = (SType)ctx.right.accept(this);
        if(!(value instanceof STypeInt || value instanceof STypeFloat)){
            notificator.addError("Operação inválido, o operador (-) só se aplica a tipos numericos", ctx);
            return STypeError.getInstance();
        }
        return value;
    }

    @Override
    public Object visitParams(LunaLangParser.ParamsContext ctx) {
        var listTypes = new ArrayList<SType>();
        for (var type: ctx.type()) {
            listTypes.add((SType)type.accept(this));
        }
        return listTypes;
    }

    @Override
    public Object visitTuple(LunaLangParser.TupleContext ctx) {
        return ctx.exp().accept(this);
    }

    @Override
    public Object visitNull(LunaLangParser.NullContext ctx) {return null;}
    @Override
    public Object visitTrue(LunaLangParser.TrueContext ctx) {return STypeBoolean.getInstance();}
    @Override
    public Object visitFalse(LunaLangParser.FalseContext ctx) {return STypeBoolean.getInstance();}
    @Override
    public Object visitFloat(LunaLangParser.FloatContext ctx) {return STypeFloat.getInstance();}
    @Override
    public Object visitInt(LunaLangParser.IntContext ctx) {return STypeInt.getInstance();}
    @Override
    public Object visitChar(LunaLangParser.CharContext ctx) {return STypeChar.getInstance();}

    @Override
    public Object visitArrayType(LunaLangParser.ArrayTypeContext ctx) {
        return new STypeArray((SType)ctx.type().accept(this));
    }

    @Override
    public Object visitBtype(LunaLangParser.BtypeContext ctx) {
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
            var typeData = dataDeclarations.get(id);
            if(typeData == null){
                notificator.addError(String.format("O tipo %s não foi definido", ctx.ID_DATA().getText()), ctx);
                return STypeEmpty.getInstance(id);
            }
            return typeData;
        }

        return STypeError.getInstance();
    }

    @Override
    public Object visitNew(LunaLangParser.NewContext ctx) {
        SType type = (SType)ctx.type().accept(this);
        if(ctx.arr_exp != null){
            ctx.arr_exp.accept(this);
            return new STypeArray(type);
        }
        return type;
    }

    @Override
    public Object visitAndexp(LunaLangParser.AndexpContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);

        if(!(left instanceof STypeBoolean && right instanceof STypeBoolean)){
            notificator.addError("Operação && é inválida, operação só suporta comparação entre booleanos", ctx);
        }

        return left;
    }

    @Override
    public Object visitNotequals(LunaLangParser.NotequalsContext ctx) {
        var left = (SType)ctx.l.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitCompare(ctx, left, right, "!=");
    }

    @Override
    public Object visitEquals(LunaLangParser.EqualsContext ctx) {
        var left = (SType)ctx.l.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitCompare(ctx, left, right, "==");
    }

    @Override
    public Object visitLesser_than(LunaLangParser.Lesser_thanContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitCompare(ctx, left, right, "<");
    }

    public SType visitCompare(ParserRuleContext ctx, SType left, SType right, String compareSymbol){
        try{
            if (!left.match(right)){
                notificator.addError(String.format("Comparação (%s) com tipos incompatíveis", compareSymbol), ctx);
                return STypeError.getInstance();
            }
            return STypeBoolean.getInstance();
        }catch (Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }

    @Override
    public Object visitAdd(LunaLangParser.AddContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitArithmetic(ctx, left, right);
    }
    @Override
    public Object visitSub(LunaLangParser.SubContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitArithmetic(ctx, left, right);
    }
    @Override
    public Object visitMult(LunaLangParser.MultContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitArithmetic(ctx, left, right);
    }
    @Override
    public Object visitDiv(LunaLangParser.DivContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitArithmetic(ctx, left, right);
    }
    @Override
    public Object visitMod(LunaLangParser.ModContext ctx) {
        var left = (SType)ctx.left.accept(this);
        var right = (SType)ctx.right.accept(this);
        return visitArithmetic(ctx, left, right);
    }

    public Object visitArithmetic(ParserRuleContext ctx, SType left, SType right){
        try{
            if(!STypeNumber.match(left, right)){
                notificator.addError(
                        String.format(
                                "Não é possível fazer operações aritméticas entre os tipos: %s %s",
                                left.TypeName(),
                                right.TypeName()), ctx);
            }
            return STypeNumber.arithmeticComputeType(left, right);
        }catch(Exception e){
            throw new LunaRuntimeException(ctx, e.getMessage());
        }
    }
}
