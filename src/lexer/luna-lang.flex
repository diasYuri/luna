
package lexer;
import token.Token;
import token.TOKEN_TYPE;
%%

%unicode
%line
%column
%public

%class Lexer

%function nextToken
%type Token


%{
    private int ntk;

    private token.Token token(token.TOKEN_TYPE type) {
        ++ntk;
        return new Token(type, yyline, yycolumn);
    }
    private Token token(TOKEN_TYPE type, String value) {
        ++ntk;
        return new Token(type, value, yyline, yycolumn);
    }

    public int numTokens() { return ntk; }
%}

%init{
    ntk = 0;
%init}


BREAK_LINE  = \r|\n|\r\n
WHITE_SPACE = {BREAK_LINE} | [ \t\f]
NUMBER      = [0]|[1-9][:digit:]*
ID          = [a-zA-Z]+
COMMENT_LINE = "//" (.)* {BREAK_LINE}

%state COMMENT

%%

<YYINITIAL> {
    "{"             { return token(TOKEN_TYPE.LBRACE); }
    "}"             { return token(TOKEN_TYPE.RBRACE); }
    "("             { return token(TOKEN_TYPE.LPAREN); }
    ")"             { return token(TOKEN_TYPE.RPAREN); }
    "="             { return token(TOKEN_TYPE.EQ);   }
    ";"             { return token(TOKEN_TYPE.SEMI); }
    "*"             { return token(TOKEN_TYPE.TIMES);}
    "+"             { return token(TOKEN_TYPE.PLUS); }
    "/*"            { yybegin(COMMENT);               }
    {WHITE_SPACE}   { /* Não faz nada  */             }
    {COMMENT_LINE}  {                                 }
    {ID}            { return token(TOKEN_TYPE.ID, yytext());   }
    {NUMBER}        { return token(TOKEN_TYPE.NUM, yytext());  }
}

<COMMENT>{
   "*/"     { yybegin(YYINITIAL); }
   [^"*/"]* {                     }
}


[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }