package src.interpreter;

public class Parameter {
    private String name;
    private String type;

    public Parameter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        return name;
    }
}
