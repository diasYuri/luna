package lang.semantics.types;

import java.util.HashMap;

public class STypeData extends SType {
    private HashMap<String, SType> symbols;
    private String typeName;

    protected STypeData(String typeName) {
        this.typeName = typeName;
    }

    public static STypeData Declare(String typeName){
        return new STypeData(typeName);
    }

    @Override
    public boolean match(SType t) {
        return this.equals(t) || t instanceof STypeDynamic;
    }

    @Override
    public String TypeName() {
        return typeName;
    }

    public STypeData AddDataDescriptor(HashMap<String, SType> dataDescriptor) {
        this.symbols = dataDescriptor;
        return this;
    }
    public SType getMemberType(String id){
        return symbols.get(id);
    }
}

