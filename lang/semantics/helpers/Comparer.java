package lang.semantics.helpers;

import lang.semantics.types.SType;

import java.util.ArrayList;

public class Comparer {
    public static boolean ListCompare(ArrayList<SType> a, ArrayList<SType> b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.size() != b.size()) return false;
        for (int i = 0; i < a.size() ; i++) {
            if(!(a.get(i).match(b.get(i)))){
                return false;
            }
        }
        return true;
    }

}
