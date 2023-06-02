package lang.ast.types;

public enum ExprType {
    AEXP_PLUS,
    AEXP_MINUS,
    MEXP_TIMES,
    MEXP_DIV,
    MEXP_MOD,
    REXP_LESS,
    REXP_EQUAL,
    REXP_NOT_EQUAL,
    EXP_AND,
    EXP_NEGATION,
    CMD_IF,
    CMD_IF_ELSE,
    CMD_ITERATE,
    CMD_READ,
    CMD_PRINT,
    CMD_RETURN,
    CMD_ASSIGNMENT,
    CMD_FUNCTION_CALL
}
