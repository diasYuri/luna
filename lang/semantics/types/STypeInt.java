package lang.semantics.types;

public class STypeInt extends SType {
    private static STypeInt instance = new STypeInt();
    public static STypeInt getInstance() {
        return instance;
    }

    @Override
    public boolean match(SType t) {
        return (t instanceof STypeInt || t instanceof STypeFloat || t instanceof STypeDynamic);
    }

    @Override
    public String TypeName() {
        return "Int";
    }
}

