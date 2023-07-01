package lang.sourcegen;

import lang.parser.antlr.LunaLangBaseVisitor;
import lang.parser.antlr.LunaLangParser;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;



public class SourceGenerator extends LunaLangBaseVisitor<ST> {

    private final STGroup stGroup;
    private final String fileName;

    public SourceGenerator(String fileName, String templatePath) {
        this.stGroup = new STGroupFile(templatePath);
        this.fileName = fileName;
    }

    @Override
    public ST visitProg(LunaLangParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public ST visitFunc(LunaLangParser.FuncContext ctx) {
        ST func = this.stGroup.getInstanceOf("func");

        var params = ctx.params().accept(this);
        var typeReturned = ctx.type().stream().map(x -> x.accept(this)).toList();


        func.add("name", ctx.ID().getText());


        return func;
    }
}
