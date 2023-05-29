package src.types.pointers;

import src.types.pool.Collectable;

public class RefPointer implements Pointer, Collectable {
    private Object value;

    public RefPointer() {}

    public RefPointer(Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object object) {
        this.value = object;
    }

    @Override
    public void clear() {
        this.value = null;
    }
}
