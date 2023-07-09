package lang;

import lang.ast.RootNode;
import lang.ast.SuperNode;
import lang.interpreter.LunaInterpreter;
import lang.parser.LunaParseAdaptor;
import lang.parser.ParseAdaptor;
import lang.parser.TestParser;
import lang.semantics.TypeChecker;
import lang.sourcegen.java.SourceGenerator;

public class LangCompiler{
   // Recupera o nome base (sem extensão) de um arquivo.
   public static void main(String[] args){
       if( args.length < 1 ){
          System.out.println("Lang compiler v 0.0.1 - Maio de 2020");
          System.out.println("Use java -cp . Lang ação <Caminho para código Fonte> ");
          System.out.println("Ação (uma das seguintes possibilidades): ");
          
          System.out.println(" -bs : Executa uma bateria de testes sintáticos");
          System.out.println(" -bty : Executa uma bateria de testes no sistemas de tipos");
          System.out.println(" -bsm : Executa uma bateria de testes no interpretador");
          System.out.println(" -bst : Executa uma bateria de testes semanticos");

          System.out.println(" -pp: Pretty print program.");
          System.out.println(" -tp: Verficar tipos e imprimir o ambiente de tipos");
          System.out.println(" -i : Apenas interpretar");


          System.out.println(" -ti: Verificar tipos e depois interpretar");
          System.out.println(" -dti: Verificar tipos, imprimir o ambiente de tipos e depois interpretar");
          System.out.println(" -gvz: Create a dot file. (Feed it to graphviz dot tool to generate graphical representation of the AST)");

          System.out.println(" -g: Gera código Java");
       }

       try{
           ParseAdaptor langParser = new LunaParseAdaptor();
          
          if(args[0].equals("-bs") ){
              System.out.println("Executando bateria de testes sintáticos:");
              TestParser tp = new TestParser(langParser);
              return;
          }if(args[0].equals("-byt") ){
              System.out.println("Executando bateria de testes sintáticos:");
              TestParser tp = new TestParser(langParser); ;
              return;
          } if(args[0].equals("-bsm") ){
              System.out.println("Executando bateria de testes sintáticos:");
              TestParser tp = new TestParser(langParser);
              return;
          }
           if(args[0].equals("-bst") ){
               System.out.println("Executando bateria de testes semanticos:");
               TypeChecker.batchTest();
               return;
           }
          if(args.length != 2){
              System.out.println("Para usar essa opção, especifique um nome de arquivo");
              return; 
          }
          SuperNode result = langParser.parseFile(args[1]);
          if(result == null){
               System.err.println("Aborting due to syntax error(s)");
               System.exit(1);
          }
          else if(args[0].equals("-i") ){
              LunaInterpreter interpreter = new LunaInterpreter();
              interpreter.interpreter((RootNode)result);
          }
          else if(args[0].equals("-ii") ){
            // iv = new InteractiveInterpreterVisitor();
            // result.accept(iv);
          }
          else if(args[0].equals("-tp") ){
              TypeChecker.check((RootNode)result, true);
          }
          else if(args[0].equals("-ti") ){
              var resultAnalyze = TypeChecker.check((RootNode)result, true);
              if(resultAnalyze.hasError()) return;
              LunaInterpreter interpreter = new LunaInterpreter();
              interpreter.interpreter((RootNode)result);
          }
          else if(args[0].equals("-pp") ){
	      // iv = new PPrint();
              //result.accept(iv);
              //((PPrint)iv).print();
          }
          else if(args[0].equals("-g") ){
              String filename = getNameFile(args[1]);
              var analized = TypeChecker.check((RootNode)result, true);
              if(analized.hasError()) return;
              var sg = new SourceGenerator(filename, "lang/sourcegen/templates/java.stg", analized);
              sg.generateCode((RootNode)result);
          }
      }catch(Exception e){
          e.printStackTrace();
      }
   }

   static String getNameFile(String path){
         var parts = path.split("/");
         var name = parts[parts.length - 1];
         return name.substring(0, name.indexOf("."));
   }
}
 
