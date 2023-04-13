
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


BREAK_LINE   = \r|\n|\r\n
WHITE_SPACE  = {BREAK_LINE} | [ \t\f]
INT          = [0]|[1-9][:digit:]*
FLOAT        = [0-9]*[.]?[0-9]+
CHAR         = \'(ˆ[\']|\ |[\\\\]n|[\\\\]r|[\\\\]t|[\\\\]\'|[\w\d\S])'
ID           = [a-z][A-Z_a-z0-9]*
COMMENT_LINE = "--" (.)* {BREAK_LINE}

%state COMMENT

%%

<YYINITIAL> {
    "Int"           { return token(TOKEN_TYPE.TYPE_INT); }
    "Char"          { return token(TOKEN_TYPE.TYPE_CHAR); }
    "Bool"          { return token(TOKEN_TYPE.TYPE_BOOL); }
    "Float"         { return token(TOKEN_TYPE.TYPE_FLOAT); }
    "data"          { return token(TOKEN_TYPE.DATA); }
    "if"            { return token(TOKEN_TYPE.IF); }
    "else"          { return token(TOKEN_TYPE.ELSE); }
    "iterate"       { return token(TOKEN_TYPE.ITERATE); }
    "read"          { return token(TOKEN_TYPE.READ); }
    "print"         { return token(TOKEN_TYPE.PRINT); }
    "return"        { return token(TOKEN_TYPE.RETURN); }
    "true"          { return token(TOKEN_TYPE.TRUE); }
    "false"         { return token(TOKEN_TYPE.FALSE); }
    "null"          { return token(TOKEN_TYPE.NULL); }
    "return"        { return token(TOKEN_TYPE.RETURN); }
    "new"           { return token(TOKEN_TYPE.NEW); }

    "::"            { return token(TOKEN_TYPE.DCOLON); }
    "=="            { return token(TOKEN_TYPE.DOUBLEEQ); }
    "!="            { return token(TOKEN_TYPE.DIFF); }
    "&&"            { return token(TOKEN_TYPE.ANDOP); }


    "{"             { return token(TOKEN_TYPE.LBRACE); }
    "}"             { return token(TOKEN_TYPE.RBRACE); }
    "("             { return token(TOKEN_TYPE.LPAREN); }
    ")"             { return token(TOKEN_TYPE.RPAREN); }
    "["             { return token(TOKEN_TYPE.LSBRACK); }
    "]"             { return token(TOKEN_TYPE.RSBRACK); }
    "="             { return token(TOKEN_TYPE.EQ);   }
    ">"             { return token(TOKEN_TYPE.QT);   }
    "<"             { return token(TOKEN_TYPE.LT);   }
    ","             { return token(TOKEN_TYPE.COMMA); }
    "."             { return token(TOKEN_TYPE.DOT); }
    ";"             { return token(TOKEN_TYPE.SEMI); }
    ":"             { return token(TOKEN_TYPE.COLON); }
    "*"             { return token(TOKEN_TYPE.TIMES);}
    "/"             { return token(TOKEN_TYPE.SLASH);}
    "%"             { return token(TOKEN_TYPE.MOD);}
    "+"             { return token(TOKEN_TYPE.PLUS); }
    "-"             { return token(TOKEN_TYPE.MINUS); }
    "!"             { return token(TOKEN_TYPE.EXCL); }
    "{-"            { yybegin(COMMENT);               }

    {WHITE_SPACE}   { /* Não faz nada  */             }
    {COMMENT_LINE}  {                                 }
    {ID}            { return token(TOKEN_TYPE.ID, yytext());   }
    {INT}           { return token(TOKEN_TYPE.INT, yytext());  }
    {FLOAT}         { return token(TOKEN_TYPE.FLOAT, yytext());  }
    {CHAR}          { return token(TOKEN_TYPE.CHAR, yytext());  }
}

<COMMENT>{
   "-}"     { yybegin(YYINITIAL); }
   [^"-}"]* {                     }
}


[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }