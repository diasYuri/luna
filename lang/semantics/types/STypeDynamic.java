package lang.semantics.types;

public class STypeDynamic extends SType{
    private static STypeDynamic instance = new STypeDynamic();

    public static STypeDynamic instance() {
        return instance;
    }

    @Override
    public boolean match(SType t) {
        return true;
    }

    @Override
    public String TypeName() {
        return "Dynamic";
    }
}
