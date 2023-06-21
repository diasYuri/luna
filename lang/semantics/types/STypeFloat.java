package lang.semantics.types;

public class STypeFloat extends SType {
    private static STypeFloat instance = new STypeFloat();

    public static STypeFloat getInstance() {
        return instance;
    }

    @Override
    public boolean match(SType t) {
        return (t instanceof STypeFloat || t instanceof STypeDynamic);
    }

    @Override
    public String TypeName() {
        return "Float";
    }
}

