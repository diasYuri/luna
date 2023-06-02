package lang.ast;

import lang.ast.abstracts.Type;

public class ArrayType extends Type {
    private Type type;

    public ArrayType(int l, int c, Type type) {
        super(l, c);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean match(Type t) {
        if (t instanceof ArrayType) {
            ArrayType other = (ArrayType) t;
            return type.match(other.type);
        }
        return false;
    }
}