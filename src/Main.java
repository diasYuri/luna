import lexer.Lexer;
import token.TOKEN_TYPE;
import token.Token;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException{
        Lexer lx = new Lexer(new FileReader("test.luna"));
        Token t = lx.nextToken();
        while(t != null){
            System.out.println(t);
            t = lx.nextToken();
        }
        var ta =TOKEN_TYPE.EQ;
        System.out.println("Total de tokens lidos " + lx.numTokens());
    }
}