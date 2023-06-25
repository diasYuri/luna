package lang.parser;

import lang.ast.RootNode;
import lang.ast.SuperNode;
import lang.parser.antlr.LunaLangLexer;
import lang.parser.antlr.LunaLangParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.IOException;

public class LunaParseAdaptor implements ParseAdaptor{
    @Override
    public SuperNode parseFile(String path) throws IOException {
        CharStream input = CharStreams.fromFileName(path);

        LunaLangLexer lexer = new LunaLangLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LunaLangParser parser = new LunaLangParser(tokens);

        ParserRuleContext tree = parser.prog();

        if(parser.getNumberOfSyntaxErrors() > 0){
            throw new RuntimeException("Erro ao realizar o parser");
        }

        return new RootNode(tree);
    }
}
