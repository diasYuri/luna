package lang.semantics.types;

public class STypeNumber {
    public static boolean match(SType left, SType right){
        var leftIsNumber = left instanceof STypeInt || left instanceof STypeFloat || left instanceof STypeDynamic;
        var rightIsNumber = right instanceof STypeInt || right instanceof STypeFloat || right instanceof STypeDynamic;
        return leftIsNumber && rightIsNumber;
    }

    public static SType arithmeticComputeType(SType left, SType right){
        if(!match(left, right)){
            return STypeError.getInstance();
        }
        if(left instanceof STypeFloat || right instanceof STypeFloat){
            return STypeFloat.getInstance();
        }
        return STypeInt.getInstance();
    }
}
