package src.types;

import src.types.pointers.RefTypedPointer;

import java.util.HashMap;

public class LunaData implements LunaType {
    private final HashMap<String, RefTypedPointer> properties;
    private final HashMap<String, Class> dataDefinition;
    public LunaData(HashMap<String, Class> dataDefinition) {
        this.properties = new HashMap<>();
        this.dataDefinition = dataDefinition;
        for(var prop : dataDefinition.entrySet()){
            this.properties.put(prop.getKey(), new RefTypedPointer(prop.getValue()));
        }
    }

    public RefTypedPointer getProperty(String propertyName){
        return this.properties.get(propertyName);
    }
}
