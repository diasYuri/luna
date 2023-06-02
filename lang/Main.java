package lang;/*
Alunos:
Matheus Pedro Zancanella Barboza - 202035005
Yuri Dias de Azevedo - 201935019
 */

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import lang.interpreter.LunaInterpreter;
import lang.parser.antlr.LunaLangLexer;
import lang.parser.antlr.LunaLangParser;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{
        CharStream input = CharStreams.fromFileName(args[0]);

        LunaLangLexer lexer = new LunaLangLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LunaLangParser parser = new LunaLangParser(tokens);

        ParserRuleContext tree = parser.prog();

        LunaInterpreter interpreter = new LunaInterpreter();

        interpreter.visit(tree);
    }
}