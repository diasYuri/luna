package src.exceptions;

public class LunaRuntimeException extends RuntimeException{

    public LunaRuntimeException(String message) {
        super(message);
    }

    public static void ThrowIfNull(Object value, String message){
        if(value == null){
            throw new LunaRuntimeException(message);
        }
    }
}
