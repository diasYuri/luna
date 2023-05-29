package src.types.descriptor;

import java.lang.reflect.InvocationTargetException;

public class PrimitiveTypeDescriptor extends TypeDescriptor{

    public PrimitiveTypeDescriptor(Class type) {
        super(type);
    }

    @Override
    public Object newInstance() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if(this.type.isArray()){
            return newArrInstance(1);
        }
        return this.type.getConstructors()[0].newInstance();
    }
}
