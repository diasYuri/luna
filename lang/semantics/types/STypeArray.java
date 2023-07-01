package lang.semantics.types;

public class STypeArray extends SType{
    private SType type;

    public STypeArray(SType type) {
        this.type = type;
    }

    public SType type() {
        return type;
    }

    @Override
    public boolean match(SType t) {
        return t instanceof STypeArray || t instanceof STypeDynamic;
    }

    @Override
    public String TypeName() {
        return "Array";
    }
}
