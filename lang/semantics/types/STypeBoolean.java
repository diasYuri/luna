package lang.semantics.types;

public class STypeBoolean extends SType {
    private static STypeBoolean instance = new STypeBoolean();

    public static STypeBoolean getInstance() {
        return instance;
    }

    @Override
    public boolean match(SType t) {
        return t instanceof STypeBoolean || t instanceof  STypeDynamic;
    }

    @Override
    public String TypeName() {
        return "Boolean";
    }
}

