package lang.interpreter.types.pointers;

public class ArrayPointer implements Pointer {

    private Object[] array;
    private int position;

    public ArrayPointer(Object[] array, int position) {
        this.array = array;
        this.position = position;
    }

    @Override
    public Object getValue() {
        return array[position];
    }

    @Override
    public void setValue(Object object) {
        array[position] = object;
    }
}
