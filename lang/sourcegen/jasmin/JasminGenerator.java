package lang.sourcegen.jasmin;

import lang.parser.antlr.LunaLangBaseVisitor;
import lang.parser.antlr.LunaLangParser;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class JasminGenerator extends LunaLangBaseVisitor<ST> {

    private final STGroup stGroup;

    public JasminGenerator(String filename){
        this.stGroup = new STGroupFile(filename);

    }
    @Override
    public ST visitFunc(LunaLangParser.FuncContext ctx) {
        var st = this.stGroup.getInstanceOf("func");
        st.add("name", ctx.ID().getText());
        st.add("params", ctx.params().accept(this));
        st.add("stmt", ctx.cmd().stream().map(x -> x.accept(this)).toList());
        // st.add("stack", "10");
        // st.add("locals" , "");
        return st;
    }

    @Override
    public ST visitData(LunaLangParser.DataContext ctx) {
        var st = this.stGroup.getInstanceOf("data");
        st.add("name", ctx.ID_DATA().getText());
        st.add("prop", ctx.decl().stream().map(x -> x.accept(this)).toList());
        return st;
    }
}
