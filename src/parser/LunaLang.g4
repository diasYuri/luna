grammar LunaLang;

@parser::header
{
    package src.parser;
}

@lexer::header
{
    package src.parser;
}

prog : data* func* EOF;

data : 'data' ID '{' decl* '}';

decl: ID '::' type ';' ;

func : ID '(' params? ')' (':' type (',' type)*)? '{' cmd* '}';

params : ID '::' type (',' ID '::' type)*;

cmd : '{' cmd* '}'
    | 'if' '(' exp ')' cmd
    | 'if' '(' exp ')' cmd 'else' cmd
    | 'iterate' '(' exp ')' cmd
    | 'read' lvalue ';'
    | 'print' exp ';'
    | 'return' exp (','exp)* ';'
    | lvalue '=' exp ';'
    | ID '(' exps? ')' ('<' lvalue (',' lvalue)* '>')? ';'
    ;

type : type '[]'
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

sexp : '!' sexp         #nexp
     | '-' sexp         #minusexp
     | 'true'           #true
     | 'false'          #false
     | 'null'           #null
     | INT              #int
     | FLOAT            #float
     | CHAR             #char
     | pexp             #ignore
     ;

pexp : lvalue
     | '(' exp ')'
     | 'new' type '[' exp ']'
     | ID '(' exps ')'
     | ID '(' exps ')' '[' ']'
     ;

exps: exp (',' exp)*;

lvalue : ID
       | lvalue '[' exp ']'
       | lvalue'.'ID
       ;

btype: TYPE_INT
     | TYPE_CHAR
     | TYPE_BOOL
     | TYPE_FLOAT
     | ID
     ;



/* Lexer Rules */

/*
AND         : '&&' ;
OR          : '||' ;
DOUBLEEQ    : '==';
DIFF        : '!=';
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

COLON       : ':';
TIMES       : '*';
SLASH       : '/';
MOD         : '%';
PLUS        : '+';
MINUS       : '-';
EXCL        : '!';
QT          : '>';
LT          : '<';
DOT         : '.';

TYPE_INT    : 'Int';
TYPE_CHAR   : 'Char';
TYPE_BOOL   : 'Bool';
TYPE_FLOAT  : 'Float';

ARRAY: '[]';

NEW         : 'new';
DATA        : 'data';
IF          : 'if';
ELSE        : 'else';
ITERATE     : 'iterate';
READ        : 'read';
PRINT       : 'print';
RETURN      : 'return';
TRUE        : 'true';
FALSE       : 'false';
NULL        : 'null';
*/

TYPE_INT    : 'Int';
TYPE_CHAR   : 'Char';
TYPE_BOOL   : 'Bool';
TYPE_FLOAT  : 'Float';

BREAKLINE   : '\r'? '\n' -> skip;
INT: [1-9][0-9]*;
FLOAT: [0-9]+ '.' [0-9]+;
CHAR: '\'' . '\'';
WS: [ \t\n\r]+ -> skip;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
// TODO: adicionar comentário