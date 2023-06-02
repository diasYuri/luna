package lang.interpreter.types.descriptors;

import lang.interpreter.types.LunaData;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class DataTypeDescriptor extends TypeDescriptor{
    private final HashMap<String, Class> dataDescription;
    private final String id;

    public DataTypeDescriptor(String id, HashMap<String, Class> dataDescription) {
        super(LunaData.class);
        this.dataDescription = dataDescription;
        this.id = id;
    }

    @Override
    public Object newInstance() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        if(this.type.isArray()){
            return this.newArrInstance(0);
        }
        return new LunaData(this.dataDescription);
    }
}
