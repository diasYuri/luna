package lang.semantics.types;

public class STypeUndeclared extends SType{
    private String id;

    public STypeUndeclared(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean match(SType t) {
        return false;
    }

    @Override
    public String TypeName() {
        return "Undeclared";
    }
}
