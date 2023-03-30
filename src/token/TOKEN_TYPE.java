package token;

public enum TOKEN_TYPE {
    ID,
    NUM,
    EQ("="),
    PLUS("+"),
    TIMES("*"),
    SEMI(";"),
    LBRACE("{"),
    RBRACE("}"),
    LPAREN("("),
    RPAREN(")");

    public String value;
    TOKEN_TYPE(String value) {
        this.value = value;
    }
    TOKEN_TYPE() {}
}
