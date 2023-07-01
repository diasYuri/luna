package lang.semantics.types;

public class STypeError extends STypeDynamic{
    private static STypeError instance = new STypeError();

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
