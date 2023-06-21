package lang.semantics.types;

public class STypeChar extends SType {
    private static STypeChar instance = new STypeChar();

    public static STypeChar getInstance() {
        return instance;
    }

    @Override
    public boolean match(SType t) {
        return t instanceof STypeChar;
    }

    @Override
    public String TypeName() {
        return "Char";
    }
}
