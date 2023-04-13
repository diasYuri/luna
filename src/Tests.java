import lexer.Lexer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Tests {
    public static void main(String[] args) {
        try (Stream<Path> paths = Files.walk(Paths.get("./samples/sintaxe/certo/"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(Tests::Test);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Test(Path path)  {
        Lexer lexer = null;
        try {
            lexer = new Lexer(new FileReader(path.toString()));
            for(var token = lexer.nextToken(); token != null; token = lexer.nextToken()){
                //System.out.println(token);
            }
            System.out.println("Total de tokens lidos " + lexer.numTokens());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (RuntimeException e) {
            System.out.println(path.toString());
            throw new RuntimeException(e);
        }
    }
}
