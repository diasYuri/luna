package src.Interpreter;

public class Pointer {
    private final String name;
    private Object value;

    public Pointer(String name) {
        this.name = name;
    }

    public Pointer(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public Object value() {
        return value;
    }

    public Pointer setValue(Object value) {
        this.value = value;
        return this;
    }
}

