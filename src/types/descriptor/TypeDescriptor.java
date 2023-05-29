package src.types.descriptor;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

public abstract class TypeDescriptor {
    protected Class type;

    public TypeDescriptor(Class type) {
        this.type = type;
    }

    public Class getType(){
        return this.type;
    }
    public void convertInArrayType(){
        this.type = this.type.getComponentType();
    }
    public Object[] newArrInstance(int size){
        return (Object[]) Array.newInstance(this.type, size);
    }
    public abstract Object newInstance() throws InvocationTargetException, InstantiationException, IllegalAccessException;
}
