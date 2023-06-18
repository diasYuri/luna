package lang.ast;

import java.util.List;

public class CallOffSet extends Cmd {
    private String name;
    private Exps args;
    private Expr offset;

    public CallOffSet(int l, int c, String name, Exps xs, Expr offset) {
        super(l, c);
        this.name = name;
        args = xs;
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public  Exps getArgs() {
        return args;
    }


    public Expr getOffset(){
        return offset;
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
