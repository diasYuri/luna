grammar lunalang;

@parser::header
{
    package parser;
    import ast.*;
}

@lexer::header
{
    package parser;
}

prog : data func;

data : DATA ID '{' decl '}';

decl: ID '::' type ;

func : ID '(' params ')' ':' type (',' type)* '{' cmd '}';

params : ID '::' type (',' ID '::' type);

cmd : '{' cmd '}'
    | IF '(' exp ')' cmd
    | IF '(' exp ')' cmd ELSE cmd
    | ITERATE '(' exp ')' cmd
    | READ lvalue ';'
    | PRINT exp ';'
    | RETURN exp (','exp)','
    //| lvalue = exp ';'
    | ID '(' exps ')' '<' lvalue (',' lvalue) '>' ';'
    ;

type : type '[' ']'
     | btype
     ;

exp : exp '&&' exp
    | rexp
    ;

rexp : aexp '<' aexp
     | rexp '==' aexp
     | rexp '!=' aexp
     | aexp
     ;

aexp : aexp '+' mexp
     | aexp '-' mexp
     | mexp
     ;

mexp : mexp '*' sexp
     | mexp '/' sexp
     | mexp '%' sexp
     | sexp
     ;

sexp : '!' sexp
     | '-' sexp
     | 'true'
     | 'false'
     | 'null'
     | TYPE_INT
     | TYPE_FLOAT
     | TYPE_CHAR
     | pexp
     ;

pexp : lvalue
     | '(' exp ')'
     | NEW type '[' exp ']'
     | ID '(' exps ')' '[' ']'
     ;

exps : exp {, exp};

lvalue : ID
       | lvalue '[' exp ']'
       | lvalue.ID
       ;

btype: TYPE_INT
     | TYPE_CHAR
     | TYPE_BOOL
     | TYPE_FLOAT
     | ID
     ;


/* Lexer Rules */

BREAKLINE   : '\r'? '\n' -> skip;
WHITESPACE  : [ \t]+ -> skip;
INT         : [0] | [1-9] [0-9]*;
FLOAT       : [0-9]* '.'? [0-9]+;
ID          : [A-Z_a-z0-9]+;

AND         : '&&' ;
OR          : '||' ;
NOT         : '!' ;
PLUS        : '+' ;
EQ          : '=' ;
COMMA       : ',' ;
SEMI        : ';' ;
LPAREN      : '(' ;
RPAREN      : ')' ;
LCURLY      : '{' ;
RCURLY      : '}' ;
LSBRACK     : '[';
RSBRACK     : ']';
DCOLON      : '::';

TYPE_INT    : 'Int';
TYPE_CHAR   : 'Char';
TYPE_BOOL   : 'Bool';
TYPE_FLOAT  : 'Float';
NEW         : 'new';
DATA        : 'data';
IF          : 'if';
ELSE        : 'else';
ITERATE     : 'iterate';
READ        : 'read';
PRINT       : 'print';
RETURN      : 'return';