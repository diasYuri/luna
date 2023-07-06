package lang.sourcegen;

import lang.ast.RootNode;
import lang.helpers.TypeHelper;
import lang.parser.antlr.LunaLangBaseVisitor;
import lang.parser.antlr.LunaLangParser;
import lang.semantics.types.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.PrintStream;


public class SourceGenerator extends LunaLangBaseVisitor<ST> {

    private final STGroup stGroup;
    private final String fileName;
    private final TypeHelper typeHelper;
    private final Environment env;
    private final DeclarationTracking declarationTracking;

    public SourceGenerator(String fileName, String templatePath, Environment env) {
        this.stGroup = new STGroupFile(templatePath);
        this.fileName = fileName;
        this.env = env;
        this.typeHelper = new TypeHelper(env);
        this.declarationTracking = new DeclarationTracking();
    }

    public void generateCode(RootNode root){
        var prog = root.Ctx().accept(this);
        try {
            PrintStream ps = new PrintStream("codegen/out/" + this.fileName + ".cs");
            ps.println(prog.render());

            System.out.println("Saída escrita em code_gen/out/" + this.fileName + ".cs");
        } catch (Exception e) {
            System.out.println("Algum erro ocorreu ao escrever a saída no arquivo:");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ST visitProg(LunaLangParser.ProgContext ctx) {
        ST st = this.stGroup.getInstanceOf("program");
        var funcs = ctx.func().stream().map(x -> x.accept(this)).toList();
        st.add("funcs", funcs);
        return st;
    }

    @Override
    public ST visitFunc(LunaLangParser.FuncContext ctx) {
        declarationTracking.newScope(false);
        try {
            var funcName = ctx.ID().getText();
            //var paramsList = typeHelper.getParams(ctx.params());
            //var funcDefinitions = env.getFunc(funcName, paramsList);

            ST func = this.stGroup.getInstanceOf("func");

            var stmt = ctx.cmd().stream().map(x -> x.accept(this)).toList();

            if(ctx.params() != null){
                var params = ctx.params().accept(this);
                func.add("params", params);
            }

            if(ctx.type() != null && ctx.type().size() > 0){
                var typeReturned = ctx.type().stream().map(x -> x.accept(this)).toList();
                func.add("type", typeReturned);
            }else{
                func.add("type", new ST("void"));
            }

            func.add("name", ctx.ID().getText());
            func.add("stmt", stmt);
            return func;
        }finally {
            declarationTracking.popScope();
        }
    }

    @Override
    public ST visitCmdscope(LunaLangParser.CmdscopeContext ctx) {
        declarationTracking.newScope(true);
        var cmds = ctx.cmd().stream().map(x -> x.accept(this)).toList();
        declarationTracking.popScope();
        var st = this.stGroup.getInstanceOf("scope");
        st.add("stmt", cmds);
        return st;
    }

    @Override
    public ST visitReturn(LunaLangParser.ReturnContext ctx) {
        var st = this.stGroup.getInstanceOf("return");
        if(ctx.exps() != null){
            st.add("expr", ctx.exps().accept(this));
        }
        return st;
    }

    @Override
    public ST visitPrint(LunaLangParser.PrintContext ctx) {
        var st = this.stGroup.getInstanceOf("print");
        st.add("expr", ctx.exp().accept(this));
        return st;
    }

    @Override
    public ST visitRead(LunaLangParser.ReadContext ctx) {
        var val = ctx.lvalue().accept(this);
        var info = this.declarationTracking.getDeclarationInfo(ctx.lvalue().getText());
        var declare = ctx.lvalue() instanceof LunaLangParser.LvalueIdContext && !info.aValue();

        ST st;
        if(declare){
            st = this.stGroup.getInstanceOf("read_decl");
        }else{
            st = this.stGroup.getInstanceOf("read");
        }

        st.add("var", val);
        return st;
    }

    @Override
    public ST visitIterate(LunaLangParser.IterateContext ctx) {
        var st = this.stGroup.getInstanceOf("while");
        st.add("expr", ctx.exp().accept(this));
        st.add("stmt", ctx.cmd().accept(this));
        return st;
    }

    @Override
    public ST visitIf(LunaLangParser.IfContext ctx) {
        var st = this.stGroup.getInstanceOf("if");
        st.add("expr", ctx.exp().accept(this));
        st.add("stmt", ctx.cmd_if.accept(this));
        if(ctx.cmd_else != null){
            st.add("elstmt", ctx.cmd_else.accept(this));
        }
        return st;
    }

    @Override
    public ST visitAttr(LunaLangParser.AttrContext ctx) {
        var name = ctx.lvalue().getText();
        var info = this.declarationTracking.getDeclarationInfo(name);
        var declare = ctx.lvalue() instanceof LunaLangParser.LvalueIdContext && !info.aValue();

        ST st;
        if(declare){
            st = this.stGroup.getInstanceOf("decl_attr");
        }else{
            st = this.stGroup.getInstanceOf("attr");
        }

        st.add("var", ctx.lvalue().accept(this));
        st.add("expr", ctx.exp().accept(this));
        st.add("type", getTypeFrom(info.bValue()));

        return st;
    }

    @Override
    public ST visitCallValue(LunaLangParser.CallValueContext ctx) {
        var st = this.stGroup.getInstanceOf("call_value");
        st.add("name", ctx.ID().getText());
        st.add("args", ctx.parameters.accept(this));
        st.add("offset", ctx.offset.accept(this));
        st.add("type", "TODO");
        return st;
    }

    @Override
    public ST visitNew(LunaLangParser.NewContext ctx) {
        if(ctx.arr_exp == null) return null;
        var st = this.stGroup.getInstanceOf("new_array");
        st.add("type", ctx.type().accept(this));
        st.add("expr", ctx.arr_exp.accept(this));
        return st;
    }

    @Override
    public ST visitTuple(LunaLangParser.TupleContext ctx) {
        var st = this.stGroup.getInstanceOf("tuple");
        st.add("exp", ctx.exp().accept(this));
        return st;
    }

    @Override
    public ST visitExps(LunaLangParser.ExpsContext ctx) {
        var exps = ctx.exp().stream().map(x -> x.accept(this)).toList();
        var st = this.stGroup.getInstanceOf("exps");
        st.add("exp", exps);
        return st;
    }

    @Override
    public ST visitLvalueAccess(LunaLangParser.LvalueAccessContext ctx) {
        var st = this.stGroup.getInstanceOf("exps");
        st.add("type", ctx.lvalue().accept(this));
        st.add("expr", ctx.ID().getText());
        return st;
    }

    @Override
    public ST visitLvalueArr(LunaLangParser.LvalueArrContext ctx) {
        var st = this.stGroup.getInstanceOf("exps");
        st.add("type", ctx.lvalue().accept(this));
        st.add("expr", ctx.exp().accept(this));
        return st;
    }

    @Override
    public ST visitLvalueId(LunaLangParser.LvalueIdContext ctx) {
        return new ST(ctx.ID().getText());
    }

    @Override
    public ST visitAndexp(LunaLangParser.AndexpContext ctx) {
        var st = this.stGroup.getInstanceOf("and_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitLesser_than(LunaLangParser.Lesser_thanContext ctx) {
        var st = this.stGroup.getInstanceOf("lt_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitEquals(LunaLangParser.EqualsContext ctx) {
        var st = this.stGroup.getInstanceOf("equals_expr");
        st.add("left_expr", ctx.l.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitNotequals(LunaLangParser.NotequalsContext ctx) {
        var st = this.stGroup.getInstanceOf("not_expr");
        st.add("left_expr", ctx.l.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitAdd(LunaLangParser.AddContext ctx) {
        var st = this.stGroup.getInstanceOf("add_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitSub(LunaLangParser.SubContext ctx) {
        var st = this.stGroup.getInstanceOf("sub_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitDiv(LunaLangParser.DivContext ctx) {
        var st = this.stGroup.getInstanceOf("div_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitMult(LunaLangParser.MultContext ctx) {
        var st = this.stGroup.getInstanceOf("mul_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitMod(LunaLangParser.ModContext ctx) {
        var st = this.stGroup.getInstanceOf("mod_expr");
        st.add("left_expr", ctx.left.accept(this));
        st.add("right_expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitNexp(LunaLangParser.NexpContext ctx) {
        var st = this.stGroup.getInstanceOf("not_expr");
        st.add("expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitMinusexp(LunaLangParser.MinusexpContext ctx) {
        var st = this.stGroup.getInstanceOf("minus_expr");
        st.add("expr", ctx.right.accept(this));
        return st;
    }

    @Override
    public ST visitTrue(LunaLangParser.TrueContext ctx) {
        return this.stGroup.getInstanceOf("true_value");
    }

    @Override
    public ST visitFalse(LunaLangParser.FalseContext ctx) {
        return this.stGroup.getInstanceOf("false_value");
    }

    @Override
    public ST visitNull(LunaLangParser.NullContext ctx) {
        return this.stGroup.getInstanceOf("null_value");
    }

    @Override
    public ST visitInt(LunaLangParser.IntContext ctx) {
        var st = this.stGroup.getInstanceOf("int_expr");
        st.add("value", ctx.INT().getText());
        return st;
    }

    @Override
    public ST visitFloat(LunaLangParser.FloatContext ctx) {
        var st = this.stGroup.getInstanceOf("float_expr");
        st.add("value", ctx.FLOAT().getText());
        return st;
    }

    @Override
    public ST visitChar(LunaLangParser.CharContext ctx) {
        var st = this.stGroup.getInstanceOf("char_expr");
        st.add("value", ctx.CHAR().getText());
        return st;
    }

    @Override
    public ST visitArrayType(LunaLangParser.ArrayTypeContext ctx) {
        var arrType = this.stGroup.getInstanceOf("array_type");
        arrType.add("type", ctx.type().accept(this));
        return arrType;
    }

    @Override
    public ST visitBtype(LunaLangParser.BtypeContext ctx) {
        if(ctx.TYPE_INT() != null){
            return this.stGroup.getInstanceOf("int_type");
        }
        if(ctx.TYPE_FLOAT() != null){
            return this.stGroup.getInstanceOf("float_type");
        }
        if(ctx.TYPE_BOOL() != null){
            return this.stGroup.getInstanceOf("boolean_type");
        }
        if(ctx.TYPE_CHAR() != null){
            return this.stGroup.getInstanceOf("char_type");
        }
        if(ctx.ID_DATA() != null){
            String id = ctx.ID_DATA().getText();
            return new ST(id);
        }
        return null;
    }

    public ST getTypeFrom(SType type) {
        if(type instanceof STypeInt){
            return this.stGroup.getInstanceOf("int_type");
        }
        if(type instanceof STypeFloat){
            return this.stGroup.getInstanceOf("float_type");
        }
        if(type instanceof STypeBoolean){
            return this.stGroup.getInstanceOf("boolean_type");
        }
        if(type instanceof STypeChar){
            return this.stGroup.getInstanceOf("char_type");
        }
        if(type instanceof STypeData sTypeData){
            String id = sTypeData.TypeName();
            return new ST(id);
        }
        return null;
    }
}
