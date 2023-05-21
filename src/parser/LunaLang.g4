grammar LunaLang;

@parser::header
{
    package src.parser;
    import src.ast.*;
    import src.ast.abstracts.*;
    import src.ast.types.*;
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

cmd : '{' cmd* '}'                      #cmdignore
    | 'if' '(' exp ')' cmd              #if
    | 'if' '(' exp ')' cmd 'else' cmd   #if
    | 'iterate' '(' exp ')' cmd         #iterate
    | 'read' lvalue ';'                 #read
    | 'print' exp ';'                   #print
    | 'return' exps ';'                 #return //'return' exp (','exp)* ';'
    | lvalue '=' exp ';'                #attr
    | ID '(' exps? ')' ('<' lvalue (',' lvalue)* '>')? ';' #call
    ;

type : type '[]'
     | btype
     ;

exp : left=exp '&&' right=exp
    | rexp
    ;

rexp : left=aexp '<' right=aexp
     | l=rexp '==' right=aexp
     | l=rexp '!=' right=aexp
     | aexp
     ;

aexp
     : left=aexp '+' right=mexp #add
     | left=aexp '-' right=mexp #sub
     | mexp                     #aexpignore
     ;

mexp
     : left=mexp '*' right=sexp #mult
     | left=mexp '/' right=sexp #div
     | left=mexp '%' right=sexp #mod
     | sexp                     #mexpignore
     ;

sexp : '!' right=sexp         #nexp
     | '-' right=sexp         #minusexp
     | 'true'           #true
     | 'false'          #false
     | 'null'           #null
     | INT              #int
     | FLOAT            #float
     | CHAR             #char
     | pexp             #pexpignore
     ;

pexp : '(' exp ')'                      #tuple
     | 'new' type ('[' exp ']')?        #new
     | ID '(' parameters=exps? ')' '[' offset=exp ']'     #callValue
     | lvalue                           #lvalueignore
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
INT: [0]|[1-9][0-9]*;
FLOAT: [0-9]+ '.' [0-9]+;
CHAR: '\'' . '\'';
WS: [ \t\n\r]+ -> skip;
ID: [a-zA-Z_][a-zA-Z_0-9]*;
// TODO: adicionar comentário