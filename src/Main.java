/*
Alunos:
Matheus Pedro Zancanella Barboza - 202035005
Yuri Dias de Azevedo - 201935019
 */
import lexer.Lexer;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{
        Lexer lexer = new Lexer(new FileReader(args[0]));
        for(var token = lexer.nextToken(); token != null; token = lexer.nextToken()){
            System.out.println(token);
        }
        System.out.println("Total de tokens lidos " + lexer.numTokens());
    }
}