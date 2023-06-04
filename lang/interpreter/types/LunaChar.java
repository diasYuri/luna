package lang.interpreter.types;

import java.util.HashMap;

public class LunaChar {
    private final Character value;
    public LunaChar() {this.value = null;}
    public LunaChar(Character value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static LunaChar parse(String $char){
        if($char.length() == 3){
            return new LunaChar($char.charAt(1));
        }else if($char.length() == 4){
            if(mapEscape.containsKey($char)){
                return new LunaChar(mapEscape.get($char));
            }
        }
        return null;
    }

    public static HashMap<String, Character> mapEscape = new HashMap<>()
    {
        {
            put("'\\n'", '\n');
            put("'\\\\'", '\\');
            put("'\\r'", '\r');
            put("'\\t'", '\t');
        }
    };
}
