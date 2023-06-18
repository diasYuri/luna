package lang.ast;

import java.util.List;

public class CallAttr extends Cmd {
    private String name;
    private Exps args;
    private List<LValue> lValues;
    public CallAttr(int l, int c, String name, Exps xs, List<LValue> lValues) {
        super(l, c);
        this.name = name;
        args = xs;
        this.lValues = lValues;
    }

    public String getName() {
        return name;
    }

    public  Exps getArgs() {
        return args;
    }


    public List<LValue> getLValue(){
        return lValues;
    }


    // //@Override
    // public String toString() {
    //     String s = name + "(";
    //     if (args.size() > 0) {
    //         s += args[0].toString();
    //         for (int i = 1; i < args.length; i++) {
    //             s += "," + args[i].toString();
    //         }
    //     }
    //     s += ")";
    //     return s;
    // }
}
