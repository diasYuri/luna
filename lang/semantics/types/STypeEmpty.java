package lang.semantics.types;

public class STypeEmpty extends SType{
    private String name;

    public STypeEmpty(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public static STypeEmpty getInstance(String name) {
        return new STypeEmpty(name);
    }

    @Override
    public boolean match(SType t) {
        return false;
    }

    @Override
    public String TypeName() {
        return "empty";
    }
}
