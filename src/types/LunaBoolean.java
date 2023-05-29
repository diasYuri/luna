package src.types;

public class LunaBoolean implements LunaEquatable {
    private final Boolean value;

    public LunaBoolean(Boolean value) {
        this.value = value;
    }

    public LunaBoolean neg(){
        return new LunaBoolean(!this.value);
    }

    public Boolean value(){
        return this.value;
    }
    public LunaBoolean and(LunaBoolean bool){
        return new LunaBoolean(this.value && bool.value);
    }
    public static LunaBoolean $true(){
        return new LunaBoolean(true);
    }
    public static LunaBoolean $false(){
        return new LunaBoolean(false);
    }

    public LunaBoolean parse(String value){
        if(value.equals("true")){
            return new LunaBoolean(true);
        }
        if(value.equals("false")){
            return new LunaBoolean(false);
        }
        return null;
    }
    @Override
    public LunaBoolean equal(LunaEquatable obj) {
        if (obj.getClass() != LunaBoolean.class) throw new RuntimeException();
        return new LunaBoolean(((LunaBoolean)obj).value.booleanValue() == this.value.booleanValue());
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
