package lang.semantics;

import lang.ast.RootNode;
import lang.parser.antlr.LunaLangLexer;
import lang.parser.antlr.LunaLangParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import java.io.File;
import java.io.IOException;

public class TypeChecker {
    public static Analyzed check(RootNode root, boolean showError)  {
        var typeAnalyzer = new TypeAnalyzer();
        var result = typeAnalyzer.Analyzer(root.Ctx());
        if(showError) result.showErrors();
        return result;
    }

    public static void batchTest() {
        System.out.println("=== Certos ===");
        allCorrects();

        System.out.println("=== Errados ===");
        allInvalids();
    }
    private static String filler(int n){
        String s = "";
        for(int i =0; i< n; i++){ s += " "; }
        return s;
    }

    private static void allInvalids(){
        var f = new File("testes/semantica/errado/");
        File inst[];
        int flips, flops;
        flips = 0;
        flops = 0;

        try{
            if( f.isDirectory() ){
                String pth;
                inst = f.listFiles();
                for(File s : inst){
                    pth = s.getPath();
                    System.out.print("Testando " + pth + filler(50 -pth.length()) + "[");
                    var result = analyzeFile(s.getPath());
                    if(result.getErrors().size() > 0){
                        System.out.println("  OK  ]");
                        flips++;
                    }else{
                        System.out.println("FALHOU]");
                        result.showErrors();
                        flops++;
                    }
                }
                System.out.println("Total de acertos: " + flips );
                System.out.println("Total de erros: " + flops );
            }else{
                System.out.println("O caminho " + f.getPath() + " não é um diretório ou não existe.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void allCorrects(){
        var f = new File("testes/semantica/certo/");
        File inst[];
        int flips, flops;
        flips = 0;
        flops = 0;

        try{
            if( f.isDirectory() ){
                String pth;
                inst = f.listFiles();
                for(File s : inst){
                    pth = s.getPath();
                    System.out.print("Testando " + pth + filler(50 -pth.length()) + "[");
                    var result = analyzeFile(s.getPath());
                    if(result.getErrors().size() == 0){
                        System.out.println("  OK  ]");
                        flips++;
                    }else{
                        System.out.println("FALHOU]");
                        result.showErrors();
                        flops++;
                    }
                }
                System.out.println("Total de acertos: " + flips );
                System.out.println("Total de erros: " + flops );
            }else{
                System.out.println("O caminho " + f.getPath() + " não é um diretório ou não existe.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static Analyzed analyzeFile(String file) throws IOException {
        CharStream input = CharStreams.fromFileName(file);

        LunaLangLexer lexer = new LunaLangLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        LunaLangParser parser = new LunaLangParser(tokens);

        ParserRuleContext tree = parser.prog();

        var typeAnalyzer = new TypeAnalyzer();

        return typeAnalyzer.Analyzer(tree);
    }
}
