package lang.semantics.types;

public class STypeError extends SType{
    private static STypeError instance;

    public static STypeError getInstance() {return instance;}

    @Override
    public boolean match(SType t) {
        return true;
    }

    @Override
    public String TypeName() {
        return "TypeError";
    }
}
