package lang.semantics.types;

public interface STypeInterface {
    boolean match(SType t);

    String TypeName();
}
