package token;

public enum TOKEN_TYPE {
    ID,
    INT,
    FLOAT,
    CHAR,
    EQ("="),
    QT(">"),
    LT("<"),
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    SLASH("/"),
    MOD("%"),
    COMMA(","),
    DOT("."),
    SEMI(";"),
    COLON(":"),
    DCOLON("::"),
    LBRACE("{"),
    RBRACE("}"),
    LPAREN("("),
    RPAREN(")"),
    LSBRACK("["),
    RSBRACK("]"),
    TYPE_INT("Int"),
    TYPE_CHAR("Char"),
    TYPE_BOOL("Bool"),
    TYPE_FLOAT("Float"),
    DATA("data"),
    IF("if"),
    ELSE("else"),
    ITERATE("iterate"),
    READ("read"),
    PRINT("print"),
    RETURN("return"),
    TRUE("true"),
    FALSE("false"),
    NULL("null"),
    NEW("new"),
    EXCL("!");


    public String value;
    TOKEN_TYPE(String value) {
        this.value = value;
    }
    TOKEN_TYPE() {}
}
