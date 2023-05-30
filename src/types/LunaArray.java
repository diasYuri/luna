package src.types;

public class LunaArray<T extends LunaType> {
    private T[] array;

    private LunaArray(T[] arr) {
        this.array = arr;
    }
}
