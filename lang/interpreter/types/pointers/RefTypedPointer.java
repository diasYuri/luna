package lang.interpreter.types.pointers;

public class RefTypedPointer extends RefPointer {
    private Class type;

    public RefTypedPointer(Class type) {
        this.type = type;
    }

    public RefTypedPointer(Class type, Object value) {
        this.type = type;
        this.setValue(value);
    }

    @Override
    public void setValue(Object object) {
        if(object.getClass() == this.type){
            super.setValue(object);
        }else{
            throw new RuntimeException("Invalid type");
        }
    }
}
